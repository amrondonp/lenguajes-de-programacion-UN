package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import java.awt.print.Book;
import java.io.*;

import classes.MyLanguageParser.Ciclo_mientrasContext;
import classes.MyLanguageParser.Ciclo_paraContext;
import classes.MyLanguageParser.Ciclo_repetirContext;
import classes.MyLanguageParser.Condicional_siContext;
import classes.MyLanguageParser.ExpresionContext;
import classes.MyLanguageParser.Expresion_logicaContext;
import classes.MyLanguageParser.GenerarprocesoContext;
import classes.MyLanguageParser.IdContext;
import classes.MyLanguageParser.InstruccionContext;
import classes.MyLanguageParser.Lista_exprContext;
import classes.MyLanguageParser.ProgramaContext;


public class MyVisitor<T> extends MyLanguageBaseVisitor<T>{

	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	//PrintWriter output = new PrintWriter(System.out);
	
	//symbol table
	public Stack<HashMap <String, Variable> > table = new Stack<HashMap <String, Variable>>();
	
	public boolean validForMath(Object a){
		 if(a instanceof Integer || a instanceof Double)
			 return true;
		 return false;
	}
		
	@Override
	public T visitId(IdContext ctx) {
		
		Variable var = find(ctx.ID().getText());
		
		//no existe id
		if(var == null){
			int line = ctx.getStart().getLine();
			int column = ctx.getStart().getCharPositionInLine() + 1;
			System.err.printf("<%d:%d> Error semantico, la variable con nombre "+ ctx.ID().getText() + " no ha sido declarada", line, column);
			System.exit(-1);
		}
		//id no incializado
		if(!var.inicializado){
			int line = ctx.getStart().getLine();
			int column = ctx.getStart().getCharPositionInLine() + 1;
			System.err.printf("<%d:%d> Error semantico, la variable con nombre "+ ctx.ID().getText() + " no ha sido inicializada", line, column);
			System.exit(-1);
		}
		
		if(!var.arreglo ){
			Object ob = var.valor;
			return (T)ob;
		}
		return super.visitId(ctx);
	
		//TODO arreglos
		//TODO llamado funciones
		
	}
	
	/* busca en la tabla de simbolos
	 * @param id
	 * @return matched object
	 * */
	public Variable find(String id){
		boolean found = false;
		Stack<HashMap <String, Variable> > temporal_table = new Stack<HashMap<String, Variable> >();
		while(!table.isEmpty() && !found){
			found |= table.peek().containsKey(id);
			if(!found) temporal_table.push(table.pop());
		}
		Variable ans = (found ? temporal_table.peek().get(id) : null );
		while(!temporal_table.isEmpty()){
			table.push(temporal_table.pop());
		}
		
		return ans; 
	}
	
	public void setVar(String id, Object value){
		boolean found = false;
		Stack<HashMap <String, Variable> > temporal_table = new Stack<HashMap<String, Variable> >();
		while(!table.isEmpty() && !found){
			found |= table.peek().containsKey(id);
			if(!found){
				temporal_table.push(table.pop());
			}
		}
		if(found){
			table.peek().get(id).valor = value;
		}
		while(!temporal_table.isEmpty()){
			table.push(temporal_table.pop());
		}
	}
	/* revisa que los simbolos en una expresion sean correctos
	 * @param objetos a y b
	 * @return true si ambos objetos son del mismo tipo o
	 * tienen tipos plausibles para una operacion
	 * @return falso en caso contrario
	 * */
	public boolean correctTypes(Object a, Object b){
		if(!a.getClass().equals(b.getClass())){
			if(a instanceof String || b instanceof String)
				return false;
			if(a instanceof Boolean || b instanceof Boolean)
				return false;
		}
		else{
			if(a instanceof Boolean || b instanceof Boolean){
				return false;
			}
		}
		return true;
	}	
	
	public String tipo(Object a){
		if(a instanceof Double)
			return "real";
		else if(a instanceof Integer)
			return "entero";
		else if(a instanceof String)
			return "cadena";
		else
			return "logico";
	}
	
	@Override
	public T visitGenerarproceso(GenerarprocesoContext ctx) {
		table.push(new HashMap<String, Variable>());
		visitChildren(ctx);
		table.pop();
		return super.visitGenerarproceso(ctx);
	}
	
