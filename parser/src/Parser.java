
/*
 * Integrantes:
 * Angela maria Munoz Medina
 * Nicolas Larranaga Cifuentes*/

import java.util.*;
import java.io.*;

public class Parser {

	static BufferedReader br;
	static PrintWriter out;
	static String buffer = new String("");
	static final Character END = new Character('\0');
	static final Token TOKEN_EOF = new Token("EOF");
	static final String EPS = new String("epsilon");

	static Deque<Token> tokens;
	static TreeSet<Character> validSymbols;
	static int row;
	static int column;
	static int p;
	static Error error = new Error();
	static boolean failure;
	static TreeSet<String> reservedWords;
	static HashMap<String, String> tokenName;
	static ArrayList<String> grammar;
	static Deque<String> derivation;
	static HashMap<String, TreeSet<String>> first, follows;
	static HashMap<String, ArrayList<TreeSet<String>>> predictions;
	static HashMap<String, Pair<Integer, String>> token_symbol;

	static HashMap<String, ArrayList<ArrayList<String>>> rules;

	static TreeSet<String> terminals, nonTerminals;
	static Token token;

	public static boolean isLetter(char c) {
		return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
	}

	public static boolean isDigit(char c) {
		return ('0' <= c && c <= '9');
	}

	public static boolean isWhiteSpace(char c) {
		return (c == '\n' || c == ' ' || c == '\t' || c == '\r');
	}

	public static boolean isSymbol(char c) {
		return validSymbols.contains(new Character(c));
	}

	public static boolean isValidCharacter(char c) {
		return (isLetter(c) || isDigit(c) || (isWhiteSpace(c) && c != '\n') || c == '_');
	}

