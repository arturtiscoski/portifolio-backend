package org.example;

import java.util.List;

public class PortoPequeno extends BasePorto {
    @Override
    public void atracarBarco(Barco barco) {
        if (barco.tamanho <= 10) {
            super.atracarBarco(barco);
        } else {
            System.out.println("Barco " + barco.nome + " é muito grande para o porto pequeno " + nome);
        }
    }
}
