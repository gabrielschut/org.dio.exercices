package org.example.Projects.Iphone.entities.Ipod;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Album {
    private String nome;
    private String nomeArtista;
    private List<Musica> musicas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeArtista() {
        return nomeArtista;
    }

    public void setNomeArtista(String nomeArtista) {
        this.nomeArtista = nomeArtista;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }


    public Musica escolheMusica(String titulo){
        AtomicReference<Musica> musica = new AtomicReference<>(new Musica());
        if(this.musicas != null && !this.musicas.isEmpty()){
            this.musicas.forEach(music -> {
                if(music.getTitulo().equals(titulo)){
                    musica.set(music);
                }
            });
        }
        return musica.get();
    }

    public Musica escolheMusica(int posicao){
        Musica musica = new Musica();
        if(this.musicas != null && !this.musicas.isEmpty()) {
            for (int i = 0; i < this.musicas.size(); i++) {
                if(i != posicao) continue;
                musica = this.musicas.get(i);
            }
            return musica;
        }else {
            throw new IndexOutOfBoundsException();
        }

    }

}
