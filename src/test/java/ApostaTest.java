import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApostaTest {

    List<Integer> numerosAposta;
    Aposta aposta;

    @BeforeEach
    void setUP(){
        numerosAposta=new ArrayList<>();
        aposta = new Aposta();
    }

    @Test
    void deveRetornarListaNula(){
        try {
            numerosAposta = null;
            aposta.verificaTamanhoAposta(numerosAposta);
            fail();
        } catch (NullPointerException e) {
            assertEquals("Lista é nula", e.getMessage());
        }
    }

    @Test
    void deveRetornarTamanhoListaInvalidoMenor(){
        try {
            numerosAposta.add(3);
            numerosAposta.add(6);
            numerosAposta.add(9);
            aposta.verificaTamanhoAposta(numerosAposta);
        } catch (IllegalArgumentException e) {
            assertEquals("Aposta abaixo do tamanho mínimo", e.getMessage());
        }
    }

    @Test
    void deveRetornarTamanhoListaInvalidoMaior(){
        try {
            numerosAposta.add(3);
            numerosAposta.add(6);
            numerosAposta.add(9);
            numerosAposta.add(12);
            numerosAposta.add(15);
            numerosAposta.add(18);
            numerosAposta.add(21);
            numerosAposta.add(24);
            numerosAposta.add(27);
            numerosAposta.add(30);
            numerosAposta.add(33);
            numerosAposta.add(36);
            numerosAposta.add(39);
            numerosAposta.add(42);
            numerosAposta.add(45);
            numerosAposta.add(48);
            aposta.verificaTamanhoAposta(numerosAposta);
        } catch (IllegalArgumentException e) {
            assertEquals("Aposta acima do tamanho máximo", e.getMessage());
        }
    }

    @Test
    void deveRetornarListaValorInvalidoEncontrado(){
        try {
            numerosAposta.add(3);
            numerosAposta.add(6);
            numerosAposta.add(9);
            numerosAposta.add(12);
            numerosAposta.add(15);
            numerosAposta.add(18);
            numerosAposta.add(21);
            numerosAposta.add(71);
            aposta.buscaDuplicados(numerosAposta);
        } catch (IllegalArgumentException e) {
            assertEquals("Valor inválido encontrado!", e.getMessage());
        }
    }

    @Test
    void deveRetornarListaValorDuplicadoEncontrado(){
        try {
            numerosAposta.add(3);
            numerosAposta.add(6);
            numerosAposta.add(9);
            numerosAposta.add(12);
            numerosAposta.add(15);
            numerosAposta.add(18);
            numerosAposta.add(21);
            numerosAposta.add(21);
            numerosAposta.add(24);
            aposta.buscaDuplicados(numerosAposta);
        } catch (IllegalArgumentException e) {
            assertEquals("Valor duplicado encontrado!", e.getMessage());
        }
    }

    @Test
    void deveRetornarListaValida(){
        numerosAposta.add(3);
        numerosAposta.add(6);
        numerosAposta.add(9);
        numerosAposta.add(12);
        numerosAposta.add(15);
        numerosAposta.add(18);
        numerosAposta.add(21);
        numerosAposta.add(24);
        List<Integer> listaValida = aposta.buscaDuplicados(numerosAposta);
        assertEquals(numerosAposta, listaValida);
    }


}