package br.com.tanos.management.commons.validations.pariticipant;

import br.com.tanos.management.record.model.Participant;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TypeValidate implements ConstraintValidator<Type, Participant.ParticipantType> {

    @Override
    public boolean isValid(Participant.ParticipantType type, ConstraintValidatorContext context) {

        if (type == null) {
            return false;
        }

        return type.equals(Participant.ParticipantType.FISICO) || type.equals(Participant.ParticipantType.JURIDICO);
    }
}
