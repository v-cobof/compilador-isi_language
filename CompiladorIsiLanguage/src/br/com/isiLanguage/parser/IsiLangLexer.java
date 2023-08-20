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
    import br.com.isiLanguage.ast.CommandEscritaComTexto;
    import br.com.isiLanguage.ast.CommandAtribuicao;
    import br.com.isiLanguage.ast.CommandDecisao;
    import br.com.isiLanguage.ast.CommandEnquanto;
    import br.com.isiLanguage.ast.CommandFacaEnquanto;

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
		T__9=10, T__10=11, AP=12, FP=13, PF=14, OP=15, ATTR=16, TEXT=17, ID=18, 
		VIR=19, OPREL=20, ACH=21, FCH=22, NUMBER=23, WS=24;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "AP", "FP", "PF", "OP", "ATTR", "TEXT", "ID", "VIR", 
			"OPREL", "ACH", "FCH", "NUMBER", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog.'", "'declare'", "'numero'", "'texto'", 
			"'se'", "'senao'", "'leia'", "'escreva'", "'enquanto'", "'faca'", "'('", 
			"')'", "'.'", null, "':='", null, null, "','", null, "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"AP", "FP", "PF", "OP", "ATTR", "TEXT", "ID", "VIR", "OPREL", "ACH", 
			"FCH", "NUMBER", "WS"
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

	    private int _tipoTermo;

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

	    public void verificaVariavelSemValor(String id){
	        IsiVariable variable = (IsiVariable) symbolTable.get(id);

	        if (variable.getValue() == null){
	            System.out.println("WARNING - A variável " + id + " não possui valor definido.");
	            throw new IsiSemanticException("");
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
		"\u0004\u0000\u0018\u00b9\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
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
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0005\u0010\u008a\b\u0010\n\u0010\f\u0010\u008d\t\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0005\u0011\u0093\b\u0011\n"+
		"\u0011\f\u0011\u0096\t\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0003\u0013\u00a3\b\u0013\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0016\u0004\u0016\u00aa\b\u0016\u000b\u0016\f"+
		"\u0016\u00ab\u0001\u0016\u0001\u0016\u0004\u0016\u00b0\b\u0016\u000b\u0016"+
		"\f\u0016\u00b1\u0003\u0016\u00b4\b\u0016\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0000\u0000\u0018\u0001\u0001\u0003\u0002\u0005\u0003"+
		"\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015"+
		"\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012"+
		"%\u0013\'\u0014)\u0015+\u0016-\u0017/\u0018\u0001\u0000\u0007\u0003\u0000"+
		"*+--//\u0006\u0000\t\t !--09AZaz\u0001\u0000az\u0003\u000009AZaz\u0002"+
		"\u0000<<>>\u0001\u000009\u0003\u0000\t\n\r\r  \u00c1\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001"+
		"\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000"+
		"\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"+
		"\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000"+
		"\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000"+
		"\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000"+
		"\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000"+
		"\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000"+
		"\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'"+
		"\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000"+
		"\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000"+
		"\u00011\u0001\u0000\u0000\u0000\u0003:\u0001\u0000\u0000\u0000\u0005C"+
		"\u0001\u0000\u0000\u0000\u0007K\u0001\u0000\u0000\u0000\tR\u0001\u0000"+
		"\u0000\u0000\u000bX\u0001\u0000\u0000\u0000\r[\u0001\u0000\u0000\u0000"+
		"\u000fa\u0001\u0000\u0000\u0000\u0011f\u0001\u0000\u0000\u0000\u0013n"+
		"\u0001\u0000\u0000\u0000\u0015w\u0001\u0000\u0000\u0000\u0017|\u0001\u0000"+
		"\u0000\u0000\u0019~\u0001\u0000\u0000\u0000\u001b\u0080\u0001\u0000\u0000"+
		"\u0000\u001d\u0082\u0001\u0000\u0000\u0000\u001f\u0084\u0001\u0000\u0000"+
		"\u0000!\u0087\u0001\u0000\u0000\u0000#\u0090\u0001\u0000\u0000\u0000%"+
		"\u0097\u0001\u0000\u0000\u0000\'\u00a2\u0001\u0000\u0000\u0000)\u00a4"+
		"\u0001\u0000\u0000\u0000+\u00a6\u0001\u0000\u0000\u0000-\u00a9\u0001\u0000"+
		"\u0000\u0000/\u00b5\u0001\u0000\u0000\u000012\u0005p\u0000\u000023\u0005"+
		"r\u0000\u000034\u0005o\u0000\u000045\u0005g\u0000\u000056\u0005r\u0000"+
		"\u000067\u0005a\u0000\u000078\u0005m\u0000\u000089\u0005a\u0000\u0000"+
		"9\u0002\u0001\u0000\u0000\u0000:;\u0005f\u0000\u0000;<\u0005i\u0000\u0000"+
		"<=\u0005m\u0000\u0000=>\u0005p\u0000\u0000>?\u0005r\u0000\u0000?@\u0005"+
		"o\u0000\u0000@A\u0005g\u0000\u0000AB\u0005.\u0000\u0000B\u0004\u0001\u0000"+
		"\u0000\u0000CD\u0005d\u0000\u0000DE\u0005e\u0000\u0000EF\u0005c\u0000"+
		"\u0000FG\u0005l\u0000\u0000GH\u0005a\u0000\u0000HI\u0005r\u0000\u0000"+
		"IJ\u0005e\u0000\u0000J\u0006\u0001\u0000\u0000\u0000KL\u0005n\u0000\u0000"+
		"LM\u0005u\u0000\u0000MN\u0005m\u0000\u0000NO\u0005e\u0000\u0000OP\u0005"+
		"r\u0000\u0000PQ\u0005o\u0000\u0000Q\b\u0001\u0000\u0000\u0000RS\u0005"+
		"t\u0000\u0000ST\u0005e\u0000\u0000TU\u0005x\u0000\u0000UV\u0005t\u0000"+
		"\u0000VW\u0005o\u0000\u0000W\n\u0001\u0000\u0000\u0000XY\u0005s\u0000"+
		"\u0000YZ\u0005e\u0000\u0000Z\f\u0001\u0000\u0000\u0000[\\\u0005s\u0000"+
		"\u0000\\]\u0005e\u0000\u0000]^\u0005n\u0000\u0000^_\u0005a\u0000\u0000"+
		"_`\u0005o\u0000\u0000`\u000e\u0001\u0000\u0000\u0000ab\u0005l\u0000\u0000"+
		"bc\u0005e\u0000\u0000cd\u0005i\u0000\u0000de\u0005a\u0000\u0000e\u0010"+
		"\u0001\u0000\u0000\u0000fg\u0005e\u0000\u0000gh\u0005s\u0000\u0000hi\u0005"+
		"c\u0000\u0000ij\u0005r\u0000\u0000jk\u0005e\u0000\u0000kl\u0005v\u0000"+
		"\u0000lm\u0005a\u0000\u0000m\u0012\u0001\u0000\u0000\u0000no\u0005e\u0000"+
		"\u0000op\u0005n\u0000\u0000pq\u0005q\u0000\u0000qr\u0005u\u0000\u0000"+
		"rs\u0005a\u0000\u0000st\u0005n\u0000\u0000tu\u0005t\u0000\u0000uv\u0005"+
		"o\u0000\u0000v\u0014\u0001\u0000\u0000\u0000wx\u0005f\u0000\u0000xy\u0005"+
		"a\u0000\u0000yz\u0005c\u0000\u0000z{\u0005a\u0000\u0000{\u0016\u0001\u0000"+
		"\u0000\u0000|}\u0005(\u0000\u0000}\u0018\u0001\u0000\u0000\u0000~\u007f"+
		"\u0005)\u0000\u0000\u007f\u001a\u0001\u0000\u0000\u0000\u0080\u0081\u0005"+
		".\u0000\u0000\u0081\u001c\u0001\u0000\u0000\u0000\u0082\u0083\u0007\u0000"+
		"\u0000\u0000\u0083\u001e\u0001\u0000\u0000\u0000\u0084\u0085\u0005:\u0000"+
		"\u0000\u0085\u0086\u0005=\u0000\u0000\u0086 \u0001\u0000\u0000\u0000\u0087"+
		"\u008b\u0005\"\u0000\u0000\u0088\u008a\u0007\u0001\u0000\u0000\u0089\u0088"+
		"\u0001\u0000\u0000\u0000\u008a\u008d\u0001\u0000\u0000\u0000\u008b\u0089"+
		"\u0001\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u008e"+
		"\u0001\u0000\u0000\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008e\u008f"+
		"\u0005\"\u0000\u0000\u008f\"\u0001\u0000\u0000\u0000\u0090\u0094\u0007"+
		"\u0002\u0000\u0000\u0091\u0093\u0007\u0003\u0000\u0000\u0092\u0091\u0001"+
		"\u0000\u0000\u0000\u0093\u0096\u0001\u0000\u0000\u0000\u0094\u0092\u0001"+
		"\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000\u0000\u0095$\u0001\u0000"+
		"\u0000\u0000\u0096\u0094\u0001\u0000\u0000\u0000\u0097\u0098\u0005,\u0000"+
		"\u0000\u0098&\u0001\u0000\u0000\u0000\u0099\u00a3\u0007\u0004\u0000\u0000"+
		"\u009a\u009b\u0005>\u0000\u0000\u009b\u00a3\u0005=\u0000\u0000\u009c\u009d"+
		"\u0005<\u0000\u0000\u009d\u00a3\u0005=\u0000\u0000\u009e\u009f\u0005="+
		"\u0000\u0000\u009f\u00a3\u0005=\u0000\u0000\u00a0\u00a1\u0005!\u0000\u0000"+
		"\u00a1\u00a3\u0005=\u0000\u0000\u00a2\u0099\u0001\u0000\u0000\u0000\u00a2"+
		"\u009a\u0001\u0000\u0000\u0000\u00a2\u009c\u0001\u0000\u0000\u0000\u00a2"+
		"\u009e\u0001\u0000\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000\u00a3"+
		"(\u0001\u0000\u0000\u0000\u00a4\u00a5\u0005{\u0000\u0000\u00a5*\u0001"+
		"\u0000\u0000\u0000\u00a6\u00a7\u0005}\u0000\u0000\u00a7,\u0001\u0000\u0000"+
		"\u0000\u00a8\u00aa\u0007\u0005\u0000\u0000\u00a9\u00a8\u0001\u0000\u0000"+
		"\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000"+
		"\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000\u00ac\u00b3\u0001\u0000\u0000"+
		"\u0000\u00ad\u00af\u0005.\u0000\u0000\u00ae\u00b0\u0007\u0005\u0000\u0000"+
		"\u00af\u00ae\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000"+
		"\u00b1\u00af\u0001\u0000\u0000\u0000\u00b1\u00b2\u0001\u0000\u0000\u0000"+
		"\u00b2\u00b4\u0001\u0000\u0000\u0000\u00b3\u00ad\u0001\u0000\u0000\u0000"+
		"\u00b3\u00b4\u0001\u0000\u0000\u0000\u00b4.\u0001\u0000\u0000\u0000\u00b5"+
		"\u00b6\u0007\u0006\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7"+
		"\u00b8\u0006\u0017\u0000\u0000\u00b80\u0001\u0000\u0000\u0000\t\u0000"+
		"\u0089\u008b\u0092\u0094\u00a2\u00ab\u00b1\u00b3\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}