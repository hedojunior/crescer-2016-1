
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hedo.junior
 */
public class Run {

    public static BufferedReader getReader(String fila) throws FileNotFoundException {
        return new BufferedReader(new FileReader(fila));
    }

    public static BufferedWriter getWriter(String fila) throws IOException {
        return new BufferedWriter(new FileWriter(fila, true));
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite seu usuário:");
        String user = teclado.nextLine();
        System.out.println("Digite o path do arquivo:");
        final String path = teclado.nextLine();

        new Thread(new Runnable() {
            @Override
            public void run() {
                BufferedReader bufferReader = null;
                try {
                    bufferReader = Run.getReader(path);
                    while (true) {
                        String readLine = bufferReader.readLine();
                        if (readLine != null && !readLine.isEmpty()) {
                            System.out.println(readLine);
                        }
                        Thread.sleep(1000l);
                    }

                } catch(Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (bufferReader != null) {
                            bufferReader.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        while (true) {
            String nextLine = teclado.nextLine();
            if (":q!".equals(nextLine)) {
                break;
            }
            BufferedWriter bufferedWriter = null;
            try {
                bufferedWriter = Run.getWriter(path);
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.forLanguageTag("pt-BR"));
                String data = format.format(new Date());
                if(nextLine.equals("flood")) {
                    for (int i = 0; i <= 20; i ++) {
                        bufferedWriter.newLine();
                        bufferedWriter.write(data + " | " +  user + ": " + "trivial");
                        bufferedWriter.flush();
                    }
                }
                bufferedWriter.write(data + " | " +  user + ": " + nextLine);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                    }
            }

        }
    }
}
