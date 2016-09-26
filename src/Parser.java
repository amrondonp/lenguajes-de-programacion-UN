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
	static HashMap<String, Pair<Integer, String>> token_symbol_alt;
	static HashMap<String, ArrayList< ArrayList< String>>> rules;
	
	static TreeSet<String> terminals, nonTerminals;
	static Token token;


	public static boolean  isLetter(char c){return ('a' <=c && c<= 'z')|| ( 'A' <= c && c <= 'Z' );}
	public static boolean  isDigit( char c ) { return ( '0' <= c && c <= '9' ); }
	public static boolean  isWhiteSpace( char c ) { return ( c == '\n' || c == ' ' || c == '\t' || c == '\r' ); }
	public static boolean  isSymbol( char c ) { return validSymbols.contains(new Character(c));}
	public static boolean  isValidCharacter( char c ) { return ( isLetter( c ) || isDigit( c ) || ( isWhiteSpace( c ) && c != '\n' ) || c == '_' ); }

	public static void init() throws IOException{
		token = new Token();
		
		first = new HashMap<String, TreeSet<String>>();
		follows = new HashMap<String, TreeSet<String>>();
		tokenName = new HashMap<String, String>();
		reservedWords = new TreeSet<String>();
		validSymbols = new TreeSet<Character>();
		grammar = new ArrayList<String>();
		derivation = new ArrayDeque<String>();
		predictions = new HashMap<String, ArrayList< TreeSet<String>>>();
		token_symbol = new HashMap<String, Pair<Integer, String>>();
		token_symbol_alt = new HashMap<String, Pair<Integer, String>>();
		rules = new HashMap<String, ArrayList<ArrayList< String>>>();
		terminals= new TreeSet<String>();
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
		
		tokenName.put("~", "token_neg");
		tokenName.put("no", "token_neg");
		tokenName.put("=", "token_igual");
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
		
		token_symbol.put("token_neg", new Pair<Integer,String>( Integer.valueOf(0), "~")  );
		token_symbol.put("token_neg", new Pair<Integer,String>( Integer.valueOf(1), "no")  );
		token_symbol.put("token_mas", new Pair<Integer,String>( Integer.valueOf(0), "+")  );
		token_symbol.put("token_mas", new Pair<Integer,String>( Integer.valueOf(0), "+")  );
		token_symbol.put("token_mas", new Pair<Integer,String>( Integer.valueOf(0), "+")  );
		token_symbol.put("token_mas", new Pair<Integer,String>( Integer.valueOf(0), "+")  );
		token_symbol.put("token_mas", new Pair<Integer,String>( Integer.valueOf(0), "+")  );
		token_symbol.put("token_mas", new Pair<Integer,String>( Integer.valueOf(0), "+")  );
		token_symbol.put("token_mas", new Pair<Integer,String>( Integer.valueOf(0), "+")  );
		token_symbol.put("token_mas", new Pair<Integer,String>( Integer.valueOf(0), "+")  );
		token_symbol.put("token_mas", new Pair<Integer,String>( Integer.valueOf(0), "+")  );
		token_symbol.put("token_mas", new Pair<Integer,String>( Integer.valueOf(0), "+")  );
		token_symbol.put("token_mas", new Pair<Integer,String>( Integer.valueOf(0), "+")  );
		token_symbol.put("token_mas", new Pair<Integer,String>( Integer.valueOf(0), "+")  );
		token_symbol.put("token_mas", new Pair<Integer,String>( Integer.valueOf(0), "+")  );
		token_symbol.put("token_mas", new Pair<Integer,String>( Integer.valueOf(0), "+")  );
		token_symbol.put("token_mas", new Pair<Integer,String>( Integer.valueOf(0), "+")  );
		

		

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
		
		/*add grammar from grammar.txt*/
		BufferedReader gr = new BufferedReader(new FileReader("grammar.txt"));
		String current_rule = new String("");
		while((current_rule = gr.readLine()) != null)
			grammar.add(current_rule);
		
		
		
		gr.close();
		
	}

	public static boolean ignoreComment(){
		boolean flag = false;
		if(buffer.charAt(p) == '/' && buffer.charAt(p+1) == '/'){
			while(buffer.charAt(p) != '\n'){
				p++; column++;
			}
			flag = true;
		}
		return flag;
	}

	public static boolean ignoreWhiteSpace(){
		boolean flag = false;
		while(isWhiteSpace(buffer.charAt(p))){
			if(buffer.charAt(p) == '\n'){
				row++; column = 1;
			}
			else column++;
			flag = true;
			p++;
		}
		return flag;
	}

	static void skip(){
		boolean trash;
		do{
			trash = false;
			trash |= ignoreWhiteSpace();
			trash |= ignoreComment();
		}
		while(trash);
	}

	public static Token readToken(){
		Token tkn = new Token(row,column);
		char c = buffer.charAt(p);

		if( isLetter(c) ){
			c = buffer.charAt(p);
			while( isLetter(c) || isDigit(c) || c == '_'){
				p++; column++;
				tkn.addChar(c);
				c = buffer.charAt(p);
			}
			if(!reservedWords.contains(tkn.lexema.toLowerCase() ) && !tokenName.containsKey(tkn.lexema.toLowerCase() ) ){
				tkn.setToken("id");
				tkn.setLexema(tkn.lexema.toLowerCase());
				}
			else if(tokenName.containsKey(tkn.lexema.toLowerCase())){
					tkn.setToken(tokenName.get(tkn.lexema.toLowerCase()));
					tkn.setLexema("");
				}
			else if(reservedWords.contains(tkn.lexema.toLowerCase())){
					tkn.setToken(tkn.lexema.toLowerCase());
					tkn.setLexema("");
			}
		}
		else if( isDigit(c)){
			if(!isDigit( buffer.charAt(p) ) ){
				tkn.setToken( tokenName.get(tkn.lexema) );
				tkn.setLexema("");
			}
			else{
				c = buffer.charAt(p);
				int i = 0;
				boolean real = false;
				while( isDigit(c) || (c == '.' && !real && isDigit(buffer.charAt(p+1) ) ) ){
					p++;column++;
					i++;
					real |= (c == '.');
					tkn.addChar(c);
					c = buffer.charAt(p);
				}
				if( c == '.'&& !isDigit( buffer.charAt(p+1) ) ){
					tkn.setToken("token_entero");
					error = new Error(row,column);
					failure = true;
				}
				else if(c =='.' && real){
					error = new Error(row,column);
					failure = true;
				}
				else if (real){
					tkn.setToken("token_real");
				}
				else if(isLetter(c)){
					error = new Error(row, column - i);
					tkn.setToken("");
					tkn.setLexema("");
					failure = true;
				}
				else
					tkn.setToken("token_entero");
			}
		}
		else if(isSymbol(c) ){
			if( c == '\'' || c == '\"' ){
				int i = p+1;
				while(buffer.charAt(i) != END && buffer.charAt(i) != '\'' && buffer.charAt(i) != '\"'){
					i++;
				}
				if(buffer.charAt(i) == '\'' || buffer.charAt(i) == '\"'){
					tkn.setToken("token_cadena");
					p++;column++;
					while(buffer.charAt(p) != '\'' && buffer.charAt(p) != '\"'){
						tkn.addChar(buffer.charAt(p));
						p++;column++;
					}
					p++;column++;
				}
				else{
					error = new Error(row,column);
					failure = true;
				}
			}
			else{
				String single = new String("");
				String dob = new String("");

				single += c;
				dob += c;
				dob += buffer.charAt(p+1);
/*				System.out.println("single = " + single);
				System.out.println("double = " + dob);*/

				if(tokenName.containsKey(dob) ){
					tkn.addChar(buffer.charAt(p));
					tkn.addChar(buffer.charAt(p+1));
					tkn.setToken(tokenName.get(tkn.lexema));
					tkn.setLexema("");
					p+=2;column+=2;
				}
				else if(tokenName.containsKey(single) ){
					
					tkn.addChar(buffer.charAt(p));
					tkn.setToken(tokenName.get(tkn.lexema));
					tkn.setLexema("");
					p++; column++;
				}
			}
		}
		else{
			error = new Error(row, column);
			failure = true;
		}

		return tkn;
	}

	public static void printTokens(){
		for(Token token: tokens){
			if(!token.token.equals("") || !token.lexema.equals(""))
				out.print(token);
		}
		out.println(error);
	}

	public static void split(){
		p = 0;
		row=column=1;
		skip();
		while(buffer.charAt(p) != END){
			Token nextToken = readToken();
			if(!failure || nextToken.token.equals("token_entero")) tokens.addLast(nextToken);
			else break;
			skip();
		}

	}
	
	public static void lexer() throws IOException{
		
		String current_line = new String("");

		while((current_line = br.readLine()) != null){
			buffer += current_line;
			buffer += "\n";
		}
		buffer += END;
		split();

		//printTokens();
	}
	
	public static void parser(){
	
		read_grammar();
		compute_firsts();
		compute_follows();
		compute_predictions();
		
		token = get_next_token();
		replace_in_derivation();
	}
	
	private static Token get_next_token() {
		Token ret = TOKEN_EOF;
		ret.r = row; ret.c = column;
		if(!tokens.isEmpty())
			ret = tokens.removeFirst();
		return ret;
	}
	private static void compute_firsts() {
		boolean changed;
		do{
			changed = false;
			for(String non_terminal : nonTerminals){
				//System.out.println(non_terminal);
				//System.out.println(rules.get(non_terminal));
				for(ArrayList<String> rule: rules.get(non_terminal)){
					if(!first.containsKey(non_terminal))
						first.put(non_terminal, new TreeSet<String>());
					changed |= add_first_from(first.get(non_terminal), rule, 0);
				}
			}
		}
		while(changed);
	}
	
	private static void compute_follows() {
		boolean changed;
		do{
			changed = false;
			for(String non_terminal_1: nonTerminals){
				//System.out.println(non_terminal_1);
				for(String non_terminal_2: nonTerminals){
					//System.out.println(non_terminal_2);
					for(ArrayList<String> rule: rules.get(non_terminal_2)){
						for(int i = 0; i < rule.size(); i++){
							if(rule.get(i).equals( non_terminal_1)){
								//System.out.println(rule.toString());
								if(!follows.containsKey(non_terminal_1))
									follows.put(non_terminal_1, new TreeSet<String>());
								changed |= add_follows_from(follows.get(non_terminal_1), non_terminal_2, rule, i+1);
							}
						}
					}
				}
			}
		}
		while(changed);
	}
	
	private static void compute_predictions(){
		for(String non_terminal : nonTerminals){
			for(ArrayList<String> rule: rules.get(non_terminal)){
				TreeSet<String> current_firsts = compute_firsts_from(rule, 0);
				TreeSet<String> current_predictions = new TreeSet<String>();
				boolean contains_eps = current_firsts.contains(EPS);
				add_symbols_of(current_predictions, current_firsts, false);
				if(contains_eps)
					add_symbols_of(current_predictions, follows.get(non_terminal), false);
				if(!predictions.containsKey(non_terminal))
					predictions.put(non_terminal, new ArrayList<TreeSet<String>>());
				predictions.get(non_terminal).add(current_predictions);
			}
		}
		
	}
	
	private static boolean add_follows_from(TreeSet<String> follows_non_terminal, String non_terminal, ArrayList<String> rule, int from){
		boolean changed = false;
		TreeSet<String> new_firsts = compute_firsts_from(rule, from);
		boolean contains_eps = new_firsts.contains(EPS);
		changed |= add_symbols_of(follows_non_terminal, new_firsts, false);
		if(contains_eps){
			if(!follows.containsKey(non_terminal))
				follows.put(non_terminal, new TreeSet<String>());
			changed |= add_symbols_of(follows_non_terminal, follows.get(non_terminal), false );
		}
		return changed;
	}
	
	private static boolean add_first_from(TreeSet<String> firsts_non_terminal, ArrayList<String> rule, int from){
		boolean changed = false;
		TreeSet<String> new_firsts = compute_firsts_from(rule, from);
		changed |= add_symbols_of(firsts_non_terminal, new_firsts, true);
		return changed;
		
	}

	private static TreeSet<String> compute_firsts_from(ArrayList<String> rule, int from) {
		TreeSet<String> new_firsts = new TreeSet<String>();
		if(from +1 ==rule.size() && rule.get(from).equals(EPS)){
			add_symbol(new_firsts, EPS);
		}
		else{
			for(int i = from; i < rule.size(); i++ ){
				if(terminals.contains(rule.get(i))){
					add_symbol(new_firsts, rule.get(i));
					break;
				}
				else{
					//System.out.println(rule.toString());
					if(!first.containsKey(rule.get(i)))
						first.put(rule.get(i), new TreeSet<String>());
					boolean contains_eps = first.get(rule.get(i)).contains(EPS);
					add_symbols_of(new_firsts, first.get(rule.get(i)), false );
					if(contains_eps){
						if(i+1 == rule.size())
							add_symbol(new_firsts, EPS);
					}
					else
						break;
				}	
			}
		}
		return new_firsts;
	}
	
	private static boolean add_symbol(TreeSet<String> set_non_terminal, String symbol){
		if( set_non_terminal.contains(symbol))
			return false;
		set_non_terminal.add(symbol);
		return true;
	}
	
	private static boolean add_symbols_of(TreeSet<String> set_non_terminal_1, TreeSet<String> set_non_terminal_2, boolean with_eps){
		boolean changed = false;
		//System.out.println(set_non_terminal_1);
		for(String symbol: set_non_terminal_2){
			if(!with_eps && symbol.equals( EPS))
				continue;
			changed |= add_symbol(set_non_terminal_1, symbol);
		}
		return changed;
	}

	public static void read_grammar(){
		boolean init_symbol = true;
		for(String line: grammar){
			ArrayList<String> currRule = new ArrayList<String>();
			String[] parts = line.split(" -> ");
			classify_symbol(parts[0]);
			if(init_symbol){
				derivation.addLast(parts[0]);
				follows.put(parts[0], new TreeSet<String>());
				follows.get(parts[0]).add(TOKEN_EOF.getValue());
				init_symbol = false;
			}
			String[] right = parts[1].split(" ");
			for(String x : right){
				currRule.add(x);
				//System.out.println(x);
				classify_symbol(x);
			}
			if( !currRule.get(currRule.size()-1 ).equals(EPS) )
				currRule.add(EPS);
			if(!rules.containsKey(parts[0]))
				rules.put(parts[0], new ArrayList<ArrayList<String>>() );
			//System.out.println("PRE "+parts[0] + " " + rules.get(parts[0]).toString());
			//System.out.println(currRule);		
			rules.get(parts[0]).add(currRule);
			//System.out.println("POST "+parts[0] + " " + rules.get(parts[0]).toString());
		}
		/*for(String r: rules.keySet()){
			System.out.println(r + " " +  rules.get(r).toString());
		}*/
		/*System.out.println(terminals.toString());
		System.out.println(nonTerminals.toString());*/
		//System.out.println(rules.toString());
	}

	private static void classify_symbol(String current) {
		if('a' <= current.charAt(0) && current.charAt(0) <= 'z')
			terminals.add(current);
		else
			nonTerminals.add(current);
	}
	
	private static void match(){
		if(derivation.isEmpty()){
			out.println("No se puede hacer emparejamiento");
			System.exit(0);
		}
		String expected_token = derivation.removeFirst();
		if(expected_token.equals(EPS) || expected_token.equals(""))
			return;
		if(token.getValue().toLowerCase().equals(expected_token)){
			token= get_next_token();
			return;
		}
		if(expected_token.toLowerCase().equals("proceso")){
			out.println("Error sintactico: falta proceso");
		}
		else{
			StringBuilder s = new StringBuilder("");
			s.append("<").append(token.r).append(token.c).append("> ");
			s.append("Error sintactico: se encontro: \"").append(token.lexema).append("\"; ");
			s.append("se esperaba: ");
			s.append("\"").append(expected_token).append("\".");
			out.println(s.toString());
		}
		System.exit(0);			
	}
	
	public static void replace_in_derivation(){
		while(!derivation.isEmpty()){
			String current_symbol = derivation.getFirst();
			if(current_symbol.equals(EPS) || terminals.contains(current_symbol)){
				match();
				continue;
			}
			else{
				boolean found_rule = false;
				for(int i = 0; i <rules.get(current_symbol).size(); i++){
					boolean found_symbol = false;
					for(String p: predictions.get(current_symbol).get(i)){
						if(p.equals(token.getValue())){
							derivation.removeFirst();
							for(int j = rules.get(current_symbol).get(i).size()-1; j>=0; j--)
								derivation.addFirst(rules.get(current_symbol).get(i).get(j));
							found_symbol = true;
							break;
						}
					}
					found_rule |= found_symbol;
					if(found_rule)
						break;
				}
				if(!found_rule)
					break;
			}
		}
		
		ArrayList<String> d = new ArrayList<String>();
		for(String e: derivation)
			if(!e.equals(EPS))
				d.add(e);
		TreeSet<String> expected_tokens = compute_firsts_from(d, 0);
		TreeSet<Pair<Integer, String> > sorted_expected_tokens = new TreeSet<Pair<Integer, String>>();
		for(String e: expected_tokens)
			if(token_symbol.containsKey(e))
				sorted_expected_tokens.add(token_symbol.get(e));
			else if(token_symbol_alt.containsKey(e))
				sorted_expected_tokens.add(token_symbol_alt.get(e));
		if(sorted_expected_tokens.size() == 0){
			out.println("El analisis sintactico ha finalizado exitosamente.");
			System.exit(0);
		}
		if(expected_tokens.contains("proceso")){
			out.println("Error sintactico: falta proceso");
		}
		else{
			StringBuilder s = new StringBuilder("");
			s.append("<").append(token.r).append(",").append(token.c).append("> ");
			s.append("Error sintactico: se encontro: \"").append(token.lexema).append("\"; ");
			s.append("se esperaba: ");
			for(Pair<Integer,String> e: sorted_expected_tokens)		
				s.append("\"").append(e.second).append("\", ");
			s.setLength(s.length()-2);
			s.append(".");
			out.println(s.toString());
		}
		System.exit(0);
	}
	


	public static void main(String[] args) throws IOException{
		//br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new FileReader("in.txt"));
		out = new PrintWriter(new BufferedOutputStream(System.out));
		init();
		lexer();
		parser();

		out.close();
		br.close();
	}



	public static class Token{
		int r, c;
		String token, lexema;


		public Token(int fila, int columna) {
			this.r= fila;
			this.c= columna;
			this.token = new String("");
			this.lexema = new String("");
		}
		
		public Token(String token){
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

		public void addChar(char c){
			this.lexema += c;
		}

		public Token() {
			this.r = 0;
			this.c = 0;
			this.lexema = "";
			this.token = "";
		}

		public void fixCase(){
			this.lexema = this.lexema.toLowerCase();
		}
		
		public String getValue(){
			if(this.token != "")
				return this.token;
			return this.lexema;
		}

		@Override
		public String toString() {
			StringBuilder s = new StringBuilder("<");
			s.append( this.token + "," );
			if(!this.lexema.equals("")){
				 s.append( this.lexema + "," );
			}
			else if(this.token.equals("token_cadena") && this.lexema.equals("")){
				s.append(",");
			}
			s.append(this.r).append(",").append(this.c).append(">\n");
			return s.toString();
		}
	}

	public static class Error{
		int r,c;

		public Error() {
			this.r = 0;
			this.c = 0;
		}

		public Error(int r, int c){
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			StringBuilder s = new StringBuilder("");
			if(this.r != 0){
				s.append(">>> Error lexico (linea: ").append(this.r).append(", posicion: ").append(this.c).append(")\n");
				return s.toString();
			}
			else
				return "";
		}
	}
	public static class Pair<A, B> {
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
	    		return 
	    		((  this.first == otherPair.first ||
	    			( this.first != null && otherPair.first != null &&
	    			  this.first.equals(otherPair.first))) &&
	    		 (	this.second == otherPair.second ||
	    			( this.second != null && otherPair.second != null &&
	    			  this.second.equals(otherPair.second))) );
	    	}

	    	return false;
	    }

	    public String toString()
	    { 
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
	}

}
