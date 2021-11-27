package com.biachacon.apicep.services;

import com.biachacon.apicep.models.Endereco;
import com.biachacon.apicep.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    public ResponseEntity<?> insert(Endereco endereco) {
        endereco.setId(null);
        endereco.setCep(formatoCEP(endereco.getCep()));

        try {
            if(endereco.getCep() == null) throw new Exception();
            return ResponseEntity.ok(enderecoRepository.save(endereco));
        }catch(Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<?> findEnderecoByCEP(String cep) {
        try {
            if (cepValidate(cep)) {
                Endereco endereco = null;
                int size = cep.length();

                while (size != 0) {
                    endereco = enderecoRepository.findEnderecoByCEP(cep);
                    if (endereco != null) {
                        return ResponseEntity.ok(endereco);
                    }else {
                        size--;
                        cep = cep.substring(0, size) + cep.substring(size, cep.length()).replaceAll("[0-9]", "0");
                    }
                }
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.badRequest().body("CEP inválido");
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("Erro interno no servidor");
        }
    }

    private boolean cepValidate(String cep) {
        cep = formatoCEP(cep);
        if (cep != null){
            return cep.length() == Endereco.SIZE_CEP_BRAZIL;
        }
        return false;
    }

    private String formatoCEP(String cep){
        if(cep.matches("[0-9]{5}-[0-9]{3}") || cep.matches("[0-9]{8}"))
            return cep.replace("-", "");
        return null;
    }
}
