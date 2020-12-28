package ru.andrei;

import java.util.UUID;

public class testApp {
    public static void main(String[] args) {
        //generate random UUIDs
        UUID id1 = UUID.randomUUID();
        System.out.println(id1);
        String str = id1.toString();
        str = str.replaceAll("[-]", "");
        System.out.println(str);
    }
}
