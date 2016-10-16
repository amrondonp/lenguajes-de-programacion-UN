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
argumento : ID lista
		  |
		  ;
lista : TOKEN_COMA ID lista
	  |
	  ;

generarproceso : inicioproceso ID cuerpo finalizarproceso;
inicioproceso: Proceso
		  	 | Algoritmo
		  	 ;
finalizarproceso : Finproceso
		   | Finalgoritmo
		   ;


cuerpo 	: Definir definicion cuerpo
		| instruccion cuerpo
		| Dimension dimensionar cuerpo
		| Si condicional_si cuerpo
		| Para ciclo_para cuerpo
		| Mientras ciclo_mientras cuerpo
		| Repetir ciclo_repetir cuerpo
		| Segun segun_hacer cuerpo
		| asignacion_llamado cuerpo
		|
		;


llamado_sub	: ID arg_llamado_proceso;
llamado_arr : ID acceder_arreglo;

dimensionar	: arreglo lista_arreglos TOKEN_PYC;
arreglo : ID dim;
dim	: TOKEN_COR_IZQ expresion lista_expr TOKEN_COR_DER
	| TOKEN_PAR_IZQ expresion lista_expr TOKEN_PAR_DER
	;
lista_arreglos  : TOKEN_COMA arreglo lista_arreglos
				|
				;

definicion	: ID lista Como tipo TOKEN_PYC ;

asignacion_llamado	: ID llamar_o_asignar TOKEN_PYC;
llamar_o_asignar : asignar
				| acceder_arreglo asignar
				| llamado_proceso
				;
asignar : TOKEN_ASIG expresion;
lista_expr : TOKEN_COMA expresion lista_expr
			|
			;
expresion : termino complemento;
complemento : TOKEN_Y termino complemento
			| TOKEN_O termino complemento
			| expresion_logica
			;
expresion_logica : TOKEN_IGUAL termino complementos_adicionales
					| TOKEN_DIF termino complementos_adicionales
					| TOKEN_MENOR termino complementos_adicionales
					| TOKEN_MAYOR termino complementos_adicionales
					| TOKEN_MENOR_IGUAL termino complementos_adicionales
					| TOKEN_MAYOR_IGUAL termino complementos_adicionales
					| expresion_mat
					;
complementos_adicionales : TOKEN_Y termino complemento
							| TOKEN_O termino complemento
							| TOKEN_MAS termino complemento
							| TOKEN_MENOS termino complemento
							| TOKEN_MUL termino complemento
							| TOKEN_MOD termino complemento
							| TOKEN_POT termino complemento
							| TOKEN_DIV termino complemento
							|
							;
expresion_mat : TOKEN_MAS termino complemento
				| TOKEN_MENOS termino complemento
				| expresion_mat2
				;
expresion_mat2 : TOKEN_MUL termino complemento
				| TOKEN_MOD termino complemento
				| TOKEN_POT termino complemento
				| TOKEN_DIV termino complemento
				|
				;
termino : TOKEN_PAR_IZQ expresion TOKEN_PAR_DER
		| constante
		| id_o_llamado
		| TOKEN_MENOS expresion
		| TOKEN_NEG expresion
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
instruccion : Esperar ins_esperar TOKEN_PYC
				| ins_borrar Pantalla TOKEN_PYC
				| Escribir expresion lista_expr TOKEN_PYC
				| Leer id_o_llamado lista_id_o_llamado TOKEN_PYC
				;
ins_borrar : Borrar
			| Limpiar
			;
ins_esperar : Tecla
				| expresion Segundos
				;
lista_id_o_llamado : TOKEN_COMA id_o_llamado lista_id_o_llamado
					|
					;
condicional_si : evaluar_par Entonces cuerpo si_no Finsi;
evaluar_par : TOKEN_PAR_IZQ expresion TOKEN_PAR_DER
				| expresion
				;
si_no : Sino cuerpo
		|
		;
ciclo_para : ID TOKEN_ASIG expresion Hasta expresion con_paso Hacer cuerpo Finpara;
con_paso : Con Paso expresion
			|
			;
ciclo_mientras: expresion Hacer cuerpo Finmientras;
ciclo_repetir : cuerpo Hasta Que expresion;
segun_hacer : expresion Hacer casos de_otro_modo Finsegun;
de_otro_modo : De Otro Modo TOKEN_DOSP cuerpo
				|
				;
casos : caso_segun casos
		|
		;
caso_segun : Caso expresion TOKEN_DOSP cuerpo ;
id_o_llamado : ID complemento_id_o_llamado;
complemento_id_o_llamado : acceder_arreglo
							| llamado_proceso
							|
							;
llamado_proceso : arg_llamado_proceso;
arg_llamado_proceso : TOKEN_PAR_IZQ arg_llamado TOKEN_PAR_DER
						|
						;
arg_llamado : expresion lista_arg_llamado
				|
				;
lista_arg_llamado : TOKEN_COMA expresion lista_arg_llamado
					|
					;
acceder_arreglo : index;
index : TOKEN_COR_IZQ expresion lista_expr TOKEN_COR_DER;

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
Mod : 'mod';
Subproceso : 'subproceso';
Finsubproceso : 'finsubproceso';
Borrar : 'borrar';
Finsubalgoritmo : 'finsubalgoritmo';
Subalgoritmo : 'subalgoritmo';
Caso : 'caso';

TOKEN_ENTERO : [0-9]+	;
TOKEN_REAL : [0-9]+[.][0-9]+;
TOKEN_CADENA : [\'|"].*?[\'|"] ;

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
TOKEN_O : '|'
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
TOKEN_MENOS : '-';
TOKEN_DIV : '/';
TOKEN_MUL : '*';
TOKEN_MOD : '%'
			| Mod
			;
TOKEN_DOSP : ':';
TOKEN_POT : '^';
TOKEN_EOF : '$';


ID : [a-zA-Z][a-zA-Z0-9_]* ;
