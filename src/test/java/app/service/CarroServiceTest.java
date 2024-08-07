package app.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CarroServiceTest {

    @Autowired
    CarroService carroService;


    @Test
    @DisplayName("Teste de ano menor que 1995")
    void cenario01(){
        //REGRA DE NEGOCIO DE VALIDAÇÃO DE NOME DO CARRO
        boolean retorno = this.carroService.verificarNomeCarro("Jeep Compass",2021);

        Assertions.assertEquals(true, retorno);
    }


    @Test
    @DisplayName("Teste de ano menor que 1995, COM EXCEPTION")
    void cenario02(){
        Assertions.assertThrows(Exception.class, ()-> {
            boolean retorno = this.carroService.verificarNomeCarro("Jeep Compass",2020);
        });
    }

}
