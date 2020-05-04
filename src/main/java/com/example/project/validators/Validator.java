package com.example.project.validators;

import org.springframework.stereotype.Component;

@Component
public class Validator {

    public boolean validateName(String name) {
        return name.matches("[A-Z][a-z]*");
    }

    public boolean validateCredits(Integer nbCredits) {
        return nbCredits > 0;
    }
}
