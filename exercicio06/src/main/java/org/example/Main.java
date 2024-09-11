package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();

        //Cria metodo pra não poluir a main
        cinema.inicializarFilmes();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Que filme você deseja assistir?");
                String nomeFilme = scanner.nextLine();

                //inicializa o filme no metodo encontrarFilme
                Filme filme = cinema.encontrarFilme(nomeFilme);

                System.out.println("Qual assento você deseja?");
                String assento = scanner.nextLine();

                System.out.println("Qual o seu nome?");
                String nomeCliente = scanner.nextLine();

                System.out.println("Qual a sua idade?");
                int idadeCliente = scanner.nextInt();
                scanner.nextLine(); // Consumir a linha restante

                Cliente cliente = new Cliente(nomeCliente, idadeCliente);
                cinema.venderIngresso(cliente, filme, assento);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("\nDeseja comprar outro ingresso? (s/n)");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("n")) {
                break;
            }
        }
    }
}
