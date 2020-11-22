package br.com.tanos.management.commons.validations.pariticipant;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = CategoryValidate.class)
public @interface Category {
    String message() default "Invalid category participant";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
