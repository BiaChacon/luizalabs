package com.biachacon.apicep.mocks;

import com.biachacon.apicep.models.Endereco;

public class MockEndereco {
    public static Endereco endereco() {
        Endereco endereco = new Endereco();
        endereco.setCep("12345-678");
        endereco.setRua("Rua");
        endereco.setCidade("Cidade");
        endereco.setEstado("Estado");
        return endereco;
    }

    public static Endereco endereco1() {
        Endereco endereco = new Endereco();
        endereco.setCep("12345678");
        endereco.setRua("Rua");
        endereco.setCidade("Cidade");
        endereco.setEstado("Estado");
        return endereco;
    }

    public static Endereco endereco2() {
        Endereco endereco = new Endereco();
        endereco.setCep("12345000");
        endereco.setRua("Rua");
        endereco.setCidade("Cidade");
        endereco.setEstado("Estado");
        return endereco;
    }

    public static Endereco enderecoErrado() {
        Endereco endereco = new Endereco();
        endereco.setCep("12345678900");
        endereco.setRua("Rua");
        endereco.setCidade("Cidade");
        endereco.setEstado("Estado");
        return endereco;
    }
}