	public static void init() throws IOException {
		token = new Token();

		first = new HashMap<String, TreeSet<String>>();
		follows = new HashMap<String, TreeSet<String>>();
		tokenName = new HashMap<String, String>();
		reservedWords = new TreeSet<String>();
		validSymbols = new TreeSet<Character>();
		grammar = new ArrayList<String>();
		derivation = new ArrayDeque<String>();
		predictions = new HashMap<String, ArrayList<TreeSet<String>>>();
		token_symbol = new HashMap<String, Pair<Integer, String>>();

		rules = new HashMap<String, ArrayList<ArrayList<String>>>();
		terminals = new TreeSet<String>();
		nonTerminals = new TreeSet<String>();
		tokens = new ArrayDeque<Token>();

		validSymbols.add(new Character('~'));
		validSymbols.add(new Character('='));
		validSymbols.add(new Character('-'));
		validSymbols.add(new Character('*'));
		validSymbols.add(new Character('+'));
		validSymbols.add(new Character('/'));
		validSymbols.add(new Character('<'));
		validSymbols.add(new Character('>'));
		validSymbols.add(new Character('%'));
		validSymbols.add(new Character(':'));
		validSymbols.add(new Character('\"'));
		validSymbols.add(new Character('\''));
		validSymbols.add(new Character(':'));
		validSymbols.add(new Character(';'));
		validSymbols.add(new Character(','));
		validSymbols.add(new Character('['));
		validSymbols.add(new Character(']'));
		validSymbols.add(new Character('('));
		validSymbols.add(new Character(')'));
		validSymbols.add(new Character('^'));
		validSymbols.add(new Character('&'));
		validSymbols.add(new Character('|'));
		validSymbols.add(new Character('$'));

		tokenName.put("~", "token_neg");
		tokenName.put("no", "token_neg");
		tokenName.put("=", "token_igual");
		tokenName.put("==", "token_igual");
		tokenName.put("<-", "token_asig");
		tokenName.put("<>", "token_dif");
		tokenName.put("<", "token_menor");
		tokenName.put(">", "token_mayor");
		tokenName.put("<=", "token_menor_igual");
		tokenName.put(">=", "token_mayor_igual");
		tokenName.put("+", "token_mas");
		tokenName.put("-", "token_menos");
		tokenName.put("/", "token_div");
		tokenName.put("*", "token_mul");
		tokenName.put("%", "token_mod");
		tokenName.put(";", "token_pyc");
		tokenName.put(":", "token_dosp");
		tokenName.put("(", "token_par_izq");
		tokenName.put(")", "token_par_der");
		tokenName.put("[", "token_cor_izq");
		tokenName.put("]", "token_cor_der");
		tokenName.put("|", "token_o");
		tokenName.put("o", "token_o");
		tokenName.put("&", "token_y");
		tokenName.put("y", "token_y");
		tokenName.put(",", "token_coma");
		tokenName.put("^", "token_pot");
		tokenName.put("mod", "token_mod");
		tokenName.put("$", "token_eof");

		token_symbol.put("algoritmo", new Pair<Integer, String>(Integer.valueOf(0), "algoritmo"));
		token_symbol.put("borrar", new Pair<Integer, String>(Integer.valueOf(1), "borrar"));
		token_symbol.put("cadena", new Pair<Integer, String>(Integer.valueOf(2), "cadena"));
		token_symbol.put("caracter", new Pair<Integer, String>(Integer.valueOf(3), "caracter"));
		token_symbol.put("caso", new Pair<Integer, String>(Integer.valueOf(4), "caso"));
		token_symbol.put("como", new Pair<Integer, String>(Integer.valueOf(5), "como"));
		token_symbol.put("con", new Pair<Integer, String>(Integer.valueOf(6), "con"));
		token_symbol.put("de", new Pair<Integer, String>(Integer.valueOf(7), "de"));
		token_symbol.put("definir", new Pair<Integer, String>(Integer.valueOf(8), "definir"));
		token_symbol.put("dimension", new Pair<Integer, String>(Integer.valueOf(9), "dimension"));
		token_symbol.put("entero", new Pair<Integer, String>(Integer.valueOf(10), "entero"));
		token_symbol.put("entonces", new Pair<Integer, String>(Integer.valueOf(11), "entonces"));
		token_symbol.put("escribir", new Pair<Integer, String>(Integer.valueOf(12), "escribir"));
		token_symbol.put("esperar", new Pair<Integer, String>(Integer.valueOf(13), "esperar"));
		token_symbol.put("falso", new Pair<Integer, String>(Integer.valueOf(14), "falso"));
		token_symbol.put("finalgoritmo", new Pair<Integer, String>(Integer.valueOf(15), "finalgoritmo"));
		token_symbol.put("finfuncion", new Pair<Integer, String>(Integer.valueOf(16), "finfuncion"));
		token_symbol.put("finmientras", new Pair<Integer, String>(Integer.valueOf(17), "finmientras"));
		token_symbol.put("finpara", new Pair<Integer, String>(Integer.valueOf(18), "finpara"));
		token_symbol.put("finproceso", new Pair<Integer, String>(Integer.valueOf(19), "finproceso"));
		token_symbol.put("finsegun", new Pair<Integer, String>(Integer.valueOf(21), "finsegun"));
		token_symbol.put("finsi", new Pair<Integer, String>(Integer.valueOf(22), "finsi"));
		token_symbol.put("finsubproceso", new Pair<Integer, String>(Integer.valueOf(23), "finsubproceso"));
		token_symbol.put("funcion", new Pair<Integer, String>(Integer.valueOf(24), "funcion"));
		token_symbol.put("hacer", new Pair<Integer, String>(Integer.valueOf(25), "hacer"));
		token_symbol.put("hasta", new Pair<Integer, String>(Integer.valueOf(26), "hasta"));
		token_symbol.put("id", new Pair<Integer, String>(Integer.valueOf(27), "identificador"));
		token_symbol.put("leer", new Pair<Integer, String>(Integer.valueOf(28), "leer"));
		token_symbol.put("limpiar", new Pair<Integer, String>(Integer.valueOf(29), "limpiar"));
		token_symbol.put("logico", new Pair<Integer, String>(Integer.valueOf(30), "logico"));
		token_symbol.put("mientras", new Pair<Integer, String>(Integer.valueOf(31), "mientras"));
		token_symbol.put("milisegundos", new Pair<Integer, String>(Integer.valueOf(32), "milisegundos"));
		token_symbol.put("modo", new Pair<Integer, String>(Integer.valueOf(33), "modo"));
		token_symbol.put("numerico", new Pair<Integer, String>(Integer.valueOf(34), "numerico"));
		token_symbol.put("numero", new Pair<Integer, String>(Integer.valueOf(35), "numero"));
		token_symbol.put("otro", new Pair<Integer, String>(Integer.valueOf(36), "otro"));
		token_symbol.put("pantalla", new Pair<Integer, String>(Integer.valueOf(37), "pantalla"));
		token_symbol.put("para", new Pair<Integer, String>(Integer.valueOf(38), "para"));
		token_symbol.put("paso", new Pair<Integer, String>(Integer.valueOf(39), "paso"));
		token_symbol.put("proceso", new Pair<Integer, String>(Integer.valueOf(40), "proceso"));
		token_symbol.put("que", new Pair<Integer, String>(Integer.valueOf(41), "que"));
		token_symbol.put("real", new Pair<Integer, String>(Integer.valueOf(42), "real"));
		token_symbol.put("repetir", new Pair<Integer, String>(Integer.valueOf(43), "repetir"));
		token_symbol.put("segun", new Pair<Integer, String>(Integer.valueOf(44), "segun"));
		token_symbol.put("segundos", new Pair<Integer, String>(Integer.valueOf(45), "segundos"));
		token_symbol.put("si", new Pair<Integer, String>(Integer.valueOf(46), "si"));
		token_symbol.put("sino", new Pair<Integer, String>(Integer.valueOf(47), "sino"));
		token_symbol.put("subproceso", new Pair<Integer, String>(Integer.valueOf(48), "subproceso"));
		token_symbol.put("tecla", new Pair<Integer, String>(Integer.valueOf(49), "tecla"));
		token_symbol.put("texto", new Pair<Integer, String>(Integer.valueOf(50), "texto"));
		token_symbol.put("token_asig", new Pair<Integer, String>(Integer.valueOf(51), "<-"));
		token_symbol.put("token_cadena", new Pair<Integer, String>(Integer.valueOf(52), "valor_cadena"));
		token_symbol.put("token_coma", new Pair<Integer, String>(Integer.valueOf(53), ","));
		token_symbol.put("token_cor_der", new Pair<Integer, String>(Integer.valueOf(54), "]"));
		token_symbol.put("token_cor_izq", new Pair<Integer, String>(Integer.valueOf(55), "["));
		token_symbol.put("token_dif", new Pair<Integer, String>(Integer.valueOf(56), "<>"));
		token_symbol.put("token_div", new Pair<Integer, String>(Integer.valueOf(57), "/"));
		token_symbol.put("token_dosp", new Pair<Integer, String>(Integer.valueOf(58), ":"));
		token_symbol.put("token_entero", new Pair<Integer, String>(Integer.valueOf(59), "valor_entero"));
		token_symbol.put("token_igual", new Pair<Integer, String>(Integer.valueOf(60), "="));
		token_symbol.put("token_mas", new Pair<Integer, String>(Integer.valueOf(61), "+"));
		token_symbol.put("token_mayor", new Pair<Integer, String>(Integer.valueOf(62), ">"));
		token_symbol.put("token_mayor_igual", new Pair<Integer, String>(Integer.valueOf(63), ">="));
		token_symbol.put("token_menor", new Pair<Integer, String>(Integer.valueOf(64), "<"));
		token_symbol.put("token_menor_igual", new Pair<Integer, String>(Integer.valueOf(65), "<="));
		token_symbol.put("token_menos", new Pair<Integer, String>(Integer.valueOf(66), "-"));
		token_symbol.put("token_mod", new Pair<Integer, String>(Integer.valueOf(67), "%"));
		token_symbol.put("token_mul", new Pair<Integer, String>(Integer.valueOf(68), "*"));
		token_symbol.put("token_neg", new Pair<Integer, String>(Integer.valueOf(69), "~"));
		token_symbol.put("token_o", new Pair<Integer, String>(Integer.valueOf(70), "|"));
		token_symbol.put("token_par_der", new Pair<Integer, String>(Integer.valueOf(71), ")"));
		token_symbol.put("token_par_izq", new Pair<Integer, String>(Integer.valueOf(72), "("));
		token_symbol.put("token_pot", new Pair<Integer, String>(Integer.valueOf(73), "^"));
		token_symbol.put("token_pyc", new Pair<Integer, String>(Integer.valueOf(74), ";"));
		token_symbol.put("token_real", new Pair<Integer, String>(Integer.valueOf(75), "valor_real"));
		token_symbol.put("token_y", new Pair<Integer, String>(Integer.valueOf(76), "&"));
		token_symbol.put("verdadero", new Pair<Integer, String>(Integer.valueOf(77), "verdadero"));
		token_symbol.put("token_eof", new Pair<Integer, String>(Integer.valueOf(78), "EOF"));

		reservedWords.add("algoritmo");
		reservedWords.add("proceso");
		reservedWords.add("finproceso");
		reservedWords.add("finalgoritmo");
		reservedWords.add("definir");
		reservedWords.add("como");
		reservedWords.add("entero");
		reservedWords.add("numero");
		reservedWords.add("numerico");
		reservedWords.add("real");
		reservedWords.add("logico");
		reservedWords.add("caracter");
		reservedWords.add("texto");
		reservedWords.add("cadena");
		reservedWords.add("dimension");
		reservedWords.add("verdadero");
		reservedWords.add("falso");
		reservedWords.add("mientras");
		reservedWords.add("hacer");
		reservedWords.add("finmientras");
		reservedWords.add("milisegundos");
		reservedWords.add("segundos");
		reservedWords.add("leer");
		reservedWords.add("limpiar");
		reservedWords.add("mod");
		reservedWords.add("pantalla");
		reservedWords.add("repetir");
		reservedWords.add("funcion");
		reservedWords.add("tecla");
		reservedWords.add("escribir");
		reservedWords.add("esperar");
		reservedWords.add("hasta");
		reservedWords.add("que");
		reservedWords.add("para");
		reservedWords.add("finpara");
		reservedWords.add("con");
		reservedWords.add("paso");
		reservedWords.add("si");
		reservedWords.add("finsi");
		reservedWords.add("sino");
		reservedWords.add("entonces");
		reservedWords.add("segun");
		reservedWords.add("finsegun");
		reservedWords.add("finfuncion");
		reservedWords.add("de");
		reservedWords.add("otro");
		reservedWords.add("modo");
		reservedWords.add("subproceso");
		reservedWords.add("finsubproceso");
		reservedWords.add("borrar");
		reservedWords.add("finsubalgoritmo");
		reservedWords.add("subalgoritmo");
		reservedWords.add("caso");
	

		/* add grammar from grammar.txt */
		/*
		 * BufferedReader gr = new BufferedReader(new
		 * FileReader("grammar.txt")); String current_rule = new String("");
		 * while((current_rule = gr.readLine()) != null)
		 * grammar.add(current_rule); gr.close();
		 */

		/* add grammar the hard way */
		grammar.add("PROGRAMA -> SUBPROCESO PROCESO SUBPROCESO token_eof");
		grammar.add("SUBPROCESO -> INICIOSUBPROCESO VARIABLE_RETORNO SUBPROCESO_ARG CUERPO FINSUBPROCESO SUBPROCESO ");
		grammar.add("SUBPROCESO -> epsilon");
		grammar.add("SUBPROCESO_ARG -> token_par_izq ARGUMENTO token_par_der");
		grammar.add("SUBPROCESO_ARG -> epsilon");
		grammar.add("INICIOSUBPROCESO -> subproceso");
		grammar.add("INICIOSUBPROCESO -> subalgoritmo");
		grammar.add("INICIOSUBPROCESO -> funcion");
		grammar.add("FINSUBPROCESO -> finsubproceso");
		grammar.add("FINSUBPROCESO -> finsubalgoritmo");
		grammar.add("FINSUBPROCESO -> finfuncion");
		grammar.add("VARIABLE_RETORNO -> id RESTO");
		grammar.add("RESTO -> token_asig id");
		grammar.add("RESTO -> epsilon");
		grammar.add("ARGUMENTO -> epsilon");
		grammar.add("ARGUMENTO -> id LISTA");
		grammar.add("LISTA -> token_coma id LISTA");
		grammar.add("LISTA -> epsilon");
		grammar.add("PROCESO -> INICIOPROCESO id CUERPO FINPROCESO");
		grammar.add("INICIOPROCESO -> proceso");
		grammar.add("INICIOPROCESO -> algoritmo");
		grammar.add("FINPROCESO -> finproceso");
		grammar.add("FINPROCESO -> finalgoritmo");
		grammar.add("CUERPO -> DEFINICION CUERPO");
		grammar.add("CUERPO -> ASIGNACION_LLAMADO CUERPO");
		grammar.add("CUERPO -> INSTRUCCION CUERPO");
		grammar.add("CUERPO -> DIMENSION CUERPO");
		grammar.add("CUERPO -> CONDICIONAL_SI CUERPO");
		grammar.add("CUERPO -> CICLO_PARA CUERPO");
		grammar.add("CUERPO -> CICLO_MIENTRAS CUERPO");
		grammar.add("CUERPO -> CICLO_REPETIR CUERPO");
		grammar.add("CUERPO -> SEGUN_HACER CUERPO");
		grammar.add("LLAMADO_SUB -> id ARG_LLAMADO_PROCESO");
		grammar.add("LLAMADO_ARR -> id ACCEDER_ARREGLO");
		grammar.add("CUERPO -> epsilon");
		grammar.add("DIMENSION -> dimension ARREGLO LISTA_ARREGLOS token_pyc");
		grammar.add("ARREGLO -> id DIM");
		grammar.add("DIM -> token_cor_izq EXPRESION LISTA_EXPR token_cor_der");
		grammar.add("DIM -> token_par_izq EXPRESION LISTA_EXPR token_par_der");
		grammar.add("LISTA_ARREGLOS -> token_coma ARREGLO LISTA_ARREGLOS");
		grammar.add("LISTA_ARREGLOS -> epsilon");
		grammar.add("DEFINICION -> definir id LISTA como TIPO token_pyc ");
		grammar.add("ASIGNACION_LLAMADO -> id LLAMAR_O_ASIGNAR token_pyc");
		grammar.add("LLAMAR_O_ASIGNAR -> ASIGNAR");
		grammar.add("LLAMAR_O_ASIGNAR -> ACCEDER_ARREGLO ASIGNAR");
		grammar.add("LLAMAR_O_ASIGNAR -> LLAMADO_PROCESO");
		grammar.add("ASIGNAR -> token_asig EXPRESION");
		grammar.add("LISTA_EXPR -> token_coma EXPRESION LISTA_EXPR");
		grammar.add("LISTA_EXPR -> epsilon");
		grammar.add("EXPRESION -> TERMINO COMPLEMENTO");
		grammar.add("COMPLEMENTO -> token_y TERMINO COMPLEMENTO");
		grammar.add("COMPLEMENTO -> token_o TERMINO COMPLEMENTO");
		grammar.add("COMPLEMENTO -> EXPRESION_LOGICA");
		grammar.add("EXPRESION_LOGICA -> token_igual TERMINO COMPLEMENTOS_ADICIONALES");
		grammar.add("EXPRESION_LOGICA -> token_dif TERMINO COMPLEMENTOS_ADICIONALES");
		grammar.add("EXPRESION_LOGICA -> token_menor TERMINO COMPLEMENTOS_ADICIONALES");
		grammar.add("EXPRESION_LOGICA -> token_mayor TERMINO COMPLEMENTOS_ADICIONALES");
		grammar.add("EXPRESION_LOGICA -> token_menor_igual TERMINO COMPLEMENTOS_ADICIONALES");
		grammar.add("EXPRESION_LOGICA -> token_mayor_igual TERMINO COMPLEMENTOS_ADICIONALES");
		grammar.add("EXPRESION_LOGICA -> EXPRESION_MAT");
		grammar.add("COMPLEMENTOS_ADICIONALES -> token_y TERMINO COMPLEMENTO");
		grammar.add("COMPLEMENTOS_ADICIONALES -> token_o TERMINO COMPLEMENTO");
		grammar.add("COMPLEMENTOS_ADICIONALES -> token_mas TERMINO COMPLEMENTO");
		grammar.add("COMPLEMENTOS_ADICIONALES -> token_menos TERMINO COMPLEMENTO");
		grammar.add("COMPLEMENTOS_ADICIONALES -> token_mul TERMINO COMPLEMENTO");
		grammar.add("COMPLEMENTOS_ADICIONALES -> token_mod TERMINO COMPLEMENTO");
		grammar.add("COMPLEMENTOS_ADICIONALES -> token_pot TERMINO COMPLEMENTO");
		grammar.add("COMPLEMENTOS_ADICIONALES -> token_div TERMINO COMPLEMENTO");
		grammar.add("COMPLEMENTOS_ADICIONALES -> epsilon");
		grammar.add("EXPRESION_MAT -> token_mas TERMINO COMPLEMENTO");
		grammar.add("EXPRESION_MAT -> token_menos TERMINO COMPLEMENTO");
		grammar.add("EXPRESION_MAT -> EXPRESION_MAT2");
		grammar.add("EXPRESION_MAT2 -> token_mul TERMINO COMPLEMENTO");
		grammar.add("EXPRESION_MAT2 -> token_mod TERMINO COMPLEMENTO");
		grammar.add("EXPRESION_MAT2 -> token_pot TERMINO COMPLEMENTO");
		grammar.add("EXPRESION_MAT2 -> token_div TERMINO COMPLEMENTO");
		grammar.add("EXPRESION_MAT2 -> epsilon");
		grammar.add("TERMINO -> token_par_izq EXPRESION token_par_der");
		grammar.add("TERMINO -> CONSTANTE");
		grammar.add("TERMINO -> ID_O_LLAMADO");
		grammar.add("TERMINO -> token_menos EXPRESION");
		grammar.add("TERMINO -> token_neg EXPRESION");
		grammar.add("CONSTANTE -> token_entero");
		grammar.add("CONSTANTE -> token_real");
		grammar.add("CONSTANTE -> token_caracter");
		grammar.add("CONSTANTE -> token_cadena");
		grammar.add("CONSTANTE -> falso");
		grammar.add("CONSTANTE -> verdadero");
		grammar.add("TIPO -> caracter");
		grammar.add("TIPO -> entero");
		grammar.add("TIPO -> logico");
		grammar.add("TIPO -> numero");
		grammar.add("TIPO -> numerico");
		grammar.add("TIPO -> real");
		grammar.add("TIPO -> texto");
		grammar.add("TIPO -> cadena");
		grammar.add("INSTRUCCION -> esperar INS_ESPERAR token_pyc");
		grammar.add("INSTRUCCION -> INS_BORRAR pantalla token_pyc ");
		grammar.add("INS_BORRAR -> borrar");
		grammar.add("INS_BORRAR -> limpiar");
		grammar.add("INSTRUCCION -> escribir EXPRESION LISTA_EXPR token_pyc ");
		grammar.add("INS_ESPERAR -> tecla ");
		grammar.add("INSTRUCCION -> leer ID_O_LLAMADO LISTA_ID_O_LLAMADO token_pyc");
		grammar.add("LISTA_ID_O_LLAMADO -> token_coma ID_O_LLAMADO LISTA_ID_O_LLAMADO");
		grammar.add("LISTA_ID_O_LLAMADO -> epsilon");
		grammar.add("INS_ESPERAR -> EXPRESION segundos  ");
		grammar.add("CONDICIONAL_SI -> si EVALUAR_PAR entonces CUERPO SI_NO finsi");
		grammar.add("EVALUAR_PAR -> token_par_izq EXPRESION token_par_der");
		grammar.add("EVALUAR_PAR -> EXPRESION");
		grammar.add("SI_NO -> sino CUERPO");
		grammar.add("SI_NO -> epsilon");
		grammar.add("CICLO_PARA -> para id token_asig EXPRESION hasta EXPRESION CON_PASO hacer CUERPO finpara");
		grammar.add("CON_PASO -> con paso EXPRESION");
		grammar.add("CON_PASO -> epsilon");
		grammar.add("CICLO_MIENTRAS -> mientras EXPRESION hacer CUERPO finmientras");
		grammar.add("CICLO_REPETIR -> repetir CUERPO hasta que EXPRESION");
		grammar.add("SEGUN_HACER -> segun EXPRESION hacer CASOS DE_OTRO_MODO finsegun");
		grammar.add("DE_OTRO_MODO -> de otro modo token_dosp CUERPO");
		grammar.add("DE_OTRO_MODO -> epsilon");
		grammar.add("CASOS -> CASO CASOS");
		grammar.add("CASOS -> epsilon");
		grammar.add("CASO -> caso EXPRESION token_dosp CUERPO");
		grammar.add("ID_O_LLAMADO -> id COMPLEMENTO_ID_O_LLAMADO");
		grammar.add("COMPLEMENTO_ID_O_LLAMADO -> ACCEDER_ARREGLO");
		grammar.add("COMPLEMENTO_ID_O_LLAMADO -> LLAMADO_PROCESO");
		grammar.add("COMPLEMENTO_ID_O_LLAMADO -> epsilon");
		grammar.add("LLAMADO_PROCESO -> ARG_LLAMADO_PROCESO");
		grammar.add("ARG_LLAMADO_PROCESO -> token_par_izq ARG_LLAMADO token_par_der");
		grammar.add("ARG_LLAMADO_PROCESO -> epsilon");
		grammar.add("ARG_LLAMADO -> EXPRESION LISTA_ARG_LLAMADO");
		grammar.add("ARG_LLAMADO -> epsilon");
		grammar.add("LISTA_ARG_LLAMADO -> token_coma EXPRESION LISTA_ARG_LLAMADO");
		grammar.add("LISTA_ARG_LLAMADO -> epsilon");
		grammar.add("ACCEDER_ARREGLO -> INDEX ");
		grammar.add("INDEX -> token_cor_izq EXPRESION LISTA_EXPR token_cor_der");

	}

