package org.example.Projects.Iphone.entities.Phone;

import org.example.utils.Util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class Phone {

    private String numeroDigitado;
    private List<Contact> contactList;
    private LinkedList<Contact> contatosFavoritos;

    public List<String> getHistoricoChamada() {
        return historicoChamada;
    }

    private List<String> historicoChamada;

    public Phone() {}

    public Phone(String numeroDigitado) {
        this.numeroDigitado = numeroDigitado;
    }

    public Phone(String numeroDigitado, List<Contact> contactList) {
        this.numeroDigitado = numeroDigitado;
        this.contactList = contactList;
    }

    public String getNumeroDigitado() {
        return numeroDigitado;
    }

    public void setNumeroDigitado(String numeroDigitado) {
        this.numeroDigitado = numeroDigitado;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public LinkedList<Contact> getContatosFavoritos() {
        return contatosFavoritos;
    }

    public void adicionaContato(Contact contato){
        if(Objects.nonNull(this.contactList) && !this.contactList.isEmpty())
            this.contactList.add(contato);
        else {
            List<Contact> contatos = new ArrayList<>();
            contatos.add(contato);
            this.contactList = contatos;
        }
    }

    public void removeContato(Contact contato){
        if(Util.isNotEmpty(this.contactList)){
            this.contactList.forEach(contact -> {
                if(contact.equals(contato))
                    this.contactList.remove(contato);
                if(Util.isNotEmpty(this.contatosFavoritos))
                    this.contatosFavoritos.remove();
            });
        }
    }

    public void favoritaContato(Contact contato){
        if(this.contactList.contains(contato))
            this.contatosFavoritos.add(contato);
    }

    public void desfavoritaContato(Contact contact){
        if(Util.isNotEmpty(this.contatosFavoritos))
            this.contatosFavoritos.remove(contact);
    }

    public void alteraOrdemFavoritos(Contact contato, int index){
        if(Util.isNotEmpty(this.contatosFavoritos)
            && this.contatosFavoritos.size() <= index){
            LinkedList<Contact> novaOrdenacao = new LinkedList<>();
            desfavoritaContato(contato);
            for(int i = 0; i < this.contatosFavoritos.size(); i++){
                if(i == index) {
                    novaOrdenacao.add(contato);
                    index = -1;
                    i--;
                    continue;
                }else {
                    novaOrdenacao.add(this.contatosFavoritos.get(i));
                }
            }
            this.contatosFavoritos = novaOrdenacao;
        }
    }

    public void realizaLigacao(){
        Contact contato = contatoConhecido(this.numeroDigitado);
        if(contato != null) {
            System.out.println("Ligando para " + contato.getNome());
            atualizaHistorico(contato.getNome());
        }else{
            System.out.println("Ligando para " + this.numeroDigitado);
            atualizaHistorico(this.numeroDigitado);
        }
    }

    public void realizaLigacao(Contact contato){
        if(Util.isNotEmpty(this.contactList)
        && this.contactList.contains(contato)) {
            System.out.println("Ligando para " + contato.getNome());
            atualizaHistorico(contato.getNome());
        }
    }

    public void recebeLigacao(String numeroDaChamada){
        Contact contato = contatoConhecido(numeroDaChamada);
        if(contato != null) {
            System.out.println("Chamada de " + contato.getNome());
            atualizaHistorico(contato.getNome());
        } else {
            System.out.println("Chamada de " + numeroDaChamada);
            atualizaHistorico(numeroDaChamada);
        }
    }

    private Contact contatoConhecido(String numero){
        AtomicReference<Contact> contato = new AtomicReference<>();
        this.contactList.forEach(contact -> {
            if(contact.telefones.contains(numero))
                contato.set(contact);
        });
        return contato.get();
    }

    private void atualizaHistorico(String registro){
        this.historicoChamada.add(registro);
    }
}
