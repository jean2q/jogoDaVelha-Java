//Essa classe é filha da classe Computador
//Seu modo de jogo é ocupar a primeira posição vazia disponível;

public class ComputadorB extends Computador {
    // ----------- Atributos
    public int[] retornaPos(Tabuleiro tab) {//Retorna a primeira posição válida do grid
        int[] pos = {0, 0};
        for (int i = 0; i < tab.mat.length; i++) {      //linhas
            for (int j = 0; j < tab.mat.length; j++)    //colunas
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
    public void jogar(Tabuleiro tab) {//Imprime que é a jogada do computador, preenche o tabuleiro na posição
        imprimeComputador();
        int[] posValida = retornaPos(tab);
        preencheTabuleiro(tab, posValida[0], posValida[1]);
    }
}



