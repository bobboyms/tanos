package br.com.tanos.management.record.repository;

import br.com.tanos.management.record.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    Optional<Participant> findByCpf(String cpf);
}
