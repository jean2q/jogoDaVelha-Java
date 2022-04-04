import java.util.Random;

public abstract class Computador{
    public static int sorteio(int bound){ //Realiza o sorteio, tendo o numero bound como parâmetro para o maior número possível (excluindo ele proprio)
        Random rand = new Random();
        int n = rand.nextInt(bound);
        return n;
    }

    protected static void imprimeComputador(){ // Método que imprime identificando que é a jogada do computador;
        System.out.println("+====+ COMPUTADOR (O)  +====+");
    }

    protected boolean verificaPosicaoOcupada(Tabuleiro tab, int i, int j){//Verifica se a posição já está ou não ocupada
        if (tab.mat[i][j] == 1 || tab.mat[i][j] == -1){
            return true;
        }
        else {
            return false;
        }
    }

    protected void preencheTabuleiro(Tabuleiro tab, int i, int j){//Preenche o tabuleiro na opção passada como parâmetro;
        tab.mat[i][j] = -1;
    }

    protected abstract void jogar(Tabuleiro tab); //Método abstrato, implementado pelas classes ComputadorA, ComputadorB,
                                                  //Computador C
}
