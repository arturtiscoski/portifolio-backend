package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Barco> barcos = new ArrayList<>();

        //Barco 1
        Barco barco1 = new Barco();
        barco1.nome = "Barco 1";
        barco1.tamanho = 2;
        barcos.add(barco1);

        //Barco 2
        Barco barco2 = new Barco();
        barco2.nome = "Barco 2";
        barco2.tamanho = 5;
        barcos.add(barco2);

        //Barco 3
        Barco barco3 = new Barco();
        barco3.nome = "Barco 3";
        barco3.tamanho = 7;
        barcos.add(barco3);

        //Barco 4
        Barco barco4 = new Barco();
        barco4.nome = "Barco 4";
        barco4.tamanho = 12;
        barcos.add(barco4);

        //Barco 5
        Barco barco5 = new Barco();
        barco5.nome = "Barco 5";
        barco5.tamanho = 20;
        barcos.add(barco5);

        PortoPequeno portoPequeno = new PortoPequeno();
        portoPequeno.nome = "Porto pequeno";
        PortoGrande portoGrande = new PortoGrande();
        portoGrande.nome = "Porto grande";

        for (Barco barco : barcos) {
            portoPequeno.atracarBarco(barco);
            //Ve se tem algum barco atracado no porto pequeno
            if (!portoPequeno.barcosAtracados.contains(barco)) {
                portoGrande.atracarBarco(barco);
            }
        }
    }
}