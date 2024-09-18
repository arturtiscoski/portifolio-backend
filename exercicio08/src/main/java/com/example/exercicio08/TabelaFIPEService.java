package com.example.exercicio08;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

@Service
public class TabelaFIPEService {

    private RestClient client = RestClient.create("https://parallelum.com.br/fipe/api/v1/");

    public String getCodigoMarca(String marca) {
        MarcaRequest[] marcas = client
                .get()
                .uri("carros/marcas")
                .retrieve()
                .body(MarcaRequest[].class);

        Optional<MarcaRequest> encontrada = Arrays.stream(marcas).filter(m -> m.getNome().equals(marca)).findFirst();

        return encontrada.map(MarcaRequest::getCodigo).orElse("Marca não encontrada");
    }

    public String getCodigoModelo(String marca, String modelo) {
        ModeloRequest modelos = client
                .get()
                .uri("carros/marcas/{marca}/modelos", marca)
                .retrieve()
                .body(ModeloRequest.class);

        Optional<DefaultRequest> encontrado = Arrays.stream(modelos.getModelos()).filter(m -> m.getNome().equals(modelo)).findFirst();

        return encontrado.map(DefaultRequest::getCodigo).orElse("Modelo não encontrado");
    }

    public String getCodigoAno(String marca, String modelo, String ano) {
        AnoRequest[] anos = client
                .get()
                .uri("carros/marcas/{marca}/modelos/{modelo}/anos", marca, modelo)
                .retrieve()
                .body(AnoRequest[].class);

        Optional<AnoRequest> encontrado = Arrays.stream(anos).filter(m -> m.getNome().equals(ano)).findFirst();

        return encontrado.map(AnoRequest::getCodigo).orElse("Ano não encontrado");
    }

    public Valor getValor(String marca, String modelo, String ano) {
        return client
                .get()
//                .uri("carros/marcas/{marca}/modelos/{modelo}/anos/{ano}", marca, modelo, ano)
                .uri("carros/marcas/21/modelos/437/anos/1987-1")
                .retrieve()
                .body(Valor.class);
    }
}