package br.com.tanos.management.commons.validations.pariticipant;

import br.com.tanos.management.record.model.Participant;
import br.com.tanos.management.record.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryValidate implements ConstraintValidator<Category, List<Participant.ParticipantCategory>> {


    @Override
    public boolean isValid(List<Participant.ParticipantCategory> category, ConstraintValidatorContext context) {

        if (category == null) {
            return false;
        }

        List<Participant.ParticipantCategory> participantCategories = category.stream()
                .filter(participantCategory ->
                        participantCategory.equals(Participant.ParticipantCategory.CUSTOMER) ||
                        participantCategory.equals(Participant.ParticipantCategory.EMPLOYEE) ||
                        participantCategory.equals(Participant.ParticipantCategory.SHIPPING_COMPANY) ||
                        participantCategory.equals(Participant.ParticipantCategory.SUPPLIER)).collect(Collectors.toList());

        return participantCategories.size() > 0;
    }

}
