package com.example.exercicio08;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ModeloRequest {
    private ArrayList<AnoRequest> anos;
    private DefaultRequest[] modelos;

    public ArrayList<AnoRequest> getAnos() {
        return anos;
    }

    public void setAnos(ArrayList<AnoRequest> anos) {
        this.anos = anos;
    }

    public DefaultRequest[] getModelos() {
        return modelos;
    }

    public void setModelos(DefaultRequest[] modelos) {
        this.modelos = modelos;
    }
}
