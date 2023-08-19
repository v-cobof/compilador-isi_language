// Generated from IsiLang.g4 by ANTLR 4.13.0
package br.com.isiLanguage.parser;

    import br.com.isiLanguage.dataStructures.IsiSymbol;
    import br.com.isiLanguage.dataStructures.IsiVariable;
    import br.com.isiLanguage.dataStructures.IsiSymbolTable;
    import br.com.isiLanguage.exceptions.IsiSemanticException;
    import br.com.isiLanguage.ast.IsiProgram;
    import br.com.isiLanguage.ast.AbstractCommand;
    import br.com.isiLanguage.ast.CommandLeitura;
    import br.com.isiLanguage.ast.CommandEscrita;
    import br.com.isiLanguage.ast.CommandAtribuicao;
    import br.com.isiLanguage.ast.CommandDecisao;

    import java.util.ArrayList;
    import java.util.Stack;

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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		AP=10, FP=11, SC=12, OP=13, ATTR=14, ID=15, NUMBER=16, VIR=17, OPREL=18, 
		ACH=19, FCH=20, WS=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"AP", "FP", "SC", "OP", "ATTR", "ID", "NUMBER", "VIR", "OPREL", "ACH", 
			"FCH", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog;'", "'declare'", "'numero'", "'texto'", 
			"'se'", "'senao'", "'leia'", "'escreva'", "'('", "')'", "';'", null, 
			"':='", null, null, "','", null, "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "AP", "FP", 
			"SC", "OP", "ATTR", "ID", "NUMBER", "VIR", "OPREL", "ACH", "FCH", "WS"
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
	    private IsiProgram program = new IsiProgram();
	    private ArrayList<AbstractCommand> curThread;
	    private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();

	    private String _readId;
	    private String _writeId;
	    private String _exprId;
	    private String _exprContent;
	    private String _exprDecision;

	    private ArrayList<AbstractCommand> listaTrue;
	    private ArrayList<AbstractCommand> listaFalse;

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

	    public void exibeComandos(){
	        for (AbstractCommand c: program.getComandos()){
	            System.out.println(c);
	        }
	    }

	    public void generateCode(){
	        program.generateTarget();
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
		"\u0004\u0000\u0015\u009c\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0005\u000ev\b\u000e\n\u000e\f\u000ey\t\u000e"+
		"\u0001\u000f\u0004\u000f|\b\u000f\u000b\u000f\f\u000f}\u0001\u000f\u0001"+
		"\u000f\u0004\u000f\u0082\b\u000f\u000b\u000f\f\u000f\u0083\u0003\u000f"+
		"\u0086\b\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0003\u0011\u0093\b\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0000\u0000\u0015\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d"+
		"\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015\u0001\u0000\u0006"+
		"\u0003\u0000*+--//\u0001\u0000az\u0003\u000009AZaz\u0001\u000009\u0002"+
		"\u0000<<>>\u0003\u0000\t\n\r\r  \u00a3\u0000\u0001\u0001\u0000\u0000\u0000"+
		"\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000"+
		"\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000"+
		"\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f"+
		"\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013"+
		"\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017"+
		"\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b"+
		"\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f"+
		"\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000"+
		"\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000"+
		"\u0000\u0000)\u0001\u0000\u0000\u0000\u0001+\u0001\u0000\u0000\u0000\u0003"+
		"4\u0001\u0000\u0000\u0000\u0005=\u0001\u0000\u0000\u0000\u0007E\u0001"+
		"\u0000\u0000\u0000\tL\u0001\u0000\u0000\u0000\u000bR\u0001\u0000\u0000"+
		"\u0000\rU\u0001\u0000\u0000\u0000\u000f[\u0001\u0000\u0000\u0000\u0011"+
		"`\u0001\u0000\u0000\u0000\u0013h\u0001\u0000\u0000\u0000\u0015j\u0001"+
		"\u0000\u0000\u0000\u0017l\u0001\u0000\u0000\u0000\u0019n\u0001\u0000\u0000"+
		"\u0000\u001bp\u0001\u0000\u0000\u0000\u001ds\u0001\u0000\u0000\u0000\u001f"+
		"{\u0001\u0000\u0000\u0000!\u0087\u0001\u0000\u0000\u0000#\u0092\u0001"+
		"\u0000\u0000\u0000%\u0094\u0001\u0000\u0000\u0000\'\u0096\u0001\u0000"+
		"\u0000\u0000)\u0098\u0001\u0000\u0000\u0000+,\u0005p\u0000\u0000,-\u0005"+
		"r\u0000\u0000-.\u0005o\u0000\u0000./\u0005g\u0000\u0000/0\u0005r\u0000"+
		"\u000001\u0005a\u0000\u000012\u0005m\u0000\u000023\u0005a\u0000\u0000"+
		"3\u0002\u0001\u0000\u0000\u000045\u0005f\u0000\u000056\u0005i\u0000\u0000"+
		"67\u0005m\u0000\u000078\u0005p\u0000\u000089\u0005r\u0000\u00009:\u0005"+
		"o\u0000\u0000:;\u0005g\u0000\u0000;<\u0005;\u0000\u0000<\u0004\u0001\u0000"+
		"\u0000\u0000=>\u0005d\u0000\u0000>?\u0005e\u0000\u0000?@\u0005c\u0000"+
		"\u0000@A\u0005l\u0000\u0000AB\u0005a\u0000\u0000BC\u0005r\u0000\u0000"+
		"CD\u0005e\u0000\u0000D\u0006\u0001\u0000\u0000\u0000EF\u0005n\u0000\u0000"+
		"FG\u0005u\u0000\u0000GH\u0005m\u0000\u0000HI\u0005e\u0000\u0000IJ\u0005"+
		"r\u0000\u0000JK\u0005o\u0000\u0000K\b\u0001\u0000\u0000\u0000LM\u0005"+
		"t\u0000\u0000MN\u0005e\u0000\u0000NO\u0005x\u0000\u0000OP\u0005t\u0000"+
		"\u0000PQ\u0005o\u0000\u0000Q\n\u0001\u0000\u0000\u0000RS\u0005s\u0000"+
		"\u0000ST\u0005e\u0000\u0000T\f\u0001\u0000\u0000\u0000UV\u0005s\u0000"+
		"\u0000VW\u0005e\u0000\u0000WX\u0005n\u0000\u0000XY\u0005a\u0000\u0000"+
		"YZ\u0005o\u0000\u0000Z\u000e\u0001\u0000\u0000\u0000[\\\u0005l\u0000\u0000"+
		"\\]\u0005e\u0000\u0000]^\u0005i\u0000\u0000^_\u0005a\u0000\u0000_\u0010"+
		"\u0001\u0000\u0000\u0000`a\u0005e\u0000\u0000ab\u0005s\u0000\u0000bc\u0005"+
		"c\u0000\u0000cd\u0005r\u0000\u0000de\u0005e\u0000\u0000ef\u0005v\u0000"+
		"\u0000fg\u0005a\u0000\u0000g\u0012\u0001\u0000\u0000\u0000hi\u0005(\u0000"+
		"\u0000i\u0014\u0001\u0000\u0000\u0000jk\u0005)\u0000\u0000k\u0016\u0001"+
		"\u0000\u0000\u0000lm\u0005;\u0000\u0000m\u0018\u0001\u0000\u0000\u0000"+
		"no\u0007\u0000\u0000\u0000o\u001a\u0001\u0000\u0000\u0000pq\u0005:\u0000"+
		"\u0000qr\u0005=\u0000\u0000r\u001c\u0001\u0000\u0000\u0000sw\u0007\u0001"+
		"\u0000\u0000tv\u0007\u0002\u0000\u0000ut\u0001\u0000\u0000\u0000vy\u0001"+
		"\u0000\u0000\u0000wu\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000"+
		"x\u001e\u0001\u0000\u0000\u0000yw\u0001\u0000\u0000\u0000z|\u0007\u0003"+
		"\u0000\u0000{z\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}{\u0001"+
		"\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~\u0085\u0001\u0000\u0000"+
		"\u0000\u007f\u0081\u0005.\u0000\u0000\u0080\u0082\u0007\u0003\u0000\u0000"+
		"\u0081\u0080\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000"+
		"\u0083\u0081\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000"+
		"\u0084\u0086\u0001\u0000\u0000\u0000\u0085\u007f\u0001\u0000\u0000\u0000"+
		"\u0085\u0086\u0001\u0000\u0000\u0000\u0086 \u0001\u0000\u0000\u0000\u0087"+
		"\u0088\u0005,\u0000\u0000\u0088\"\u0001\u0000\u0000\u0000\u0089\u0093"+
		"\u0007\u0004\u0000\u0000\u008a\u008b\u0005>\u0000\u0000\u008b\u0093\u0005"+
		"=\u0000\u0000\u008c\u008d\u0005<\u0000\u0000\u008d\u0093\u0005=\u0000"+
		"\u0000\u008e\u008f\u0005=\u0000\u0000\u008f\u0093\u0005=\u0000\u0000\u0090"+
		"\u0091\u0005!\u0000\u0000\u0091\u0093\u0005=\u0000\u0000\u0092\u0089\u0001"+
		"\u0000\u0000\u0000\u0092\u008a\u0001\u0000\u0000\u0000\u0092\u008c\u0001"+
		"\u0000\u0000\u0000\u0092\u008e\u0001\u0000\u0000\u0000\u0092\u0090\u0001"+
		"\u0000\u0000\u0000\u0093$\u0001\u0000\u0000\u0000\u0094\u0095\u0005{\u0000"+
		"\u0000\u0095&\u0001\u0000\u0000\u0000\u0096\u0097\u0005}\u0000\u0000\u0097"+
		"(\u0001\u0000\u0000\u0000\u0098\u0099\u0007\u0005\u0000\u0000\u0099\u009a"+
		"\u0001\u0000\u0000\u0000\u009a\u009b\u0006\u0014\u0000\u0000\u009b*\u0001"+
		"\u0000\u0000\u0000\u0007\u0000uw}\u0083\u0085\u0092\u0001\u0006\u0000"+
		"\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}