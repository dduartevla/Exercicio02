import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sorteio {

    private final int NUM_MAX = 60;
    private final double CINCO_ACERTOS = 0.2;
    private final double QUATRO_ACERTOS = 0.05;
    Aposta aposta;

    public Sorteio(){
        this.aposta = new Aposta();
    }


    public List<Integer> fazSorteio(){
        List<Integer> numerosSorteados =  new ArrayList<>();
        int s;
        while (numerosSorteados.size() <= 6) {
            s = new Random().nextInt(NUM_MAX-1) + 1;
            if (!numerosSorteados.contains(s)) {
                numerosSorteados.add(s);
            }
        }
        return numerosSorteados;
    }

    public int contaAcertos(List<Integer> numerosSorteados, List<Integer> numerosAposta){
        if (numerosSorteados == null){
            throw new NullPointerException("Lista de numeros sorteados é nula!");
        }
        int totalAcertos=0;

        for (Integer i: aposta.buscaDuplicados(numerosAposta)){
            if (numerosSorteados.contains(i)){
                totalAcertos++;
            }
        }

        return totalAcertos;
    }

    public void isNumerosApostaValido(List<Integer> numAposta){
        List<Integer> auxNumAposta = aposta.buscaDuplicados(numAposta);
    }

    public double auxCalculaValor(int totalAcertos, double valorPremio){
        double resultado = 0.0;

        if (totalAcertos >= 6){
            resultado = valorPremio;
        } else if (totalAcertos == 5){
            resultado =  valorPremio * CINCO_ACERTOS;
        } else if (totalAcertos == 4){
            resultado = valorPremio * QUATRO_ACERTOS    ;
        }

        return resultado;
    }

    public double calculaValor(List<Integer> numerosAposta,double valorPremio){
        isNumerosApostaValido(numerosAposta);
        if (valorPremio <=0){
            throw new IllegalArgumentException("Valor do prêmio inválido!");
        }

        List<Integer> numerosSorteados = fazSorteio();
        int totalAcertos = contaAcertos(numerosSorteados,numerosAposta);
        return auxCalculaValor(totalAcertos, valorPremio);
    }
}
