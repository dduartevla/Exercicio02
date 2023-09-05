import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SorteioTest {

    Aposta aposta;
    Sorteio sorteio;

    List<Integer> numerosApostaValida;
    List<Integer> numerosSorteados;

    @BeforeEach
    void setUp(){
        aposta = new Aposta();
        sorteio = new Sorteio();
        numerosSorteados = sorteio.fazSorteio();

        numerosApostaValida=new ArrayList<>();
        numerosApostaValida.add(3);
        numerosApostaValida.add(6);
        numerosApostaValida.add(9);
        numerosApostaValida.add(12);
        numerosApostaValida.add(15);
        numerosApostaValida.add(18);
        numerosApostaValida.add(21);
        numerosApostaValida.add(24);
    }

    @Test
    void contaAcertosDeveRetornarListaNumerosSorteadosNula(){
        try{
            List<Integer> numerosSorteados = null;
            int acertos = sorteio.contaAcertos(numerosSorteados, numerosApostaValida);
            fail();
        } catch (NullPointerException e){
            assertEquals("Lista de numeros sorteados é nula!", e.getMessage());
        }
    }

    @Test
    void contaAcertosDeveRetornarInteiroMaiorQueZero(){
        int acertos = sorteio.contaAcertos(numerosSorteados,numerosApostaValida);
        boolean eValido=false;
        if (acertos >=0){
            eValido =true;
        }
        assertTrue(eValido);
    }

    @Test
    void calculaValorDeveRetornarValorPremioInvalido(){
        try{
            sorteio.calculaValor(numerosApostaValida,-1.00);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals("Valor do prêmio inválido!", e.getMessage());
        }
    }

    @Test
     void calculaValorDeveRetornarPremioQuatroAcertos(){
        double valorPremio = 100.00;
        double resultado = sorteio.auxCalculaValor(4,valorPremio);
        assertEquals(5.0,resultado);
    }

    @Test
    void calculaValorDeveRetornarPremioCincoAcertos(){
        double valorPremio = 100.00;
        double resultado = sorteio.auxCalculaValor(5,valorPremio);
        assertEquals(20.0,resultado);
    }

    @Test
    void calculaValorDeveRetornarPremioSeisMaisAcertos(){
        double valorPremio = 100.00;
        double resultado = sorteio.auxCalculaValor(6,valorPremio);
        assertEquals(100.0,resultado);
    }

    @Test
    void calculaValorDeveRetornarPremioMenosDeQuatroAcertos(){
        double valorPremio = 100.00;
        double resultado = sorteio.auxCalculaValor(3,valorPremio);
        assertEquals(0.0,resultado);
    }
}