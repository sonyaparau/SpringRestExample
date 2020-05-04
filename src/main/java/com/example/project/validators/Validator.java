package com.example.project.validators;

public class Validator {

    public boolean validateName(String name) {
        return name.matches("[A-Z][a-z]*");
    }

    public boolean validateCredits(Integer nbCredits) {
        return nbCredits > 0;
    }
}
