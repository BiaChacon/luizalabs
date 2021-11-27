package com.biachacon.apicep.models;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final int SIZE_CEP_BRAZIL = 8;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String cep;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;

}
