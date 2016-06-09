package exercicios0806;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Hedo
 */
public class MeuWriterUtils {
    
    public static void main(String[] args) {
        MeuWriterUtils mw = new MeuWriterUtils();
        Scanner teclado = new Scanner(System.in);
        String nome = teclado.nextLine();
        mw.writeLines(nome);
    }
    
    public void writeLines(String fileName){
        if(!new File(fileName).exists())
            System.err.println("O arquivo não existe.");
        else if(!fileName.matches("^.*\\.(txt|TXT)$"))
            System.err.println("Arquivo inválido. Somente podem ser lidos arquivos .txt");
        else {
            try {
                final Writer writer = new FileWriter(fileName);
                final BufferedWriter bufferedWriter = new BufferedWriter(writer);
                ArrayList<String> linhas = new ArrayList<String>();
            
                System.out.println("Digite seu texto. Quando quiser terminar, digite '/quit'.");
            
                boolean keepGoing = true;
                Scanner teclado = new Scanner(System.in);
            
                while(keepGoing = true){
                    String nextLine = teclado.nextLine();
                    if(nextLine.equals("/quit")) {
                        keepGoing = false;
                        System.out.println("Terminado com sucesso.");
                        break;
                    }
                    else
                        linhas.add(nextLine);
                }
            
                for(int i = 0; i < linhas.size(); i++){
                    bufferedWriter.newLine();
                    bufferedWriter.write(linhas.get(i));
                    bufferedWriter.flush();
                }
            
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
