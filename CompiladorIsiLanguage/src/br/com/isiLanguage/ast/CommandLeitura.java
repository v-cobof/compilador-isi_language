package br.com.isiLanguage.ast;

import br.com.isiLanguage.dataStructures.IsiVariable;

public class CommandLeitura extends AbstractCommand {

    private String id;
    private IsiVariable var;

    public CommandLeitura(String id, IsiVariable var){
        this.id = id;
        this.var = var;
    }

    @Override
    public String generateJavaCode() {
        return id +"= _key." + (var.getType()==IsiVariable.NUMBER? "nextDouble();": "nextLine();");
    }
}
