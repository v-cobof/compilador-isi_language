grammar IsiLang;

@header{
    import br.com.isiLanguage.dataStructures.IsiSymbol;
    import br.com.isiLanguage.dataStructures.IsiVariable;
    import br.com.isiLanguage.dataStructures.IsiSymbolTable;
    import br.com.isiLanguage.exceptions.IsiSemanticException;

}

@members {
    private int _tipo;
    private String _varName;
    private String _varValue;
    private IsiSymbolTable symbolTable = new IsiSymbolTable();
    private IsiSymbol symbol;

    public void handleInsercaoSimboloNaTabela(String varName)
    {
        _varName = varName;
        _varValue = null;
        symbol = new IsiVariable(_varName, _tipo, _varValue);

        if(!symbolTable.exists(_varName))
        {
            symbolTable.add(symbol);
            System.out.println("Simbolo adicionado " + symbol);
        }
        else
        {
            throw new IsiSemanticException("Simbolo "+_varName+" ja foi declarado");
        }
    }

    public void verificaId(String id){
        if (!symbolTable.exists(id)){
            throw new IsiSemanticException("Simbolo "+id+" não foi declarado");
        }
    }
}

prog	: 'programa' decl bloco 'fimprog;'
		;

decl    :  (declaravar)+
        ;


declaravar :  'declare' tipo ID { handleInsercaoSimboloNaTabela(_input.LT(-1).getText()); }
                        (VIR ID { handleInsercaoSimboloNaTabela(_input.LT(-1).getText()); })*
		                 SC
           ;

tipo       :    'numero'  { _tipo = IsiVariable.NUMBER;  }
           |    'texto'   { _tipo = IsiVariable.TEXT;  }
           ;

bloco	: (cmd)+
		;

cmd		:  cmdleitura { System.out.println("Reconheci leitura"); }
        |  cmdescrita { System.out.println("Reconheci escrita"); }
        |  cmdattrib  { System.out.println("Reconheci atribuição"); }
		;


cmdleitura	: 'leia' AP
                     ID { _varName = _input.LT(-1).getText();
                          verificaId(_varName);
                        }
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