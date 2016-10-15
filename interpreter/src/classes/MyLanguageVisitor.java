// Generated from MyLanguage.g by ANTLR 4.5.3
package classes;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MyLanguageParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MyLanguageVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(MyLanguageParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#generarsubproceso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenerarsubproceso(MyLanguageParser.GenerarsubprocesoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#iniciosubproceso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIniciosubproceso(MyLanguageParser.IniciosubprocesoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#subproceso_arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubproceso_arg(MyLanguageParser.Subproceso_argContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#finalizarsubproceso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinalizarsubproceso(MyLanguageParser.FinalizarsubprocesoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#variable_retorno}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable_retorno(MyLanguageParser.Variable_retornoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#argumento}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumento(MyLanguageParser.ArgumentoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#lista}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLista(MyLanguageParser.ListaContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#generarproceso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenerarproceso(MyLanguageParser.GenerarprocesoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#inicioproceso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInicioproceso(MyLanguageParser.InicioprocesoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#finalizarproceso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinalizarproceso(MyLanguageParser.FinalizarprocesoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#cuerpo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCuerpo(MyLanguageParser.CuerpoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#llamado_sub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLlamado_sub(MyLanguageParser.Llamado_subContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#llamado_arr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLlamado_arr(MyLanguageParser.Llamado_arrContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#dimensionar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimensionar(MyLanguageParser.DimensionarContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#arreglo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArreglo(MyLanguageParser.ArregloContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#dim}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDim(MyLanguageParser.DimContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#lista_arreglos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLista_arreglos(MyLanguageParser.Lista_arreglosContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#definicion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinicion(MyLanguageParser.DefinicionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#asignacion_llamado}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignacion_llamado(MyLanguageParser.Asignacion_llamadoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#llamar_o_asignar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLlamar_o_asignar(MyLanguageParser.Llamar_o_asignarContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#asignar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignar(MyLanguageParser.AsignarContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#lista_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLista_expr(MyLanguageParser.Lista_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresion(MyLanguageParser.ExpresionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#complemento}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComplemento(MyLanguageParser.ComplementoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#expresion_logica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresion_logica(MyLanguageParser.Expresion_logicaContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#complementos_adicionales}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComplementos_adicionales(MyLanguageParser.Complementos_adicionalesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#expresion_mat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresion_mat(MyLanguageParser.Expresion_matContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#expresion_mat2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresion_mat2(MyLanguageParser.Expresion_mat2Context ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#termino}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermino(MyLanguageParser.TerminoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#constante}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstante(MyLanguageParser.ConstanteContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(MyLanguageParser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruccion(MyLanguageParser.InstruccionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#ins_borrar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIns_borrar(MyLanguageParser.Ins_borrarContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#ins_esperar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIns_esperar(MyLanguageParser.Ins_esperarContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#lista_id_o_llamado}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLista_id_o_llamado(MyLanguageParser.Lista_id_o_llamadoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#condicional_si}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondicional_si(MyLanguageParser.Condicional_siContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#evaluar_par}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvaluar_par(MyLanguageParser.Evaluar_parContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#si_no}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSi_no(MyLanguageParser.Si_noContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#ciclo_para}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCiclo_para(MyLanguageParser.Ciclo_paraContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#con_paso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCon_paso(MyLanguageParser.Con_pasoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#ciclo_mientras}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCiclo_mientras(MyLanguageParser.Ciclo_mientrasContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#ciclo_repetir}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCiclo_repetir(MyLanguageParser.Ciclo_repetirContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#segun_hacer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSegun_hacer(MyLanguageParser.Segun_hacerContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#de_otro_modo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDe_otro_modo(MyLanguageParser.De_otro_modoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#casos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCasos(MyLanguageParser.CasosContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#caso_segun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaso_segun(MyLanguageParser.Caso_segunContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#id_o_llamado}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId_o_llamado(MyLanguageParser.Id_o_llamadoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#complemento_id_o_llamado}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComplemento_id_o_llamado(MyLanguageParser.Complemento_id_o_llamadoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#llamado_proceso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLlamado_proceso(MyLanguageParser.Llamado_procesoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#arg_llamado_proceso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg_llamado_proceso(MyLanguageParser.Arg_llamado_procesoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#arg_llamado}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg_llamado(MyLanguageParser.Arg_llamadoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#lista_arg_llamado}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLista_arg_llamado(MyLanguageParser.Lista_arg_llamadoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#acceder_arreglo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAcceder_arreglo(MyLanguageParser.Acceder_arregloContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#index}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex(MyLanguageParser.IndexContext ctx);
}