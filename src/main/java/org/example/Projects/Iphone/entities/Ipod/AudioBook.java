package org.example.Projects.Iphone.entities.Ipod;

import java.io.File;

public class AudioBook {

    String titulo;
    File arquivo;
    private String licenca;

    public AudioBook(){}

    public AudioBook(String titulo, File arquivo, String licenca) {
        this.titulo = titulo;
        this.arquivo = arquivo;
        this.licenca = licenca;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public File getArquivo() {
        return arquivo;
    }

    public void setArquivo(File arquivo) {
        this.arquivo = arquivo;
    }

    public String getLicenca() {
        return licenca;
    }
}
