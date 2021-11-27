package com.biachacon.apicep.services;

import com.biachacon.apicep.mocks.MockEndereco;
import com.biachacon.apicep.repositories.EnderecoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ContextConfiguration(classes = EnderecoServiceTests.class)
@WebMvcTest
class EnderecoServiceTests {

    @InjectMocks
    private EnderecoService enderecoService;

    @Mock
    private EnderecoRepository enderecoRepository;

    @BeforeEach
    public void setUp() {
        standaloneSetup(enderecoService);
    }

    @Test
    @DisplayName("Dado um CEP válido, deve retornar o endereço correspondente.")
    void cepValido() {
        String cep = "12345-678";
        when(enderecoRepository.findEnderecoByCEP(cep))
                .thenReturn(MockEndereco.endereco1());
        ResponseEntity<?> response = enderecoService.findEnderecoByCEP(cep);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(MockEndereco.endereco1(), response.getBody());

    }

    @Test
    @DisplayName(" Dado um CEP válido, que não exista o endereço, deve substituir um dígito da direita para a esquerda " +
            "por zero até que o endereço seja localizado.")
    void substituirDigitoAteLocalizar() {
        String cep = "12345-678";
        when(enderecoRepository.findEnderecoByCEP(cep))
                .thenReturn(MockEndereco.endereco2());
        ResponseEntity<?> response = enderecoService.findEnderecoByCEP(cep);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(MockEndereco.endereco2(), response.getBody());

    }

    @Test
    @DisplayName("Dado um CEP inválido (nesse caso com caracteres a mais), deve retornar uma mensagem reportando o erro: 'CEP inválido'.")
    void cepInvalido() {
        String cep = "12345-6789";
        when(enderecoRepository.findEnderecoByCEP(cep))
                .thenReturn(MockEndereco.endereco1());
        ResponseEntity<?> response = enderecoService.findEnderecoByCEP(cep);
        assertEquals(400, response.getStatusCodeValue());
        assertEquals("CEP inválido", response.getBody());
    }

    @Test
    @DisplayName("Dado um CEP inválido (nesse caso endereço não existe), deve retornar uma mensagem reportando o erro: 'CEP inválido'.")
    void cepEnderecoNaoExistente() {
        String cep = "078442-678";
        when(enderecoRepository.findEnderecoByCEP(cep))
                .thenReturn(MockEndereco.endereco1());
        ResponseEntity<?> response = enderecoService.findEnderecoByCEP(cep);
        assertEquals(400, response.getStatusCodeValue());
        assertEquals("CEP inválido", response.getBody());
    }

    @Test
    @DisplayName("Dado um CEP inválido (nesse caso com letras), deve retornar uma mensagem reportando o erro: 'CEP inválido'.")
    void cepComCarcteresErrados() {
        String cep = "078442-678";
        when(enderecoRepository.findEnderecoByCEP(cep))
                .thenReturn(MockEndereco.endereco1());
        ResponseEntity<?> response = enderecoService.findEnderecoByCEP(cep);
        assertEquals(400, response.getStatusCodeValue());
        assertEquals("CEP inválido", response.getBody());
    }

    @Test
    @DisplayName("Dado um CEP inválido (nesse caso menor que o tamanho), deve retornar uma mensagem reportando o erro: 'CEP inválido'.")
    void cepMenorQueTamanho() {
        String cep = "0784";
        when(enderecoRepository.findEnderecoByCEP(cep))
                .thenReturn(MockEndereco.endereco1());
        ResponseEntity<?> response = enderecoService.findEnderecoByCEP(cep);
        assertEquals(400, response.getStatusCodeValue());
        assertEquals("CEP inválido", response.getBody());
    }

    @Test
    @DisplayName("Cadastrar Endereço correto.")
    void cadastroEnderecoCorreto() {
        when(enderecoRepository.save(MockEndereco.endereco1()))
                .thenReturn(MockEndereco.endereco1());
        ResponseEntity<?>  response = enderecoService.insert(MockEndereco.endereco1());
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(MockEndereco.endereco1(), response.getBody());
    }

    @Test
    @DisplayName("Retornar erro ao tentar cadastrar um endereço com CEP errado.")
    void cadastroEnderecoErrado() {
        when(enderecoRepository.save(MockEndereco.endereco1()))
                .thenReturn(MockEndereco.endereco1());
        ResponseEntity<?>  response = enderecoService.insert(MockEndereco.enderecoErrado());
        assertEquals(400, response.getStatusCodeValue());
    }
}
