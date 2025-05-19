package myRealProject;

import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static final String[] MOEDAS_DISPONIVEIS = {"USD", "EUR", "GBP", "JPY", "AUD", "BRL"};

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Conversor de Moedas");
        System.out.println("Moedas disponíveis: USD, EUR, GBP, JPY, AUD, BRL");

        System.out.print("Digite a moeda de origem (ex: USD): ");
        String moedaOrigem = scanner.nextLine().toUpperCase();

        System.out.print("Digite a moeda de destino (ex: BRL): ");
        String moedaDestino = scanner.nextLine().toUpperCase();

        System.out.print("Digite o valor a ser convertido: ");
        double valor = scanner.nextDouble();

        if (!isValid(moedaOrigem) || !isValid(moedaDestino)) {
            System.out.println("Moeda inválida");
        }

        double resultado = Conversor.converte(moedaOrigem, moedaDestino, valor);
        if (resultado >= 0) {
            System.out.printf("%.2f %s => %.2f %s%n", valor, moedaOrigem, resultado, moedaDestino );
        } else {
          System.out.println("Falha na Conversão.");
        }
    }

    public static boolean isValid(String moeda){
        for (String m : MOEDAS_DISPONIVEIS) {
            if (m.equalsIgnoreCase(moeda)) {
                return true;
            }
        }
        return false;
    }

}