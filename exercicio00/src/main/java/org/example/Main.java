package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // aqui sa porra eh um objeto (na vdd é classe(é obj sim porra))
        String penis = "cu";
        Integer aaaa = 10;
        Float bbbb = 10.0f;

        // tipos primitivos
        boolean ehounaoeh = true;
        int numerinho = 10;
        float cu = 10.0f;

        String penisgrande = penis.toUpperCase();

        //scannerzada

        String[] cores = new String[4];
        cores[0] = "azul";
        cores[1] = "verde";
        cores[2] = "amarelo";
        cores[3] = "vermelho";
//        cores[4] = "outra cor";

        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("digita o primeiro nome ae: ");
            String nome = scanner.nextLine();

            if (nome.isEmpty()) {
                return;
            };

            System.out.println("digita o sobrenome ae agr: ");
            String sobrenome = scanner.nextLine();
            if (sobrenome.isEmpty()) return;

            System.out.println("Seu nome inteiro é: " + nome + " " + sobrenome);

            Random random = new Random();
            Integer randomNumero = random.nextInt(10, 100);
            Integer randomIndice = random.nextInt(cores.length);

            String cor = cores[randomIndice];

            System.out.println("agora o nome só q com um numero do lado: " + nome + " " + sobrenome + " " + randomNumero + " " + cor);
        }
    }
}