package br.com.hedo.aula1;
import java.util.Scanner;

public class Projeto {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite um número:");
        int num = teclado.nextInt();

        if (num % 2 == 0) {
            System.out.println("O número é par!");
        } else {
            System.out.println("O número é ímpar!");
        }
    }
}
