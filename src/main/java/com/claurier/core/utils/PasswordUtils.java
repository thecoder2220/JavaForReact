package com.claurier.core.utils;

import org.springframework.stereotype.Component;

@Component
public class PasswordUtils {
    public boolean checkPassword(String encryptedPassword, String plainPassword) {
        if (encryptedPassword == null || plainPassword == null || encryptedPassword.length() < 4 || encryptedPassword.charAt(0) != '{') {
            throw new IllegalArgumentException("Le contenu d'un des mots de passe n'est pas correct. clair='" + plainPassword + "', crypt\u00e9='" + encryptedPassword + "'");
        }
        int braceEnd = encryptedPassword.indexOf(125);
        if (braceEnd == -1) {
            return false;
        }
        boolean pass = false;
        String algorithm = encryptedPassword.substring(1, braceEnd);
        return pass;
    }
}

