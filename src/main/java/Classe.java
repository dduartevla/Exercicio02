import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Classe {

    //inicia os valores
    List<Integer> numerosEntrada;
    double valorEntrada;

    public void setValorEntrada(double valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public void setNumerosEntrada(List<Integer> numerosEntrada) {
        if (numerosEntrada != null) {
            this.numerosEntrada = numerosEntrada;
        } else {
            throw new IllegalArgumentException("Lista inválida!");
        }
    }

    public List<Integer> fazPrimeiraLista(){
        List<Integer> list = new ArrayList<>();
        for (Integer n: numerosEntrada){
            if (n < 1 || n > 60){
                throw new IllegalArgumentException("Valor inválido encontrado!");
            }
            if (list.contains(n)){
                throw new IllegalArgumentException("Valor inválido encontrado!");
            }
            list.add(n);
        }
        return list;
    }

    public boolean lista1Valida(List<Integer> list){
        if (list!=null && list.size() >= 6 && list.size() <= 15){
            return true;
        }
        else return false;
    }

    public List<Integer> fazSegundaLista(List<Integer> list){
        if (!lista1Valida(list)){
            throw new IllegalArgumentException("Primeira lista não é válida!");
        }

        List<Integer> list2 = new ArrayList<>();
        int s;
        while (list2.size() < 6) {
            s = new Random().nextInt(59) + 1;
            if (!list2.contains(s)) {
                list2.add(s);
            }
        }
        return list2;
    }

    public int contaIguais(List<Integer> list2){
        if (list2 != null){
            throw new NullPointerException("Segunda lista é nula!");
        }
        int total=0;

        for (Integer i: numerosEntrada){
            if (list2.contains(i)){
                total++;
            }
        }
        return total;
    }

    public double calculaValor(int total){
        double resultado = valorEntrada;

        if (total == 5){
            resultado =  valorEntrada * 0.2;
        } else if (total == 4){
            resultado = valorEntrada * 0.05;
        }

        return resultado;
    }

    public double metodo(List<Integer> num, double valor) {
        List<Integer> list = fazPrimeiraLista();
        List<Integer> list2 = fazSegundaLista(list);
        int total = contaIguais(list2);

        return calculaValor(total);
    }
}
