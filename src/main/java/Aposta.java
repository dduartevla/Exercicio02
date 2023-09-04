import java.util.ArrayList;
import java.util.List;

public class Aposta {

    private final int NUM_MAX = 60;
    private final int NUM_MIN = 1;
    private final int TAMANHO_MAX = 15;
    private final int TAMANHO_MIN = 6;


    public List<Integer> buscaDuplicados(List<Integer> numerosAposta){
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
        verificaTamanhoAposta(auxNumAposta);
        return auxNumAposta;
    }

    public void verificaTamanhoAposta(List<Integer> auxNumAposta){
        if (auxNumAposta==null) {
            throw new NullPointerException("Lista é nula");
        } else if (auxNumAposta.size() <= TAMANHO_MIN) {
            throw new IllegalArgumentException("Aposta abaixo do tamanho mínimo");
        }else if(auxNumAposta.size() >= TAMANHO_MAX){
            throw new IllegalArgumentException("Aposta acima do tamanho máximo");
        }
    }




}
