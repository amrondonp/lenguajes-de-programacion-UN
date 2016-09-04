import java.util.*;
import java.io.*;

public class Main {
	

	static String buffer;
	static final Character END = new Character('\0');
	
	static TreeSet<Token> tokens;
	static TreeSet<Character> validSymbols;
	static int row;
	static int column;
	static int p;
	static Error error;
	static boolean failure;
	static TreeSet<String> reservedWords;
	static HashMap<String, String> tokenName;
	
	
	boolean isLetter(char c){return ('a' <=c && c<= 'z')|| ( 'A' <= c && c <= 'Z' );}
	boolean isDigit( char c ) { return ( '0' <= c && c <= '9' ); }
	boolean isWhiteSpace( char c ) { return ( c == '\n' || c == ' ' || c == '\t' || c == '\r' ); }
	boolean isSymbol( char c ) { return validSymbols.contains(new Character(c));}	
	
	public static void init(){
		row = column = p = 0;
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
	
	boolean ignoreComment(){
		boolean flag = false;
		if(buffer.charAt(p) == '/' && buffer.charAt(p+1) == '/'){
			while(buffer.charAt(p) != '\n'){
				p++; column++;
			}
			flag = true;
		}
		return flag;
	}
	
	boolean ignoreWhiteSpace(){
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
	
	void skip(){
		boolean trash;
		do{
			trash = false;
			trash |= ignoreWhiteSpace();
			trash |= ignoreComment();
		}
		while(trash);
	}
	
	public static void process() {
			
		
	}
	
	
	public static void main(String[] args) throws IOException{
		
		init();
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BufferedReader br = new BufferedReader(new FileReader("D:/u/octavo/lenguajes/taller2/in.txt"));
		String current_line;				
		while((current_line = br.readLine()) != null){
			buffer += current_line;
			buffer += "\n";
		}
		buffer += END;
		
		process();
		br.close();
	}
	


	public class Token{
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
		
		public Token() {
			this.r = 0;
			this.c = 0;
			this.lexema = "";
		}
		
		@Override
		public String toString() {
			StringBuilder s = new StringBuilder("<");
			if(!token.equals("")) s.append( token + "," );
			if(!lexema.equals("")) s.append( lexema + "," );
			s.append(r).append(" ").append(c).append(">\n");
			return s.toString();
		}
	}
	
	public class Error{
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
			StringBuilder s = new StringBuilder(">>> Error lexico (linea: ");
			if(this.r != 0){
				s.append(this.r).append(", posicion: ").append(this.c).append(")\n");
			}
			return s.toString();
		}
	}

}
