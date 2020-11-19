package br.com.tanos.management.record.model;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "tb_person")
public class Person {

    public enum PersonType {
        FISICO,
        JURIDICO
    }

    public enum PersonCategory {
        CUSTOMER, //CLIENTE
        SUPPLIER, //FORNECEDOR
        SHIPPING_COMPANY, //TRANSPORTADORA
        EMPLOYEE //FUNCIÁRIO
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private PersonType personType;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<PersonCategory> personCategory;

}