	public static boolean ignoreComment() {
		boolean flag = false;
		if (buffer.charAt(p) == '/' && buffer.charAt(p + 1) == '/') {
			while (buffer.charAt(p) != '\n') {
				p++;
				column++;
			}
			flag = true;
		}
		return flag;
	}

	public static boolean ignoreWhiteSpace() {
		boolean flag = false;
		while (isWhiteSpace(buffer.charAt(p))) {
			if (buffer.charAt(p) == '\n') {
				row++;
				column = 1;
			} else
				column++;
			flag = true;
			p++;
		}
		return flag;
	}

	static void skip() {
		boolean trash;
		do {
			trash = false;
			trash |= ignoreWhiteSpace();
			trash |= ignoreComment();
		} while (trash);
	}

	public static Token readToken() {
		Token tkn = new Token(row, column);
		char c = buffer.charAt(p);

		if (isLetter(c)) {
			c = buffer.charAt(p);
			while (isLetter(c) || isDigit(c) || c == '_') {
				p++;
				column++;
				tkn.addChar(c);
				c = buffer.charAt(p);
			}
			if (!reservedWords.contains(tkn.lexema.toLowerCase()) && !tokenName.containsKey(tkn.lexema.toLowerCase())) {
				tkn.setToken("id");
				tkn.setLexema(tkn.lexema.toLowerCase());
			} else if (tokenName.containsKey(tkn.lexema.toLowerCase())) {
				tkn.setToken(tokenName.get(tkn.lexema.toLowerCase()));
				tkn.setLexema("");
			} else if (reservedWords.contains(tkn.lexema.toLowerCase())) {
				tkn.setToken(tkn.lexema.toLowerCase());
				tkn.setLexema("");
			}
		} else if (isDigit(c)) {
			if (!isDigit(buffer.charAt(p))) {
				tkn.setToken(tokenName.get(tkn.lexema));
				tkn.setLexema("");
			} else {
				c = buffer.charAt(p);
				int i = 0;
				boolean real = false;
				while (isDigit(c) || (c == '.' && !real && isDigit(buffer.charAt(p + 1)))) {
					p++;
					column++;
					i++;
					real |= (c == '.');
					tkn.addChar(c);
					c = buffer.charAt(p);
				}
				if (c == '.' && !isDigit(buffer.charAt(p + 1))) {
					tkn.setToken("token_entero");
					error = new Error(row, column);
					failure = true;
				} else if (c == '.' && real) {
					error = new Error(row, column);
					failure = true;
				} else if (real) {
					tkn.setToken("token_real");
				} else if (isLetter(c)) {
					error = new Error(row, column - i);
					tkn.setToken("");
					tkn.setLexema("");
					failure = true;
				} else
					tkn.setToken("token_entero");
			}
		} else if (isSymbol(c)) {
			if (c == '\'' || c == '\"') {
				int i = p + 1;
				while (buffer.charAt(i) != END && buffer.charAt(i) != '\'' && buffer.charAt(i) != '\"') {
					i++;
				}
				if (buffer.charAt(i) == '\'' || buffer.charAt(i) == '\"') {
					tkn.setToken("token_cadena");
					p++;
					column++;
					while (buffer.charAt(p) != '\'' && buffer.charAt(p) != '\"') {
						tkn.addChar(buffer.charAt(p));
						p++;
						column++;
					}
					p++;
					column++;
				} else {
					error = new Error(row, column);
					failure = true;
				}
			} else {
				String single = new String("");
				String dob = new String("");

				single += c;
				dob += c;
				dob += buffer.charAt(p + 1);
				/*
				 * System.out.println("single = " + single);
				 * System.out.println("double = " + dob);
				 */

				if (tokenName.containsKey(dob)) {
					tkn.addChar(buffer.charAt(p));
					tkn.addChar(buffer.charAt(p + 1));
					tkn.setToken(tokenName.get(tkn.lexema));
					tkn.setLexema("");
					p += 2;
					column += 2;
				} else if (tokenName.containsKey(single)) {

					tkn.addChar(buffer.charAt(p));
					tkn.setToken(tokenName.get(tkn.lexema));
					tkn.setLexema("");
					p++;
					column++;
				}
			}
		} else {
			error = new Error(row, column);
			failure = true;
		}

		return tkn;
	}

