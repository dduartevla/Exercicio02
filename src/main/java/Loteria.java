import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Loteria {

    private final double CINCO_ACERTOS = 0.2;
    private final double QUATRO_ACERTOS = 0.05;
    private final int NUM_MAX = 60;
    private final int NUM_MIN = 1;
    List<Integer> numerosAposta;
    double valorPremio;

    public void setvalorPremio(double valorPremio) {
        this.valorPremio = valorPremio;
    }

    public void setnumerosAposta(List<Integer> numerosAposta) {
        if (numerosAposta != null) {
            this.numerosAposta = numerosAposta;
        } else {
            throw new IllegalArgumentException("Lista inválida!");
        }
    }

    public List<Integer> buscaDuplicados(){
        List<Integer> auxNumAposta = new ArrayList<>();
        for (Integer n: numerosAposta){
            if (n < NUM_MIN || n > NUM_MAX){
                throw new IllegalArgumentException("Valor inválido encontrado!");
            }
            if (auxNumAposta.contains(n)){
                throw new IllegalArgumentException("Valor duplicado encontrado!");
            }
            auxNumAposta.add(n);
        }
        return auxNumAposta;
    }

    public void numApostaValida(List<Integer> auxNumAposta){
        if (auxNumAposta!=null && auxNumAposta.size() >= 6 && auxNumAposta.size() <= 15){
            throw new IllegalArgumentException("Tamanho da lista inválido!");
        }
    }

    public List<Integer> fazSorteio(){
        List<Integer> numerosSorteados = new ArrayList<>();
        int s;
        while (numerosSorteados.size() < 6) {
            s = new Random().nextInt(NUM_MAX-1) + 1;
            if (!numerosSorteados.contains(s)) {
                numerosSorteados.add(s);
            }
        }
        return numerosSorteados;
    }

    public int contaAcertos(List<Integer> numerosSorteados){
        if (numerosSorteados != null){
            throw new NullPointerException("Segunda lista é nula!");
        }
        int totalAcertos=0;

        for (Integer i: numerosAposta){
            if (numerosSorteados.contains(i)){
                totalAcertos++;
            }
        }
        return totalAcertos;
    }

    public double calculaValor(int totalAcertos){
        double resultado = 0.0;

        if (totalAcertos == 6){
            resultado = valorPremio;
        } else if (totalAcertos == 5){
            resultado =  valorPremio * CINCO_ACERTOS;
        } else if (totalAcertos == 4){
            resultado = valorPremio * QUATRO_ACERTOS    ;
        }

        return resultado;
    }

    public double loteriaSorteio(List<Integer> num, double valor) {
        List<Integer> auxNumAposta = buscaDuplicados();
        numApostaValida(auxNumAposta);
        List<Integer> numerosSorteados = fazSorteio();
        int totalAcertos = contaAcertos(numerosSorteados);

        return calculaValor(totalAcertos);
    }
}
