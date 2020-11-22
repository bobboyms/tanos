package br.com.tanos.management.commons.validations.cpf;

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
@Constraint(validatedBy = SingleCpfValidate.class)
public @interface SingleCpf {
    String message() default "CPF already registered only";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
