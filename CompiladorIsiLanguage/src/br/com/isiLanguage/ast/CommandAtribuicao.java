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

    private void validarNumero(String expr, IsiVariable variable) {

        if (expr.contains("+") ||
            expr.contains("-") ||
            expr.contains("*") ||
            expr.contains("/")) {


        }

        if (!isNumber(variable.getValue())){

        }
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

    private boolean isNumber(String valor){
        try{
            Double.parseDouble(valor);
            return true;
        }catch(Exception ex) {
            return false;
        }
    }

    private boolean isString(String valor){
        int count = 0;
        for (char c : valor.toCharArray()) {
            if (c == '"') {
                count++;
            }
        }
        return count == 2;
    }
}
