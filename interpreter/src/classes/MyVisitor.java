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
			
			if(var1 instanceof String){
				
			}
			else if(var1 instanceof Integer){
				
			}
			else if(var1 instanceof Double){
				
			}
			else if(var1 instanceof Boolean){
				
			}
			
			
			switch(op){
			case "<":
				
			}
				
			
		}
		return super.visitExpresion_logica(ctx);
	}
	
	
}
