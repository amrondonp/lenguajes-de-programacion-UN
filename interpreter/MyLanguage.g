grammar MyLanguage;

programa : subproceso proceso subproceso

subproceso : iniciosubproceso variable_retorno ID subproceso_arg cuerpo finsubproceso subproceso
		   |
		   ;
subproceso_arg : TOKEN_PAR_IZQ argumento TOKEN_PAR_DER
			   |
			   ;
iniciosubproceso : 'subproceso'
				 | 'subalgoritmo'
				 | 'funcion'
				 ;
finsubproceso : 'finsubproceso'
			  | 'finsubalgoritmo'
			  | 'finfuncion'
			  ;
variable_retorno : ID TOKEN_ASIG
				 | 
				 ;
argumento : ID lista
		  |
		  ;
lista : ',' ID lista
	  | 
	  ;

proceso : inicioproceso ID cuerpo finproceso
inicioproceso: 'proceso'
		  	 | 'algoritmo'
		  	 ;
finproceso : 'finproceso'
		   | 'finalgoritmo'


cuerpo 	: definicion cuerpo
		| definicion cuerpo
		| asignacion cuerpo
		| instruccion cuerpo
		| dimension cuerpo
		| condicional_si cuerpo
		| ciclo_para cuerpo
		| ciclo_mientras cuerpo
		| ciclo_repetir cuerpo
		| segun_hacer cuerpo
		| llamado_sub cuerpo
		|
		;


llamado_sub	: ID arg_llamado_proceso
llamado_arr : ID acceder_arreglo

dimension	: 'dimension' arreglo lista_arreglos TOKEN_PYC
arreglo : ID dim
dim	: TOKEN_COR_IZQ expresion lista_expr TOKEN_COR_DER
lista_arreglos  : ',' arreglo lista_arreglos
				| 
				;

definicion	: 'definir' ID lista 'como' tipo TOKEN_PYC ;
asignacion	: ID TOKEN_ASIG expresion TOKEN_PYC ;
			| llamado_arr TOKEN_ASIG expresion TOKEN_PYC
			;
@TODO

			
		


COMMENT 		: '/*' .*? '*/' -> skip ;
LINE_COMMENT 	: '//' ~[\r\n]* -> skip ;
WS		: [ \t\r\n]+ -> skip ;

ID : [a-zA-Z][a-zA-Z0-9_]* ;
ENTERO : [0-9]+ ;
REAL : [0-9]+[.][0-9]+ ;
CADENA : '"'[.]* ;
LOGICO : 'verdadero'
	   | 'falso'
	   ;
TOKEN_PAR_IZQ : '(';
TOKEN_PAR_DER : ')';
TOKEN_COR_IZQ : '[';
TOKEN_COR_DER : ']';	  
TOKEN_PYC : ';';
TOKEN_ASIG : '<-';
	
				 