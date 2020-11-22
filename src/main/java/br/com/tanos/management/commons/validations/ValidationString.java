package br.com.tanos.management.commons.validations;

import org.apache.logging.log4j.util.Strings;

import java.util.Objects;

public class ValidationString {

    public static boolean isValid(String value) {

        if (Objects.isNull(value) || Strings.isEmpty(value) || Strings.isBlank(value)) {
            return false;
        }

        return true;
    }

}
