// Generated from IsiLang.g4 by ANTLR 4.13.0
package br.com.isiLanguage.parser;

    import br.com.isiLanguage.dataStructures.IsiSymbol;
    import br.com.isiLanguage.dataStructures.IsiVariable;
    import br.com.isiLanguage.dataStructures.IsiSymbolTable;
    import br.com.isiLanguage.exceptions.IsiSemanticException;


import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class IsiLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, AP=8, FP=9, SC=10, 
		OP=11, ATTR=12, ID=13, NUMBER=14, VIR=15, WS=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "AP", "FP", "SC", 
			"OP", "ATTR", "ID", "NUMBER", "VIR", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog;'", "'declare'", "'numero'", "'texto'", 
			"'leia'", "'escreva'", "'('", "')'", "';'", null, "':='", null, null, 
			"','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "AP", "FP", "SC", "OP", 
			"ATTR", "ID", "NUMBER", "VIR", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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

	    public void validarSeVariavelExiste(String id){
	        if (!symbolTable.exists(id)){
	            throw new IsiSemanticException("Symbol "+id+" not declared");
	        }
	    }


	public IsiLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "IsiLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0010z\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0005\fc\b\f\n\f\f\ff\t"+
		"\f\u0001\r\u0004\ri\b\r\u000b\r\f\rj\u0001\r\u0001\r\u0004\ro\b\r\u000b"+
		"\r\f\rp\u0003\rs\b\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0000\u0000\u0010\u0001\u0001\u0003\u0002\u0005\u0003"+
		"\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015"+
		"\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010\u0001\u0000"+
		"\u0005\u0003\u0000*+--//\u0001\u0000az\u0003\u000009AZaz\u0001\u00000"+
		"9\u0003\u0000\t\n\r\r  }\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003"+
		"\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007"+
		"\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001"+
		"\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000"+
		"\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000"+
		"\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000"+
		"\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000"+
		"\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000"+
		"\u0000\u0000\u0001!\u0001\u0000\u0000\u0000\u0003*\u0001\u0000\u0000\u0000"+
		"\u00053\u0001\u0000\u0000\u0000\u0007;\u0001\u0000\u0000\u0000\tB\u0001"+
		"\u0000\u0000\u0000\u000bH\u0001\u0000\u0000\u0000\rM\u0001\u0000\u0000"+
		"\u0000\u000fU\u0001\u0000\u0000\u0000\u0011W\u0001\u0000\u0000\u0000\u0013"+
		"Y\u0001\u0000\u0000\u0000\u0015[\u0001\u0000\u0000\u0000\u0017]\u0001"+
		"\u0000\u0000\u0000\u0019`\u0001\u0000\u0000\u0000\u001bh\u0001\u0000\u0000"+
		"\u0000\u001dt\u0001\u0000\u0000\u0000\u001fv\u0001\u0000\u0000\u0000!"+
		"\"\u0005p\u0000\u0000\"#\u0005r\u0000\u0000#$\u0005o\u0000\u0000$%\u0005"+
		"g\u0000\u0000%&\u0005r\u0000\u0000&\'\u0005a\u0000\u0000\'(\u0005m\u0000"+
		"\u0000()\u0005a\u0000\u0000)\u0002\u0001\u0000\u0000\u0000*+\u0005f\u0000"+
		"\u0000+,\u0005i\u0000\u0000,-\u0005m\u0000\u0000-.\u0005p\u0000\u0000"+
		"./\u0005r\u0000\u0000/0\u0005o\u0000\u000001\u0005g\u0000\u000012\u0005"+
		";\u0000\u00002\u0004\u0001\u0000\u0000\u000034\u0005d\u0000\u000045\u0005"+
		"e\u0000\u000056\u0005c\u0000\u000067\u0005l\u0000\u000078\u0005a\u0000"+
		"\u000089\u0005r\u0000\u00009:\u0005e\u0000\u0000:\u0006\u0001\u0000\u0000"+
		"\u0000;<\u0005n\u0000\u0000<=\u0005u\u0000\u0000=>\u0005m\u0000\u0000"+
		">?\u0005e\u0000\u0000?@\u0005r\u0000\u0000@A\u0005o\u0000\u0000A\b\u0001"+
		"\u0000\u0000\u0000BC\u0005t\u0000\u0000CD\u0005e\u0000\u0000DE\u0005x"+
		"\u0000\u0000EF\u0005t\u0000\u0000FG\u0005o\u0000\u0000G\n\u0001\u0000"+
		"\u0000\u0000HI\u0005l\u0000\u0000IJ\u0005e\u0000\u0000JK\u0005i\u0000"+
		"\u0000KL\u0005a\u0000\u0000L\f\u0001\u0000\u0000\u0000MN\u0005e\u0000"+
		"\u0000NO\u0005s\u0000\u0000OP\u0005c\u0000\u0000PQ\u0005r\u0000\u0000"+
		"QR\u0005e\u0000\u0000RS\u0005v\u0000\u0000ST\u0005a\u0000\u0000T\u000e"+
		"\u0001\u0000\u0000\u0000UV\u0005(\u0000\u0000V\u0010\u0001\u0000\u0000"+
		"\u0000WX\u0005)\u0000\u0000X\u0012\u0001\u0000\u0000\u0000YZ\u0005;\u0000"+
		"\u0000Z\u0014\u0001\u0000\u0000\u0000[\\\u0007\u0000\u0000\u0000\\\u0016"+
		"\u0001\u0000\u0000\u0000]^\u0005:\u0000\u0000^_\u0005=\u0000\u0000_\u0018"+
		"\u0001\u0000\u0000\u0000`d\u0007\u0001\u0000\u0000ac\u0007\u0002\u0000"+
		"\u0000ba\u0001\u0000\u0000\u0000cf\u0001\u0000\u0000\u0000db\u0001\u0000"+
		"\u0000\u0000de\u0001\u0000\u0000\u0000e\u001a\u0001\u0000\u0000\u0000"+
		"fd\u0001\u0000\u0000\u0000gi\u0007\u0003\u0000\u0000hg\u0001\u0000\u0000"+
		"\u0000ij\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000jk\u0001\u0000"+
		"\u0000\u0000kr\u0001\u0000\u0000\u0000ln\u0005.\u0000\u0000mo\u0007\u0003"+
		"\u0000\u0000nm\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000pn\u0001"+
		"\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000qs\u0001\u0000\u0000\u0000"+
		"rl\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000s\u001c\u0001\u0000"+
		"\u0000\u0000tu\u0005,\u0000\u0000u\u001e\u0001\u0000\u0000\u0000vw\u0007"+
		"\u0004\u0000\u0000wx\u0001\u0000\u0000\u0000xy\u0006\u000f\u0000\u0000"+
		"y \u0001\u0000\u0000\u0000\u0006\u0000bdjpr\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}