	@Override
	public T visitInstruccion(InstruccionContext ctx) {
		String toOut = new String("");
		if(ctx.Escribir() != null){
			for(Expresion_logicaContext x : ctx.lista_expr().expresion_logica()){
				toOut += visitExpresion_logica(x).toString();
				toOut += " ";
				System.out.println(toOut);
			}
			System.out.println("esto es de out" + toOut);
		}
		if(ctx.Leer() != null){
				for(IdContext x: ctx.lista_id_o_llamado().id()){
					Variable var = find(x.ID().getText());
					if(var == null){
						int line = ctx.getStart().getLine();
						int column = ctx.getStart().getCharPositionInLine() + 1;
						System.err.printf("<%d:%d> Error semantico, la variable con nombre "+ x.ID().getText() + " no ha sido declarada", line, column);
						System.exit(-1);
					}
					//TODO
					
					
				}
		}
		
		//TODO 
		return super.visitInstruccion(ctx);
	}
	
	public int comparar (Object var1, Object var2){
		if(var1 instanceof String && var2 instanceof String){
			return ((String)var1).compareTo((String)var2);
		}
		else if(var1 instanceof Double && var2 instanceof Double){
			return ((Double)var1).compareTo((Double)var2);
		}
		else if(var1 instanceof Double && var2 instanceof Integer){
			return ((Double)var1).compareTo(((Integer)var2).doubleValue());
		}
		else if(var1 instanceof Integer && var2 instanceof Double){
			return Double.valueOf( ( (Integer)var1 ).doubleValue()  ).compareTo((Double)var2);
		}
		else if(var1 instanceof Integer && var2 instanceof Integer){
			return ((Integer) var1).compareTo(  (Integer)var2 );
		}
		else if(var1 instanceof Boolean && var2 instanceof Boolean){
			return ((Boolean)var1).compareTo((Boolean)var2);
		}
		else{
			return Integer.MIN_VALUE;
		}
	}
	@Override
	public T visitExpresion_logica(Expresion_logicaContext ctx) {
		Boolean ans = null;
		
		if(ctx.TOKEN_NEG() != null){
			Object ob = visitExpresion_logica(ctx.expresion_logica(0));
			//TODO Manejo de errores
			if(!(ob instanceof Boolean) ){
				int line = ctx.getStart().getLine();
				int column = ctx.getStart().getCharPositionInLine() + 1;
				System.err.printf("<%d:%d> Error semantico: tipos de datos incompatible. Se esperaba: logico; se encontro: " + tipo(ob), line, column);
				System.exit(-1);
			}
			ans = (Boolean)ob;
			return (T)ans;
		}
		else if(ctx.RELOP() != null){
			String op = ctx.RELOP().getText();
			Object var1 = visitExpresion_logica(ctx.expresion_logica(0));
			Object var2 = visitExpresion_logica(ctx.expresion_logica(1));
			
			if(! correctTypes(var1, var2)){
				int line = ctx.getStart().getLine();
				int column = ctx.getStart().getCharPositionInLine() + 1;
				//TODO Manejo de errores
				System.err.printf("<%d:%d> Error semantico: tipos de datos incompatible. Se esperaba: logico; se encontro: " + tipo(var2), line, column);
				System.exit(-1);
			}
			
			switch(op){
			case "<":
				ans = comparar(var1, var2) < 0;
				break;
			case ">":
				ans = comparar(var1, var2) >0;
				break;
			case ">=":
				ans = (comparar(var1, var2) > 0 || comparar(var1, var2) == 0);
				break;
			case "<=":
				ans = (comparar(var1, var2) <0  || comparar(var1, var2) == 0);
				break;		
			}		
			//System.out.println(ans.toString());
			return (T)ans;
		}
		else if(ctx.IODOP() != null){
			String op = ctx.IODOP().getText();
			Object var1 = visitExpresion_logica(ctx.expresion_logica(0));
			Object var2 = visitExpresion_logica(ctx.expresion_logica(1));
			
			//TODO manejar error
			
			if(!(var1 instanceof Boolean) || !(var2 instanceof Boolean)){
				int line = ctx.getStart().getLine();
				int column = ctx.getStart().getCharPositionInLine() + 1;
				//TODO Manejo de errores
				System.err.printf("<%d:%d> Error semantico: tipos de datos incompatible. Se esperaba: logico; se encontro: " + tipo(var1), line, column);
				System.exit(-1);
			}
			
			switch(op){
			case "=":
			case "==":
				ans = (comparar(var1, var2) == 0);
				break;
			case "<>":
				ans = (comparar(var1, var2) != 0);
				break;	
			}
			//System.out.println(ans.toString());
			return (T)ans;
		}
		else if(ctx.TOKEN_Y() != null){
			Object var1 = visitExpresion_logica(ctx.expresion_logica(0));
			Object var2 = visitExpresion_logica(ctx.expresion_logica(1));
			
			//TODO manejo errores
			if(!(var1 instanceof Boolean) || !(var2 instanceof Boolean)){
				int line = ctx.getStart().getLine();
				int column = ctx.getStart().getCharPositionInLine() + 1;
				System.err.printf("<%d:%d> Error semantico: tipos de datos incompatible. Se esperaba: logico; se encontro: " + tipo(var1), line, column);
				System.exit(-1);
			}
			
			ans = (Boolean)var1 && (Boolean)var2;
			//System.out.println(ans.toString());
			return (T)ans;
			
		}
		else if(ctx.TOKEN_O() != null){
			Object var1 = visitExpresion_logica(ctx.expresion_logica(0));
			Object var2 = visitExpresion_logica(ctx.expresion_logica(1));
			
			//TODO manejo errores
			if(!(var1 instanceof Boolean) || !(var2 instanceof Boolean)){
				int line = ctx.getStart().getLine();
				int column = ctx.getStart().getCharPositionInLine() + 1;
				//TODO Manejo de errores
				System.err.printf("<%d:%d> Error semantico: tipos de datos incompatible. Se esperaba: logico; se encontro: " + tipo(var1), line, column);
				System.exit(-1);
			}
			ans = (Boolean)var1 || (Boolean)var2;
			//System.out.println(ans.toString());
			return (T)ans;
		}
		else if(ctx.TOKEN_PAR_IZQ() != null)
			return visitExpresion_logica(ctx.expresion_logica(0));
		else if(ctx.expresion() != null){
			return visitExpresion(ctx.expresion());
		}
		
		return super.visitExpresion_logica(ctx);
	}
	

