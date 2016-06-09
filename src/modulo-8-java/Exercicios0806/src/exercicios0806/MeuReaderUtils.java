package exercicios0806;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.Scanner;
import java.io.File;

/**
 *
 * @author Hedo
 */
public class MeuReaderUtils {
    
    public static void main(String[] args) {
        MeuReaderUtils mr = new MeuReaderUtils();
        Scanner teclado = new Scanner(System.in);
        String nome = teclado.nextLine();
        mr.fileReader(nome);
    }
    
    public void fileReader(String fileName){
        if(!new File(fileName).exists())
            System.err.println("O arquivo não existe.");
        else if(!fileName.matches("^.*\\.(txt|TXT)$"))
            System.err.println("Arquivo inválido. Somente podem ser lidos arquivos .txt");
        else {
            try {
                final Reader reader = new FileReader(fileName);
                final BufferedReader bufferedReader = new BufferedReader(reader);
                while(bufferedReader.readLine() != null){
                    System.out.println(bufferedReader.readLine());
                }
            }
            catch(Exception e){
            e.printStackTrace();
            }
        }
    }
}
