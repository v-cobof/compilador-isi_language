package br.com.isiLanguage.main;

import br.com.isiLanguage.exceptions.IsiSemanticException;
import br.com.isiLanguage.parser.IsiLangLexer;
import br.com.isiLanguage.parser.IsiLangParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

// rodar o antlr
// java -cp "C:\Users\victor.figueiro_fina\Desktop\fac\compiladores\compilador-isi_language\CompiladorIsiLanguage\antlr-4.13.0-complete.jar" org.antlr.v4.Tool IsiLang.g4 -package br.com.isiLanguage.parser -o ./src/br/com/isiLanguage/parser

/* esta é a classe que é responsável por criar a interação com o usuário
 * instanciando nosso parser e apontando para o arquivo fonte
 *
 * Arquivo fonte: extensao .isi
 *
 */
public class MainClass {
    public static void main(String[] args) {
        try {
            IsiLangLexer lexer;
            IsiLangParser parser;

            // leio o arquivo "input.isi" e isso é entrada para o Analisador Lexico
            lexer = new IsiLangLexer(CharStreams.fromFileName("C:\\Users\\victor.figueiro_fina\\Desktop\\fac\\compiladores\\compilador-isi_language\\CompiladorIsiLanguage\\repeticao.isi"));

            // crio um "fluxo de tokens" para passar para o PARSER
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);

            // crio meu parser a partir desse tokenStream
            parser = new IsiLangParser(tokenStream);

            parser.prog();

            System.out.println("Compilação bem sucedida");

            parser.exibeComandos();

            parser.generateCode();

        }
        catch(IsiSemanticException ex){
            System.err.println("Semantic error - " + ex.getMessage());
        }
        catch(Exception ex) {
            ex.printStackTrace();
            System.err.println("ERROR " + ex.getMessage());
        }
    }
}