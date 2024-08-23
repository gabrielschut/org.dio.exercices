package org.example.Projects.Iphone.entities.Ipod;

import org.example.Projects.Iphone.entities.Phone.Contact;
import org.example.utils.Util;

import java.util.List;

public class Ipod {
    private List<Album> albuns;
    private List<AudioBook> livros;
    private List<Contact> contactList;

    public List<AudioBook> getLivros() {
        return livros;
    }

    public void setLivros(List<AudioBook> livros) {
        this.livros = livros;
    }

    public List<Album> getAlbuns() {
        return albuns;
    }

    public void setAlbuns(List<Album> albuns) {
        this.albuns = albuns;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public void playAlbum(int posicao){
        Album album = this.albuns.get(posicao);
        System.out.println("Abrindo album" + album.getNome());
        album.getMusicas().forEach(musica -> {
            System.out.println("Tocando :" + musica.getTitulo());
        });
    }

    public void playEbook(int posicao){
        System.out.println("Iniciando o livro :" + this.livros.get(posicao).titulo);
    }

    public void sincronizaContatos(List<Contact> contactList){
        if(Util.isNotEmpty(this.contactList)
                && Util.isNotEmpty(contactList)){
            for(int i =0; i <= this.contactList.size(); i++){
                if(!contactList.contains(this.contactList.get(i)))contactList.add(this.contactList.get(i));
            }
        }
    }

    public void musicasDoAlbum(Album album){
        System.out.println("Musicas do album" + album.getNome());
        for(int i =0; i <= album.getMusicas().size(); i++){
            System.out.println(i+1 + "- " + album.getMusicas().get(i).getTitulo());
        }
    }

}
