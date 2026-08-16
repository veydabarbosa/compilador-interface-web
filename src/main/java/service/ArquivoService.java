package service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

//Nicole
public class ArquivoService {

    public String abrir(Path caminho) throws IOException {
        return Files.readString(caminho, StandardCharsets.UTF_8);
    }

    public void salvar(Path caminho, String conteudo) throws IOException {
        Files.writeString(caminho, conteudo, StandardCharsets.UTF_8);
    }
}