	public static void printTokens() {
		for (Token token : tokens) {
			if (!token.token.equals("") || !token.lexema.equals(""))
				out.print(token);
		}
		out.println(error);
	}

	public static void split() {
		p = 0;
		row = column = 1;
		skip();
		while (buffer.charAt(p) != END) {
			Token nextToken = readToken();
			if (!failure || nextToken.token.equals("token_entero"))
				tokens.addLast(nextToken);
			else
				break;
			skip();
		}

	}

	public static void lexer() throws IOException {

		String current_line = new String("");

		while ((current_line = br.readLine()) != null) {
			buffer += current_line;
			buffer += "\n";
		}
		buffer += "$";
		buffer += END;
		split();

		// printTokens();
	}

	public static void parser() throws IOException {

		read_grammar();
		compute_firsts();
		compute_follows();
		compute_predictions();

		// System.out.println(first);
		// System.out.println(follows);
		// System.out.println(predictions);

		// System.out.println(tokens);
		// System.out.println(derivation);
		token = get_next_token();
		replace_in_derivation();
	}

	private static Token get_next_token() {
		Token ret = TOKEN_EOF;
		ret.r = row;
		ret.c = column;
		if (!tokens.isEmpty())
			ret = tokens.removeFirst();
		return ret;
	}

	private static void compute_firsts() {
		boolean changed;
		do {
			changed = false;
			for (String non_terminal : nonTerminals) {
				// System.out.println(non_terminal);
				// System.out.println(rules.get(non_terminal));
				for (ArrayList<String> rule : rules.get(non_terminal)) {
					if (!first.containsKey(non_terminal))
						first.put(non_terminal, new TreeSet<String>());
					changed |= add_first_from(first.get(non_terminal), rule, 0);
				}
			}
		} while (changed);
	}

