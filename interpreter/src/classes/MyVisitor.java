package classes;

import java.util.HashMap;
import java.util.Stack;

import classes.MyLanguageParser.ExpresionContext;
import classes.MyLanguageParser.Expresion_logicaContext;
import classes.MyLanguageParser.GenerarprocesoContext;
import classes.MyLanguageParser.InstruccionContext;
import classes.MyLanguageParser.ProgramaContext;


public class MyVisitor<T> extends MyLanguageBaseVisitor<T>{
	//symbol table
	public Stack<HashMap <String, Object> > table = new Stack<HashMap <String, Object>>();
	
	/* searches trough symbol table for a specified id
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
			
			//id			
			//entero
			//real
			//boleano
			//cadena
		}
		//TODO
		return super.visitInstruccion(ctx);
	}
	@Override
	public T visitExpresion(ExpresionContext ctx) {

		return super.visitExpresion(ctx);
	}
	
	
}
