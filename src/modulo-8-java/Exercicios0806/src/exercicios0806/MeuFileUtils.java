package exercicios0806;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author hedo.junior
 */
public class MeuFileUtils {

    public static void main(String[] args) {
        MeuFileUtils mf = new MeuFileUtils();
        Scanner teclado = new Scanner(System.in);
        switch(args[0]){
            case "mk":
                System.out.println("Digite o nome do arquivo:");
                mf.createFileOrFolder(teclado.nextLine());
            break;
            case "rm":
                System.out.println("Digite o nome do arquivo:");
                mf.deleteFile(teclado.nextLine());
            break;
            case "ls":
                System.out.println("Digite o nome do arquivo:");
                mf.showAbsolutePath(teclado.nextLine());
            break;
            case "mv":
                System.out.println("Digite o nome atual do arquivo:");
                String atual = teclado.nextLine();
                System.out.println("Digite o novo path do arquivo:");
                String novo = teclado.nextLine();
                mf.moveFile(atual, novo);
            break;
            default:
                System.out.println("Valor inválido.");
        }
    }

    public void createFileOrFolder(String fileName){
        try {
            if(fileName.contains(".")){
                final boolean b = new File(fileName).createNewFile();
                System.out.println("Arquivo criado com sucesso.");
            }
            else {
                final boolean b = new File(fileName).mkdir();
                System.out.println("Diretório criado com sucesso.");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
        
    public void deleteFile(String fileName){
        try {
            final File file = new File(fileName);
            if(file.isDirectory()){
                System.out.println("Arquivo inválido para deleção, pois é um diretório.");
            }
            else {
                final boolean b = file.delete();
                System.out.println("Arquivo deletado com sucesso.");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void showAbsolutePath(String fileName){
        try {
            final File file = new File(fileName);
            if(file.isDirectory()){
                for(String i : file.list()){
                    System.out.println(i);
                }
            }
            else {
                System.out.println(file.getAbsolutePath());
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void moveFile(String fileName, String fileNewName){
        try {
            final File file = new File(fileName);
            if(file.isDirectory()) System.out.println("Arquivo inválido.");
            else {
            final File file2 = new File(fileNewName);
            file.renameTo(file2);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
