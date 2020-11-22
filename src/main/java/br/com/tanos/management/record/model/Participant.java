package br.com.tanos.management.record.model;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "tb_person")
public class Participant {

    public enum ParticipantType {
        FISICO,
        JURIDICO
    }

    public enum ParticipantCategory {
        CUSTOMER, //CLIENTE
        SUPPLIER, //FORNECEDOR
        SHIPPING_COMPANY, //TRANSPORTADORA
        EMPLOYEE //FUNCIÁRIO
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private ParticipantType participantType;

    @Column(nullable = false)
    @ElementCollection(fetch = FetchType.EAGER)
    private List<ParticipantCategory> participantCategory;

}
