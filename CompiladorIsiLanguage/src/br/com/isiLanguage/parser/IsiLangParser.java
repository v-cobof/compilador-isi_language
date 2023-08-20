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

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class IsiLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, AP=12, FP=13, PF=14, OP=15, ATTR=16, TEXT=17, ID=18, 
		VIR=19, OPREL=20, ACH=21, FCH=22, NUMBER=23, WS=24;
	public static final int
		RULE_prog = 0, RULE_decl = 1, RULE_declaravar = 2, RULE_tipo = 3, RULE_bloco = 4, 
		RULE_cmd = 5, RULE_cmdselecao = 6, RULE_cmdleitura = 7, RULE_cmdescrita = 8, 
		RULE_cmdattrib = 9, RULE_cmdEnquanto = 10, RULE_cmdFacaEnquanto = 11, 
		RULE_expr = 12, RULE_termo = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "decl", "declaravar", "tipo", "bloco", "cmd", "cmdselecao", "cmdleitura", 
			"cmdescrita", "cmdattrib", "cmdEnquanto", "cmdFacaEnquanto", "expr", 
			"termo"
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

	@Override
	public String getGrammarFileName() { return "IsiLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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



	public IsiLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(T__0);
			setState(29);
			decl();
			setState(30);
			bloco();
			setState(31);
			match(T__1);

			            program.setVarTable(symbolTable);
			            program.setComandos(stack.pop());
			           
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclContext extends ParserRuleContext {
		public List<DeclaravarContext> declaravar() {
			return getRuleContexts(DeclaravarContext.class);
		}
		public DeclaravarContext declaravar(int i) {
			return getRuleContext(DeclaravarContext.class,i);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(34);
				declaravar();
				}
				}
				setState(37); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaravarContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public TerminalNode PF() { return getToken(IsiLangParser.PF, 0); }
		public List<TerminalNode> VIR() { return getTokens(IsiLangParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(IsiLangParser.VIR, i);
		}
		public DeclaravarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaravar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterDeclaravar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitDeclaravar(this);
		}
	}

	public final DeclaravarContext declaravar() throws RecognitionException {
		DeclaravarContext _localctx = new DeclaravarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaravar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(T__2);
			setState(40);
			tipo();
			setState(41);
			match(ID);
			 handleInsercaoSimboloNaTabela(_input.LT(-1).getText()); 
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(43);
				match(VIR);
				setState(44);
				match(ID);
				 handleInsercaoSimboloNaTabela(_input.LT(-1).getText()); 
				}
				}
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(51);
			match(PF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitTipo(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tipo);
		try {
			setState(57);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				match(T__3);
				 _tipo = IsiVariable.NUMBER;  
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				match(T__4);
				 _tipo = IsiVariable.TEXT;  
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlocoContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitBloco(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 curThread = new ArrayList<AbstractCommand>();
			              stack.push(curThread);
			            
			setState(61); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(60);
				cmd();
				}
				}
				setState(63); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 266048L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdContext extends ParserRuleContext {
		public CmdleituraContext cmdleitura() {
			return getRuleContext(CmdleituraContext.class,0);
		}
		public CmdescritaContext cmdescrita() {
			return getRuleContext(CmdescritaContext.class,0);
		}
		public CmdattribContext cmdattrib() {
			return getRuleContext(CmdattribContext.class,0);
		}
		public CmdselecaoContext cmdselecao() {
			return getRuleContext(CmdselecaoContext.class,0);
		}
		public CmdEnquantoContext cmdEnquanto() {
			return getRuleContext(CmdEnquantoContext.class,0);
		}
		public CmdFacaEnquantoContext cmdFacaEnquanto() {
			return getRuleContext(CmdFacaEnquantoContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmd(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmd);
		try {
			setState(77);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				cmdleitura();
				 System.out.println("Reconheci leitura"); 
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				cmdescrita();
				 System.out.println("Reconheci escrita"); 
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(71);
				cmdattrib();
				 System.out.println("Reconheci atribuição"); 
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 4);
				{
				setState(74);
				cmdselecao();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 5);
				{
				setState(75);
				cmdEnquanto();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 6);
				{
				setState(76);
				cmdFacaEnquanto();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdselecaoContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public TerminalNode OPREL() { return getToken(IsiLangParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public List<TerminalNode> ACH() { return getTokens(IsiLangParser.ACH); }
		public TerminalNode ACH(int i) {
			return getToken(IsiLangParser.ACH, i);
		}
		public List<TerminalNode> FCH() { return getTokens(IsiLangParser.FCH); }
		public TerminalNode FCH(int i) {
			return getToken(IsiLangParser.FCH, i);
		}
		public TerminalNode NUMBER() { return getToken(IsiLangParser.NUMBER, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdselecaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdselecao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdselecao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdselecao(this);
		}
	}

	public final CmdselecaoContext cmdselecao() throws RecognitionException {
		CmdselecaoContext _localctx = new CmdselecaoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdselecao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(T__5);
			setState(80);
			match(AP);
			setState(81);
			match(ID);
			 _exprDecision = _input.LT(-1).getText(); 
			setState(83);
			match(OPREL);
			 _exprDecision += _input.LT(-1).getText(); 
			setState(85);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			 _exprDecision += _input.LT(-1).getText(); 
			setState(87);
			match(FP);
			setState(88);
			match(ACH);

			                        curThread = new ArrayList<AbstractCommand>();
			                        stack.push(curThread);
			                     
			setState(91); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(90);
				cmd();
				}
				}
				setState(93); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 266048L) != 0) );
			setState(95);
			match(FCH);

			                        listaTrue = stack.pop();
			                     
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(97);
				match(T__6);
				setState(98);
				match(ACH);

				                        curThread = new ArrayList<AbstractCommand>();
				                        stack.push(curThread);
				                    
				{
				setState(101); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(100);
					cmd();
					}
					}
					setState(103); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 266048L) != 0) );
				}
				setState(105);
				match(FCH);

				                        listaFalse = stack.pop();
				                        CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
				                        stack.peek().add(cmd);
				                    
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdleituraContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode PF() { return getToken(IsiLangParser.PF, 0); }
		public CmdleituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdleitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdleitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdleitura(this);
		}
	}

	public final CmdleituraContext cmdleitura() throws RecognitionException {
		CmdleituraContext _localctx = new CmdleituraContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdleitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(T__7);
			setState(111);
			match(AP);
			setState(112);
			match(ID);
			 verificaId(_input.LT(-1).getText());
			                          _readId = _input.LT(-1).getText();
			                        
			setState(114);
			match(FP);
			setState(115);
			match(PF);

			                IsiVariable var = (IsiVariable) symbolTable.get(_readId);
			                CommandLeitura cmd = new CommandLeitura(_readId, var);
			                stack.peek().add(cmd);
			              
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdescritaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode PF() { return getToken(IsiLangParser.PF, 0); }
		public TerminalNode TEXT() { return getToken(IsiLangParser.TEXT, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public CmdescritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdescrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdescrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdescrita(this);
		}
	}

	public final CmdescritaContext cmdescrita() throws RecognitionException {
		CmdescritaContext _localctx = new CmdescritaContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdescrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(T__8);
			setState(119);
			match(AP);
			setState(125);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FP:
				{
				}
				break;
			case TEXT:
				{
				setState(121);
				match(TEXT);

				                            CommandEscritaComTexto cmd = new CommandEscritaComTexto(_input.LT(-1).getText());
				                            stack.peek().add(cmd);
				                        
				}
				break;
			case ID:
				{
				setState(123);
				match(ID);
				 verificaId(_input.LT(-1).getText());
				                             _writeId = _input.LT(-1).getText();

				                             CommandEscrita cmd = new CommandEscrita(_writeId);
				                             stack.peek().add(cmd);
				                        
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(127);
			match(FP);
			setState(128);
			match(PF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdattribContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode ATTR() { return getToken(IsiLangParser.ATTR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PF() { return getToken(IsiLangParser.PF, 0); }
		public CmdattribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdattrib; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdattrib(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdattrib(this);
		}
	}

	public final CmdattribContext cmdattrib() throws RecognitionException {
		CmdattribContext _localctx = new CmdattribContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdattrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(ID);
			 verificaId(_input.LT(-1).getText());
			                   _exprId = _input.LT(-1).getText();
			                 
			setState(132);
			match(ATTR);
			 _exprContent = ""; 
			setState(134);
			expr();
			setState(135);
			match(PF);

			                CommandAtribuicao cmd = new CommandAtribuicao(_exprId, _exprContent);
			                stack.peek().add(cmd);
			              
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdEnquantoContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public TerminalNode OPREL() { return getToken(IsiLangParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode ACH() { return getToken(IsiLangParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(IsiLangParser.FCH, 0); }
		public TerminalNode NUMBER() { return getToken(IsiLangParser.NUMBER, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdEnquantoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdEnquanto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdEnquanto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdEnquanto(this);
		}
	}

	public final CmdEnquantoContext cmdEnquanto() throws RecognitionException {
		CmdEnquantoContext _localctx = new CmdEnquantoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cmdEnquanto);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(T__9);
			setState(139);
			match(AP);
			setState(140);
			match(ID);
			 _exprDecision = _input.LT(-1).getText(); 
			setState(142);
			match(OPREL);
			 _exprDecision += _input.LT(-1).getText(); 
			setState(144);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			_exprDecision += _input.LT(-1).getText(); 
			setState(146);
			match(FP);
			setState(147);
			match(ACH);

			                   curThread = new ArrayList<AbstractCommand>();
			                   ArrayList<AbstractCommand> lista = new ArrayList<AbstractCommand>();
			                   stack.push(curThread);
			                 
			setState(150); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(149);
				cmd();
				}
				}
				setState(152); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 266048L) != 0) );
			setState(154);
			match(FCH);

			                   lista = stack.pop();
			                   CommandEnquanto cmd = new CommandEnquanto(_exprDecision, lista);
			                   stack.peek().add(cmd);
			                 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdFacaEnquantoContext extends ParserRuleContext {
		public TerminalNode ACH() { return getToken(IsiLangParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(IsiLangParser.FCH, 0); }
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public TerminalNode OPREL() { return getToken(IsiLangParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode PF() { return getToken(IsiLangParser.PF, 0); }
		public TerminalNode NUMBER() { return getToken(IsiLangParser.NUMBER, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdFacaEnquantoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdFacaEnquanto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdFacaEnquanto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdFacaEnquanto(this);
		}
	}

	public final CmdFacaEnquantoContext cmdFacaEnquanto() throws RecognitionException {
		CmdFacaEnquantoContext _localctx = new CmdFacaEnquantoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cmdFacaEnquanto);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(T__10);
			setState(158);
			match(ACH);

			                   curThread = new ArrayList<AbstractCommand>();
			                   ArrayList<AbstractCommand> lista = new ArrayList<AbstractCommand>();
			                   stack.push(curThread);
			                 
			setState(161); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(160);
				cmd();
				}
				}
				setState(163); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 266048L) != 0) );
			setState(165);
			match(FCH);
			setState(166);
			match(T__9);
			setState(167);
			match(AP);
			setState(168);
			match(ID);
			 _exprDecision = _input.LT(-1).getText(); 
			setState(170);
			match(OPREL);
			 _exprDecision += _input.LT(-1).getText(); 
			setState(172);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			_exprDecision += _input.LT(-1).getText(); 
			setState(174);
			match(FP);

			                   lista = stack.pop();
			                   CommandFacaEnquanto cmd = new CommandFacaEnquanto(_exprDecision, lista);
			                   stack.peek().add(cmd);
			                 
			setState(176);
			match(PF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public List<TerminalNode> OP() { return getTokens(IsiLangParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(IsiLangParser.OP, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			termo();
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(179);
				match(OP);
				 _exprContent += _input.LT(-1).getText(); 
				setState(181);
				termo();
				}
				}
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(IsiLangParser.NUMBER, 0); }
		public TerminalNode TEXT() { return getToken(IsiLangParser.TEXT, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_termo);
		try {
			setState(193);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(187);
				match(ID);
				  verificaId(_input.LT(-1).getText());
				                    _exprContent += _input.LT(-1).getText();
				                
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(189);
				match(NUMBER);


				                IsiVariable variable = (IsiVariable) symbolTable.get(_exprId);

				                if (variable.getType() != IsiVariable.NUMBER){
				                    throw new IsiSemanticException(_exprId + " não é um número");
				                }

				                _exprContent += _input.LT(-1).getText();
				            
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 3);
				{
				setState(191);
				match(TEXT);

				                IsiVariable variable = (IsiVariable) symbolTable.get(_exprId);

				                if (variable.getType() != IsiVariable.TEXT){
				                    throw new IsiSemanticException(_exprId + " não é um texto");
				                }

				                _exprContent += _input.LT(-1).getText();
				              
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0018\u00c4\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0004\u0001$\b\u0001\u000b"+
		"\u0001\f\u0001%\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0005\u0002/\b\u0002\n\u0002\f\u00022\t"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u0003:\b\u0003\u0001\u0004\u0001\u0004\u0004\u0004>\b\u0004"+
		"\u000b\u0004\f\u0004?\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005N\b\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0004\u0006\\\b\u0006"+
		"\u000b\u0006\f\u0006]\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0004\u0006f\b\u0006\u000b\u0006\f\u0006g\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0003\u0006m\b\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b"+
		"~\b\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0004\n\u0097\b\n\u000b"+
		"\n\f\n\u0098\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0004\u000b\u00a2\b\u000b\u000b\u000b\f\u000b\u00a3\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u00b7\b\f\n\f\f\f\u00ba"+
		"\t\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00c2\b\r"+
		"\u0001\r\u0000\u0000\u000e\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u0000\u0001\u0002\u0000\u0012\u0012\u0017\u0017"+
		"\u00c8\u0000\u001c\u0001\u0000\u0000\u0000\u0002#\u0001\u0000\u0000\u0000"+
		"\u0004\'\u0001\u0000\u0000\u0000\u00069\u0001\u0000\u0000\u0000\b;\u0001"+
		"\u0000\u0000\u0000\nM\u0001\u0000\u0000\u0000\fO\u0001\u0000\u0000\u0000"+
		"\u000en\u0001\u0000\u0000\u0000\u0010v\u0001\u0000\u0000\u0000\u0012\u0082"+
		"\u0001\u0000\u0000\u0000\u0014\u008a\u0001\u0000\u0000\u0000\u0016\u009d"+
		"\u0001\u0000\u0000\u0000\u0018\u00b2\u0001\u0000\u0000\u0000\u001a\u00c1"+
		"\u0001\u0000\u0000\u0000\u001c\u001d\u0005\u0001\u0000\u0000\u001d\u001e"+
		"\u0003\u0002\u0001\u0000\u001e\u001f\u0003\b\u0004\u0000\u001f \u0005"+
		"\u0002\u0000\u0000 !\u0006\u0000\uffff\uffff\u0000!\u0001\u0001\u0000"+
		"\u0000\u0000\"$\u0003\u0004\u0002\u0000#\"\u0001\u0000\u0000\u0000$%\u0001"+
		"\u0000\u0000\u0000%#\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000"+
		"&\u0003\u0001\u0000\u0000\u0000\'(\u0005\u0003\u0000\u0000()\u0003\u0006"+
		"\u0003\u0000)*\u0005\u0012\u0000\u0000*0\u0006\u0002\uffff\uffff\u0000"+
		"+,\u0005\u0013\u0000\u0000,-\u0005\u0012\u0000\u0000-/\u0006\u0002\uffff"+
		"\uffff\u0000.+\u0001\u0000\u0000\u0000/2\u0001\u0000\u0000\u00000.\u0001"+
		"\u0000\u0000\u000001\u0001\u0000\u0000\u000013\u0001\u0000\u0000\u0000"+
		"20\u0001\u0000\u0000\u000034\u0005\u000e\u0000\u00004\u0005\u0001\u0000"+
		"\u0000\u000056\u0005\u0004\u0000\u00006:\u0006\u0003\uffff\uffff\u0000"+
		"78\u0005\u0005\u0000\u00008:\u0006\u0003\uffff\uffff\u000095\u0001\u0000"+
		"\u0000\u000097\u0001\u0000\u0000\u0000:\u0007\u0001\u0000\u0000\u0000"+
		";=\u0006\u0004\uffff\uffff\u0000<>\u0003\n\u0005\u0000=<\u0001\u0000\u0000"+
		"\u0000>?\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000?@\u0001\u0000"+
		"\u0000\u0000@\t\u0001\u0000\u0000\u0000AB\u0003\u000e\u0007\u0000BC\u0006"+
		"\u0005\uffff\uffff\u0000CN\u0001\u0000\u0000\u0000DE\u0003\u0010\b\u0000"+
		"EF\u0006\u0005\uffff\uffff\u0000FN\u0001\u0000\u0000\u0000GH\u0003\u0012"+
		"\t\u0000HI\u0006\u0005\uffff\uffff\u0000IN\u0001\u0000\u0000\u0000JN\u0003"+
		"\f\u0006\u0000KN\u0003\u0014\n\u0000LN\u0003\u0016\u000b\u0000MA\u0001"+
		"\u0000\u0000\u0000MD\u0001\u0000\u0000\u0000MG\u0001\u0000\u0000\u0000"+
		"MJ\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000ML\u0001\u0000\u0000"+
		"\u0000N\u000b\u0001\u0000\u0000\u0000OP\u0005\u0006\u0000\u0000PQ\u0005"+
		"\f\u0000\u0000QR\u0005\u0012\u0000\u0000RS\u0006\u0006\uffff\uffff\u0000"+
		"ST\u0005\u0014\u0000\u0000TU\u0006\u0006\uffff\uffff\u0000UV\u0007\u0000"+
		"\u0000\u0000VW\u0006\u0006\uffff\uffff\u0000WX\u0005\r\u0000\u0000XY\u0005"+
		"\u0015\u0000\u0000Y[\u0006\u0006\uffff\uffff\u0000Z\\\u0003\n\u0005\u0000"+
		"[Z\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000][\u0001\u0000\u0000"+
		"\u0000]^\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_`\u0005\u0016"+
		"\u0000\u0000`l\u0006\u0006\uffff\uffff\u0000ab\u0005\u0007\u0000\u0000"+
		"bc\u0005\u0015\u0000\u0000ce\u0006\u0006\uffff\uffff\u0000df\u0003\n\u0005"+
		"\u0000ed\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000ge\u0001\u0000"+
		"\u0000\u0000gh\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ij\u0005"+
		"\u0016\u0000\u0000jk\u0006\u0006\uffff\uffff\u0000km\u0001\u0000\u0000"+
		"\u0000la\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000m\r\u0001\u0000"+
		"\u0000\u0000no\u0005\b\u0000\u0000op\u0005\f\u0000\u0000pq\u0005\u0012"+
		"\u0000\u0000qr\u0006\u0007\uffff\uffff\u0000rs\u0005\r\u0000\u0000st\u0005"+
		"\u000e\u0000\u0000tu\u0006\u0007\uffff\uffff\u0000u\u000f\u0001\u0000"+
		"\u0000\u0000vw\u0005\t\u0000\u0000w}\u0005\f\u0000\u0000x~\u0001\u0000"+
		"\u0000\u0000yz\u0005\u0011\u0000\u0000z~\u0006\b\uffff\uffff\u0000{|\u0005"+
		"\u0012\u0000\u0000|~\u0006\b\uffff\uffff\u0000}x\u0001\u0000\u0000\u0000"+
		"}y\u0001\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000~\u007f\u0001\u0000"+
		"\u0000\u0000\u007f\u0080\u0005\r\u0000\u0000\u0080\u0081\u0005\u000e\u0000"+
		"\u0000\u0081\u0011\u0001\u0000\u0000\u0000\u0082\u0083\u0005\u0012\u0000"+
		"\u0000\u0083\u0084\u0006\t\uffff\uffff\u0000\u0084\u0085\u0005\u0010\u0000"+
		"\u0000\u0085\u0086\u0006\t\uffff\uffff\u0000\u0086\u0087\u0003\u0018\f"+
		"\u0000\u0087\u0088\u0005\u000e\u0000\u0000\u0088\u0089\u0006\t\uffff\uffff"+
		"\u0000\u0089\u0013\u0001\u0000\u0000\u0000\u008a\u008b\u0005\n\u0000\u0000"+
		"\u008b\u008c\u0005\f\u0000\u0000\u008c\u008d\u0005\u0012\u0000\u0000\u008d"+
		"\u008e\u0006\n\uffff\uffff\u0000\u008e\u008f\u0005\u0014\u0000\u0000\u008f"+
		"\u0090\u0006\n\uffff\uffff\u0000\u0090\u0091\u0007\u0000\u0000\u0000\u0091"+
		"\u0092\u0006\n\uffff\uffff\u0000\u0092\u0093\u0005\r\u0000\u0000\u0093"+
		"\u0094\u0005\u0015\u0000\u0000\u0094\u0096\u0006\n\uffff\uffff\u0000\u0095"+
		"\u0097\u0003\n\u0005\u0000\u0096\u0095\u0001\u0000\u0000\u0000\u0097\u0098"+
		"\u0001\u0000\u0000\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0098\u0099"+
		"\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a\u009b"+
		"\u0005\u0016\u0000\u0000\u009b\u009c\u0006\n\uffff\uffff\u0000\u009c\u0015"+
		"\u0001\u0000\u0000\u0000\u009d\u009e\u0005\u000b\u0000\u0000\u009e\u009f"+
		"\u0005\u0015\u0000\u0000\u009f\u00a1\u0006\u000b\uffff\uffff\u0000\u00a0"+
		"\u00a2\u0003\n\u0005\u0000\u00a1\u00a0\u0001\u0000\u0000\u0000\u00a2\u00a3"+
		"\u0001\u0000\u0000\u0000\u00a3\u00a1\u0001\u0000\u0000\u0000\u00a3\u00a4"+
		"\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5\u00a6"+
		"\u0005\u0016\u0000\u0000\u00a6\u00a7\u0005\n\u0000\u0000\u00a7\u00a8\u0005"+
		"\f\u0000\u0000\u00a8\u00a9\u0005\u0012\u0000\u0000\u00a9\u00aa\u0006\u000b"+
		"\uffff\uffff\u0000\u00aa\u00ab\u0005\u0014\u0000\u0000\u00ab\u00ac\u0006"+
		"\u000b\uffff\uffff\u0000\u00ac\u00ad\u0007\u0000\u0000\u0000\u00ad\u00ae"+
		"\u0006\u000b\uffff\uffff\u0000\u00ae\u00af\u0005\r\u0000\u0000\u00af\u00b0"+
		"\u0006\u000b\uffff\uffff\u0000\u00b0\u00b1\u0005\u000e\u0000\u0000\u00b1"+
		"\u0017\u0001\u0000\u0000\u0000\u00b2\u00b8\u0003\u001a\r\u0000\u00b3\u00b4"+
		"\u0005\u000f\u0000\u0000\u00b4\u00b5\u0006\f\uffff\uffff\u0000\u00b5\u00b7"+
		"\u0003\u001a\r\u0000\u00b6\u00b3\u0001\u0000\u0000\u0000\u00b7\u00ba\u0001"+
		"\u0000\u0000\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b8\u00b9\u0001"+
		"\u0000\u0000\u0000\u00b9\u0019\u0001\u0000\u0000\u0000\u00ba\u00b8\u0001"+
		"\u0000\u0000\u0000\u00bb\u00bc\u0005\u0012\u0000\u0000\u00bc\u00c2\u0006"+
		"\r\uffff\uffff\u0000\u00bd\u00be\u0005\u0017\u0000\u0000\u00be\u00c2\u0006"+
		"\r\uffff\uffff\u0000\u00bf\u00c0\u0005\u0011\u0000\u0000\u00c0\u00c2\u0006"+
		"\r\uffff\uffff\u0000\u00c1\u00bb\u0001\u0000\u0000\u0000\u00c1\u00bd\u0001"+
		"\u0000\u0000\u0000\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c2\u001b\u0001"+
		"\u0000\u0000\u0000\r%09?M]gl}\u0098\u00a3\u00b8\u00c1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}