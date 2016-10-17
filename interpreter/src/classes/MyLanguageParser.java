// Generated from MyLanguage.g by ANTLR 4.5.3
package classes;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MyLanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, LINE_COMMENT=2, WS=3, Verdadero=4, Falso=5, Algoritmo=6, Proceso=7, 
		Finproceso=8, Finalgoritmo=9, Definir=10, Como=11, Entero=12, Numero=13, 
		Numerico=14, Real=15, Logico=16, Caracter=17, Texto=18, Cadena=19, Dimension=20, 
		Mientras=21, Hacer=22, Finmientras=23, Milisegundos=24, Segundos=25, Leer=26, 
		Limpiar=27, Pantalla=28, Repetir=29, Funcion=30, Tecla=31, Escribir=32, 
		Esperar=33, Hasta=34, Que=35, Para=36, Finpara=37, Con=38, Paso=39, Si=40, 
		Finsi=41, Sino=42, Entonces=43, Segun=44, Finsegun=45, Finfuncion=46, 
		De=47, Otro=48, Modo=49, Mod=50, Subproceso=51, Finsubproceso=52, Borrar=53, 
		Finsubalgoritmo=54, Subalgoritmo=55, Caso=56, RELOP=57, IODOP=58, TOKEN_MENOS=59, 
		SUMOP=60, MULOP=61, TOKEN_PAR_IZQ=62, TOKEN_PAR_DER=63, TOKEN_COR_IZQ=64, 
		TOKEN_COR_DER=65, TOKEN_PYC=66, TOKEN_ASIG=67, TOKEN_DIF=68, TOKEN_MENOR=69, 
		TOKEN_MAYOR=70, TOKEN_MENOR_IGUAL=71, TOKEN_MAYOR_IGUAL=72, TOKEN_COMA=73, 
		TOKEN_O=74, TOKEN_Y=75, TOKEN_NEG=76, TOKEN_IGUAL=77, TOKEN_MAS=78, TOKEN_DIV=79, 
		TOKEN_MUL=80, TOKEN_MOD=81, TOKEN_DOSP=82, TOKEN_POT=83, TOKEN_EOF=84, 
		TOKEN_ENTERO=85, TOKEN_REAL=86, TOKEN_CADENA=87, ID=88;
	public static final int
		RULE_programa = 0, RULE_generarsubproceso = 1, RULE_iniciosubproceso = 2, 
		RULE_subproceso_arg = 3, RULE_finalizarsubproceso = 4, RULE_variable_retorno = 5, 
		RULE_argumento = 6, RULE_lista = 7, RULE_generarproceso = 8, RULE_inicioproceso = 9, 
		RULE_finalizarproceso = 10, RULE_cuerpo = 11, RULE_dimensionar = 12, RULE_arreglo = 13, 
		RULE_dim = 14, RULE_lista_arreglos = 15, RULE_definicion = 16, RULE_asignacion_llamado = 17, 
		RULE_llamar_o_asignar = 18, RULE_asignar = 19, RULE_lista_expr = 20, RULE_expresion_logica = 21, 
		RULE_expresion = 22, RULE_constante = 23, RULE_tipo = 24, RULE_id = 25, 
		RULE_llamado = 26, RULE_pars_fun = 27, RULE_pars_lista = 28, RULE_acceder_arreglo = 29, 
		RULE_instruccion = 30, RULE_ins_borrar = 31, RULE_ins_esperar = 32, RULE_lista_id_o_llamado = 33, 
		RULE_condicional_si = 34, RULE_si_no = 35, RULE_ciclo_para = 36, RULE_con_paso = 37, 
		RULE_ciclo_mientras = 38, RULE_ciclo_repetir = 39, RULE_segun_hacer = 40, 
		RULE_de_otro_modo = 41, RULE_casos = 42, RULE_caso_segun = 43;
	public static final String[] ruleNames = {
		"programa", "generarsubproceso", "iniciosubproceso", "subproceso_arg", 
		"finalizarsubproceso", "variable_retorno", "argumento", "lista", "generarproceso", 
		"inicioproceso", "finalizarproceso", "cuerpo", "dimensionar", "arreglo", 
		"dim", "lista_arreglos", "definicion", "asignacion_llamado", "llamar_o_asignar", 
		"asignar", "lista_expr", "expresion_logica", "expresion", "constante", 
		"tipo", "id", "llamado", "pars_fun", "pars_lista", "acceder_arreglo", 
		"instruccion", "ins_borrar", "ins_esperar", "lista_id_o_llamado", "condicional_si", 
		"si_no", "ciclo_para", "con_paso", "ciclo_mientras", "ciclo_repetir", 
		"segun_hacer", "de_otro_modo", "casos", "caso_segun"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, "'verdadero'", "'falso'", "'algoritmo'", "'proceso'", 
		"'finproceso'", "'finalgoritmo'", "'definir'", "'como'", "'entero'", "'numero'", 
		"'numerico'", "'real'", "'logico'", "'caracter'", "'texto'", "'cadena'", 
		"'dimension'", "'mientras'", "'hacer'", "'finmientras'", "'milisegundos'", 
		"'segundos'", "'leer'", "'limpiar'", "'pantalla'", "'repetir'", "'funcion'", 
		"'tecla'", "'escribir'", "'esperar'", "'hasta'", "'que'", "'para'", "'finpara'", 
		"'con'", "'paso'", "'si'", "'finsi'", "'sino'", "'entonces'", "'segun'", 
		"'finsegun'", "'finfuncion'", "'de'", "'otro'", "'modo'", "'mod'", "'subproceso'", 
		"'finsubproceso'", "'borrar'", "'finsubalgoritmo'", "'subalgoritmo'", 
		"'caso'", null, null, "'-'", null, null, "'('", "')'", "'['", "']'", "';'", 
		"'<-'", "'<>'", "'<'", "'>'", "'<='", "'>='", "','", null, null, null, 
		null, "'+'", "'/'", "'*'", null, "':'", "'^'", "'$'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "COMMENT", "LINE_COMMENT", "WS", "Verdadero", "Falso", "Algoritmo", 
		"Proceso", "Finproceso", "Finalgoritmo", "Definir", "Como", "Entero", 
		"Numero", "Numerico", "Real", "Logico", "Caracter", "Texto", "Cadena", 
		"Dimension", "Mientras", "Hacer", "Finmientras", "Milisegundos", "Segundos", 
		"Leer", "Limpiar", "Pantalla", "Repetir", "Funcion", "Tecla", "Escribir", 
		"Esperar", "Hasta", "Que", "Para", "Finpara", "Con", "Paso", "Si", "Finsi", 
		"Sino", "Entonces", "Segun", "Finsegun", "Finfuncion", "De", "Otro", "Modo", 
		"Mod", "Subproceso", "Finsubproceso", "Borrar", "Finsubalgoritmo", "Subalgoritmo", 
		"Caso", "RELOP", "IODOP", "TOKEN_MENOS", "SUMOP", "MULOP", "TOKEN_PAR_IZQ", 
		"TOKEN_PAR_DER", "TOKEN_COR_IZQ", "TOKEN_COR_DER", "TOKEN_PYC", "TOKEN_ASIG", 
		"TOKEN_DIF", "TOKEN_MENOR", "TOKEN_MAYOR", "TOKEN_MENOR_IGUAL", "TOKEN_MAYOR_IGUAL", 
		"TOKEN_COMA", "TOKEN_O", "TOKEN_Y", "TOKEN_NEG", "TOKEN_IGUAL", "TOKEN_MAS", 
		"TOKEN_DIV", "TOKEN_MUL", "TOKEN_MOD", "TOKEN_DOSP", "TOKEN_POT", "TOKEN_EOF", 
		"TOKEN_ENTERO", "TOKEN_REAL", "TOKEN_CADENA", "ID"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MyLanguage.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MyLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramaContext extends ParserRuleContext {
		public GenerarsubprocesoContext generarsubproceso() {
			return getRuleContext(GenerarsubprocesoContext.class,0);
		}
		public GenerarprocesoContext generarproceso() {
			return getRuleContext(GenerarprocesoContext.class,0);
		}
		public TerminalNode EOF() { return getToken(MyLanguageParser.EOF, 0); }
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitPrograma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		try {
			setState(93);
			switch (_input.LA(1)) {
			case Algoritmo:
			case Proceso:
			case Funcion:
			case Subproceso:
			case Subalgoritmo:
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				generarsubproceso();
				setState(89);
				generarproceso();
				setState(90);
				match(EOF);
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
				setState(92);
				match(EOF);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GenerarsubprocesoContext extends ParserRuleContext {
		public IniciosubprocesoContext iniciosubproceso() {
			return getRuleContext(IniciosubprocesoContext.class,0);
		}
		public Variable_retornoContext variable_retorno() {
			return getRuleContext(Variable_retornoContext.class,0);
		}
		public TerminalNode ID() { return getToken(MyLanguageParser.ID, 0); }
		public Subproceso_argContext subproceso_arg() {
			return getRuleContext(Subproceso_argContext.class,0);
		}
		public CuerpoContext cuerpo() {
			return getRuleContext(CuerpoContext.class,0);
		}
		public FinalizarsubprocesoContext finalizarsubproceso() {
			return getRuleContext(FinalizarsubprocesoContext.class,0);
		}
		public GenerarsubprocesoContext generarsubproceso() {
			return getRuleContext(GenerarsubprocesoContext.class,0);
		}
		public GenerarsubprocesoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generarsubproceso; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterGenerarsubproceso(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitGenerarsubproceso(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitGenerarsubproceso(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GenerarsubprocesoContext generarsubproceso() throws RecognitionException {
		GenerarsubprocesoContext _localctx = new GenerarsubprocesoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_generarsubproceso);
		try {
			setState(104);
			switch (_input.LA(1)) {
			case Funcion:
			case Subproceso:
			case Subalgoritmo:
				enterOuterAlt(_localctx, 1);
				{
				setState(95);
				iniciosubproceso();
				setState(96);
				variable_retorno();
				setState(97);
				match(ID);
				setState(98);
				subproceso_arg();
				setState(99);
				cuerpo();
				setState(100);
				finalizarsubproceso();
				setState(101);
				generarsubproceso();
				}
				break;
			case Algoritmo:
			case Proceso:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IniciosubprocesoContext extends ParserRuleContext {
		public TerminalNode Subproceso() { return getToken(MyLanguageParser.Subproceso, 0); }
		public TerminalNode Subalgoritmo() { return getToken(MyLanguageParser.Subalgoritmo, 0); }
		public TerminalNode Funcion() { return getToken(MyLanguageParser.Funcion, 0); }
		public IniciosubprocesoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iniciosubproceso; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterIniciosubproceso(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitIniciosubproceso(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitIniciosubproceso(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IniciosubprocesoContext iniciosubproceso() throws RecognitionException {
		IniciosubprocesoContext _localctx = new IniciosubprocesoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_iniciosubproceso);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Funcion) | (1L << Subproceso) | (1L << Subalgoritmo))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Subproceso_argContext extends ParserRuleContext {
		public TerminalNode TOKEN_PAR_IZQ() { return getToken(MyLanguageParser.TOKEN_PAR_IZQ, 0); }
		public ArgumentoContext argumento() {
			return getRuleContext(ArgumentoContext.class,0);
		}
		public TerminalNode TOKEN_PAR_DER() { return getToken(MyLanguageParser.TOKEN_PAR_DER, 0); }
		public Subproceso_argContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subproceso_arg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterSubproceso_arg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitSubproceso_arg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitSubproceso_arg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Subproceso_argContext subproceso_arg() throws RecognitionException {
		Subproceso_argContext _localctx = new Subproceso_argContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_subproceso_arg);
		try {
			setState(113);
			switch (_input.LA(1)) {
			case TOKEN_PAR_IZQ:
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				match(TOKEN_PAR_IZQ);
				setState(109);
				argumento();
				setState(110);
				match(TOKEN_PAR_DER);
				}
				break;
			case Definir:
			case Dimension:
			case Mientras:
			case Leer:
			case Limpiar:
			case Repetir:
			case Escribir:
			case Esperar:
			case Para:
			case Si:
			case Segun:
			case Finfuncion:
			case Finsubproceso:
			case Borrar:
			case Finsubalgoritmo:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FinalizarsubprocesoContext extends ParserRuleContext {
		public TerminalNode Finsubproceso() { return getToken(MyLanguageParser.Finsubproceso, 0); }
		public TerminalNode Finsubalgoritmo() { return getToken(MyLanguageParser.Finsubalgoritmo, 0); }
		public TerminalNode Finfuncion() { return getToken(MyLanguageParser.Finfuncion, 0); }
		public FinalizarsubprocesoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finalizarsubproceso; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterFinalizarsubproceso(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitFinalizarsubproceso(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitFinalizarsubproceso(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FinalizarsubprocesoContext finalizarsubproceso() throws RecognitionException {
		FinalizarsubprocesoContext _localctx = new FinalizarsubprocesoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_finalizarsubproceso);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Finfuncion) | (1L << Finsubproceso) | (1L << Finsubalgoritmo))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Variable_retornoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MyLanguageParser.ID, 0); }
		public TerminalNode TOKEN_ASIG() { return getToken(MyLanguageParser.TOKEN_ASIG, 0); }
		public Variable_retornoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_retorno; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterVariable_retorno(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitVariable_retorno(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitVariable_retorno(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variable_retornoContext variable_retorno() throws RecognitionException {
		Variable_retornoContext _localctx = new Variable_retornoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_variable_retorno);
		try {
			setState(120);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				match(ID);
				setState(118);
				match(TOKEN_ASIG);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MyLanguageParser.ID, 0); }
		public ListaContext lista() {
			return getRuleContext(ListaContext.class,0);
		}
		public ArgumentoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumento; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterArgumento(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitArgumento(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitArgumento(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentoContext argumento() throws RecognitionException {
		ArgumentoContext _localctx = new ArgumentoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_argumento);
		try {
			setState(125);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				match(ID);
				setState(123);
				lista();
				}
				break;
			case TOKEN_PAR_DER:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListaContext extends ParserRuleContext {
		public TerminalNode TOKEN_COMA() { return getToken(MyLanguageParser.TOKEN_COMA, 0); }
		public TerminalNode ID() { return getToken(MyLanguageParser.ID, 0); }
		public ListaContext lista() {
			return getRuleContext(ListaContext.class,0);
		}
		public ListaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lista; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterLista(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitLista(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitLista(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListaContext lista() throws RecognitionException {
		ListaContext _localctx = new ListaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_lista);
		try {
			setState(131);
			switch (_input.LA(1)) {
			case TOKEN_COMA:
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				match(TOKEN_COMA);
				setState(128);
				match(ID);
				setState(129);
				lista();
				}
				break;
			case Como:
			case TOKEN_PAR_DER:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GenerarprocesoContext extends ParserRuleContext {
		public InicioprocesoContext inicioproceso() {
			return getRuleContext(InicioprocesoContext.class,0);
		}
		public TerminalNode ID() { return getToken(MyLanguageParser.ID, 0); }
		public CuerpoContext cuerpo() {
			return getRuleContext(CuerpoContext.class,0);
		}
		public FinalizarprocesoContext finalizarproceso() {
			return getRuleContext(FinalizarprocesoContext.class,0);
		}
		public GenerarprocesoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generarproceso; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterGenerarproceso(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitGenerarproceso(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitGenerarproceso(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GenerarprocesoContext generarproceso() throws RecognitionException {
		GenerarprocesoContext _localctx = new GenerarprocesoContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_generarproceso);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			inicioproceso();
			setState(134);
			match(ID);
			setState(135);
			cuerpo();
			setState(136);
			finalizarproceso();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InicioprocesoContext extends ParserRuleContext {
		public TerminalNode Proceso() { return getToken(MyLanguageParser.Proceso, 0); }
		public TerminalNode Algoritmo() { return getToken(MyLanguageParser.Algoritmo, 0); }
		public InicioprocesoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inicioproceso; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterInicioproceso(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitInicioproceso(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitInicioproceso(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InicioprocesoContext inicioproceso() throws RecognitionException {
		InicioprocesoContext _localctx = new InicioprocesoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_inicioproceso);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			_la = _input.LA(1);
			if ( !(_la==Algoritmo || _la==Proceso) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FinalizarprocesoContext extends ParserRuleContext {
		public TerminalNode Finproceso() { return getToken(MyLanguageParser.Finproceso, 0); }
		public TerminalNode Finalgoritmo() { return getToken(MyLanguageParser.Finalgoritmo, 0); }
		public FinalizarprocesoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finalizarproceso; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterFinalizarproceso(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitFinalizarproceso(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitFinalizarproceso(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FinalizarprocesoContext finalizarproceso() throws RecognitionException {
		FinalizarprocesoContext _localctx = new FinalizarprocesoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_finalizarproceso);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			_la = _input.LA(1);
			if ( !(_la==Finproceso || _la==Finalgoritmo) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CuerpoContext extends ParserRuleContext {
		public TerminalNode Definir() { return getToken(MyLanguageParser.Definir, 0); }
		public DefinicionContext definicion() {
			return getRuleContext(DefinicionContext.class,0);
		}
		public CuerpoContext cuerpo() {
			return getRuleContext(CuerpoContext.class,0);
		}
		public InstruccionContext instruccion() {
			return getRuleContext(InstruccionContext.class,0);
		}
		public TerminalNode Dimension() { return getToken(MyLanguageParser.Dimension, 0); }
		public DimensionarContext dimensionar() {
			return getRuleContext(DimensionarContext.class,0);
		}
		public TerminalNode Si() { return getToken(MyLanguageParser.Si, 0); }
		public Condicional_siContext condicional_si() {
			return getRuleContext(Condicional_siContext.class,0);
		}
		public TerminalNode Para() { return getToken(MyLanguageParser.Para, 0); }
		public Ciclo_paraContext ciclo_para() {
			return getRuleContext(Ciclo_paraContext.class,0);
		}
		public TerminalNode Mientras() { return getToken(MyLanguageParser.Mientras, 0); }
		public Ciclo_mientrasContext ciclo_mientras() {
			return getRuleContext(Ciclo_mientrasContext.class,0);
		}
		public TerminalNode Repetir() { return getToken(MyLanguageParser.Repetir, 0); }
		public Ciclo_repetirContext ciclo_repetir() {
			return getRuleContext(Ciclo_repetirContext.class,0);
		}
		public TerminalNode Segun() { return getToken(MyLanguageParser.Segun, 0); }
		public Segun_hacerContext segun_hacer() {
			return getRuleContext(Segun_hacerContext.class,0);
		}
		public Asignacion_llamadoContext asignacion_llamado() {
			return getRuleContext(Asignacion_llamadoContext.class,0);
		}
		public CuerpoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cuerpo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterCuerpo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitCuerpo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitCuerpo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CuerpoContext cuerpo() throws RecognitionException {
		CuerpoContext _localctx = new CuerpoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cuerpo);
		try {
			setState(177);
			switch (_input.LA(1)) {
			case Definir:
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				match(Definir);
				setState(143);
				definicion();
				setState(144);
				cuerpo();
				}
				break;
			case Leer:
			case Limpiar:
			case Escribir:
			case Esperar:
			case Borrar:
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				instruccion();
				setState(147);
				cuerpo();
				}
				break;
			case Dimension:
				enterOuterAlt(_localctx, 3);
				{
				setState(149);
				match(Dimension);
				setState(150);
				dimensionar();
				setState(151);
				cuerpo();
				}
				break;
			case Si:
				enterOuterAlt(_localctx, 4);
				{
				setState(153);
				match(Si);
				setState(154);
				condicional_si();
				setState(155);
				cuerpo();
				}
				break;
			case Para:
				enterOuterAlt(_localctx, 5);
				{
				setState(157);
				match(Para);
				setState(158);
				ciclo_para();
				setState(159);
				cuerpo();
				}
				break;
			case Mientras:
				enterOuterAlt(_localctx, 6);
				{
				setState(161);
				match(Mientras);
				setState(162);
				ciclo_mientras();
				setState(163);
				cuerpo();
				}
				break;
			case Repetir:
				enterOuterAlt(_localctx, 7);
				{
				setState(165);
				match(Repetir);
				setState(166);
				ciclo_repetir();
				setState(167);
				cuerpo();
				}
				break;
			case Segun:
				enterOuterAlt(_localctx, 8);
				{
				setState(169);
				match(Segun);
				setState(170);
				segun_hacer();
				setState(171);
				cuerpo();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 9);
				{
				setState(173);
				asignacion_llamado();
				setState(174);
				cuerpo();
				}
				break;
			case Finproceso:
			case Finalgoritmo:
			case Finmientras:
			case Hasta:
			case Finpara:
			case Finsi:
			case Sino:
			case Finsegun:
			case Finfuncion:
			case De:
			case Finsubproceso:
			case Finsubalgoritmo:
			case Caso:
				enterOuterAlt(_localctx, 10);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DimensionarContext extends ParserRuleContext {
		public ArregloContext arreglo() {
			return getRuleContext(ArregloContext.class,0);
		}
		public Lista_arreglosContext lista_arreglos() {
			return getRuleContext(Lista_arreglosContext.class,0);
		}
		public TerminalNode TOKEN_PYC() { return getToken(MyLanguageParser.TOKEN_PYC, 0); }
		public DimensionarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dimensionar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterDimensionar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitDimensionar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitDimensionar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DimensionarContext dimensionar() throws RecognitionException {
		DimensionarContext _localctx = new DimensionarContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_dimensionar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			arreglo();
			setState(180);
			lista_arreglos();
			setState(181);
			match(TOKEN_PYC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArregloContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MyLanguageParser.ID, 0); }
		public DimContext dim() {
			return getRuleContext(DimContext.class,0);
		}
		public ArregloContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arreglo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterArreglo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitArreglo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitArreglo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArregloContext arreglo() throws RecognitionException {
		ArregloContext _localctx = new ArregloContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_arreglo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(ID);
			setState(184);
			dim();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DimContext extends ParserRuleContext {
		public TerminalNode TOKEN_COR_IZQ() { return getToken(MyLanguageParser.TOKEN_COR_IZQ, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public Lista_exprContext lista_expr() {
			return getRuleContext(Lista_exprContext.class,0);
		}
		public TerminalNode TOKEN_COR_DER() { return getToken(MyLanguageParser.TOKEN_COR_DER, 0); }
		public TerminalNode TOKEN_PAR_IZQ() { return getToken(MyLanguageParser.TOKEN_PAR_IZQ, 0); }
		public TerminalNode TOKEN_PAR_DER() { return getToken(MyLanguageParser.TOKEN_PAR_DER, 0); }
		public DimContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dim; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterDim(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitDim(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitDim(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DimContext dim() throws RecognitionException {
		DimContext _localctx = new DimContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_dim);
		try {
			setState(196);
			switch (_input.LA(1)) {
			case TOKEN_COR_IZQ:
				enterOuterAlt(_localctx, 1);
				{
				setState(186);
				match(TOKEN_COR_IZQ);
				setState(187);
				expresion(0);
				setState(188);
				lista_expr();
				setState(189);
				match(TOKEN_COR_DER);
				}
				break;
			case TOKEN_PAR_IZQ:
				enterOuterAlt(_localctx, 2);
				{
				setState(191);
				match(TOKEN_PAR_IZQ);
				setState(192);
				expresion(0);
				setState(193);
				lista_expr();
				setState(194);
				match(TOKEN_PAR_DER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Lista_arreglosContext extends ParserRuleContext {
		public TerminalNode TOKEN_COMA() { return getToken(MyLanguageParser.TOKEN_COMA, 0); }
		public ArregloContext arreglo() {
			return getRuleContext(ArregloContext.class,0);
		}
		public Lista_arreglosContext lista_arreglos() {
			return getRuleContext(Lista_arreglosContext.class,0);
		}
		public Lista_arreglosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lista_arreglos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterLista_arreglos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitLista_arreglos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitLista_arreglos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lista_arreglosContext lista_arreglos() throws RecognitionException {
		Lista_arreglosContext _localctx = new Lista_arreglosContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_lista_arreglos);
		try {
			setState(203);
			switch (_input.LA(1)) {
			case TOKEN_COMA:
				enterOuterAlt(_localctx, 1);
				{
				setState(198);
				match(TOKEN_COMA);
				setState(199);
				arreglo();
				setState(200);
				lista_arreglos();
				}
				break;
			case TOKEN_PYC:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefinicionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MyLanguageParser.ID, 0); }
		public ListaContext lista() {
			return getRuleContext(ListaContext.class,0);
		}
		public TerminalNode Como() { return getToken(MyLanguageParser.Como, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode TOKEN_PYC() { return getToken(MyLanguageParser.TOKEN_PYC, 0); }
		public DefinicionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definicion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterDefinicion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitDefinicion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitDefinicion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinicionContext definicion() throws RecognitionException {
		DefinicionContext _localctx = new DefinicionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_definicion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(ID);
			setState(206);
			lista();
			setState(207);
			match(Como);
			setState(208);
			tipo();
			setState(209);
			match(TOKEN_PYC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Asignacion_llamadoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MyLanguageParser.ID, 0); }
		public Llamar_o_asignarContext llamar_o_asignar() {
			return getRuleContext(Llamar_o_asignarContext.class,0);
		}
		public TerminalNode TOKEN_PYC() { return getToken(MyLanguageParser.TOKEN_PYC, 0); }
		public Asignacion_llamadoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asignacion_llamado; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterAsignacion_llamado(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitAsignacion_llamado(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitAsignacion_llamado(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Asignacion_llamadoContext asignacion_llamado() throws RecognitionException {
		Asignacion_llamadoContext _localctx = new Asignacion_llamadoContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_asignacion_llamado);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(ID);
			setState(212);
			llamar_o_asignar();
			setState(213);
			match(TOKEN_PYC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Llamar_o_asignarContext extends ParserRuleContext {
		public AsignarContext asignar() {
			return getRuleContext(AsignarContext.class,0);
		}
		public Acceder_arregloContext acceder_arreglo() {
			return getRuleContext(Acceder_arregloContext.class,0);
		}
		public Pars_funContext pars_fun() {
			return getRuleContext(Pars_funContext.class,0);
		}
		public Llamar_o_asignarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_llamar_o_asignar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterLlamar_o_asignar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitLlamar_o_asignar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitLlamar_o_asignar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Llamar_o_asignarContext llamar_o_asignar() throws RecognitionException {
		Llamar_o_asignarContext _localctx = new Llamar_o_asignarContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_llamar_o_asignar);
		try {
			setState(220);
			switch (_input.LA(1)) {
			case TOKEN_ASIG:
				enterOuterAlt(_localctx, 1);
				{
				setState(215);
				asignar();
				}
				break;
			case TOKEN_COR_IZQ:
				enterOuterAlt(_localctx, 2);
				{
				setState(216);
				acceder_arreglo();
				setState(217);
				asignar();
				}
				break;
			case TOKEN_PAR_IZQ:
				enterOuterAlt(_localctx, 3);
				{
				setState(219);
				pars_fun();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AsignarContext extends ParserRuleContext {
		public TerminalNode TOKEN_ASIG() { return getToken(MyLanguageParser.TOKEN_ASIG, 0); }
		public Expresion_logicaContext expresion_logica() {
			return getRuleContext(Expresion_logicaContext.class,0);
		}
		public AsignarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asignar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterAsignar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitAsignar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitAsignar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsignarContext asignar() throws RecognitionException {
		AsignarContext _localctx = new AsignarContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_asignar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(TOKEN_ASIG);
			setState(223);
			expresion_logica(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Lista_exprContext extends ParserRuleContext {
		public TerminalNode TOKEN_COMA() { return getToken(MyLanguageParser.TOKEN_COMA, 0); }
		public Expresion_logicaContext expresion_logica() {
			return getRuleContext(Expresion_logicaContext.class,0);
		}
		public Lista_exprContext lista_expr() {
			return getRuleContext(Lista_exprContext.class,0);
		}
		public Lista_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lista_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterLista_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitLista_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitLista_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lista_exprContext lista_expr() throws RecognitionException {
		Lista_exprContext _localctx = new Lista_exprContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_lista_expr);
		try {
			setState(230);
			switch (_input.LA(1)) {
			case TOKEN_COMA:
				enterOuterAlt(_localctx, 1);
				{
				setState(225);
				match(TOKEN_COMA);
				setState(226);
				expresion_logica(0);
				setState(227);
				lista_expr();
				}
				break;
			case TOKEN_PAR_DER:
			case TOKEN_COR_DER:
			case TOKEN_PYC:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expresion_logicaContext extends ParserRuleContext {
		public TerminalNode TOKEN_NEG() { return getToken(MyLanguageParser.TOKEN_NEG, 0); }
		public List<Expresion_logicaContext> expresion_logica() {
			return getRuleContexts(Expresion_logicaContext.class);
		}
		public Expresion_logicaContext expresion_logica(int i) {
			return getRuleContext(Expresion_logicaContext.class,i);
		}
		public TerminalNode TOKEN_PAR_IZQ() { return getToken(MyLanguageParser.TOKEN_PAR_IZQ, 0); }
		public TerminalNode TOKEN_PAR_DER() { return getToken(MyLanguageParser.TOKEN_PAR_DER, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode RELOP() { return getToken(MyLanguageParser.RELOP, 0); }
		public TerminalNode IODOP() { return getToken(MyLanguageParser.IODOP, 0); }
		public TerminalNode TOKEN_Y() { return getToken(MyLanguageParser.TOKEN_Y, 0); }
		public TerminalNode TOKEN_O() { return getToken(MyLanguageParser.TOKEN_O, 0); }
		public Expresion_logicaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion_logica; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterExpresion_logica(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitExpresion_logica(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitExpresion_logica(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expresion_logicaContext expresion_logica() throws RecognitionException {
		return expresion_logica(0);
	}

	private Expresion_logicaContext expresion_logica(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expresion_logicaContext _localctx = new Expresion_logicaContext(_ctx, _parentState);
		Expresion_logicaContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_expresion_logica, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(233);
				match(TOKEN_NEG);
				setState(234);
				expresion_logica(7);
				}
				break;
			case 2:
				{
				setState(235);
				match(TOKEN_PAR_IZQ);
				setState(236);
				expresion_logica(0);
				setState(237);
				match(TOKEN_PAR_DER);
				}
				break;
			case 3:
				{
				setState(239);
				expresion(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(256);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(254);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new Expresion_logicaContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion_logica);
						setState(242);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(243);
						match(RELOP);
						setState(244);
						expresion_logica(7);
						}
						break;
					case 2:
						{
						_localctx = new Expresion_logicaContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion_logica);
						setState(245);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(246);
						match(IODOP);
						setState(247);
						expresion_logica(6);
						}
						break;
					case 3:
						{
						_localctx = new Expresion_logicaContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion_logica);
						setState(248);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(249);
						match(TOKEN_Y);
						setState(250);
						expresion_logica(5);
						}
						break;
					case 4:
						{
						_localctx = new Expresion_logicaContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion_logica);
						setState(251);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(252);
						match(TOKEN_O);
						setState(253);
						expresion_logica(4);
						}
						break;
					}
					} 
				}
				setState(258);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExpresionContext extends ParserRuleContext {
		public TerminalNode TOKEN_MENOS() { return getToken(MyLanguageParser.TOKEN_MENOS, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public ConstanteContext constante() {
			return getRuleContext(ConstanteContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode TOKEN_PAR_IZQ() { return getToken(MyLanguageParser.TOKEN_PAR_IZQ, 0); }
		public TerminalNode TOKEN_PAR_DER() { return getToken(MyLanguageParser.TOKEN_PAR_DER, 0); }
		public TerminalNode TOKEN_POT() { return getToken(MyLanguageParser.TOKEN_POT, 0); }
		public TerminalNode MULOP() { return getToken(MyLanguageParser.MULOP, 0); }
		public TerminalNode SUMOP() { return getToken(MyLanguageParser.SUMOP, 0); }
		public ExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterExpresion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitExpresion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitExpresion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpresionContext expresion() throws RecognitionException {
		return expresion(0);
	}

	private ExpresionContext expresion(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpresionContext _localctx = new ExpresionContext(_ctx, _parentState);
		ExpresionContext _prevctx = _localctx;
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_expresion, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			switch (_input.LA(1)) {
			case TOKEN_MENOS:
				{
				setState(260);
				match(TOKEN_MENOS);
				setState(261);
				expresion(7);
				}
				break;
			case Verdadero:
			case Falso:
			case TOKEN_ENTERO:
			case TOKEN_REAL:
			case TOKEN_CADENA:
				{
				setState(262);
				constante();
				}
				break;
			case ID:
				{
				setState(263);
				id();
				}
				break;
			case TOKEN_PAR_IZQ:
				{
				setState(264);
				match(TOKEN_PAR_IZQ);
				setState(265);
				expresion(0);
				setState(266);
				match(TOKEN_PAR_DER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(281);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(279);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(270);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(271);
						match(TOKEN_POT);
						setState(272);
						expresion(7);
						}
						break;
					case 2:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(273);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(274);
						match(MULOP);
						setState(275);
						expresion(6);
						}
						break;
					case 3:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(276);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(277);
						match(SUMOP);
						setState(278);
						expresion(5);
						}
						break;
					}
					} 
				}
				setState(283);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ConstanteContext extends ParserRuleContext {
		public TerminalNode TOKEN_ENTERO() { return getToken(MyLanguageParser.TOKEN_ENTERO, 0); }
		public TerminalNode TOKEN_REAL() { return getToken(MyLanguageParser.TOKEN_REAL, 0); }
		public TerminalNode TOKEN_CADENA() { return getToken(MyLanguageParser.TOKEN_CADENA, 0); }
		public TerminalNode Verdadero() { return getToken(MyLanguageParser.Verdadero, 0); }
		public TerminalNode Falso() { return getToken(MyLanguageParser.Falso, 0); }
		public ConstanteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constante; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterConstante(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitConstante(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitConstante(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstanteContext constante() throws RecognitionException {
		ConstanteContext _localctx = new ConstanteContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_constante);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			_la = _input.LA(1);
			if ( !(_la==Verdadero || _la==Falso || ((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (TOKEN_ENTERO - 85)) | (1L << (TOKEN_REAL - 85)) | (1L << (TOKEN_CADENA - 85)))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipoContext extends ParserRuleContext {
		public TerminalNode Caracter() { return getToken(MyLanguageParser.Caracter, 0); }
		public TerminalNode Entero() { return getToken(MyLanguageParser.Entero, 0); }
		public TerminalNode Logico() { return getToken(MyLanguageParser.Logico, 0); }
		public TerminalNode Numero() { return getToken(MyLanguageParser.Numero, 0); }
		public TerminalNode Numerico() { return getToken(MyLanguageParser.Numerico, 0); }
		public TerminalNode Real() { return getToken(MyLanguageParser.Real, 0); }
		public TerminalNode Texto() { return getToken(MyLanguageParser.Texto, 0); }
		public TerminalNode Cadena() { return getToken(MyLanguageParser.Cadena, 0); }
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitTipo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitTipo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_tipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Entero) | (1L << Numero) | (1L << Numerico) | (1L << Real) | (1L << Logico) | (1L << Caracter) | (1L << Texto) | (1L << Cadena))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MyLanguageParser.ID, 0); }
		public LlamadoContext llamado() {
			return getRuleContext(LlamadoContext.class,0);
		}
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			match(ID);
			setState(289);
			llamado();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LlamadoContext extends ParserRuleContext {
		public Acceder_arregloContext acceder_arreglo() {
			return getRuleContext(Acceder_arregloContext.class,0);
		}
		public Pars_funContext pars_fun() {
			return getRuleContext(Pars_funContext.class,0);
		}
		public LlamadoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_llamado; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterLlamado(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitLlamado(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitLlamado(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LlamadoContext llamado() throws RecognitionException {
		LlamadoContext _localctx = new LlamadoContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_llamado);
		try {
			setState(294);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(292);
				acceder_arreglo();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(293);
				pars_fun();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pars_funContext extends ParserRuleContext {
		public TerminalNode TOKEN_PAR_IZQ() { return getToken(MyLanguageParser.TOKEN_PAR_IZQ, 0); }
		public Pars_listaContext pars_lista() {
			return getRuleContext(Pars_listaContext.class,0);
		}
		public TerminalNode TOKEN_PAR_DER() { return getToken(MyLanguageParser.TOKEN_PAR_DER, 0); }
		public Pars_funContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pars_fun; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterPars_fun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitPars_fun(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitPars_fun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pars_funContext pars_fun() throws RecognitionException {
		Pars_funContext _localctx = new Pars_funContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_pars_fun);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			match(TOKEN_PAR_IZQ);
			setState(297);
			pars_lista();
			setState(298);
			match(TOKEN_PAR_DER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pars_listaContext extends ParserRuleContext {
		public Expresion_logicaContext expresion_logica() {
			return getRuleContext(Expresion_logicaContext.class,0);
		}
		public Lista_exprContext lista_expr() {
			return getRuleContext(Lista_exprContext.class,0);
		}
		public Pars_listaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pars_lista; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterPars_lista(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitPars_lista(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitPars_lista(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pars_listaContext pars_lista() throws RecognitionException {
		Pars_listaContext _localctx = new Pars_listaContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_pars_lista);
		try {
			setState(304);
			switch (_input.LA(1)) {
			case Verdadero:
			case Falso:
			case TOKEN_MENOS:
			case TOKEN_PAR_IZQ:
			case TOKEN_NEG:
			case TOKEN_ENTERO:
			case TOKEN_REAL:
			case TOKEN_CADENA:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(300);
				expresion_logica(0);
				setState(301);
				lista_expr();
				}
				break;
			case TOKEN_PAR_DER:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Acceder_arregloContext extends ParserRuleContext {
		public TerminalNode TOKEN_COR_IZQ() { return getToken(MyLanguageParser.TOKEN_COR_IZQ, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public Lista_exprContext lista_expr() {
			return getRuleContext(Lista_exprContext.class,0);
		}
		public TerminalNode TOKEN_COR_DER() { return getToken(MyLanguageParser.TOKEN_COR_DER, 0); }
		public Acceder_arregloContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_acceder_arreglo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterAcceder_arreglo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitAcceder_arreglo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitAcceder_arreglo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Acceder_arregloContext acceder_arreglo() throws RecognitionException {
		Acceder_arregloContext _localctx = new Acceder_arregloContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_acceder_arreglo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			match(TOKEN_COR_IZQ);
			setState(307);
			expresion(0);
			setState(308);
			lista_expr();
			setState(309);
			match(TOKEN_COR_DER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstruccionContext extends ParserRuleContext {
		public TerminalNode Esperar() { return getToken(MyLanguageParser.Esperar, 0); }
		public Ins_esperarContext ins_esperar() {
			return getRuleContext(Ins_esperarContext.class,0);
		}
		public TerminalNode TOKEN_PYC() { return getToken(MyLanguageParser.TOKEN_PYC, 0); }
		public Ins_borrarContext ins_borrar() {
			return getRuleContext(Ins_borrarContext.class,0);
		}
		public TerminalNode Pantalla() { return getToken(MyLanguageParser.Pantalla, 0); }
		public TerminalNode Escribir() { return getToken(MyLanguageParser.Escribir, 0); }
		public Expresion_logicaContext expresion_logica() {
			return getRuleContext(Expresion_logicaContext.class,0);
		}
		public Lista_exprContext lista_expr() {
			return getRuleContext(Lista_exprContext.class,0);
		}
		public TerminalNode Leer() { return getToken(MyLanguageParser.Leer, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Lista_id_o_llamadoContext lista_id_o_llamado() {
			return getRuleContext(Lista_id_o_llamadoContext.class,0);
		}
		public InstruccionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruccion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterInstruccion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitInstruccion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitInstruccion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstruccionContext instruccion() throws RecognitionException {
		InstruccionContext _localctx = new InstruccionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_instruccion);
		try {
			setState(329);
			switch (_input.LA(1)) {
			case Esperar:
				enterOuterAlt(_localctx, 1);
				{
				setState(311);
				match(Esperar);
				setState(312);
				ins_esperar();
				setState(313);
				match(TOKEN_PYC);
				}
				break;
			case Limpiar:
			case Borrar:
				enterOuterAlt(_localctx, 2);
				{
				setState(315);
				ins_borrar();
				setState(316);
				match(Pantalla);
				setState(317);
				match(TOKEN_PYC);
				}
				break;
			case Escribir:
				enterOuterAlt(_localctx, 3);
				{
				setState(319);
				match(Escribir);
				setState(320);
				expresion_logica(0);
				setState(321);
				lista_expr();
				setState(322);
				match(TOKEN_PYC);
				}
				break;
			case Leer:
				enterOuterAlt(_localctx, 4);
				{
				setState(324);
				match(Leer);
				setState(325);
				id();
				setState(326);
				lista_id_o_llamado();
				setState(327);
				match(TOKEN_PYC);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ins_borrarContext extends ParserRuleContext {
		public TerminalNode Borrar() { return getToken(MyLanguageParser.Borrar, 0); }
		public TerminalNode Limpiar() { return getToken(MyLanguageParser.Limpiar, 0); }
		public Ins_borrarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ins_borrar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterIns_borrar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitIns_borrar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitIns_borrar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ins_borrarContext ins_borrar() throws RecognitionException {
		Ins_borrarContext _localctx = new Ins_borrarContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_ins_borrar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			_la = _input.LA(1);
			if ( !(_la==Limpiar || _la==Borrar) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ins_esperarContext extends ParserRuleContext {
		public TerminalNode Tecla() { return getToken(MyLanguageParser.Tecla, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode Segundos() { return getToken(MyLanguageParser.Segundos, 0); }
		public Ins_esperarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ins_esperar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterIns_esperar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitIns_esperar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitIns_esperar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ins_esperarContext ins_esperar() throws RecognitionException {
		Ins_esperarContext _localctx = new Ins_esperarContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_ins_esperar);
		try {
			setState(337);
			switch (_input.LA(1)) {
			case Tecla:
				enterOuterAlt(_localctx, 1);
				{
				setState(333);
				match(Tecla);
				}
				break;
			case Verdadero:
			case Falso:
			case TOKEN_MENOS:
			case TOKEN_PAR_IZQ:
			case TOKEN_ENTERO:
			case TOKEN_REAL:
			case TOKEN_CADENA:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(334);
				expresion(0);
				setState(335);
				match(Segundos);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Lista_id_o_llamadoContext extends ParserRuleContext {
		public TerminalNode TOKEN_COMA() { return getToken(MyLanguageParser.TOKEN_COMA, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Lista_id_o_llamadoContext lista_id_o_llamado() {
			return getRuleContext(Lista_id_o_llamadoContext.class,0);
		}
		public Lista_id_o_llamadoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lista_id_o_llamado; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterLista_id_o_llamado(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitLista_id_o_llamado(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitLista_id_o_llamado(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lista_id_o_llamadoContext lista_id_o_llamado() throws RecognitionException {
		Lista_id_o_llamadoContext _localctx = new Lista_id_o_llamadoContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_lista_id_o_llamado);
		try {
			setState(344);
			switch (_input.LA(1)) {
			case TOKEN_COMA:
				enterOuterAlt(_localctx, 1);
				{
				setState(339);
				match(TOKEN_COMA);
				setState(340);
				id();
				setState(341);
				lista_id_o_llamado();
				}
				break;
			case TOKEN_PYC:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Condicional_siContext extends ParserRuleContext {
		public Expresion_logicaContext expresion_logica() {
			return getRuleContext(Expresion_logicaContext.class,0);
		}
		public TerminalNode Entonces() { return getToken(MyLanguageParser.Entonces, 0); }
		public CuerpoContext cuerpo() {
			return getRuleContext(CuerpoContext.class,0);
		}
		public Si_noContext si_no() {
			return getRuleContext(Si_noContext.class,0);
		}
		public TerminalNode Finsi() { return getToken(MyLanguageParser.Finsi, 0); }
		public Condicional_siContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condicional_si; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterCondicional_si(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitCondicional_si(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitCondicional_si(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Condicional_siContext condicional_si() throws RecognitionException {
		Condicional_siContext _localctx = new Condicional_siContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_condicional_si);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			expresion_logica(0);
			setState(347);
			match(Entonces);
			setState(348);
			cuerpo();
			setState(349);
			si_no();
			setState(350);
			match(Finsi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Si_noContext extends ParserRuleContext {
		public TerminalNode Sino() { return getToken(MyLanguageParser.Sino, 0); }
		public CuerpoContext cuerpo() {
			return getRuleContext(CuerpoContext.class,0);
		}
		public Si_noContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_si_no; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterSi_no(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitSi_no(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitSi_no(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Si_noContext si_no() throws RecognitionException {
		Si_noContext _localctx = new Si_noContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_si_no);
		try {
			setState(355);
			switch (_input.LA(1)) {
			case Sino:
				enterOuterAlt(_localctx, 1);
				{
				setState(352);
				match(Sino);
				setState(353);
				cuerpo();
				}
				break;
			case Finsi:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ciclo_paraContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MyLanguageParser.ID, 0); }
		public TerminalNode TOKEN_ASIG() { return getToken(MyLanguageParser.TOKEN_ASIG, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode Hasta() { return getToken(MyLanguageParser.Hasta, 0); }
		public Expresion_logicaContext expresion_logica() {
			return getRuleContext(Expresion_logicaContext.class,0);
		}
		public Con_pasoContext con_paso() {
			return getRuleContext(Con_pasoContext.class,0);
		}
		public TerminalNode Hacer() { return getToken(MyLanguageParser.Hacer, 0); }
		public CuerpoContext cuerpo() {
			return getRuleContext(CuerpoContext.class,0);
		}
		public TerminalNode Finpara() { return getToken(MyLanguageParser.Finpara, 0); }
		public Ciclo_paraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ciclo_para; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterCiclo_para(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitCiclo_para(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitCiclo_para(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ciclo_paraContext ciclo_para() throws RecognitionException {
		Ciclo_paraContext _localctx = new Ciclo_paraContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_ciclo_para);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
			match(ID);
			setState(358);
			match(TOKEN_ASIG);
			setState(359);
			expresion(0);
			setState(360);
			match(Hasta);
			setState(361);
			expresion_logica(0);
			setState(362);
			con_paso();
			setState(363);
			match(Hacer);
			setState(364);
			cuerpo();
			setState(365);
			match(Finpara);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Con_pasoContext extends ParserRuleContext {
		public TerminalNode Con() { return getToken(MyLanguageParser.Con, 0); }
		public TerminalNode Paso() { return getToken(MyLanguageParser.Paso, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public Con_pasoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_con_paso; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterCon_paso(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitCon_paso(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitCon_paso(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Con_pasoContext con_paso() throws RecognitionException {
		Con_pasoContext _localctx = new Con_pasoContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_con_paso);
		try {
			setState(371);
			switch (_input.LA(1)) {
			case Con:
				enterOuterAlt(_localctx, 1);
				{
				setState(367);
				match(Con);
				setState(368);
				match(Paso);
				setState(369);
				expresion(0);
				}
				break;
			case Hacer:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ciclo_mientrasContext extends ParserRuleContext {
		public Expresion_logicaContext expresion_logica() {
			return getRuleContext(Expresion_logicaContext.class,0);
		}
		public TerminalNode Hacer() { return getToken(MyLanguageParser.Hacer, 0); }
		public CuerpoContext cuerpo() {
			return getRuleContext(CuerpoContext.class,0);
		}
		public TerminalNode Finmientras() { return getToken(MyLanguageParser.Finmientras, 0); }
		public Ciclo_mientrasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ciclo_mientras; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterCiclo_mientras(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitCiclo_mientras(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitCiclo_mientras(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ciclo_mientrasContext ciclo_mientras() throws RecognitionException {
		Ciclo_mientrasContext _localctx = new Ciclo_mientrasContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_ciclo_mientras);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
			expresion_logica(0);
			setState(374);
			match(Hacer);
			setState(375);
			cuerpo();
			setState(376);
			match(Finmientras);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ciclo_repetirContext extends ParserRuleContext {
		public CuerpoContext cuerpo() {
			return getRuleContext(CuerpoContext.class,0);
		}
		public TerminalNode Hasta() { return getToken(MyLanguageParser.Hasta, 0); }
		public TerminalNode Que() { return getToken(MyLanguageParser.Que, 0); }
		public Expresion_logicaContext expresion_logica() {
			return getRuleContext(Expresion_logicaContext.class,0);
		}
		public Ciclo_repetirContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ciclo_repetir; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterCiclo_repetir(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitCiclo_repetir(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitCiclo_repetir(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ciclo_repetirContext ciclo_repetir() throws RecognitionException {
		Ciclo_repetirContext _localctx = new Ciclo_repetirContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_ciclo_repetir);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			cuerpo();
			setState(379);
			match(Hasta);
			setState(380);
			match(Que);
			setState(381);
			expresion_logica(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Segun_hacerContext extends ParserRuleContext {
		public TerminalNode Segun() { return getToken(MyLanguageParser.Segun, 0); }
		public TerminalNode ID() { return getToken(MyLanguageParser.ID, 0); }
		public TerminalNode Hacer() { return getToken(MyLanguageParser.Hacer, 0); }
		public CasosContext casos() {
			return getRuleContext(CasosContext.class,0);
		}
		public De_otro_modoContext de_otro_modo() {
			return getRuleContext(De_otro_modoContext.class,0);
		}
		public TerminalNode Finsegun() { return getToken(MyLanguageParser.Finsegun, 0); }
		public Segun_hacerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_segun_hacer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterSegun_hacer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitSegun_hacer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitSegun_hacer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Segun_hacerContext segun_hacer() throws RecognitionException {
		Segun_hacerContext _localctx = new Segun_hacerContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_segun_hacer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(383);
			match(Segun);
			setState(384);
			match(ID);
			setState(385);
			match(Hacer);
			setState(386);
			casos();
			setState(387);
			de_otro_modo();
			setState(388);
			match(Finsegun);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class De_otro_modoContext extends ParserRuleContext {
		public TerminalNode De() { return getToken(MyLanguageParser.De, 0); }
		public TerminalNode Otro() { return getToken(MyLanguageParser.Otro, 0); }
		public TerminalNode Modo() { return getToken(MyLanguageParser.Modo, 0); }
		public TerminalNode TOKEN_DOSP() { return getToken(MyLanguageParser.TOKEN_DOSP, 0); }
		public CuerpoContext cuerpo() {
			return getRuleContext(CuerpoContext.class,0);
		}
		public De_otro_modoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_de_otro_modo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterDe_otro_modo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitDe_otro_modo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitDe_otro_modo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final De_otro_modoContext de_otro_modo() throws RecognitionException {
		De_otro_modoContext _localctx = new De_otro_modoContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_de_otro_modo);
		try {
			setState(396);
			switch (_input.LA(1)) {
			case De:
				enterOuterAlt(_localctx, 1);
				{
				setState(390);
				match(De);
				setState(391);
				match(Otro);
				setState(392);
				match(Modo);
				setState(393);
				match(TOKEN_DOSP);
				setState(394);
				cuerpo();
				}
				break;
			case Finsegun:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CasosContext extends ParserRuleContext {
		public Caso_segunContext caso_segun() {
			return getRuleContext(Caso_segunContext.class,0);
		}
		public CasosContext casos() {
			return getRuleContext(CasosContext.class,0);
		}
		public CasosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_casos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterCasos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitCasos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitCasos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CasosContext casos() throws RecognitionException {
		CasosContext _localctx = new CasosContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_casos);
		try {
			setState(402);
			switch (_input.LA(1)) {
			case Caso:
				enterOuterAlt(_localctx, 1);
				{
				setState(398);
				caso_segun();
				setState(399);
				casos();
				}
				break;
			case Finsegun:
			case De:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Caso_segunContext extends ParserRuleContext {
		public TerminalNode Caso() { return getToken(MyLanguageParser.Caso, 0); }
		public Expresion_logicaContext expresion_logica() {
			return getRuleContext(Expresion_logicaContext.class,0);
		}
		public TerminalNode TOKEN_DOSP() { return getToken(MyLanguageParser.TOKEN_DOSP, 0); }
		public CuerpoContext cuerpo() {
			return getRuleContext(CuerpoContext.class,0);
		}
		public Caso_segunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caso_segun; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterCaso_segun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitCaso_segun(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitCaso_segun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Caso_segunContext caso_segun() throws RecognitionException {
		Caso_segunContext _localctx = new Caso_segunContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_caso_segun);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(404);
			match(Caso);
			setState(405);
			expresion_logica(0);
			setState(406);
			match(TOKEN_DOSP);
			setState(407);
			cuerpo();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 21:
			return expresion_logica_sempred((Expresion_logicaContext)_localctx, predIndex);
		case 22:
			return expresion_sempred((ExpresionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expresion_logica_sempred(Expresion_logicaContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean expresion_sempred(ExpresionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 6);
		case 5:
			return precpred(_ctx, 5);
		case 6:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3Z\u019c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\3\2\3\2\3\2\3\2\3\2\5\2`\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\5\3k\n\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\5\5t\n\5\3\6\3\6\3\7\3\7\3"+
		"\7\5\7{\n\7\3\b\3\b\3\b\5\b\u0080\n\b\3\t\3\t\3\t\3\t\5\t\u0086\n\t\3"+
		"\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00b4\n\r\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20"+
		"\u00c7\n\20\3\21\3\21\3\21\3\21\3\21\5\21\u00ce\n\21\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\5\24\u00df"+
		"\n\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\5\26\u00e9\n\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u00f3\n\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u0101\n\27\f\27\16\27\u0104\13"+
		"\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u010f\n\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u011a\n\30\f\30\16\30\u011d"+
		"\13\30\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\5\34\u0129\n"+
		"\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\5\36\u0133\n\36\3\37\3\37"+
		"\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 "+
		"\5 \u014c\n \3!\3!\3\"\3\"\3\"\3\"\5\"\u0154\n\"\3#\3#\3#\3#\3#\5#\u015b"+
		"\n#\3$\3$\3$\3$\3$\3$\3%\3%\3%\5%\u0166\n%\3&\3&\3&\3&\3&\3&\3&\3&\3&"+
		"\3&\3\'\3\'\3\'\3\'\5\'\u0176\n\'\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3*\3*"+
		"\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\5+\u018f\n+\3,\3,\3,\3,\5,\u0195\n,"+
		"\3-\3-\3-\3-\3-\3-\2\4,..\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&"+
		"(*,.\60\62\64\668:<>@BDFHJLNPRTVX\2\t\5\2  \65\6599\5\2\60\60\66\6688"+
		"\3\2\b\t\3\2\n\13\4\2\6\7WY\3\2\16\25\4\2\35\35\67\67\u019b\2_\3\2\2\2"+
		"\4j\3\2\2\2\6l\3\2\2\2\bs\3\2\2\2\nu\3\2\2\2\fz\3\2\2\2\16\177\3\2\2\2"+
		"\20\u0085\3\2\2\2\22\u0087\3\2\2\2\24\u008c\3\2\2\2\26\u008e\3\2\2\2\30"+
		"\u00b3\3\2\2\2\32\u00b5\3\2\2\2\34\u00b9\3\2\2\2\36\u00c6\3\2\2\2 \u00cd"+
		"\3\2\2\2\"\u00cf\3\2\2\2$\u00d5\3\2\2\2&\u00de\3\2\2\2(\u00e0\3\2\2\2"+
		"*\u00e8\3\2\2\2,\u00f2\3\2\2\2.\u010e\3\2\2\2\60\u011e\3\2\2\2\62\u0120"+
		"\3\2\2\2\64\u0122\3\2\2\2\66\u0128\3\2\2\28\u012a\3\2\2\2:\u0132\3\2\2"+
		"\2<\u0134\3\2\2\2>\u014b\3\2\2\2@\u014d\3\2\2\2B\u0153\3\2\2\2D\u015a"+
		"\3\2\2\2F\u015c\3\2\2\2H\u0165\3\2\2\2J\u0167\3\2\2\2L\u0175\3\2\2\2N"+
		"\u0177\3\2\2\2P\u017c\3\2\2\2R\u0181\3\2\2\2T\u018e\3\2\2\2V\u0194\3\2"+
		"\2\2X\u0196\3\2\2\2Z[\5\4\3\2[\\\5\22\n\2\\]\7\2\2\3]`\3\2\2\2^`\7\2\2"+
		"\3_Z\3\2\2\2_^\3\2\2\2`\3\3\2\2\2ab\5\6\4\2bc\5\f\7\2cd\7Z\2\2de\5\b\5"+
		"\2ef\5\30\r\2fg\5\n\6\2gh\5\4\3\2hk\3\2\2\2ik\3\2\2\2ja\3\2\2\2ji\3\2"+
		"\2\2k\5\3\2\2\2lm\t\2\2\2m\7\3\2\2\2no\7@\2\2op\5\16\b\2pq\7A\2\2qt\3"+
		"\2\2\2rt\3\2\2\2sn\3\2\2\2sr\3\2\2\2t\t\3\2\2\2uv\t\3\2\2v\13\3\2\2\2"+
		"wx\7Z\2\2x{\7E\2\2y{\3\2\2\2zw\3\2\2\2zy\3\2\2\2{\r\3\2\2\2|}\7Z\2\2}"+
		"\u0080\5\20\t\2~\u0080\3\2\2\2\177|\3\2\2\2\177~\3\2\2\2\u0080\17\3\2"+
		"\2\2\u0081\u0082\7K\2\2\u0082\u0083\7Z\2\2\u0083\u0086\5\20\t\2\u0084"+
		"\u0086\3\2\2\2\u0085\u0081\3\2\2\2\u0085\u0084\3\2\2\2\u0086\21\3\2\2"+
		"\2\u0087\u0088\5\24\13\2\u0088\u0089\7Z\2\2\u0089\u008a\5\30\r\2\u008a"+
		"\u008b\5\26\f\2\u008b\23\3\2\2\2\u008c\u008d\t\4\2\2\u008d\25\3\2\2\2"+
		"\u008e\u008f\t\5\2\2\u008f\27\3\2\2\2\u0090\u0091\7\f\2\2\u0091\u0092"+
		"\5\"\22\2\u0092\u0093\5\30\r\2\u0093\u00b4\3\2\2\2\u0094\u0095\5> \2\u0095"+
		"\u0096\5\30\r\2\u0096\u00b4\3\2\2\2\u0097\u0098\7\26\2\2\u0098\u0099\5"+
		"\32\16\2\u0099\u009a\5\30\r\2\u009a\u00b4\3\2\2\2\u009b\u009c\7*\2\2\u009c"+
		"\u009d\5F$\2\u009d\u009e\5\30\r\2\u009e\u00b4\3\2\2\2\u009f\u00a0\7&\2"+
		"\2\u00a0\u00a1\5J&\2\u00a1\u00a2\5\30\r\2\u00a2\u00b4\3\2\2\2\u00a3\u00a4"+
		"\7\27\2\2\u00a4\u00a5\5N(\2\u00a5\u00a6\5\30\r\2\u00a6\u00b4\3\2\2\2\u00a7"+
		"\u00a8\7\37\2\2\u00a8\u00a9\5P)\2\u00a9\u00aa\5\30\r\2\u00aa\u00b4\3\2"+
		"\2\2\u00ab\u00ac\7.\2\2\u00ac\u00ad\5R*\2\u00ad\u00ae\5\30\r\2\u00ae\u00b4"+
		"\3\2\2\2\u00af\u00b0\5$\23\2\u00b0\u00b1\5\30\r\2\u00b1\u00b4\3\2\2\2"+
		"\u00b2\u00b4\3\2\2\2\u00b3\u0090\3\2\2\2\u00b3\u0094\3\2\2\2\u00b3\u0097"+
		"\3\2\2\2\u00b3\u009b\3\2\2\2\u00b3\u009f\3\2\2\2\u00b3\u00a3\3\2\2\2\u00b3"+
		"\u00a7\3\2\2\2\u00b3\u00ab\3\2\2\2\u00b3\u00af\3\2\2\2\u00b3\u00b2\3\2"+
		"\2\2\u00b4\31\3\2\2\2\u00b5\u00b6\5\34\17\2\u00b6\u00b7\5 \21\2\u00b7"+
		"\u00b8\7D\2\2\u00b8\33\3\2\2\2\u00b9\u00ba\7Z\2\2\u00ba\u00bb\5\36\20"+
		"\2\u00bb\35\3\2\2\2\u00bc\u00bd\7B\2\2\u00bd\u00be\5.\30\2\u00be\u00bf"+
		"\5*\26\2\u00bf\u00c0\7C\2\2\u00c0\u00c7\3\2\2\2\u00c1\u00c2\7@\2\2\u00c2"+
		"\u00c3\5.\30\2\u00c3\u00c4\5*\26\2\u00c4\u00c5\7A\2\2\u00c5\u00c7\3\2"+
		"\2\2\u00c6\u00bc\3\2\2\2\u00c6\u00c1\3\2\2\2\u00c7\37\3\2\2\2\u00c8\u00c9"+
		"\7K\2\2\u00c9\u00ca\5\34\17\2\u00ca\u00cb\5 \21\2\u00cb\u00ce\3\2\2\2"+
		"\u00cc\u00ce\3\2\2\2\u00cd\u00c8\3\2\2\2\u00cd\u00cc\3\2\2\2\u00ce!\3"+
		"\2\2\2\u00cf\u00d0\7Z\2\2\u00d0\u00d1\5\20\t\2\u00d1\u00d2\7\r\2\2\u00d2"+
		"\u00d3\5\62\32\2\u00d3\u00d4\7D\2\2\u00d4#\3\2\2\2\u00d5\u00d6\7Z\2\2"+
		"\u00d6\u00d7\5&\24\2\u00d7\u00d8\7D\2\2\u00d8%\3\2\2\2\u00d9\u00df\5("+
		"\25\2\u00da\u00db\5<\37\2\u00db\u00dc\5(\25\2\u00dc\u00df\3\2\2\2\u00dd"+
		"\u00df\58\35\2\u00de\u00d9\3\2\2\2\u00de\u00da\3\2\2\2\u00de\u00dd\3\2"+
		"\2\2\u00df\'\3\2\2\2\u00e0\u00e1\7E\2\2\u00e1\u00e2\5,\27\2\u00e2)\3\2"+
		"\2\2\u00e3\u00e4\7K\2\2\u00e4\u00e5\5,\27\2\u00e5\u00e6\5*\26\2\u00e6"+
		"\u00e9\3\2\2\2\u00e7\u00e9\3\2\2\2\u00e8\u00e3\3\2\2\2\u00e8\u00e7\3\2"+
		"\2\2\u00e9+\3\2\2\2\u00ea\u00eb\b\27\1\2\u00eb\u00ec\7N\2\2\u00ec\u00f3"+
		"\5,\27\t\u00ed\u00ee\7@\2\2\u00ee\u00ef\5,\27\2\u00ef\u00f0\7A\2\2\u00f0"+
		"\u00f3\3\2\2\2\u00f1\u00f3\5.\30\2\u00f2\u00ea\3\2\2\2\u00f2\u00ed\3\2"+
		"\2\2\u00f2\u00f1\3\2\2\2\u00f3\u0102\3\2\2\2\u00f4\u00f5\f\b\2\2\u00f5"+
		"\u00f6\7;\2\2\u00f6\u0101\5,\27\t\u00f7\u00f8\f\7\2\2\u00f8\u00f9\7<\2"+
		"\2\u00f9\u0101\5,\27\b\u00fa\u00fb\f\6\2\2\u00fb\u00fc\7M\2\2\u00fc\u0101"+
		"\5,\27\7\u00fd\u00fe\f\5\2\2\u00fe\u00ff\7L\2\2\u00ff\u0101\5,\27\6\u0100"+
		"\u00f4\3\2\2\2\u0100\u00f7\3\2\2\2\u0100\u00fa\3\2\2\2\u0100\u00fd\3\2"+
		"\2\2\u0101\u0104\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103"+
		"-\3\2\2\2\u0104\u0102\3\2\2\2\u0105\u0106\b\30\1\2\u0106\u0107\7=\2\2"+
		"\u0107\u010f\5.\30\t\u0108\u010f\5\60\31\2\u0109\u010f\5\64\33\2\u010a"+
		"\u010b\7@\2\2\u010b\u010c\5.\30\2\u010c\u010d\7A\2\2\u010d\u010f\3\2\2"+
		"\2\u010e\u0105\3\2\2\2\u010e\u0108\3\2\2\2\u010e\u0109\3\2\2\2\u010e\u010a"+
		"\3\2\2\2\u010f\u011b\3\2\2\2\u0110\u0111\f\b\2\2\u0111\u0112\7U\2\2\u0112"+
		"\u011a\5.\30\t\u0113\u0114\f\7\2\2\u0114\u0115\7?\2\2\u0115\u011a\5.\30"+
		"\b\u0116\u0117\f\6\2\2\u0117\u0118\7>\2\2\u0118\u011a\5.\30\7\u0119\u0110"+
		"\3\2\2\2\u0119\u0113\3\2\2\2\u0119\u0116\3\2\2\2\u011a\u011d\3\2\2\2\u011b"+
		"\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c/\3\2\2\2\u011d\u011b\3\2\2\2"+
		"\u011e\u011f\t\6\2\2\u011f\61\3\2\2\2\u0120\u0121\t\7\2\2\u0121\63\3\2"+
		"\2\2\u0122\u0123\7Z\2\2\u0123\u0124\5\66\34\2\u0124\65\3\2\2\2\u0125\u0129"+
		"\3\2\2\2\u0126\u0129\5<\37\2\u0127\u0129\58\35\2\u0128\u0125\3\2\2\2\u0128"+
		"\u0126\3\2\2\2\u0128\u0127\3\2\2\2\u0129\67\3\2\2\2\u012a\u012b\7@\2\2"+
		"\u012b\u012c\5:\36\2\u012c\u012d\7A\2\2\u012d9\3\2\2\2\u012e\u012f\5,"+
		"\27\2\u012f\u0130\5*\26\2\u0130\u0133\3\2\2\2\u0131\u0133\3\2\2\2\u0132"+
		"\u012e\3\2\2\2\u0132\u0131\3\2\2\2\u0133;\3\2\2\2\u0134\u0135\7B\2\2\u0135"+
		"\u0136\5.\30\2\u0136\u0137\5*\26\2\u0137\u0138\7C\2\2\u0138=\3\2\2\2\u0139"+
		"\u013a\7#\2\2\u013a\u013b\5B\"\2\u013b\u013c\7D\2\2\u013c\u014c\3\2\2"+
		"\2\u013d\u013e\5@!\2\u013e\u013f\7\36\2\2\u013f\u0140\7D\2\2\u0140\u014c"+
		"\3\2\2\2\u0141\u0142\7\"\2\2\u0142\u0143\5,\27\2\u0143\u0144\5*\26\2\u0144"+
		"\u0145\7D\2\2\u0145\u014c\3\2\2\2\u0146\u0147\7\34\2\2\u0147\u0148\5\64"+
		"\33\2\u0148\u0149\5D#\2\u0149\u014a\7D\2\2\u014a\u014c\3\2\2\2\u014b\u0139"+
		"\3\2\2\2\u014b\u013d\3\2\2\2\u014b\u0141\3\2\2\2\u014b\u0146\3\2\2\2\u014c"+
		"?\3\2\2\2\u014d\u014e\t\b\2\2\u014eA\3\2\2\2\u014f\u0154\7!\2\2\u0150"+
		"\u0151\5.\30\2\u0151\u0152\7\33\2\2\u0152\u0154\3\2\2\2\u0153\u014f\3"+
		"\2\2\2\u0153\u0150\3\2\2\2\u0154C\3\2\2\2\u0155\u0156\7K\2\2\u0156\u0157"+
		"\5\64\33\2\u0157\u0158\5D#\2\u0158\u015b\3\2\2\2\u0159\u015b\3\2\2\2\u015a"+
		"\u0155\3\2\2\2\u015a\u0159\3\2\2\2\u015bE\3\2\2\2\u015c\u015d\5,\27\2"+
		"\u015d\u015e\7-\2\2\u015e\u015f\5\30\r\2\u015f\u0160\5H%\2\u0160\u0161"+
		"\7+\2\2\u0161G\3\2\2\2\u0162\u0163\7,\2\2\u0163\u0166\5\30\r\2\u0164\u0166"+
		"\3\2\2\2\u0165\u0162\3\2\2\2\u0165\u0164\3\2\2\2\u0166I\3\2\2\2\u0167"+
		"\u0168\7Z\2\2\u0168\u0169\7E\2\2\u0169\u016a\5.\30\2\u016a\u016b\7$\2"+
		"\2\u016b\u016c\5,\27\2\u016c\u016d\5L\'\2\u016d\u016e\7\30\2\2\u016e\u016f"+
		"\5\30\r\2\u016f\u0170\7\'\2\2\u0170K\3\2\2\2\u0171\u0172\7(\2\2\u0172"+
		"\u0173\7)\2\2\u0173\u0176\5.\30\2\u0174\u0176\3\2\2\2\u0175\u0171\3\2"+
		"\2\2\u0175\u0174\3\2\2\2\u0176M\3\2\2\2\u0177\u0178\5,\27\2\u0178\u0179"+
		"\7\30\2\2\u0179\u017a\5\30\r\2\u017a\u017b\7\31\2\2\u017bO\3\2\2\2\u017c"+
		"\u017d\5\30\r\2\u017d\u017e\7$\2\2\u017e\u017f\7%\2\2\u017f\u0180\5,\27"+
		"\2\u0180Q\3\2\2\2\u0181\u0182\7.\2\2\u0182\u0183\7Z\2\2\u0183\u0184\7"+
		"\30\2\2\u0184\u0185\5V,\2\u0185\u0186\5T+\2\u0186\u0187\7/\2\2\u0187S"+
		"\3\2\2\2\u0188\u0189\7\61\2\2\u0189\u018a\7\62\2\2\u018a\u018b\7\63\2"+
		"\2\u018b\u018c\7T\2\2\u018c\u018f\5\30\r\2\u018d\u018f\3\2\2\2\u018e\u0188"+
		"\3\2\2\2\u018e\u018d\3\2\2\2\u018fU\3\2\2\2\u0190\u0191\5X-\2\u0191\u0192"+
		"\5V,\2\u0192\u0195\3\2\2\2\u0193\u0195\3\2\2\2\u0194\u0190\3\2\2\2\u0194"+
		"\u0193\3\2\2\2\u0195W\3\2\2\2\u0196\u0197\7:\2\2\u0197\u0198\5,\27\2\u0198"+
		"\u0199\7T\2\2\u0199\u019a\5\30\r\2\u019aY\3\2\2\2\34_jsz\177\u0085\u00b3"+
		"\u00c6\u00cd\u00de\u00e8\u00f2\u0100\u0102\u010e\u0119\u011b\u0128\u0132"+
		"\u014b\u0153\u015a\u0165\u0175\u018e\u0194";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}