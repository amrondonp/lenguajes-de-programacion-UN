grammar MyLanguage;



programa : generarsubproceso generarproceso EOF
		 | EOF
		 ;

generarsubproceso : iniciosubproceso variable_retorno ID subproceso_arg cuerpo finalizarsubproceso generarsubproceso
		   |
		   ;
iniciosubproceso : Subproceso
				 | Subalgoritmo
				 | Funcion
				 ;
subproceso_arg : TOKEN_PAR_IZQ argumento TOKEN_PAR_DER
			   |
			   ;

finalizarsubproceso : Finsubproceso
			  | Finsubalgoritmo
			  | Finfuncion
			  ;
variable_retorno : ID TOKEN_ASIG
				 |
				 ;
argumento : lista
		  |
		  ;
lista : ID (TOKEN_COMA ID)*
	  |
	  ;

generarproceso : inicioproceso ID cuerpo finalizarproceso;
inicioproceso: Proceso
		  	 | Algoritmo
		  	 ;
finalizarproceso : Finproceso
		   | Finalgoritmo
		   ;


cuerpo 	: Definir definicion cuerpo  //ya
		| instruccion cuerpo  //falta esperar
		| Dimension dimensionar cuerpo
		| Si condicional_si cuerpo
		| Para ciclo_para cuerpo
		| Mientras ciclo_mientras cuerpo
		| Repetir ciclo_repetir cuerpo
		| Segun segun_hacer cuerpo
		| asignacion_llamado cuerpo
		|
		;


dimensionar	:  lista_arreglos TOKEN_PYC;
arreglo : ID dim;
dim	: TOKEN_COR_IZQ  lista_expr TOKEN_COR_DER
	| TOKEN_PAR_IZQ  lista_expr TOKEN_PAR_DER
	;
lista_arreglos  : arreglo (TOKEN_COMA arreglo)*	;

definicion	: lista Como tipo TOKEN_PYC ;

asignacion_llamado	: ID llamar_o_asignar TOKEN_PYC;
llamar_o_asignar : asignar
				| acceder_arreglo asignar
				| pars_fun
				;
asignar : TOKEN_ASIG expresion_logica;
lista_expr : expresion_logica (TOKEN_COMA expresion_logica)*	;

expresion_logica	: TOKEN_NEG expresion_logica
									| expresion_logica RELOP expresion_logica
									| expresion_logica IODOP expresion_logica
									| expresion_logica TOKEN_Y expresion_logica
									| expresion_logica TOKEN_O expresion_logica
									| TOKEN_PAR_IZQ expresion_logica TOKEN_PAR_DER
									| expresion
									;

expresion	:	TOKEN_MENOS expresion
					| expresion TOKEN_POT expresion
					| expresion MULOP expresion
					| expresion SUMOP expresion
					| constante
					| id
					| TOKEN_PAR_IZQ expresion TOKEN_PAR_DER
					;




constante : TOKEN_ENTERO
			| TOKEN_REAL
			| TOKEN_CADENA
			| Verdadero
			| Falso
			;

tipo : Caracter
		| Entero
		| Logico
		| Numero
		| Numerico
		| Real
		| Texto
		| Cadena
		;


		id : ID llamado ;
		llamado	:
							|	acceder_arreglo
							| pars_fun
							;
		pars_fun : TOKEN_PAR_IZQ pars_lista TOKEN_PAR_DER;
		pars_lista : lista_expr
							 |
							 ;

		acceder_arreglo : TOKEN_COR_IZQ lista_expr TOKEN_COR_DER ;


instruccion : Esperar ins_esperar TOKEN_PYC
				| ins_borrar Pantalla TOKEN_PYC
				| Escribir lista_expr TOKEN_PYC
				| Leer lista_id_o_llamado TOKEN_PYC
				;
ins_borrar : Borrar
			| Limpiar
			;
ins_esperar : Tecla
				| expresion Segundos
				;
lista_id_o_llamado : id (TOKEN_COMA id)*	;

condicional_si : expresion_logica Entonces cuerpo si_no Finsi;

si_no : Sino cuerpo
		|
		;
