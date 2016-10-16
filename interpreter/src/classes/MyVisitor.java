package classes;

import classes.MyLanguageParser.InstruccionContext;

public class MyVisitor<T> extends MyLanguageBaseVisitor<T>{
	@Override
	public T visitInstruccion(InstruccionContext ctx) {
		if(ctx.Leer() != null){
			//TODO 
		}
		if(ctx.Escribir() != null){
			//TODO
		}
		else{
			return visitChildren(ctx);
		}
		return super.visitInstruccion(ctx);
	}
	
}
