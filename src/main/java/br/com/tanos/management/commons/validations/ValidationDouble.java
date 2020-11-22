package br.com.tanos.management.commons.validations;

import java.util.Objects;

public class ValidationDouble {

    public static boolean isValid(Double value) {

        if (Objects.isNull(value) || value.doubleValue() <= 0d) {
            return false;
        }

        return true;
    }

}
