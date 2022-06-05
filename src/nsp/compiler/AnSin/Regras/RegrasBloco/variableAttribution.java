package nsp.compiler.AnSin.Regras.RegrasBloco;

import java.util.List;

import nsp.compiler.AnLex.Token;
import nsp.compiler.AnLex.Tokens_List;
import nsp.compiler.AnSin.Regras.Error;

public class variableAttribution {
    private List<Token> tokens;
    private int pos;

    public variableAttribution(List<Token> tokens){
        this.tokens = tokens;
    }

    public int run(int pos){
        this.pos = pos;
        match(Tokens_List.ATRIBUICAO);
        isValor();
        match(Tokens_List.EOI);
        return this.pos+1;
    }

    public void match(Tokens_List esperado){
        lookAhead();
        if (this.tokens.get(this.pos).tipo == esperado){
            //Não Faz Nada
            // System.out.printf("\t%s - %s\n",this.tokens.get(this.pos).tipo, esperado);
        }else{
            Error.errorToken(this.tokens.get(this.pos).tipo, esperado);
        }
    }

    private void lookAhead(){
        this.pos ++;
    }

    public void isValor(){
        lookAhead();
        switch (this.tokens.get(this.pos).tipo) {
            case INT_VALUE:
            case FLOAT_VALUE:
            case CHAR_VALUE:
            case BOOLEAN_VALUE:
            case STRING_VALUE:
                break;
        
            default:
                Error.errorTipo(this.tokens.get(this.pos).tipo);
                break;
        }
    }
}
