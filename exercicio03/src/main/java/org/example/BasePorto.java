package org.example;

import java.util.ArrayList;
import java.util.List;

public class BasePorto {
    public String nome;
    public List<Barco> barcosAtracados;

    //aqui pesquisei na net pq tava dando erro de array vazio quando rodava o projeto
    public BasePorto() {
        this.barcosAtracados = new ArrayList<>();
    }

    public void atracarBarco(Barco barco) {
        barcosAtracados.add(barco);
        System.out.println("Barco " + barco.nome + " atracou no porto " + nome);
    }

    public void desatracarBarco(Barco barco) {
        barcosAtracados.remove(barco);
        System.out.println("Barco " + barco.nome + " desatracou do porto " + nome);
    }
}
