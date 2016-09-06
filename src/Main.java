import java.util.*;
import java.io.*;

public class Main {
	
	
	static PrintWriter out;
	static String buffer;
	static final Character END = new Character('\0');
	
	static ArrayList<Token> tokens;
	static TreeSet<Character> validSymbols;
	static int row;
	static int column;
	static int p;
	static Error error;
	static boolean failure;
	static TreeSet<String> reservedWords;
	static HashMap<String, String> tokenName;
	
	
	public static boolean  isLetter(char c){return ('a' <=c && c<= 'z')|| ( 'A' <= c && c <= 'Z' );}
	public static boolean  isDigit( char c ) { return ( '0' <= c && c <= '9' ); }
	public static boolean  isWhiteSpace( char c ) { return ( c == '\n' || c == ' ' || c == '\t' || c == '\r' ); }
	public static boolean  isSymbol( char c ) { return validSymbols.contains(new Character(c));}	
	public static boolean  isValidCharacter( char c ) { return ( isLetter( c ) || isDigit( c ) || ( isWhiteSpace( c ) && c != '\n' ) || c == '_' ); }
	
	public static void init(){
		tokenName = new HashMap<String, String>();
		reservedWords = new TreeSet<String>();
		validSymbols = new TreeSet<Character>();
		tokens = new ArrayList<Token>();
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
		
		validSymbols.add(new Character('~'));
		validSymbols.add(new Character('='));
		validSymbols.add(new Character('-'));
		validSymbols.add(new Character('*'));
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
		reservedWords.add("de");
		reservedWords.add("otro");
		reservedWords.add("modo");
		reservedWords.add("subproceso");
		reservedWords.add("finsubproceso");		
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
			else if(tokenName.containsKey(tkn.lexema)){
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
				boolean real = false;
				while( isDigit(c) || (c == '.' && !real && isDigit(buffer.charAt(p+1) ) ) ){
					p++;column++;
					real |= (c == '.');
					tkn.addChar(c);
					c = buffer.charAt(p);
				}
				if(real) tkn.setToken("token_real");
				else tkn.setToken("token_entero");
			}
		}
		else if(isSymbol(c) ){
			if( c == '\'' || c == '\"' ){
				int i = p;
				while( buffer.charAt(i) != END) i++;
				if(buffer.charAt(i) == '\"' || buffer.charAt(i) == '\''){
					while(buffer.charAt(i) != '\'' && buffer.charAt(i) != '\"' ){
						tkn.addChar(buffer.charAt(p));
						tkn.setToken("token_cadena");
						p++;column++;
					}										
				}
				else{
					error = new Error(row, column);
					failure = true;
				}		
			}
			else{
				String temp = "";
				temp +=(c + buffer.charAt(p));
				if(tokenName.containsKey(temp) ){
					tkn.addChar(buffer.charAt(p));
					tkn.setToken(tokenName.get(tkn.lexema));
					tkn.setLexema("");
					p++;c++;
				}
				else if(tokenName.containsKey(tkn.lexema) ){
					tkn.setToken(tokenName.get(tkn.lexema));
					tkn.setLexema("");
				}
				else{
					error = new Error(row,column-1);
					failure = true;
				}
				
			}
		}
		else{
			error = new Error(row, column-1);
			failure = true;
		}
		
		return tkn;
	}
	
	public static void printTokens(){
		for(Token token: tokens){
			out.println(token);
		}
		out.println(error);
	}
	
	public static void split(){
		p = 0;
		row=column=1;
		skip();
		while(buffer.charAt(p) != END){
			Token nextToken = readToken();
			if(!failure) tokens.add(nextToken);
			else break;
			skip();
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		init();
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BufferedReader br = new BufferedReader(new FileReader("in.txt"));
		out = new PrintWriter(new BufferedOutputStream(System.out));
		String current_line;				
		while((current_line = br.readLine()) != null){
			buffer += current_line;
			buffer += "\n";
		}
		buffer += END;
		
		split();
		printTokens();
		br.close();
		out.close();
	}
	


	public static class Token{
		int r, c;
		String token, lexema;
		
		public Token(int fila, int columna) {
			this.r= fila;
			this.c= columna;
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
		
		@Override
		public String toString() {
			StringBuilder s = new StringBuilder("<");
			if(!token.equals(""))s.append( token + "," );
			if(!lexema.equals("")) s.append( lexema + "," );
			s.append(r).append(" ").append(c).append(">\n");
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
				return "no error";
		}
	}

}