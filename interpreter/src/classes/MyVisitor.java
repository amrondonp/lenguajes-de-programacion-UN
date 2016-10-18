package classes;

import java.util.HashMap;
import java.util.Stack;
import java.io.*;

import classes.MyLanguageParser.ExpresionContext;
import classes.MyLanguageParser.Expresion_logicaContext;
import classes.MyLanguageParser.GenerarprocesoContext;
import classes.MyLanguageParser.InstruccionContext;
import classes.MyLanguageParser.Lista_exprContext;
import classes.MyLanguageParser.ProgramaContext;


public class MyVisitor<T> extends MyLanguageBaseVisitor<T>{
	//symbol table
	public Stack<HashMap <String, Object> > table = new Stack<HashMap <String, Object>>();
	public PrintWriter out = new PrintWriter(System.out);
	
	
	/* busca en la tabla de simbolos
	 * @param id
	 * @return matched object
	 * */
	public Object find(String id){
		boolean found = false;
		Stack<HashMap <String, Object> > temporal_table = table;
		while(!temporal_table.isEmpty() && !found){
			found |= temporal_table.peek().containsKey(id);
			if(!found) temporal_table.pop();
		}
		
		return (found ? temporal_table.peek().get(id) : null );
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
		return true;
	}
 
	
	
	
	@Override
	public T visitGenerarproceso(GenerarprocesoContext ctx) {
		table.push(new HashMap<String, Object>());
		visitChildren(ctx);
		table.pop();
		return super.visitGenerarproceso(ctx);
	}
	
	@Override
	public T visitInstruccion(InstruccionContext ctx) {
		if(ctx.Escribir() != null){
			Object expr = visitExpresion_logica(ctx.expresion_logica());
			String toOutput = expr.toString();
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
			ans = (Boolean)visitExpresion_logica(ctx.expresion_logica(0));
			return (T)ans;
		}
		else if(ctx.RELOP() != null){
			String op = ctx.RELOP().getText();
			Object var1 = visitExpresion_logica(ctx.expresion_logica(0));
			Object var2 = visitExpresion_logica(ctx.expresion_logica(1));
			
			//TODO manejar error
			
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
			return (T)ans;
		}
		else if(ctx.IODOP() != null){
			String op = ctx.IODOP().getText();
			Object var1 = visitExpresion_logica(ctx.expresion_logica(0));
			Object var2 = visitExpresion_logica(ctx.expresion_logica(1));
			
			//TODO manejar error
			
			switch(op){
			case "=":
			case "==":
				ans = (comparar(var1, var2) == 0);
				break;
			case "<>":
				ans = (comparar(var1, var2) != 0);
				break;	
			}
			return (T)ans;
		}
		else if(ctx.TOKEN_Y() != null){
			Object var1 = visitExpresion_logica(ctx.expresion_logica(0));
			Object var2 = visitExpresion_logica(ctx.expresion_logica(1));
			
			
			//TODO manejo errores
			ans = (Boolean)var1 && (Boolean)var2;
			return (T)ans;
			
		}
		else if(ctx.TOKEN_O() != null){
			Object var1 = visitExpresion_logica(ctx.expresion_logica(0));
			Object var2 = visitExpresion_logica(ctx.expresion_logica(1));
			
			//TODO manejo errores
			ans = (Boolean)var1 || (Boolean)var2;
			return (T)ans;
		}
		else if(ctx.TOKEN_PAR_IZQ() != null)
			return visitExpresion_logica(ctx.expresion_logica(0));
		else if(ctx.expresion() != null){
			return visitExpresion(ctx.expresion());
		}
		
		return super.visitExpresion_logica(ctx);
	}
	
	public boolean validForMath(Object a){
		 if(a instanceof Integer || a instanceof Double)
			 return true;
		 return false;
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
					ans = Math.pow( (Double)var1, (Integer)var2 );
			else if(var1 instanceof Integer && var2 instanceof Integer)
					ans = Math.pow((Integer)var1, (Double)var2);
			else
				ans = Math.pow((Integer)var1, (Integer)var2);
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
					ans = (Double)var1 * (Integer)var2;
				else if(var1 instanceof Integer && var2 instanceof Integer)
					ans = (Integer)var1 * (Double)var2;
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
					ans = (Double)var1 / (Integer)var2;
				else if(var1 instanceof Integer && var2 instanceof Integer)
					ans = (Integer)var1 / (Double)var2;
				else
					ans = (Integer)var1 / (Integer)var2;
				break;
			case "mod":
			case "%":
				if(var1 instanceof Double && var2 instanceof Double)
					ans = (Double)var1 % (Double)var2;
				else if(var1 instanceof Double && var2 instanceof Integer)
					ans = (Double)var1 % (Integer)var2;
				else if(var1 instanceof Integer && var2 instanceof Integer)
					ans = (Integer)var1 % (Double)var2;
				else
					ans = (Integer)var1 % (Integer)var2;
				break;
			}
			return (T)ans;
		}
		
		//TODO queda pendiente en expresion calcular sumas y restas, constantes, ids y parentesis
		return super.visitExpresion(ctx);
	}
	
	
}