	@Override
	public T visitExpresion(ExpresionContext ctx) {
		Object ans = null;
		if(ctx.TOKEN_MENOS() != null){
			ans = visitExpresion(ctx.expresion(0));
			if(! validForMath(ans)  ){
				int line = ctx.getStart().getLine();
				int column = ctx.getStart().getCharPositionInLine() + 1;
				System.err.printf("<%d:%d> Error semantico, los tipos no coinciden", line, column);
				System.exit(-1);
			}
			if(ans instanceof Double){
				ans = -( (Double)ans );
				return (T)ans;
			}
			if(ans instanceof Integer){
				ans = -((Integer)ans);
				return (T)ans;
			}
		}
		if(ctx.TOKEN_POT() != null){
			Object var1 = visitExpresion(ctx.expresion(0));
			Object var2 = visitExpresion(ctx.expresion(1));
			if(! validForMath(var1) || !validForMath(var2) ){
				int line = ctx.getStart().getLine();
				int column = ctx.getStart().getCharPositionInLine() + 1;
				System.err.printf("<%d:%d> Error semantico, los tipos no coinciden", line, column);
				System.exit(-1);
			}
			if(var1 instanceof Double && var2 instanceof Double)
					ans = Math.pow((Double)var1,(Double)var2 );
			else if(var1 instanceof Double && var2 instanceof Integer)
					ans = Math.pow( (Double)var1, ((Integer)var2).doubleValue() );
			else if(var1 instanceof Integer && var2 instanceof Double)
					ans = Math.pow(((Integer)var1).doubleValue(), (Double)var2);
			else
				ans = Integer.valueOf((int) (Math.pow((Integer)var1, (Integer)var2)));
			//System.out.println(ans.toString());
			return (T)ans;
		}
		if(ctx.MULOP() != null){
			Object var1 = visitExpresion(ctx.expresion(0));
			Object var2 = visitExpresion(ctx.expresion(1));
			String op = ctx.MULOP().getText();
			if(! validForMath(var1) || !validForMath(var2) ){
				int line = ctx.getStart().getLine();
				int column = ctx.getStart().getCharPositionInLine() + 1;
				System.err.printf("<%d:%d> Error semantico, los tipos no coinciden", line, column);
				System.exit(-1);
			}
			
			switch(op){
			case "*":
				if(var1 instanceof Double && var2 instanceof Double)
					ans = (Double)var1 * (Double)var2;
				else if(var1 instanceof Double && var2 instanceof Integer)
					ans = (Double)var1 * ((Integer)var2).doubleValue();
				else if(var1 instanceof Integer && var2 instanceof Double)
					ans = ((Integer)var1).doubleValue() * (Double)var2;
				else
					ans = (Integer)var1 * (Integer)var2;
				break;
			case "/":
				if(var2 instanceof Double && ((Double)var2).equals(Double.valueOf(0))){
					int line= ctx.getStart().getLine();
					int column = ctx.getStart().getCharPositionInLine() + 1;
					System.err.printf("<%d:%d> Error semantico, division entre 0", line, column);
					System.exit(-1);
				}
				
				if(var2 instanceof Integer && ((Integer)var2).equals(Integer.valueOf(0))){
					int line= ctx.getStart().getLine();
					int column = ctx.getStart().getCharPositionInLine() + 1;
					System.err.printf("<%d:%d> Error semantico, division entre 0", line, column);
					System.exit(-1);
				}
				
				if(var1 instanceof Double && var2 instanceof Double)
					ans = (Double)var1 / (Double)var2;
				else if(var1 instanceof Double && var2 instanceof Integer)
					ans = (Double)var1 / ((Integer)var2).doubleValue();
				else if(var1 instanceof Integer && var2 instanceof Double)
					ans = ((Integer)var1).doubleValue() / (Double)var2;
				else
					ans = (Integer)var1 / (Integer)var2;
				break;
			case "mod":
			case "%":
				if(var1 instanceof Double && var2 instanceof Double)
					ans = (Double)var1 % (Double)var2;
				else if(var1 instanceof Double && var2 instanceof Integer)
					ans = (Double)var1 % ((Integer)var2).doubleValue();
				else if(var1 instanceof Integer && var2 instanceof Double)
					ans = ((Integer)var1).doubleValue() % (Double)var2;
				else
					ans = (Integer)var1 % (Integer)var2;
				break;
			}
			//System.out.println(ans.toString());
			return (T)ans;
		}
		if(ctx.SUMOP() != null){
			Object var1 = visitExpresion(ctx.expresion(0));
			Object var2 = visitExpresion(ctx.expresion(1));
			String op = ctx.SUMOP().getText();
			if(! validForMath(var1) || !validForMath(var2) ){
				int line = ctx.getStart().getLine();
				int column = ctx.getStart().getCharPositionInLine() + 1;
				System.err.printf("<%d:%d> Error semantico, los tipos no coinciden", line, column);
				System.exit(-1);
			}
			switch(op){
			case "+":
				if(var1 instanceof Double && var2 instanceof Double)
					ans = (Double)var1 + (Double)var2;
				else if(var1 instanceof Double && var2 instanceof Integer)
					ans = (Double)var1 + ((Integer)var2).doubleValue();
				else if(var1 instanceof Integer && var2 instanceof Double)
					ans = ((Integer)var1).doubleValue() + (Double)var2;
				else
					ans = (Integer)var1 + (Integer)var2;
				break;
			case "-":
				if(var1 instanceof Double && var2 instanceof Double)
					ans = (Double)var1 - (Double)var2;
				else if(var1 instanceof Double && var2 instanceof Integer)
					ans = (Double)var1 - ((Integer)var2).doubleValue();
				else if(var1 instanceof Integer && var2 instanceof Double)
					ans = ((Integer)var1).doubleValue() - (Double)var2;
				else
					ans = (Integer)var1 - (Integer)var2;
				break;
			}
			//System.out.println(ans.toString());
			return (T)ans;
		}
		if(ctx.TOKEN_PAR_IZQ() != null)
			return visitExpresion(ctx.expresion(0));
		if(ctx.constante() != null){
			if(ctx.constante().TOKEN_CADENA() != null){
				ans = (String)ctx.constante().getText();
				
			}
			else if(ctx.constante().TOKEN_REAL()	!= null){
				ans = new Double(ctx.constante().getText());
				
			}
			else if(ctx.constante().TOKEN_ENTERO()!= null){
				ans = new Integer(ctx.constante().getText());
				
			}
			else if(ctx.constante().Falso() != null){
				ans = new Boolean(false);
				
			}
			else if(ctx.constante().Verdadero() != null){
				ans = new Boolean(true);
				
			}
			//System.out.println(ans.toString());
			return (T)ans;
		}
		
		//TODO queda pendiente en expresi1on calcular ids
		if(ctx.id() != null){
			ans = visitId(ctx.id());
			return (T)ans;
		}
		return super.visitExpresion(ctx);
	}
	
