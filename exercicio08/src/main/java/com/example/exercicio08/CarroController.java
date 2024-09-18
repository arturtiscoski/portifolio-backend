package com.example.exercicio08;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarroController {
    @Autowired
    private TabelaFIPEService tabelaFIPEService;

    @PostMapping("/valor")
    @ResponseBody
    public Valor valores(@RequestBody ValorRequest valorRequest) {
        String codigoMarca = tabelaFIPEService.getCodigoMarca(valorRequest.getMarca());
        String codigoModelo = tabelaFIPEService.getCodigoModelo(codigoMarca, valorRequest.getModelo());
        String codigoAno = tabelaFIPEService.getCodigoAno(codigoMarca, codigoModelo, valorRequest.getAno());

        return tabelaFIPEService.getValor(codigoMarca, codigoModelo, codigoAno);
    }
}