	private static void compute_follows() {
		boolean changed;
		do {
			changed = false;
			for (String non_terminal_1 : nonTerminals) {
				// System.out.println(non_terminal_1);
				for (String non_terminal_2 : nonTerminals) {
					// System.out.println(non_terminal_2);
					for (ArrayList<String> rule : rules.get(non_terminal_2)) {
						for (int i = 0; i < rule.size(); i++) {
							if (rule.get(i).equals(non_terminal_1)) {
								// System.out.println(rule.toString());
								if (!follows.containsKey(non_terminal_1))
									follows.put(non_terminal_1, new TreeSet<String>());
								changed |= add_follows_from(follows.get(non_terminal_1), non_terminal_2, rule, i + 1);
							}
						}
					}
				}
			}
		} while (changed);
	}

	private static void compute_predictions() {
		for (String non_terminal : nonTerminals) {
			for (ArrayList<String> rule : rules.get(non_terminal)) {
				TreeSet<String> current_firsts = compute_firsts_from(rule, 0);
				TreeSet<String> current_predictions = new TreeSet<String>();
				boolean contains_eps = current_firsts.contains(EPS);
				add_symbols_of(current_predictions, current_firsts, false);
				if (contains_eps)
					add_symbols_of(current_predictions, follows.get(non_terminal), false);
				if (!predictions.containsKey(non_terminal))
					predictions.put(non_terminal, new ArrayList<TreeSet<String>>());
				predictions.get(non_terminal).add(current_predictions);
			}
		}

	}

