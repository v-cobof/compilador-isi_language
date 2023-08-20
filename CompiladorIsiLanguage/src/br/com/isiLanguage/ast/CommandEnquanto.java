package br.com.isiLanguage.ast;

import java.util.ArrayList;

public class CommandEnquanto extends AbstractCommand {

    private String condition;
    private ArrayList<AbstractCommand> lista;

    public CommandEnquanto(String condition, ArrayList<AbstractCommand> lista) {
        this.condition = condition;
        this.lista = lista;
    }

    @Override
    public String generateJavaCode() {
        StringBuilder builder = new StringBuilder();
        builder.append("\nwhile(").append(condition).append("){\n");
        for(AbstractCommand v: this.lista)
        {
            builder.append(v.generateJavaCode());
        }
        builder.append("\n}");
        return builder.toString();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(AbstractCommand v: lista)
        {
            builder.append(v);
        }
        return "Comando enquanto lido com sucesso.\n [enquanto ("+condition+" ){\n"+builder+"\n";
    }
}