	@Override
	public T visitCondicional_si(Condicional_siContext ctx) {
		// TODO Auto-generated method stub
		table.push(new HashMap<String, Variable>());
		Boolean ans = (Boolean)visitExpresion_logica(ctx.expresion_logica());
		if(ans){
			visitCuerpo(ctx.cuerpo());
		}
		else{
			visitSi_no(ctx.si_no());
		}
		table.pop();
		return super.visitCondicional_si(ctx);
	}
	
	// TODO visitCuerpo
	
	@Override
	public T visitCiclo_para(Ciclo_paraContext ctx) {
		// TODO Auto-generated method stub
		table.push(new HashMap<String, Variable>());
		Object num, hasta, paso;
		if(ctx.ID()!=null){
			
			num = visitExpresion(ctx.expresion());
			if(num instanceof Integer){
				num = (Integer)num;
			}
			else if(num instanceof Double){
				num = (Double)num;
				num = ((Double) num).intValue();
			}
			
			hasta = visitExpresion_logica(ctx.expresion_logica());
			if(hasta instanceof Integer){
				hasta = (Integer)hasta;
			}
			else if(hasta instanceof Double){
				hasta = (Double)hasta;
				hasta = ((Double) hasta).intValue();
			}	
			
			paso = visitCon_paso(ctx.con_paso());
			if(paso instanceof Integer){
				paso = (Integer)paso;
			}
			else if(paso instanceof Double){
				paso = (Double)paso;
				paso = ((Double) paso).intValue();
			}
			
			for (int i = Integer.valueOf((Integer) num); i < Integer.valueOf((Integer) hasta); i += Integer.valueOf((Integer) paso)) {
				visitCuerpo(ctx.cuerpo());
			}
		}
		table.pop();
		return super.visitCiclo_para(ctx);
	}
	
