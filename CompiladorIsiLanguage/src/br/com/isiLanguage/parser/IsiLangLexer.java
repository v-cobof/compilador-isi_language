// Generated from IsiLang.g4 by ANTLR 4.13.0
package br.com.isiLanguage.parser;
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
		T__0=1, T__1=2, T__2=3, T__3=4, AP=5, FP=6, SC=7, OP=8, ATTR=9, ID=10, 
		NUMBER=11, WS=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "AP", "FP", "SC", "OP", "ATTR", "ID", 
			"NUMBER", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog;'", "'leia'", "'escreva'", "'('", "')'", 
			"';'", null, "':='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "AP", "FP", "SC", "OP", "ATTR", "ID", "NUMBER", 
			"WS"
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
		"\u0004\u0000\f[\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0005\tF\b\t\n\t\f\tI\t\t\u0001\n\u0004\nL\b\n\u000b"+
		"\n\f\nM\u0001\n\u0001\n\u0004\nR\b\n\u000b\n\f\nS\u0003\nV\b\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0000\u0000\f\u0001\u0001\u0003\u0002"+
		"\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013"+
		"\n\u0015\u000b\u0017\f\u0001\u0000\u0005\u0003\u0000*+--//\u0001\u0000"+
		"az\u0003\u000009AZaz\u0001\u000009\u0003\u0000\t\n\r\r  ^\u0000\u0001"+
		"\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005"+
		"\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001"+
		"\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000"+
		"\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000"+
		"\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000"+
		"\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0001\u0019\u0001\u0000"+
		"\u0000\u0000\u0003\"\u0001\u0000\u0000\u0000\u0005+\u0001\u0000\u0000"+
		"\u0000\u00070\u0001\u0000\u0000\u0000\t8\u0001\u0000\u0000\u0000\u000b"+
		":\u0001\u0000\u0000\u0000\r<\u0001\u0000\u0000\u0000\u000f>\u0001\u0000"+
		"\u0000\u0000\u0011@\u0001\u0000\u0000\u0000\u0013C\u0001\u0000\u0000\u0000"+
		"\u0015K\u0001\u0000\u0000\u0000\u0017W\u0001\u0000\u0000\u0000\u0019\u001a"+
		"\u0005p\u0000\u0000\u001a\u001b\u0005r\u0000\u0000\u001b\u001c\u0005o"+
		"\u0000\u0000\u001c\u001d\u0005g\u0000\u0000\u001d\u001e\u0005r\u0000\u0000"+
		"\u001e\u001f\u0005a\u0000\u0000\u001f \u0005m\u0000\u0000 !\u0005a\u0000"+
		"\u0000!\u0002\u0001\u0000\u0000\u0000\"#\u0005f\u0000\u0000#$\u0005i\u0000"+
		"\u0000$%\u0005m\u0000\u0000%&\u0005p\u0000\u0000&\'\u0005r\u0000\u0000"+
		"\'(\u0005o\u0000\u0000()\u0005g\u0000\u0000)*\u0005;\u0000\u0000*\u0004"+
		"\u0001\u0000\u0000\u0000+,\u0005l\u0000\u0000,-\u0005e\u0000\u0000-.\u0005"+
		"i\u0000\u0000./\u0005a\u0000\u0000/\u0006\u0001\u0000\u0000\u000001\u0005"+
		"e\u0000\u000012\u0005s\u0000\u000023\u0005c\u0000\u000034\u0005r\u0000"+
		"\u000045\u0005e\u0000\u000056\u0005v\u0000\u000067\u0005a\u0000\u0000"+
		"7\b\u0001\u0000\u0000\u000089\u0005(\u0000\u00009\n\u0001\u0000\u0000"+
		"\u0000:;\u0005)\u0000\u0000;\f\u0001\u0000\u0000\u0000<=\u0005;\u0000"+
		"\u0000=\u000e\u0001\u0000\u0000\u0000>?\u0007\u0000\u0000\u0000?\u0010"+
		"\u0001\u0000\u0000\u0000@A\u0005:\u0000\u0000AB\u0005=\u0000\u0000B\u0012"+
		"\u0001\u0000\u0000\u0000CG\u0007\u0001\u0000\u0000DF\u0007\u0002\u0000"+
		"\u0000ED\u0001\u0000\u0000\u0000FI\u0001\u0000\u0000\u0000GE\u0001\u0000"+
		"\u0000\u0000GH\u0001\u0000\u0000\u0000H\u0014\u0001\u0000\u0000\u0000"+
		"IG\u0001\u0000\u0000\u0000JL\u0007\u0003\u0000\u0000KJ\u0001\u0000\u0000"+
		"\u0000LM\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000MN\u0001\u0000"+
		"\u0000\u0000NU\u0001\u0000\u0000\u0000OQ\u0005.\u0000\u0000PR\u0007\u0003"+
		"\u0000\u0000QP\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000SQ\u0001"+
		"\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000TV\u0001\u0000\u0000\u0000"+
		"UO\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000V\u0016\u0001\u0000"+
		"\u0000\u0000WX\u0007\u0004\u0000\u0000XY\u0001\u0000\u0000\u0000YZ\u0006"+
		"\u000b\u0000\u0000Z\u0018\u0001\u0000\u0000\u0000\u0006\u0000EGMSU\u0001"+
		"\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}