package br.com.isiLanguage.ast;

import br.com.isiLanguage.dataStructures.IsiSymbol;
import br.com.isiLanguage.dataStructures.IsiVariable;
import br.com.isiLanguage.exceptions.IsiSemanticException;

public class CommandAtribuicao extends AbstractCommand {
    private String id;
    private String expr;


    public CommandAtribuicao(String id, String expr) {
        this.id = id;
        this.expr = expr;
    }


    @Override
    public String generateJavaCode() {
        // TODO Auto-generated method stub
        return id + " = "+expr+";";
    }
    @Override
    public String toString() {
        return "CommandAtribuicao [id=" + id + ", expr=" + expr + "]";
    }
}
