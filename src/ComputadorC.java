//Essa classe é filha da classe Computador
//Seu modo de jogo é ocupar a última posição vazia disponível;

public class ComputadorC extends Computador {
    // ----------- Atributos
    protected int[] retornaPos(Tabuleiro tab) { //Retorna a última posição válida do grid
        int[] pos = {0, 0};
        for (int i = tab.mat.length - 1; i >= 0; i--) {      //linhas
            for (int j = tab.mat.length - 1; j >= 0; j--)    //colunas
            {
                if (!verificaPosicaoOcupada(tab, i, j)) {
                    pos[0] = i;
                    pos[1] = j;
                    return pos;
                }
            }
        }
        return pos;
    }
    // ---Sobrescrito (polimorfismo);
    public void jogar(Tabuleiro tab) { //Imprime que é a jogada do computador, preenche o tabuleiro na posição
        imprimeComputador();
        int[] posValida = retornaPos(tab);
        preencheTabuleiro(tab, posValida[0], posValida[1]);
    }
}



