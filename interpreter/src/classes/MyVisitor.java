package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import java.awt.print.Book;
import java.io.*;

import classes.MyLanguageParser.ArregloContext;
import classes.MyLanguageParser.Asignacion_llamadoContext;
import classes.MyLanguageParser.Caso_segunContext;
import classes.MyLanguageParser.Ciclo_mientrasContext;
import classes.MyLanguageParser.Ciclo_paraContext;
import classes.MyLanguageParser.Ciclo_repetirContext;
import classes.MyLanguageParser.Condicional_siContext;
import classes.MyLanguageParser.CuerpoContext;
import classes.MyLanguageParser.DefinicionContext;
import classes.MyLanguageParser.DimensionarContext;
import classes.MyLanguageParser.ExpresionContext;
import classes.MyLanguageParser.Expresion_logicaContext;
import classes.MyLanguageParser.GenerarprocesoContext;
import classes.MyLanguageParser.IdContext;
import classes.MyLanguageParser.InstruccionContext;
import classes.MyLanguageParser.Lista_exprContext;
import classes.MyLanguageParser.ProgramaContext;
import classes.MyLanguageParser.Segun_hacerContext;
import classes.MyLanguageParser.TipoContext;


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
	public T visitPrograma(ProgramaContext ctx) {
		table.push(new HashMap<String, Variable>());
		Object a = super.visitPrograma(ctx);
		table.pop();
		return (T)a;
	}
	public T visitId(IdContext ctx) {
		
		Variable var = find(ctx.ID().getText());
		
		if(!var.arreglo ){
			Object ob = var.valor;
			return (T)ob;
		}
		else if(var.arreglo){
			ArrayList<Integer> index = new ArrayList<Integer>();
			for(Expresion_logicaContext x: ctx.llamado().acceder_arreglo().lista_expr().expresion_logica() ){
				Object ans = visitExpresion_logica(x);
				if(ans instanceof Boolean || ans instanceof String){
					int line = x.getStart().getLine();
					int column = x.getStart().getCharPositionInLine() + 1;
					System.err.printf("<%d,%d> Error semantico: tipos de datos incompatibles. Se esperaba: entero; se encontro "+ ans.getClass().toString() +".", line,column);
					System.exit(-1);
				}
				
				index.add((Integer)ans);
				
				Object obj = var.getFromArray(index);
				return (T)obj;
			}
		}
		return null;
	
		
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
		Variable ans = (found ? table.peek().get(id) : null );
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
			table.peek().get(id).inicializado = true;
		}
		while(!temporal_table.isEmpty()){
			table.push(temporal_table.pop());
		}
	}
	
	public void setVarArray(String id, Object value, ArrayList<Integer> index){
		boolean found = false;
		Stack<HashMap <String, Variable> > temporal_table = new Stack<HashMap<String, Variable> >();
		while(!table.isEmpty() && !found){
			found |= table.peek().containsKey(id);
			if(!found){
				temporal_table.push(table.pop());
			}
		}
		if(found){
			table.peek().get(id).setObjectInArray(index, value);
			table.peek().get(id).inicializado = true;
		}
		while(!temporal_table.isEmpty()){
			table.push(temporal_table.pop());
		}
	}
	
	
	public void setDim(String id, ArrayList<Integer> tamanos){
		boolean found = false;
		Stack<HashMap <String, Variable> > temporal_table = new Stack<HashMap<String, Variable> >();
		while(!table.isEmpty() && !found){
			found |= table.peek().containsKey(id);
			if(!found){
				temporal_table.push(table.pop());
			}
		}
		if(found){
			table.peek().get(id).SetArreglo(tamanos.size(), tamanos);
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
	public T visitDefinicion(DefinicionContext ctx) {
		for(TerminalNode x :  ctx.lista().ID()){
			if(find(x.getText()) != null){
				int line = x.getSymbol().getLine();
				int column = x.getSymbol().getCharPositionInLine() + 1;
				System.err.printf("<%d:%d> Error semantico, la variable con nombre "+ x.getText() + " ya ha sido declarada", line, column);
				System.exit(-1);
			}
			Variable var = new Variable();
			var.setTipo((String)visitTipo(ctx.tipo()));
			table.peek().put(x.getText(), var); 
			
		}
		return null;
	}
	
	
	
	@Override
	public T visitDimensionar(DimensionarContext ctx) {
		for( ArregloContext x: ctx.lista_arreglos().arreglo()){
			visitArreglo(x);
		}
		return null;
	}

	@Override
	public T visitArreglo(ArregloContext ctx) {
		String id = ctx.ID().getText();
		ArrayList<Integer> tamanos = new ArrayList<Integer>();
		for(Expresion_logicaContext x :ctx.dim().lista_expr().expresion_logica()){
			Integer tam = (Integer)visitExpresion_logica(x);
			tamanos.add(tam);			
		}
		setDim(id, tamanos);
		return null;
	}
	
	@Override
	public T visitTipo(TipoContext ctx) {
		if(ctx.Entero() != null || ctx.Numero() != null)
			return (T)"entero";
		else if(ctx.Caracter() != null || ctx.Cadena() != null)
			return (T)"cadena";
		else if (ctx.Real() != null || ctx.Numerico() != null)
			return (T)"real";
		else if(ctx.Logico() != null)
			return (T)"logico";
		else
			return null;
	}
	
	
	@Override
	public T visitInstruccion(InstruccionContext ctx) {
		
		if(ctx.Escribir() != null){
			String toOut = new String("");
			for(Expresion_logicaContext x : ctx.lista_expr().expresion_logica()){
				
				if(x.expresion().id() != null){
					if(!find(x.expresion().id().ID().getText()).inicializado){
						int line = x.expresion().id().ID().getSymbol().getLine();
						int column = x.expresion().id().ID().getSymbol().getCharPositionInLine() + 1;
						System.err.printf("<%d:%d> Error semantico, la variable con nombre "+ x.expresion().id().ID().getText() + " no ha sido inicializada", line, column);
						System.exit(-1);
					}
				}
				
				toOut += visitExpresion_logica(x).toString();
				toOut += " ";
			}
			System.out.println(toOut);
		}
		if(ctx.Leer() != null){
				for( IdContext x: ctx.lista_id_o_llamado().id()){
					Object value = null;
					Variable var = find(x.getText());
					if(var == null){
						int line = x.ID().getSymbol().getLine();
						int column = x.ID().getSymbol().getCharPositionInLine() + 1;
						System.err.printf("<%d:%d> Error semantico, la variable con nombre "+ x.getText() + " no ha sido declarada", line, column);
						System.exit(-1);
					}
					
									
					String tipo = var.tipo;
					
					if(tipo.equals("entero")){
						try {
							value = (Integer)(Integer.parseInt(in.readLine()));
						} catch (NumberFormatException e) {

							e.printStackTrace();
						} catch (IOException e) {
							
							e.printStackTrace();
						}
					}
					else if(tipo.equals("cadena")){
						try {
							value = in.readLine();
						} catch (IOException e) {
				
							e.printStackTrace();
						}
					}
					else if(tipo.equals("real")){
						try {
							value = (Double)(Double.parseDouble(in.readLine()));
						} catch (NumberFormatException | IOException e) {
						
							e.printStackTrace();
						}
					}
					else if(tipo.equals("logico")){
						try {
							value = (Boolean)(Boolean.parseBoolean(in.readLine()));
						} catch (IOException e) {

							e.printStackTrace();
						}
					}
					if(var.arreglo){
						if(x.llamado().acceder_arreglo() == null){
							int line = x.ID().getSymbol().getLine();
							int column = x.ID().getSymbol().getCharPositionInLine() + 1;
							System.err.printf("<%d,%d> Error semantico: La variable "+x.ID().getText()+ " es un arreglo.", line,column);
							System.exit(-1);
						}
						ArrayList<Integer> index = new ArrayList<Integer>();
						for( Expresion_logicaContext y: x.llamado().acceder_arreglo().lista_expr().expresion_logica()){
							Object temp = visitExpresion_logica(y);
							if(temp instanceof Boolean || temp instanceof String){
								int line = y.getStart().getLine();
								int column = y.getStart().getCharPositionInLine() + 1;
								System.err.printf("<%d,%d> Error semantico: tipos de datos incompatibles. Se esperaba: entero; se encontro "+ temp.getClass().toString() +".", line,column);
								System.exit(-1);
							}
							
							index.add((Integer)temp);
						}
						
						setVarArray(x.ID().getText(), value, index);
						
					}
					else if(!var.arreglo){
						setVar(x.getText(), value);
					}
					
				}
		}
		else if(ctx.Esperar() != null){
			//TODO
		}
		
		
		return null;
	}
	
	@Override
	public T visitAsignacion_llamado(Asignacion_llamadoContext ctx) {
		if(ctx.llamar_o_asignar().asignar() != null){
			Variable var = find(ctx.ID().getText());
			Object value = null;
			value = visitExpresion_logica(ctx.llamar_o_asignar().asignar().expresion_logica());
			
			if(var == null){
				int line = ctx.ID().getSymbol().getLine();
				int column = ctx.ID().getSymbol().getCharPositionInLine() + 1;
				System.err.printf("<%d:%d> Error semantico, la variable con nombre "+ ctx.ID().getText() + " no ha sido declarada", line, column);
				System.exit(-1);
			}
			String tipovar = var.tipo;
			
			
			String tipo;
			if(value instanceof Double)
				tipo = new String("real");
			else if(value instanceof Integer)
				tipo = new String("entero");
			else if(value instanceof String)
				tipo = new String("cadena");
			else
				tipo = new String("logico");	
			
			if(!tipovar.equals(tipo)){
				int line = ctx.getStart().getLine();
				int column = ctx.getStart().getCharPositionInLine() + 1;
				System.err.printf("<%d:%d> Error semantico: tipos de datos incompatible. Se esperaba: " + tipovar+ "; se encontro: " + tipo, line, column);
				System.exit(-1);
			}
			if(var.arreglo){
				if(ctx.llamar_o_asignar().acceder_arreglo() == null){
					int line = ctx.ID().getSymbol().getLine();
					int column = ctx.ID().getSymbol().getCharPositionInLine() + 1;
					System.err.printf("<%d,%d> Error semantico: La variable "+ ctx.ID().getText()+ " es un arreglo.", line,column);
					System.exit(-1);
				}
				ArrayList<Integer> index = new ArrayList<Integer>();
				for( Expresion_logicaContext y: ctx.llamar_o_asignar().acceder_arreglo().lista_expr().expresion_logica()){
					Object temp = visitExpresion_logica(y);
					if(temp instanceof Boolean || temp instanceof String){
						int line = y.getStart().getLine();
						int column = y.getStart().getCharPositionInLine() + 1;
						System.err.printf("<%d,%d> Error semantico: tipos de datos incompatibles. Se esperaba: entero; se encontro "+ temp.getClass().toString() +".", line,column);
						System.exit(-1);
					}
					
					index.add((Integer)temp);
				}
				
				setVarArray(ctx.ID().getText(), value, index);
				
			}
			else if(!var.arreglo){
				setVar(ctx.ID().getText(), value);
			}
			
		}
		
		return null;
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
		
		return null;
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
		
		if(ctx.id() != null){
			Variable var = find(ctx.id().ID().getText());
			//no existe id
			if(var == null){
				int line = ctx.id().ID().getSymbol().getLine();
				int column = ctx.id().ID().getSymbol().getCharPositionInLine() + 1;
				System.err.printf("<%d:%d> Error semantico, la variable con nombre "+ ctx.id().ID().getText() + " no ha sido declarada", line, column);
				System.exit(-1);
			}
			ans = visitId(ctx.id());
			
			
			return (T)ans;
		}
		return null;
	}
	
	
	@Override
	public T visitCondicional_si(Condicional_siContext ctx) {
		Boolean condicion = (Boolean)visitExpresion_logica(ctx.expresion_logica());
		if(condicion){
			System.out.println("entre a si");
			visitCuerpo(ctx.cuerpo());
		}
		else if(ctx.si_no().cuerpo() != null) {
			System.out.println("entre a else");
			visitCuerpo(ctx.si_no().cuerpo());
			
		}
		return null;
		
	}
	
	
	@Override
	public T visitCiclo_para(Ciclo_paraContext ctx) {
		// TODO Auto-generated method stub

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
	
		return null;
	}
	
	@Override
	public T visitCiclo_mientras(Ciclo_mientrasContext ctx) {


		Boolean ans = (Boolean)visitExpresion_logica(ctx.expresion_logica());
		while(ans){
			visitCuerpo(ctx.cuerpo());
		}
		return null;
	}
	@Override
	public T visitCuerpo(CuerpoContext ctx) {
		table.push(new HashMap<String, Variable>());
		Object a = super.visitCuerpo(ctx);
		table.pop();
		return (T)a;
	}
	@Override
	public T visitSegun_hacer(Segun_hacerContext ctx) {
		Variable var = find(ctx.id().ID().getText());
		
		//errores
		if(var == null){
			int line = ctx.id().getStart().getLine();
			int column = ctx.id().getStart().getCharPositionInLine() + 1;
			System.err.printf("<%d,%d> Error semantico: la variable " + ctx.id().ID().getText() + " no ha sido declarada.", line,column);
			System.exit(-1);	
		}
		else if(!var.inicializado){
			int line = ctx.id().getStart().getLine();
			int column = ctx.id().getStart().getCharPositionInLine() + 1;
			System.err.printf("<%d,%d> Error semantico: la variable " + ctx.id().ID().getText() + " no ha sido inicializada.", line,column);
			System.exit(-1);
		}
		else if(!(var.valor instanceof Integer) ){
			int line = ctx.id().getStart().getLine();
			int column = ctx.id().getStart().getCharPositionInLine() + 1;
			System.err.printf("<%d,%d> Error semantico: tipos de datos incompatibles. Se esperaba: entero; se encontro "+var.tipo+".", line,column);
			System.exit(-1);
		}
		boolean flag = false;
		for(Caso_segunContext x : ctx.casos().caso_segun()){
			
			
			Object obj = visitExpresion_logica(x.expresion_logica());
			if(!(obj instanceof Integer)){
				int line = ctx.id().getStart().getLine();
				int column = ctx.id().getStart().getCharPositionInLine() + 1;
				System.err.printf("<%d,%d> Error semantico: tipos de datos incompatibles. Se esperaba: entero; se encontro "+ obj.getClass().toString() +".", line,column);
				System.exit(-1);
			}
			Integer o = (Integer)obj;
			flag |= ((Integer)var.valor).equals(o);
			if(flag){
				visitCuerpo(x.cuerpo());
				break;
			}
		}
		if(!flag){
			visitDe_otro_modo(ctx.de_otro_modo());
		}
		
		return null;
	}
	
	@Override
	public T visitCiclo_repetir(Ciclo_repetirContext ctx) {

		Boolean ans = (Boolean)visitExpresion_logica(ctx.expresion_logica());
		do{
			visitCuerpo(ctx.cuerpo());
		}while(ans);
	
		return null;
	}
	
	public class Variable{
		public String tipo;
		public boolean inicializado;
		public Object valor;
		public boolean arreglo;
		public int dimensiones;
		public ArrayList<Integer> tamanos;
		public boolean funcion;
		public Object[] array;
		
		public Variable() {
			this.tipo = tipo;
			this.inicializado = inicializado;
			this.dimensiones = 0;
			this.arreglo = false;
			this.funcion = false;
		}
		
		public void setValor(Object valor){
			this.valor = valor;
		}
		
		public void setTipo(String tipo){
			this.tipo = tipo;
		}
		public void Inicializar(){
			this.inicializado = true;
		}
		
		public void SetArreglo(int dimensiones, ArrayList<Integer> tamanos){
			this.arreglo = true;
			this.dimensiones = dimensiones;
			this.tamanos = tamanos;
			
			Integer tam = new Integer(tamanos.get(0));
			for(int i = 1; i < tamanos.size(); i++){
				tam *= tamanos.get(i);
			}
			
			if(tipo.equals("entero")){
				this.array = new Integer[tam];
			}
			if(tipo.equals("caracter")){
				this.array = new String[tam];
			}
			if(tipo.equals("real")){
				this.array = new Double[tam];
			}
			if(tipo.equals("logico")){
				this.array = new Double[tam];
			}
			
		}
		
		public Object getFromArray(ArrayList<Integer> index){
			Object ans = null;
			Integer tam= new Integer(1);
			for(Integer t : this.tamanos)
				tam *= t;
			Integer idx = new Integer(0);
			
			for(int i = 0; i < tamanos.size(); i++){
				idx += (index.get(i)*(tam/this.tamanos.get(i)));
			}
			ans = array[idx];
			
			return ans;
		}
		
		public void setObjectInArray(ArrayList<Integer> index, Object var){
			Object ans = null;
			Integer tam= new Integer(1);
			for(Integer t : this.tamanos)
				tam *= t;
			Integer idx = new Integer(0);
			
			for(int i = 0; i < tamanos.size(); i++){
				idx += (index.get(i)*(tam/this.tamanos.get(i)));
			}
			array[idx] = var;
			
			
		}
		
	}
	
}
