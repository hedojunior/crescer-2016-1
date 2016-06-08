package br.com.hedo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author Hedo
 */
public class Parcelator {
    
    public static void main(String[] args) {
        try(final Scanner keyboard = new Scanner(System.in)){
            System.out.println("Digite o montante:");
            double value = keyboard.nextDouble();
            System.out.println("Digite a taxa de juros:");
            double tax = keyboard.nextDouble();
            System.out.println("Digite a quantidade de parcelas desejada:");
            int nthMonths = keyboard.nextInt();
            
            System.out.println("Digite a data do primeiro pagamento:");
            String payDay = keyboard.next();
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.forLanguageTag("pt-BR"));
            Date data = new Date(format.parse(payDay).getTime());
            
            HashMap<Date,Double> parcelas = parcelator(value,tax,nthMonths,data);
            Map<Date,Double> treeMap = new TreeMap<Date,Double>(parcelas);
            int i = 0;
            for (Date dataPgto: treeMap.keySet()){
                String key =format.format(dataPgto);
                Double valor = treeMap.get(dataPgto);  
                System.out.println(i + " " + key + " " + valor);
                i++;
            } 
            
        }catch(Exception e){
            e.printStackTrace();
        }   
        
    }
    
    public static HashMap<Date,Double> parcelator(double value, double tax, int nthMonths, Date payDay) {
        double taxedValue = value * (1 + (tax * nthMonths));
        double parcelValue = taxedValue / nthMonths;
        
        HashMap<Date,Double> allPayments = new HashMap();
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(payDay);
        
        for(int i = 0; i < nthMonths; i++){
            allPayments.put(cal.getTime(),parcelValue);
            cal.add(Calendar.MONTH, 1);
        }
        
        return allPayments;
    }
 
}