ciclo_para : ID TOKEN_ASIG expresion Hasta expresion_logica con_paso Hacer cuerpo Finpara;
con_paso : Con Paso expresion
			|
			;
ciclo_mientras: expresion_logica Hacer cuerpo Finmientras;
ciclo_repetir : cuerpo Hasta Que expresion_logica;

segun_hacer :  id Hacer casos de_otro_modo Finsegun;

de_otro_modo : De Otro Modo TOKEN_DOSP cuerpo
				|
				;
casos : caso_segun (caso_segun)*
		|
		;
caso_segun : Caso expresion_logica TOKEN_DOSP cuerpo ;


COMMENT 		: '/*' .*? '*/' -> skip ;
LINE_COMMENT 	: '//' ~[\r\n]* -> skip ;
WS		: [ \t\r\n]+ -> skip ;

Verdadero : 'verdadero';
Falso : 'falso';
Algoritmo : 'algoritmo';
Proceso : 'proceso';
Finproceso : 'finproceso';
Finalgoritmo : 'finalgoritmo';
Definir : 'definir';
Como: 'como';
Entero : 'entero';
Numero : 'numero';
Numerico : 'numerico';
Real : 'real';
Logico : 'logico';
Caracter: 'caracter';
Texto : 'texto';
Cadena : 'cadena';
Dimension : 'dimension';
Mientras : 'mientras';
Hacer : 'hacer';
Finmientras : 'finmientras';
Milisegundos : 'milisegundos';
Segundos : 'segundos';
Leer : 'leer';
Limpiar : 'limpiar';
Pantalla : 'pantalla';
Repetir : 'repetir';
Funcion : 'funcion';
Tecla : 'tecla';
Escribir : 'escribir';
Esperar : 'esperar';
Hasta : 'hasta';
Que : 'que';
Para : 'para';
Finpara : 'finpara';
Con :'con';
Paso : 'paso';
Si : 'si';
Finsi : 'finsi';
Sino: 'sino';
Entonces : 'entonces';
Segun : 'segun';
Finsegun : 'finsegun';
Finfuncion : 'finfuncion';
De : 'de';
Otro : 'otro';
Modo : 'modo';
Subproceso : 'subproceso';
Finsubproceso : 'finsubproceso';
Borrar : 'borrar';
Finsubalgoritmo : 'finsubalgoritmo';
Subalgoritmo : 'subalgoritmo';
Caso : 'caso';


RELOP	: TOKEN_MENOR
			| TOKEN_MENOR_IGUAL
			| TOKEN_MAYOR
			| TOKEN_MAYOR_IGUAL
			;

IODOP	: TOKEN_IGUAL
			| TOKEN_DIF
			;
TOKEN_MENOS : '-';
SUMOP : TOKEN_MAS | TOKEN_MENOS;
MULOP : TOKEN_MUL | TOKEN_DIV | TOKEN_MOD;


TOKEN_PAR_IZQ : '(';
TOKEN_PAR_DER : ')';
TOKEN_COR_IZQ : '[';
TOKEN_COR_DER : ']';
TOKEN_PYC : ';';
TOKEN_ASIG : '<-';
TOKEN_DIF : '<>';
TOKEN_MENOR : '<';
TOKEN_MAYOR : '>';
TOKEN_MENOR_IGUAL : '<=';
TOKEN_MAYOR_IGUAL : '>=';
TOKEN_COMA : ',';
TOKEN_O : '\u007C'
		| 'o'
		;
TOKEN_Y : '&'
		| 'y'
		;
TOKEN_NEG : '~'
			| 'no';
TOKEN_IGUAL : '='
			| '==';
TOKEN_MAS : '+';

TOKEN_DIV : '/';
TOKEN_MUL : '*';
TOKEN_MOD : '%'
			| 'mod'
			;
TOKEN_DOSP : ':';
TOKEN_POT : '^';
TOKEN_EOF : '$';




TOKEN_ENTERO : [0-9]+	;
TOKEN_REAL : [0-9]+[.][0-9]+;
TOKEN_CADENA : [\'|"].*?[\'|"] ;

ID : [a-zA-Z][a-zA-Z0-9_]* ;
