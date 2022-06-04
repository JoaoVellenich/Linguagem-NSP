package nsp.compiler;

import java.util.List;
import nsp.compiler.AnLex.Token;

public class Compiler {
    
    private String[] filePath;
    private String codFont;

    private Compile compile;

    public Compiler(String[] param){
        this.filePath = param;
        this.compile = new Compile();
    }

    public void run(){
        System.out.println("Compiling NSP:");
        try {
            //Leitura do Arquivo
            File file = new File(filePath[0]);
            this.codFont = file.getCodFont();

            //Lexico
            List<Token> tokens = this.compile.lexico(this.codFont);
            System.out.println("Done");

            //Sintatico
            this.compile.sintatico(tokens);
        } catch (RuntimeException e) {
            System.out.println("Error");
            System.exit(1);
        }
    }
}
