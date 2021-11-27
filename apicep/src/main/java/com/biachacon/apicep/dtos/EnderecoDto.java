package com.biachacon.apicep.dtos;

import com.biachacon.apicep.models.Endereco;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class EnderecoDto {

    @NotBlank
    @Size(min = Endereco.SIZE_CEP_BRAZIL, max = Endereco.SIZE_CEP_BRAZIL)
    private String cep;

    @NotBlank
    private String rua;

    @NotBlank
    private String bairro;

    @NotBlank
    private String cidade;

    @NotBlank
    private String estado;
}