	private static boolean add_follows_from(TreeSet<String> follows_non_terminal, String non_terminal,
			ArrayList<String> rule, int from) {
		boolean changed = false;
		TreeSet<String> new_firsts = compute_firsts_from(rule, from);
		boolean contains_eps = new_firsts.contains(EPS);
		changed |= add_symbols_of(follows_non_terminal, new_firsts, false);
		if (contains_eps) {
			if (!follows.containsKey(non_terminal))
				follows.put(non_terminal, new TreeSet<String>());
			changed |= add_symbols_of(follows_non_terminal, follows.get(non_terminal), false);
		}
		return changed;
	}

	private static boolean add_first_from(TreeSet<String> firsts_non_terminal, ArrayList<String> rule, int from) {
		boolean changed = false;
		TreeSet<String> new_firsts = compute_firsts_from(rule, from);
		changed |= add_symbols_of(firsts_non_terminal, new_firsts, true);
		return changed;

	}

	private static TreeSet<String> compute_firsts_from(ArrayList<String> rule, int from) {
		TreeSet<String> new_firsts = new TreeSet<String>();
		if (from + 1 == rule.size() && rule.get(from).equals(EPS)) {
			add_symbol(new_firsts, EPS);
		} else {
			for (int i = from; i < rule.size(); i++) {
				if (terminals.contains(rule.get(i))) {
					add_symbol(new_firsts, rule.get(i));
					break;
				} else {
					// System.out.println(rule.toString());
					if (!first.containsKey(rule.get(i)))
						first.put(rule.get(i), new TreeSet<String>());
					boolean contains_eps = first.get(rule.get(i)).contains(EPS);
					add_symbols_of(new_firsts, first.get(rule.get(i)), false);
					if (contains_eps) {
						if (i + 1 == rule.size())
							add_symbol(new_firsts, EPS);
					} else
						break;
				}
			}
		}
		return new_firsts;
	}

