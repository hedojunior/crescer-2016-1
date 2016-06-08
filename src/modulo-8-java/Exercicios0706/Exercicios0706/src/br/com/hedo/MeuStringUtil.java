package br.com.hedo;

import java.text.Normalizer;
import java.util.Scanner;

/**
 *
 * @author Hedo
 */
public class MeuStringUtil {

    public static void main(String[] args) {
        try (final Scanner keyboard = new Scanner(System.in)) {
            System.out.println("Digite uma palavra:");
            String word = keyboard.nextLine();
            System.out.println("Escolha uma opção: "
                    + "\n 1-Verificar se a string é vazia;"
                    + "\n 2-Contar vogais da string;"
                    + "\n 3-Inverter string;"
                    + "\n 4-Verificar se é palíndromo.");
            int entry = keyboard.nextInt();

            switch (entry) {
                case 1:
                    System.out.println(checkIfEmpty(word));
                    break;
                case 2:
                    System.out.println(vocalCounter(word));
                    break;
                case 3:
                    System.out.println(wordInverter(word));
                    break;
                case 4:
                    System.out.println(palindromeDetector(word));
                    break;
                default:
                    System.out.println("Valor inválido.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean checkIfEmpty(String str) {
        return str.trim().length() > 0 ? false : true;
    }

    public static int vocalCounter(String str) {
        int counter = 0;

        if (checkIfEmpty(str)) {
            return 0;
        }

        for (char ch : str.toLowerCase().toCharArray()) {

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                counter++;
            }
        }
        return counter;
    }

    public static String wordInverter(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static boolean palindromeDetector(String str) {
        str = Normalizer.normalize(str, Normalizer.Form.NFD)
        .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        
        str = str.replaceAll(" ", "");
        System.out.println(str);
        String reverseStr = wordInverter(str);
        
        return str.equalsIgnoreCase(reverseStr) ? true : false;
    }
}
