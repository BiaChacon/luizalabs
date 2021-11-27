package com.biachacon.apicep.repositories;

import com.biachacon.apicep.models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Query(value = "SELECT * FROM ENDERECO WHERE cep = ?1", nativeQuery = true)
    Endereco findEnderecoByCEP(String cep);
}
