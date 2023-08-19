package br.com.isiLanguage.dataStructures;

public class IsiVariable extends IsiSymbol {

    public static final int NUMBER=0;
    public static final int TEXT = 1;

    private int type;
    private String value;

    public IsiVariable(String name, int type, String value) {
        super(name);
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString(){
        return "Variavel: " + name + ", tipo = " + this.type + ", valor = " + this.value ;
    }
}
