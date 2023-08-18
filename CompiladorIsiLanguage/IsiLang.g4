grammar IsiLang;

prog	: 'programa' bloco 'fimprog;'
		;

decl    :  (declaravar)+
        ;


declaravar :  'declare' tipo ID
                        (VIR ID )*
		                 SC
           ;

tipo       :    'numero'
           |    'texto'
           ;

bloco	: (cmd)+
		;

cmd		:  cmdleitura { System.out.println("Reconheci leitura"); }
        |  cmdescrita { System.out.println("Reconheci escrita"); }
        |  cmdattrib  { System.out.println("Reconheci atribuição"); }
		;


cmdleitura	: 'leia' AP
                     ID
                     FP
                     SC
            ;

cmdescrita	: 'escreva' AP
                        ID
                        FP
                        SC
			;

cmdattrib   : ID ATTR expr SC
            ;

expr        : termo ( OP termo )*
            ;

termo       : ID | NUMBER
            ;

AP	: '('
	;

FP	: ')'
	;

SC	: ';'
	;

OP	: '+' | '-' | '*' | '/'
	;

ATTR : ':='
	 ;

ID	: [a-z] ([a-z] | [A-Z] | [0-9])*
	;

NUMBER	: [0-9]+ ('.' [0-9]+)?
		;

VIR     :  ','
        ;

WS	: (' ' | '\t' | '\n' | '\r') -> skip;