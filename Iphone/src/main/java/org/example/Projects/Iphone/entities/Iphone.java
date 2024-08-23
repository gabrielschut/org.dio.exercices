package org.example.Projects.Iphone.entities;

import org.example.Projects.Iphone.entities.Ipod.Ipod;
import org.example.Projects.Iphone.entities.Phone.Phone;
import org.example.Projects.Iphone.entities.Safary.Safary;

public class Iphone {

    private Phone phone;
    private Ipod ipod;
    private Safary safary;

    public Iphone(Safary safary) {
        this.safary = safary;
    }

    public Iphone(Phone phone, Ipod ipod, Safary safary) {
        this.phone = phone;
        this.ipod = ipod;
        this.safary = safary;
        this.ipod.sincronizaContatos(this.phone.getContactList());
    }

    public void scrollaAtela(){
        System.out.println("Scrolando a tela ...");
    }
}