	private static boolean add_symbol(TreeSet<String> set_non_terminal, String symbol) {
		if (set_non_terminal.contains(symbol))
			return false;
		set_non_terminal.add(symbol);
		return true;
	}

	private static boolean add_symbols_of(TreeSet<String> set_non_terminal_1, TreeSet<String> set_non_terminal_2,
			boolean with_eps) {
		boolean changed = false;
		// System.out.println(set_non_terminal_1);
		for (String symbol : set_non_terminal_2) {
			if (!with_eps && symbol.equals(EPS))
				continue;
			changed |= add_symbol(set_non_terminal_1, symbol);
		}
		return changed;
	}

	public static void read_grammar() {
		boolean init_symbol = true;
		for (String line : grammar) {
			ArrayList<String> currRule = new ArrayList<String>();
			String[] parts = line.split(" -> ");
			classify_symbol(parts[0]);
			if (init_symbol) {
				derivation.addLast(parts[0]);
				follows.put(parts[0], new TreeSet<String>());
				follows.get(parts[0]).add(TOKEN_EOF.getValue());
				init_symbol = false;
			}
			String[] right = parts[1].split(" ");
			for (String x : right) {
				currRule.add(x);
				classify_symbol(x);
			}
			if (!currRule.get(currRule.size() - 1).equals(EPS))
				currRule.add(EPS);
			if (!rules.containsKey(parts[0]))
				rules.put(parts[0], new ArrayList<ArrayList<String>>());
			rules.get(parts[0]).add(currRule);

		}
	}

	private static void classify_symbol(String current) {
		if ('a' <= current.charAt(0) && current.charAt(0) <= 'z')
			terminals.add(current);
		else
			nonTerminals.add(current);
	}

	public static void match() throws IOException {
		if (derivation.isEmpty()) {
			out.println("No se puede hacer emparejamiento");
			out.close();
			br.close();
			System.exit(0);
		}
		String expected_token = derivation.removeFirst();
		if (expected_token.equals(EPS) || expected_token.equals(""))
			return;
		if (token.getValue().toLowerCase().equals(expected_token)) {
			token = get_next_token();
			return;
		}
		if (expected_token.toLowerCase().equals("proceso")) {
			out.println("Error sintactico: falta proceso.");
		} else {
			StringBuilder s = new StringBuilder("");
			s.append("<").append(token.r).append(":").append(token.c).append("> ");
			s.append("Error sintactico: se encontro: \"").append(token_symbol.get(token.getValue()).second)
					.append("\"; ");
			s.append("se esperaba: ");
			s.append("\"").append(token_symbol.get(expected_token).second).append("\".");
			out.println(s.toString());
		}
		out.close();
		br.close();
		System.exit(0);
	}