	@Override
	public T visitCiclo_mientras(Ciclo_mientrasContext ctx) {
		// TODO Auto-generated method stub
		table.push(new HashMap<String, Variable>());
		Boolean ans = (Boolean)visitExpresion_logica(ctx.expresion_logica());
		while(ans){
			visitCuerpo(ctx.cuerpo());
		}table.pop();
		return super.visitCiclo_mientras(ctx);
	}
	
	@Override
	public T visitCiclo_repetir(Ciclo_repetirContext ctx) {
		// TODO Auto-generated method stub
		table.push(new HashMap<String, Variable>());
		Boolean ans = (Boolean)visitExpresion_logica(ctx.expresion_logica());
		do{
			visitCuerpo(ctx.cuerpo());
		}while(ans);
		table.pop();
		return super.visitCiclo_repetir(ctx);
	}
	
	public class Variable{
		public String tipo;
		public boolean inicializado;
		public Object valor;
		public boolean arreglo;
		public int dimensiones;
		public ArrayList<Integer> tamanos;
		
		public Variable(String tipo, boolean inicializado, Object valor) {
			this.tipo = tipo;
			this.inicializado = inicializado;
			this.valor = valor;
			this.dimensiones = 0;
			this.arreglo = false;
		}
		
		public void SetArreglo(int dimensiones, ArrayList<Integer> tamanos){
			this.arreglo = true;
			this.dimensiones = dimensiones;
			this.tamanos = tamanos;
		}
		
	}
	
}
