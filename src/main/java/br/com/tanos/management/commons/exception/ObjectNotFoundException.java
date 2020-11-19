package br.com.tanos.management.commons.exception;

import br.com.tanos.management.commons.reponse.ValidationMessage;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.function.Supplier;

@Getter
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ObjectNotFoundException extends LocalException {

    public ObjectNotFoundException(List<ValidationMessage> validationMessages) {
        super(validationMessages);
    }
}
