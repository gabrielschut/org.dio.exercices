package org.example.Projects.Iphone.entities.Phone;

import java.util.List;
import java.util.Objects;

public class Contact {

    String nome;
    List<String> telefones;
    List<String> emails;

    public Contact(){}

    public Contact(String nome) {
        this.nome = nome;
    }

    public Contact(String nome, List<String> telefones) {
        this.nome = nome;
        this.telefones = telefones;
    }

    public Contact(String nome, List<String> telefones,List<String> emails) {
        this.nome = nome;
        this.telefones = telefones;
        this.emails = emails;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<String> telefones) {
        this.telefones = telefones;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(nome, contact.nome)
                && Objects.equals(telefones, contact.telefones)
                && Objects.equals(emails, contact.emails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, telefones, emails);
    }
}
