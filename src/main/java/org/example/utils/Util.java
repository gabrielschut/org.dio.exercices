package org.example.utils;

import org.example.Projects.Iphone.entities.Phone.Contact;

import java.util.LinkedList;
import java.util.List;

public class Util {

    public static boolean isNotEmpty(List<Contact> list){
        return list != null && !list.isEmpty();
    }

    public static boolean isNotEmpty(LinkedList<Contact> list){
        return list != null && !list.isEmpty();
    }
}