	public static void replace_in_derivation() throws IOException {
		while (!derivation.isEmpty()) {
			String current_symbol = derivation.getFirst();
			//System.out.println(current_symbol);
			if (current_symbol.equals(EPS) || terminals.contains(current_symbol)) {
				match();
				continue;
			} else {
				boolean found_rule = false;
				for (int i = 0; i < rules.get(current_symbol).size(); i++) {
					boolean found_symbol = false;
					for (String p : predictions.get(current_symbol).get(i)) {
						if (p.equals(token.getValue())) {
							derivation.removeFirst();
							for (int j = rules.get(current_symbol).get(i).size() - 1; j >= 0; j--)
								derivation.addFirst(rules.get(current_symbol).get(i).get(j));
							found_symbol = true;
							break;
						}
					}
					found_rule |= found_symbol;
					if (found_rule)
						break;
				}
				if (!found_rule)
					break;
			}
		}

		ArrayList<String> d = new ArrayList<String>();
		for (String e : derivation)
			if (!e.equals(EPS))
				d.add(e);
		TreeSet<String> expected_tokens = compute_firsts_from(d, 0);
		TreeSet<Pair<Integer, String>> sorted_expected_tokens = new TreeSet<Pair<Integer, String>>();
		for (String e : expected_tokens)
			if (token_symbol.containsKey(e))
				sorted_expected_tokens.add(token_symbol.get(e));

		if (sorted_expected_tokens.size() == 0) {
			out.println("El analisis sintactico ha finalizado exitosamente.");
			out.close();
			br.close();
			System.exit(0);
		}
		if (expected_tokens.contains("proceso")) {
			out.println("Error sintactico: falta proceso.");
		} else {
			StringBuilder s = new StringBuilder("");
			s.append("<").append(token.r).append(":").append(token.c).append("> ");
			s.append("Error sintactico: se encontro: \"");
			s.append(token_symbol.get(token.getValue()).second);
			s.append("\"; ");
			s.append("se esperaba: ");
			for (Pair<Integer, String> e : sorted_expected_tokens)
				s.append("\"").append(e.second).append("\", ");
			s.setLength(s.length() - 2);
			s.append(".");
			out.println(s.toString());
		}
		br.close();
		out.close();
		System.exit(0);
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		//br = new BufferedReader(new FileReader("in.txt"));
		out = new PrintWriter(System.out);
		init();
		lexer();
		parser();

		out.close();
		br.close();
	}

	public static class Token {
		int r, c;
		String token, lexema;

		public Token(int fila, int columna) {
			this.r = fila;
			this.c = columna;
			this.token = new String("");
			this.lexema = new String("");
		}

		public Token(String token) {
			this.r = 0;
			this.c = 0;
			this.token = new String(token);
			this.lexema = new String("");
		}

		public void setToken(String token) {
			this.token = token;
		}

		public void setLexema(String lexema) {
			this.lexema = lexema;
		}

		public void addChar(char c) {
			this.lexema += c;
		}

		public Token() {
			this.r = 0;
			this.c = 0;
			this.lexema = "";
			this.token = "";
		}

		public void fixCase() {
			this.lexema = this.lexema.toLowerCase();
		}

		public String getValue() {
			if (!this.token.equals(""))
				return this.token;
			return this.lexema;
		}

		@Override
		public String toString() {
			StringBuilder s = new StringBuilder("<");
			s.append(this.token + ",");
			if (!this.lexema.equals("")) {
				s.append(this.lexema + ",");
			} else if (this.token.equals("token_cadena") && this.lexema.equals("")) {
				s.append(",");
			}
			s.append(this.r).append(",").append(this.c).append(">\n");
			return s.toString();
		}
	}

	public static class Error {
		int r, c;

		public Error() {
			this.r = 0;
			this.c = 0;
		}

		public Error(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			StringBuilder s = new StringBuilder("");
			if (this.r != 0) {
				s.append(">>> Error lexico (linea: ").append(this.r).append(", posicion: ").append(this.c)
						.append(")\n");
				return s.toString();
			} else
				return "";
		}
	}

	public static class Pair<A extends Comparable<? super A>, B extends Comparable<? super B>>
			implements Comparable<Pair<A, B>> {
		private A first;
		private B second;

		public Pair(A first, B second) {
			super();
			this.first = first;
			this.second = second;
		}

		public int hashCode() {
			int hashFirst = first != null ? first.hashCode() : 0;
			int hashSecond = second != null ? second.hashCode() : 0;

			return (hashFirst + hashSecond) * hashSecond + hashFirst;
		}

		public boolean equals(Object other) {
			if (other instanceof Pair) {
				Pair otherPair = (Pair) other;
				return ((this.first == otherPair.first
						|| (this.first != null && otherPair.first != null && this.first.equals(otherPair.first)))
						&& (this.second == otherPair.second || (this.second != null && otherPair.second != null
								&& this.second.equals(otherPair.second))));
			}

			return false;
		}

		public String toString() {
			return "(" + first + ", " + second + ")";
		}

		public A getFirst() {
			return first;
		}

		public void setFirst(A first) {
			this.first = first;
		}

		public B getSecond() {
			return second;
		}

		public void setSecond(B second) {
			this.second = second;
		}

		@Override
		public int compareTo(Pair o) {
			int result = this.first.compareTo((A) o.first);
			return (result == 0 ? this.second.compareTo((B) o.second) : result);

		}
	}

}
