package br.com.hedo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Hedo
 */
public class MeuCalendarioUtil {
    public static void main(String[] args) {
        try(final Scanner keyboard = new Scanner(System.in)){
        System.out.println("Você deseja: "
                + "\n 1- Descobrir o nome do dia da semana de uma data; "
                + "\n 2- Descobrir a diferença entre uma data e agora.");
        int option = keyboard.nextInt();
            System.out.println("Digite uma data:");
            String data = keyboard.next();
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.forLanguageTag("pt-BR"));
            Date dataEmDate = new Date(format.parse(data).getTime());
            switch (option) {
            case 1:
                System.out.println(dayOfBirth(dataEmDate));
            break;
            case 2:
                System.out.println(timeUntilNow(dataEmDate));
            break;
            default:
                System.out.println("Valor inválido.");
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static String dayOfBirth(Date birthDate){
        Calendar cal = Calendar.getInstance();
        cal.setTime(birthDate);
        return cal.getDisplayName
        (Calendar.DAY_OF_WEEK,Calendar.LONG, Locale.forLanguageTag("pt-BR"));
    }
    
    public static String timeUntilNow(Date thenDate){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        long diff = cal.getTime().getTime() - thenDate.getTime();
        Date dataFinal = new Date(diff);
        SimpleDateFormat format = new SimpleDateFormat("yy MM dd HH:mm:ss");
        return format.format(dataFinal);
    }
}
