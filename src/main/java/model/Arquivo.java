package model;

import java.nio.file.Path;

//Nicole
public class Arquivo {

    private Path caminho;

    public Arquivo() {
        caminho = null;
    }

    public Path getCaminho() {
        return caminho;
    }

    public void setCaminho(Path caminho) {
        this.caminho = caminho;
    }

    public boolean isNovo() {
        return caminho == null;
    }

    public void limpar() {
        caminho = null;
    }
}