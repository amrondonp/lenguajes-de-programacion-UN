// Generated from MyLanguage.g by ANTLR 4.5.3
package classes;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MyLanguageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, LINE_COMMENT=2, WS=3, ID=4, TOKEN_ENTERO=5, TOKEN_REAL=6, TOKEN_CADENA=7, 
		TOKEN_PAR_IZQ=8, TOKEN_PAR_DER=9, TOKEN_COR_IZQ=10, TOKEN_COR_DER=11, 
		TOKEN_PYC=12, TOKEN_ASIG=13, TOKEN_DIF=14, TOKEN_MENOR=15, TOKEN_MAYOR=16, 
		TOKEN_MENOR_IGUAL=17, TOKEN_MAYOR_IGUAL=18, TOKEN_COMA=19, TOKEN_O=20, 
		TOKEN_Y=21, TOKEN_NEG=22, TOKEN_IGUAL=23, TOKEN_MAS=24, TOKEN_MENOS=25, 
		TOKEN_DIV=26, TOKEN_MUL=27, TOKEN_MOD=28, TOKEN_DOSP=29, TOKEN_POT=30, 
		TOKEN_EOF=31, Verdadero=32, Falso=33, Algoritmo=34, Proceso=35, Finproceso=36, 
		Finalgoritmo=37, Definir=38, Como=39, Entero=40, Numero=41, Numerico=42, 
		Real=43, Logico=44, Caracter=45, Texto=46, Cadena=47, Dimension=48, Mientras=49, 
		Hacer=50, Finmientras=51, Milisegundos=52, Segundos=53, Leer=54, Limpiar=55, 
		Pantalla=56, Repetir=57, Funcion=58, Tecla=59, Escribir=60, Esperar=61, 
		Hasta=62, Que=63, Para=64, Finpara=65, Con=66, Paso=67, Si=68, Finsi=69, 
		Sino=70, Entonces=71, Segun=72, Finsegun=73, Finfuncion=74, De=75, Otro=76, 
		Modo=77, Mod=78, Subproceso=79, Finsubproceso=80, Borrar=81, Finsubalgoritmo=82, 
		Subalgoritmo=83, Caso=84, B=85, C=86, D=87, E=88, F=89, G=90, H=91, I=92, 
		J=93, K=94, L=95, M=96, N=97, O=98, P=99, Q=100, R=101, S=102, T=103, 
		U=104, V=105, W=106, X=107, Y=108, Z=109;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"COMMENT", "LINE_COMMENT", "WS", "ID", "TOKEN_ENTERO", "TOKEN_REAL", "TOKEN_CADENA", 
		"TOKEN_PAR_IZQ", "TOKEN_PAR_DER", "TOKEN_COR_IZQ", "TOKEN_COR_DER", "TOKEN_PYC", 
		"TOKEN_ASIG", "TOKEN_DIF", "TOKEN_MENOR", "TOKEN_MAYOR", "TOKEN_MENOR_IGUAL", 
		"TOKEN_MAYOR_IGUAL", "TOKEN_COMA", "TOKEN_O", "TOKEN_Y", "TOKEN_NEG", 
		"TOKEN_IGUAL", "TOKEN_MAS", "TOKEN_MENOS", "TOKEN_DIV", "TOKEN_MUL", "TOKEN_MOD", 
		"TOKEN_DOSP", "TOKEN_POT", "TOKEN_EOF", "Verdadero", "Falso", "Algoritmo", 
		"Proceso", "Finproceso", "Finalgoritmo", "Definir", "Como", "Entero", 
		"Numero", "Numerico", "Real", "Logico", "Caracter", "Texto", "Cadena", 
		"Dimension", "Mientras", "Hacer", "Finmientras", "Milisegundos", "Segundos", 
		"Leer", "Limpiar", "Pantalla", "Repetir", "Funcion", "Tecla", "Escribir", 
		"Esperar", "Hasta", "Que", "Para", "Finpara", "Con", "Paso", "Si", "Finsi", 
		"Sino", "Entonces", "Segun", "Finsegun", "Finfuncion", "De", "Otro", "Modo", 
		"Mod", "Subproceso", "Finsubproceso", "Borrar", "Finsubalgoritmo", "Subalgoritmo", 
		"Caso", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", 
		"N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, "'('", "')'", "'['", "']'", 
		"';'", "'<-'", "'<>'", "'<'", "'>'", "'<='", "'>='", "','", null, null, 
		null, null, "'+'", "'-'", "'/'", "'*'", null, "':'", "'^'", "'$'", "'verdadero'", 
		"'falso'", "'algoritmo'", "'proceso'", "'finproceso'", "'finalgoritmo'", 
		"'definir'", "'como'", "'entero'", "'numero'", "'numerico'", "'real'", 
		"'logico'", "'caracter'", "'texto'", "'cadena'", "'dimension'", "'mientras'", 
		"'hacer'", "'finmientras'", "'milisegundos'", "'segundos'", "'leer'", 
		"'limpiar'", "'pantalla'", "'repetir'", "'funcion'", "'tecla'", "'escribir'", 
		"'esperar'", "'hasta'", "'que'", "'para'", "'finpara'", "'con'", "'paso'", 
		"'si'", "'finsi'", "'sino'", "'entonces'", "'segun'", "'finsegun'", "'finfuncion'", 
		"'de'", "'otro'", "'modo'", "'mod'", "'subproceso'", "'finsubproceso'", 
		"'borrar'", "'finsubalgoritmo'", "'subalgoritmo'", "'caso'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "COMMENT", "LINE_COMMENT", "WS", "ID", "TOKEN_ENTERO", "TOKEN_REAL", 
		"TOKEN_CADENA", "TOKEN_PAR_IZQ", "TOKEN_PAR_DER", "TOKEN_COR_IZQ", "TOKEN_COR_DER", 
		"TOKEN_PYC", "TOKEN_ASIG", "TOKEN_DIF", "TOKEN_MENOR", "TOKEN_MAYOR", 
		"TOKEN_MENOR_IGUAL", "TOKEN_MAYOR_IGUAL", "TOKEN_COMA", "TOKEN_O", "TOKEN_Y", 
		"TOKEN_NEG", "TOKEN_IGUAL", "TOKEN_MAS", "TOKEN_MENOS", "TOKEN_DIV", "TOKEN_MUL", 
		"TOKEN_MOD", "TOKEN_DOSP", "TOKEN_POT", "TOKEN_EOF", "Verdadero", "Falso", 
		"Algoritmo", "Proceso", "Finproceso", "Finalgoritmo", "Definir", "Como", 
		"Entero", "Numero", "Numerico", "Real", "Logico", "Caracter", "Texto", 
		"Cadena", "Dimension", "Mientras", "Hacer", "Finmientras", "Milisegundos", 
		"Segundos", "Leer", "Limpiar", "Pantalla", "Repetir", "Funcion", "Tecla", 
		"Escribir", "Esperar", "Hasta", "Que", "Para", "Finpara", "Con", "Paso", 
		"Si", "Finsi", "Sino", "Entonces", "Segun", "Finsegun", "Finfuncion", 
		"De", "Otro", "Modo", "Mod", "Subproceso", "Finsubproceso", "Borrar", 
		"Finsubalgoritmo", "Subalgoritmo", "Caso", "B", "C", "D", "E", "F", "G", 
		"H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", 
		"V", "W", "X", "Y", "Z"
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


	public MyLanguageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MyLanguage.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2o\u032e\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\4m\tm\4n\tn\4o\to\3\2\3\2\3\2\3\2\7\2\u00e4\n\2\f\2\16\2\u00e7"+
		"\13\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3\u00f2\n\3\f\3\16\3\u00f5"+
		"\13\3\3\3\3\3\3\4\6\4\u00fa\n\4\r\4\16\4\u00fb\3\4\3\4\3\5\3\5\7\5\u0102"+
		"\n\5\f\5\16\5\u0105\13\5\3\6\6\6\u0108\n\6\r\6\16\6\u0109\3\7\6\7\u010d"+
		"\n\7\r\7\16\7\u010e\3\7\3\7\6\7\u0113\n\7\r\7\16\7\u0114\3\b\3\b\7\b\u0119"+
		"\n\b\f\b\16\b\u011c\13\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\23\3\23"+
		"\3\23\3\24\3\24\3\25\3\25\5\25\u013c\n\25\3\26\3\26\5\26\u0140\n\26\3"+
		"\27\3\27\3\27\3\27\5\27\u0146\n\27\3\30\3\30\3\30\5\30\u014b\n\30\3\31"+
		"\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\5\35\u0157\n\35\3\36\3\36"+
		"\3\37\3\37\3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\""+
		"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%"+
		"\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3"+
		"*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3"+
		"-\3.\3.\3.\3.\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60"+
		"\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3\64"+
		"\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65"+
		"\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66"+
		"\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\38\38\38\38\38\38\3"+
		"8\38\39\39\39\39\39\39\39\39\39\3:\3:\3:\3:\3:\3:\3:\3:\3;\3;\3;\3;\3"+
		";\3;\3;\3;\3<\3<\3<\3<\3<\3<\3=\3=\3=\3=\3=\3=\3=\3=\3=\3>\3>\3>\3>\3"+
		">\3>\3>\3>\3?\3?\3?\3?\3?\3?\3@\3@\3@\3@\3A\3A\3A\3A\3A\3B\3B\3B\3B\3"+
		"B\3B\3B\3B\3C\3C\3C\3C\3D\3D\3D\3D\3D\3E\3E\3E\3F\3F\3F\3F\3F\3F\3G\3"+
		"G\3G\3G\3G\3H\3H\3H\3H\3H\3H\3H\3H\3H\3I\3I\3I\3I\3I\3I\3J\3J\3J\3J\3"+
		"J\3J\3J\3J\3J\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3L\3L\3L\3M\3M\3M\3M\3"+
		"M\3N\3N\3N\3N\3N\3O\3O\3O\3O\3P\3P\3P\3P\3P\3P\3P\3P\3P\3P\3P\3Q\3Q\3"+
		"Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3R\3R\3R\3R\3R\3R\3R\3S\3S\3S\3S\3"+
		"S\3S\3S\3S\3S\3S\3S\3S\3S\3S\3S\3S\3T\3T\3T\3T\3T\3T\3T\3T\3T\3T\3T\3"+
		"T\3T\3U\3U\3U\3U\3U\3V\3V\3W\3W\3X\3X\3Y\3Y\3Z\3Z\3[\3[\3\\\3\\\3]\3]"+
		"\3^\3^\3_\3_\3`\3`\3a\3a\3b\3b\3c\3c\3d\3d\3e\3e\3f\3f\3g\3g\3h\3h\3i"+
		"\3i\3j\3j\3k\3k\3l\3l\3m\3m\3n\3n\3o\3o\3\u00e5\2p\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'"+
		"M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177"+
		"A\u0081B\u0083C\u0085D\u0087E\u0089F\u008bG\u008dH\u008fI\u0091J\u0093"+
		"K\u0095L\u0097M\u0099N\u009bO\u009dP\u009fQ\u00a1R\u00a3S\u00a5T\u00a7"+
		"U\u00a9V\u00ab\2\u00adW\u00afX\u00b1Y\u00b3Z\u00b5[\u00b7\\\u00b9]\u00bb"+
		"^\u00bd_\u00bf`\u00c1a\u00c3b\u00c5c\u00c7d\u00c9e\u00cbf\u00cdg\u00cf"+
		"h\u00d1i\u00d3j\u00d5k\u00d7l\u00d9m\u00dbn\u00ddo\3\2\"\4\2\f\f\17\17"+
		"\5\2\13\f\17\17\"\"\4\2C\\c|\6\2\62;C\\aac|\3\2\62;\3\2\60\60\4\2CCcc"+
		"\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2L"+
		"Lll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4"+
		"\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\u0339"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3"+
		"\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2"+
		"\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2"+
		"{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085"+
		"\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2"+
		"\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097"+
		"\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2"+
		"\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2\2\2\u00a5\3\2\2\2\2\u00a7\3\2\2\2\2\u00a9"+
		"\3\2\2\2\2\u00ad\3\2\2\2\2\u00af\3\2\2\2\2\u00b1\3\2\2\2\2\u00b3\3\2\2"+
		"\2\2\u00b5\3\2\2\2\2\u00b7\3\2\2\2\2\u00b9\3\2\2\2\2\u00bb\3\2\2\2\2\u00bd"+
		"\3\2\2\2\2\u00bf\3\2\2\2\2\u00c1\3\2\2\2\2\u00c3\3\2\2\2\2\u00c5\3\2\2"+
		"\2\2\u00c7\3\2\2\2\2\u00c9\3\2\2\2\2\u00cb\3\2\2\2\2\u00cd\3\2\2\2\2\u00cf"+
		"\3\2\2\2\2\u00d1\3\2\2\2\2\u00d3\3\2\2\2\2\u00d5\3\2\2\2\2\u00d7\3\2\2"+
		"\2\2\u00d9\3\2\2\2\2\u00db\3\2\2\2\2\u00dd\3\2\2\2\3\u00df\3\2\2\2\5\u00ed"+
		"\3\2\2\2\7\u00f9\3\2\2\2\t\u00ff\3\2\2\2\13\u0107\3\2\2\2\r\u010c\3\2"+
		"\2\2\17\u0116\3\2\2\2\21\u011d\3\2\2\2\23\u011f\3\2\2\2\25\u0121\3\2\2"+
		"\2\27\u0123\3\2\2\2\31\u0125\3\2\2\2\33\u0127\3\2\2\2\35\u012a\3\2\2\2"+
		"\37\u012d\3\2\2\2!\u012f\3\2\2\2#\u0131\3\2\2\2%\u0134\3\2\2\2\'\u0137"+
		"\3\2\2\2)\u013b\3\2\2\2+\u013f\3\2\2\2-\u0145\3\2\2\2/\u014a\3\2\2\2\61"+
		"\u014c\3\2\2\2\63\u014e\3\2\2\2\65\u0150\3\2\2\2\67\u0152\3\2\2\29\u0156"+
		"\3\2\2\2;\u0158\3\2\2\2=\u015a\3\2\2\2?\u015c\3\2\2\2A\u015e\3\2\2\2C"+
		"\u0168\3\2\2\2E\u016e\3\2\2\2G\u0178\3\2\2\2I\u0180\3\2\2\2K\u018b\3\2"+
		"\2\2M\u0198\3\2\2\2O\u01a0\3\2\2\2Q\u01a5\3\2\2\2S\u01ac\3\2\2\2U\u01b3"+
		"\3\2\2\2W\u01bc\3\2\2\2Y\u01c1\3\2\2\2[\u01c8\3\2\2\2]\u01d1\3\2\2\2_"+
		"\u01d7\3\2\2\2a\u01de\3\2\2\2c\u01e8\3\2\2\2e\u01f1\3\2\2\2g\u01f7\3\2"+
		"\2\2i\u0203\3\2\2\2k\u0210\3\2\2\2m\u0219\3\2\2\2o\u021e\3\2\2\2q\u0226"+
		"\3\2\2\2s\u022f\3\2\2\2u\u0237\3\2\2\2w\u023f\3\2\2\2y\u0245\3\2\2\2{"+
		"\u024e\3\2\2\2}\u0256\3\2\2\2\177\u025c\3\2\2\2\u0081\u0260\3\2\2\2\u0083"+
		"\u0265\3\2\2\2\u0085\u026d\3\2\2\2\u0087\u0271\3\2\2\2\u0089\u0276\3\2"+
		"\2\2\u008b\u0279\3\2\2\2\u008d\u027f\3\2\2\2\u008f\u0284\3\2\2\2\u0091"+
		"\u028d\3\2\2\2\u0093\u0293\3\2\2\2\u0095\u029c\3\2\2\2\u0097\u02a7\3\2"+
		"\2\2\u0099\u02aa\3\2\2\2\u009b\u02af\3\2\2\2\u009d\u02b4\3\2\2\2\u009f"+
		"\u02b8\3\2\2\2\u00a1\u02c3\3\2\2\2\u00a3\u02d1\3\2\2\2\u00a5\u02d8\3\2"+
		"\2\2\u00a7\u02e8\3\2\2\2\u00a9\u02f5\3\2\2\2\u00ab\u02fa\3\2\2\2\u00ad"+
		"\u02fc\3\2\2\2\u00af\u02fe\3\2\2\2\u00b1\u0300\3\2\2\2\u00b3\u0302\3\2"+
		"\2\2\u00b5\u0304\3\2\2\2\u00b7\u0306\3\2\2\2\u00b9\u0308\3\2\2\2\u00bb"+
		"\u030a\3\2\2\2\u00bd\u030c\3\2\2\2\u00bf\u030e\3\2\2\2\u00c1\u0310\3\2"+
		"\2\2\u00c3\u0312\3\2\2\2\u00c5\u0314\3\2\2\2\u00c7\u0316\3\2\2\2\u00c9"+
		"\u0318\3\2\2\2\u00cb\u031a\3\2\2\2\u00cd\u031c\3\2\2\2\u00cf\u031e\3\2"+
		"\2\2\u00d1\u0320\3\2\2\2\u00d3\u0322\3\2\2\2\u00d5\u0324\3\2\2\2\u00d7"+
		"\u0326\3\2\2\2\u00d9\u0328\3\2\2\2\u00db\u032a\3\2\2\2\u00dd\u032c\3\2"+
		"\2\2\u00df\u00e0\7\61\2\2\u00e0\u00e1\7,\2\2\u00e1\u00e5\3\2\2\2\u00e2"+
		"\u00e4\13\2\2\2\u00e3\u00e2\3\2\2\2\u00e4\u00e7\3\2\2\2\u00e5\u00e6\3"+
		"\2\2\2\u00e5\u00e3\3\2\2\2\u00e6\u00e8\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e8"+
		"\u00e9\7,\2\2\u00e9\u00ea\7\61\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ec\b\2"+
		"\2\2\u00ec\4\3\2\2\2\u00ed\u00ee\7\61\2\2\u00ee\u00ef\7\61\2\2\u00ef\u00f3"+
		"\3\2\2\2\u00f0\u00f2\n\2\2\2\u00f1\u00f0\3\2\2\2\u00f2\u00f5\3\2\2\2\u00f3"+
		"\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f6\3\2\2\2\u00f5\u00f3\3\2"+
		"\2\2\u00f6\u00f7\b\3\2\2\u00f7\6\3\2\2\2\u00f8\u00fa\t\3\2\2\u00f9\u00f8"+
		"\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc"+
		"\u00fd\3\2\2\2\u00fd\u00fe\b\4\2\2\u00fe\b\3\2\2\2\u00ff\u0103\t\4\2\2"+
		"\u0100\u0102\t\5\2\2\u0101\u0100\3\2\2\2\u0102\u0105\3\2\2\2\u0103\u0101"+
		"\3\2\2\2\u0103\u0104\3\2\2\2\u0104\n\3\2\2\2\u0105\u0103\3\2\2\2\u0106"+
		"\u0108\t\6\2\2\u0107\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u0107\3\2"+
		"\2\2\u0109\u010a\3\2\2\2\u010a\f\3\2\2\2\u010b\u010d\t\6\2\2\u010c\u010b"+
		"\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f"+
		"\u0110\3\2\2\2\u0110\u0112\t\7\2\2\u0111\u0113\t\6\2\2\u0112\u0111\3\2"+
		"\2\2\u0113\u0114\3\2\2\2\u0114\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115"+
		"\16\3\2\2\2\u0116\u011a\7$\2\2\u0117\u0119\t\7\2\2\u0118\u0117\3\2\2\2"+
		"\u0119\u011c\3\2\2\2\u011a\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b\20"+
		"\3\2\2\2\u011c\u011a\3\2\2\2\u011d\u011e\7*\2\2\u011e\22\3\2\2\2\u011f"+
		"\u0120\7+\2\2\u0120\24\3\2\2\2\u0121\u0122\7]\2\2\u0122\26\3\2\2\2\u0123"+
		"\u0124\7_\2\2\u0124\30\3\2\2\2\u0125\u0126\7=\2\2\u0126\32\3\2\2\2\u0127"+
		"\u0128\7>\2\2\u0128\u0129\7/\2\2\u0129\34\3\2\2\2\u012a\u012b\7>\2\2\u012b"+
		"\u012c\7@\2\2\u012c\36\3\2\2\2\u012d\u012e\7>\2\2\u012e \3\2\2\2\u012f"+
		"\u0130\7@\2\2\u0130\"\3\2\2\2\u0131\u0132\7>\2\2\u0132\u0133\7?\2\2\u0133"+
		"$\3\2\2\2\u0134\u0135\7@\2\2\u0135\u0136\7?\2\2\u0136&\3\2\2\2\u0137\u0138"+
		"\7.\2\2\u0138(\3\2\2\2\u0139\u013c\7~\2\2\u013a\u013c\5\u00c7d\2\u013b"+
		"\u0139\3\2\2\2\u013b\u013a\3\2\2\2\u013c*\3\2\2\2\u013d\u0140\7(\2\2\u013e"+
		"\u0140\5\u00dbn\2\u013f\u013d\3\2\2\2\u013f\u013e\3\2\2\2\u0140,\3\2\2"+
		"\2\u0141\u0146\7\u0080\2\2\u0142\u0143\5\u00c5c\2\u0143\u0144\5\u00c7"+
		"d\2\u0144\u0146\3\2\2\2\u0145\u0141\3\2\2\2\u0145\u0142\3\2\2\2\u0146"+
		".\3\2\2\2\u0147\u014b\7?\2\2\u0148\u0149\7?\2\2\u0149\u014b\7?\2\2\u014a"+
		"\u0147\3\2\2\2\u014a\u0148\3\2\2\2\u014b\60\3\2\2\2\u014c\u014d\7-\2\2"+
		"\u014d\62\3\2\2\2\u014e\u014f\7/\2\2\u014f\64\3\2\2\2\u0150\u0151\7\61"+
		"\2\2\u0151\66\3\2\2\2\u0152\u0153\7,\2\2\u01538\3\2\2\2\u0154\u0157\7"+
		"\'\2\2\u0155\u0157\5\u009dO\2\u0156\u0154\3\2\2\2\u0156\u0155\3\2\2\2"+
		"\u0157:\3\2\2\2\u0158\u0159\7<\2\2\u0159<\3\2\2\2\u015a\u015b\7`\2\2\u015b"+
		">\3\2\2\2\u015c\u015d\7&\2\2\u015d@\3\2\2\2\u015e\u015f\7x\2\2\u015f\u0160"+
		"\7g\2\2\u0160\u0161\7t\2\2\u0161\u0162\7f\2\2\u0162\u0163\7c\2\2\u0163"+
		"\u0164\7f\2\2\u0164\u0165\7g\2\2\u0165\u0166\7t\2\2\u0166\u0167\7q\2\2"+
		"\u0167B\3\2\2\2\u0168\u0169\7h\2\2\u0169\u016a\7c\2\2\u016a\u016b\7n\2"+
		"\2\u016b\u016c\7u\2\2\u016c\u016d\7q\2\2\u016dD\3\2\2\2\u016e\u016f\7"+
		"c\2\2\u016f\u0170\7n\2\2\u0170\u0171\7i\2\2\u0171\u0172\7q\2\2\u0172\u0173"+
		"\7t\2\2\u0173\u0174\7k\2\2\u0174\u0175\7v\2\2\u0175\u0176\7o\2\2\u0176"+
		"\u0177\7q\2\2\u0177F\3\2\2\2\u0178\u0179\7r\2\2\u0179\u017a\7t\2\2\u017a"+
		"\u017b\7q\2\2\u017b\u017c\7e\2\2\u017c\u017d\7g\2\2\u017d\u017e\7u\2\2"+
		"\u017e\u017f\7q\2\2\u017fH\3\2\2\2\u0180\u0181\7h\2\2\u0181\u0182\7k\2"+
		"\2\u0182\u0183\7p\2\2\u0183\u0184\7r\2\2\u0184\u0185\7t\2\2\u0185\u0186"+
		"\7q\2\2\u0186\u0187\7e\2\2\u0187\u0188\7g\2\2\u0188\u0189\7u\2\2\u0189"+
		"\u018a\7q\2\2\u018aJ\3\2\2\2\u018b\u018c\7h\2\2\u018c\u018d\7k\2\2\u018d"+
		"\u018e\7p\2\2\u018e\u018f\7c\2\2\u018f\u0190\7n\2\2\u0190\u0191\7i\2\2"+
		"\u0191\u0192\7q\2\2\u0192\u0193\7t\2\2\u0193\u0194\7k\2\2\u0194\u0195"+
		"\7v\2\2\u0195\u0196\7o\2\2\u0196\u0197\7q\2\2\u0197L\3\2\2\2\u0198\u0199"+
		"\7f\2\2\u0199\u019a\7g\2\2\u019a\u019b\7h\2\2\u019b\u019c\7k\2\2\u019c"+
		"\u019d\7p\2\2\u019d\u019e\7k\2\2\u019e\u019f\7t\2\2\u019fN\3\2\2\2\u01a0"+
		"\u01a1\7e\2\2\u01a1\u01a2\7q\2\2\u01a2\u01a3\7o\2\2\u01a3\u01a4\7q\2\2"+
		"\u01a4P\3\2\2\2\u01a5\u01a6\7g\2\2\u01a6\u01a7\7p\2\2\u01a7\u01a8\7v\2"+
		"\2\u01a8\u01a9\7g\2\2\u01a9\u01aa\7t\2\2\u01aa\u01ab\7q\2\2\u01abR\3\2"+
		"\2\2\u01ac\u01ad\7p\2\2\u01ad\u01ae\7w\2\2\u01ae\u01af\7o\2\2\u01af\u01b0"+
		"\7g\2\2\u01b0\u01b1\7t\2\2\u01b1\u01b2\7q\2\2\u01b2T\3\2\2\2\u01b3\u01b4"+
		"\7p\2\2\u01b4\u01b5\7w\2\2\u01b5\u01b6\7o\2\2\u01b6\u01b7\7g\2\2\u01b7"+
		"\u01b8\7t\2\2\u01b8\u01b9\7k\2\2\u01b9\u01ba\7e\2\2\u01ba\u01bb\7q\2\2"+
		"\u01bbV\3\2\2\2\u01bc\u01bd\7t\2\2\u01bd\u01be\7g\2\2\u01be\u01bf\7c\2"+
		"\2\u01bf\u01c0\7n\2\2\u01c0X\3\2\2\2\u01c1\u01c2\7n\2\2\u01c2\u01c3\7"+
		"q\2\2\u01c3\u01c4\7i\2\2\u01c4\u01c5\7k\2\2\u01c5\u01c6\7e\2\2\u01c6\u01c7"+
		"\7q\2\2\u01c7Z\3\2\2\2\u01c8\u01c9\7e\2\2\u01c9\u01ca\7c\2\2\u01ca\u01cb"+
		"\7t\2\2\u01cb\u01cc\7c\2\2\u01cc\u01cd\7e\2\2\u01cd\u01ce\7v\2\2\u01ce"+
		"\u01cf\7g\2\2\u01cf\u01d0\7t\2\2\u01d0\\\3\2\2\2\u01d1\u01d2\7v\2\2\u01d2"+
		"\u01d3\7g\2\2\u01d3\u01d4\7z\2\2\u01d4\u01d5\7v\2\2\u01d5\u01d6\7q\2\2"+
		"\u01d6^\3\2\2\2\u01d7\u01d8\7e\2\2\u01d8\u01d9\7c\2\2\u01d9\u01da\7f\2"+
		"\2\u01da\u01db\7g\2\2\u01db\u01dc\7p\2\2\u01dc\u01dd\7c\2\2\u01dd`\3\2"+
		"\2\2\u01de\u01df\7f\2\2\u01df\u01e0\7k\2\2\u01e0\u01e1\7o\2\2\u01e1\u01e2"+
		"\7g\2\2\u01e2\u01e3\7p\2\2\u01e3\u01e4\7u\2\2\u01e4\u01e5\7k\2\2\u01e5"+
		"\u01e6\7q\2\2\u01e6\u01e7\7p\2\2\u01e7b\3\2\2\2\u01e8\u01e9\7o\2\2\u01e9"+
		"\u01ea\7k\2\2\u01ea\u01eb\7g\2\2\u01eb\u01ec\7p\2\2\u01ec\u01ed\7v\2\2"+
		"\u01ed\u01ee\7t\2\2\u01ee\u01ef\7c\2\2\u01ef\u01f0\7u\2\2\u01f0d\3\2\2"+
		"\2\u01f1\u01f2\7j\2\2\u01f2\u01f3\7c\2\2\u01f3\u01f4\7e\2\2\u01f4\u01f5"+
		"\7g\2\2\u01f5\u01f6\7t\2\2\u01f6f\3\2\2\2\u01f7\u01f8\7h\2\2\u01f8\u01f9"+
		"\7k\2\2\u01f9\u01fa\7p\2\2\u01fa\u01fb\7o\2\2\u01fb\u01fc\7k\2\2\u01fc"+
		"\u01fd\7g\2\2\u01fd\u01fe\7p\2\2\u01fe\u01ff\7v\2\2\u01ff\u0200\7t\2\2"+
		"\u0200\u0201\7c\2\2\u0201\u0202\7u\2\2\u0202h\3\2\2\2\u0203\u0204\7o\2"+
		"\2\u0204\u0205\7k\2\2\u0205\u0206\7n\2\2\u0206\u0207\7k\2\2\u0207\u0208"+
		"\7u\2\2\u0208\u0209\7g\2\2\u0209\u020a\7i\2\2\u020a\u020b\7w\2\2\u020b"+
		"\u020c\7p\2\2\u020c\u020d\7f\2\2\u020d\u020e\7q\2\2\u020e\u020f\7u\2\2"+
		"\u020fj\3\2\2\2\u0210\u0211\7u\2\2\u0211\u0212\7g\2\2\u0212\u0213\7i\2"+
		"\2\u0213\u0214\7w\2\2\u0214\u0215\7p\2\2\u0215\u0216\7f\2\2\u0216\u0217"+
		"\7q\2\2\u0217\u0218\7u\2\2\u0218l\3\2\2\2\u0219\u021a\7n\2\2\u021a\u021b"+
		"\7g\2\2\u021b\u021c\7g\2\2\u021c\u021d\7t\2\2\u021dn\3\2\2\2\u021e\u021f"+
		"\7n\2\2\u021f\u0220\7k\2\2\u0220\u0221\7o\2\2\u0221\u0222\7r\2\2\u0222"+
		"\u0223\7k\2\2\u0223\u0224\7c\2\2\u0224\u0225\7t\2\2\u0225p\3\2\2\2\u0226"+
		"\u0227\7r\2\2\u0227\u0228\7c\2\2\u0228\u0229\7p\2\2\u0229\u022a\7v\2\2"+
		"\u022a\u022b\7c\2\2\u022b\u022c\7n\2\2\u022c\u022d\7n\2\2\u022d\u022e"+
		"\7c\2\2\u022er\3\2\2\2\u022f\u0230\7t\2\2\u0230\u0231\7g\2\2\u0231\u0232"+
		"\7r\2\2\u0232\u0233\7g\2\2\u0233\u0234\7v\2\2\u0234\u0235\7k\2\2\u0235"+
		"\u0236\7t\2\2\u0236t\3\2\2\2\u0237\u0238\7h\2\2\u0238\u0239\7w\2\2\u0239"+
		"\u023a\7p\2\2\u023a\u023b\7e\2\2\u023b\u023c\7k\2\2\u023c\u023d\7q\2\2"+
		"\u023d\u023e\7p\2\2\u023ev\3\2\2\2\u023f\u0240\7v\2\2\u0240\u0241\7g\2"+
		"\2\u0241\u0242\7e\2\2\u0242\u0243\7n\2\2\u0243\u0244\7c\2\2\u0244x\3\2"+
		"\2\2\u0245\u0246\7g\2\2\u0246\u0247\7u\2\2\u0247\u0248\7e\2\2\u0248\u0249"+
		"\7t\2\2\u0249\u024a\7k\2\2\u024a\u024b\7d\2\2\u024b\u024c\7k\2\2\u024c"+
		"\u024d\7t\2\2\u024dz\3\2\2\2\u024e\u024f\7g\2\2\u024f\u0250\7u\2\2\u0250"+
		"\u0251\7r\2\2\u0251\u0252\7g\2\2\u0252\u0253\7t\2\2\u0253\u0254\7c\2\2"+
		"\u0254\u0255\7t\2\2\u0255|\3\2\2\2\u0256\u0257\7j\2\2\u0257\u0258\7c\2"+
		"\2\u0258\u0259\7u\2\2\u0259\u025a\7v\2\2\u025a\u025b\7c\2\2\u025b~\3\2"+
		"\2\2\u025c\u025d\7s\2\2\u025d\u025e\7w\2\2\u025e\u025f\7g\2\2\u025f\u0080"+
		"\3\2\2\2\u0260\u0261\7r\2\2\u0261\u0262\7c\2\2\u0262\u0263\7t\2\2\u0263"+
		"\u0264\7c\2\2\u0264\u0082\3\2\2\2\u0265\u0266\7h\2\2\u0266\u0267\7k\2"+
		"\2\u0267\u0268\7p\2\2\u0268\u0269\7r\2\2\u0269\u026a\7c\2\2\u026a\u026b"+
		"\7t\2\2\u026b\u026c\7c\2\2\u026c\u0084\3\2\2\2\u026d\u026e\7e\2\2\u026e"+
		"\u026f\7q\2\2\u026f\u0270\7p\2\2\u0270\u0086\3\2\2\2\u0271\u0272\7r\2"+
		"\2\u0272\u0273\7c\2\2\u0273\u0274\7u\2\2\u0274\u0275\7q\2\2\u0275\u0088"+
		"\3\2\2\2\u0276\u0277\7u\2\2\u0277\u0278\7k\2\2\u0278\u008a\3\2\2\2\u0279"+
		"\u027a\7h\2\2\u027a\u027b\7k\2\2\u027b\u027c\7p\2\2\u027c\u027d\7u\2\2"+
		"\u027d\u027e\7k\2\2\u027e\u008c\3\2\2\2\u027f\u0280\7u\2\2\u0280\u0281"+
		"\7k\2\2\u0281\u0282\7p\2\2\u0282\u0283\7q\2\2\u0283\u008e\3\2\2\2\u0284"+
		"\u0285\7g\2\2\u0285\u0286\7p\2\2\u0286\u0287\7v\2\2\u0287\u0288\7q\2\2"+
		"\u0288\u0289\7p\2\2\u0289\u028a\7e\2\2\u028a\u028b\7g\2\2\u028b\u028c"+
		"\7u\2\2\u028c\u0090\3\2\2\2\u028d\u028e\7u\2\2\u028e\u028f\7g\2\2\u028f"+
		"\u0290\7i\2\2\u0290\u0291\7w\2\2\u0291\u0292\7p\2\2\u0292\u0092\3\2\2"+
		"\2\u0293\u0294\7h\2\2\u0294\u0295\7k\2\2\u0295\u0296\7p\2\2\u0296\u0297"+
		"\7u\2\2\u0297\u0298\7g\2\2\u0298\u0299\7i\2\2\u0299\u029a\7w\2\2\u029a"+
		"\u029b\7p\2\2\u029b\u0094\3\2\2\2\u029c\u029d\7h\2\2\u029d\u029e\7k\2"+
		"\2\u029e\u029f\7p\2\2\u029f\u02a0\7h\2\2\u02a0\u02a1\7w\2\2\u02a1\u02a2"+
		"\7p\2\2\u02a2\u02a3\7e\2\2\u02a3\u02a4\7k\2\2\u02a4\u02a5\7q\2\2\u02a5"+
		"\u02a6\7p\2\2\u02a6\u0096\3\2\2\2\u02a7\u02a8\7f\2\2\u02a8\u02a9\7g\2"+
		"\2\u02a9\u0098\3\2\2\2\u02aa\u02ab\7q\2\2\u02ab\u02ac\7v\2\2\u02ac\u02ad"+
		"\7t\2\2\u02ad\u02ae\7q\2\2\u02ae\u009a\3\2\2\2\u02af\u02b0\7o\2\2\u02b0"+
		"\u02b1\7q\2\2\u02b1\u02b2\7f\2\2\u02b2\u02b3\7q\2\2\u02b3\u009c\3\2\2"+
		"\2\u02b4\u02b5\7o\2\2\u02b5\u02b6\7q\2\2\u02b6\u02b7\7f\2\2\u02b7\u009e"+
		"\3\2\2\2\u02b8\u02b9\7u\2\2\u02b9\u02ba\7w\2\2\u02ba\u02bb\7d\2\2\u02bb"+
		"\u02bc\7r\2\2\u02bc\u02bd\7t\2\2\u02bd\u02be\7q\2\2\u02be\u02bf\7e\2\2"+
		"\u02bf\u02c0\7g\2\2\u02c0\u02c1\7u\2\2\u02c1\u02c2\7q\2\2\u02c2\u00a0"+
		"\3\2\2\2\u02c3\u02c4\7h\2\2\u02c4\u02c5\7k\2\2\u02c5\u02c6\7p\2\2\u02c6"+
		"\u02c7\7u\2\2\u02c7\u02c8\7w\2\2\u02c8\u02c9\7d\2\2\u02c9\u02ca\7r\2\2"+
		"\u02ca\u02cb\7t\2\2\u02cb\u02cc\7q\2\2\u02cc\u02cd\7e\2\2\u02cd\u02ce"+
		"\7g\2\2\u02ce\u02cf\7u\2\2\u02cf\u02d0\7q\2\2\u02d0\u00a2\3\2\2\2\u02d1"+
		"\u02d2\7d\2\2\u02d2\u02d3\7q\2\2\u02d3\u02d4\7t\2\2\u02d4\u02d5\7t\2\2"+
		"\u02d5\u02d6\7c\2\2\u02d6\u02d7\7t\2\2\u02d7\u00a4\3\2\2\2\u02d8\u02d9"+
		"\7h\2\2\u02d9\u02da\7k\2\2\u02da\u02db\7p\2\2\u02db\u02dc\7u\2\2\u02dc"+
		"\u02dd\7w\2\2\u02dd\u02de\7d\2\2\u02de\u02df\7c\2\2\u02df\u02e0\7n\2\2"+
		"\u02e0\u02e1\7i\2\2\u02e1\u02e2\7q\2\2\u02e2\u02e3\7t\2\2\u02e3\u02e4"+
		"\7k\2\2\u02e4\u02e5\7v\2\2\u02e5\u02e6\7o\2\2\u02e6\u02e7\7q\2\2\u02e7"+
		"\u00a6\3\2\2\2\u02e8\u02e9\7u\2\2\u02e9\u02ea\7w\2\2\u02ea\u02eb\7d\2"+
		"\2\u02eb\u02ec\7c\2\2\u02ec\u02ed\7n\2\2\u02ed\u02ee\7i\2\2\u02ee\u02ef"+
		"\7q\2\2\u02ef\u02f0\7t\2\2\u02f0\u02f1\7k\2\2\u02f1\u02f2\7v\2\2\u02f2"+
		"\u02f3\7o\2\2\u02f3\u02f4\7q\2\2\u02f4\u00a8\3\2\2\2\u02f5\u02f6\7e\2"+
		"\2\u02f6\u02f7\7c\2\2\u02f7\u02f8\7u\2\2\u02f8\u02f9\7q\2\2\u02f9\u00aa"+
		"\3\2\2\2\u02fa\u02fb\t\b\2\2\u02fb\u00ac\3\2\2\2\u02fc\u02fd\t\t\2\2\u02fd"+
		"\u00ae\3\2\2\2\u02fe\u02ff\t\n\2\2\u02ff\u00b0\3\2\2\2\u0300\u0301\t\13"+
		"\2\2\u0301\u00b2\3\2\2\2\u0302\u0303\t\f\2\2\u0303\u00b4\3\2\2\2\u0304"+
		"\u0305\t\r\2\2\u0305\u00b6\3\2\2\2\u0306\u0307\t\16\2\2\u0307\u00b8\3"+
		"\2\2\2\u0308\u0309\t\17\2\2\u0309\u00ba\3\2\2\2\u030a\u030b\t\20\2\2\u030b"+
		"\u00bc\3\2\2\2\u030c\u030d\t\21\2\2\u030d\u00be\3\2\2\2\u030e\u030f\t"+
		"\22\2\2\u030f\u00c0\3\2\2\2\u0310\u0311\t\23\2\2\u0311\u00c2\3\2\2\2\u0312"+
		"\u0313\t\24\2\2\u0313\u00c4\3\2\2\2\u0314\u0315\t\25\2\2\u0315\u00c6\3"+
		"\2\2\2\u0316\u0317\t\26\2\2\u0317\u00c8\3\2\2\2\u0318\u0319\t\27\2\2\u0319"+
		"\u00ca\3\2\2\2\u031a\u031b\t\30\2\2\u031b\u00cc\3\2\2\2\u031c\u031d\t"+
		"\31\2\2\u031d\u00ce\3\2\2\2\u031e\u031f\t\32\2\2\u031f\u00d0\3\2\2\2\u0320"+
		"\u0321\t\33\2\2\u0321\u00d2\3\2\2\2\u0322\u0323\t\34\2\2\u0323\u00d4\3"+
		"\2\2\2\u0324\u0325\t\35\2\2\u0325\u00d6\3\2\2\2\u0326\u0327\t\36\2\2\u0327"+
		"\u00d8\3\2\2\2\u0328\u0329\t\37\2\2\u0329\u00da\3\2\2\2\u032a\u032b\t"+
		" \2\2\u032b\u00dc\3\2\2\2\u032c\u032d\t!\2\2\u032d\u00de\3\2\2\2\20\2"+
		"\u00e5\u00f3\u00fb\u0103\u0109\u010e\u0114\u011a\u013b\u013f\u0145\u014a"+
		"\u0156\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}