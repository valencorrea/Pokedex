package com.certant.pokedexliteengrupo.seguridad.entity.util;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncriptarPassword {
    public static void main(String[] args) {

        String []passwords = {"adminADMIN01","ashASH01","mistyMISTY01","brockBROCK01","rojoROJO01","azulAZUL01","oakOAK01"};

        for ( String password : passwords){
            System.out.println("password: " + password);
            System.out.println("password encriptado: " + encriptarPassword(password));
        }
    }

    public static String encriptarPassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
