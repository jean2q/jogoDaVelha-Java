//Essa classe é filha da classe Computador
//Seu modo de jogo é aleatório

public class ComputadorA extends Computador {

    public void jogar(Tabuleiro tab){
        int i = sorteio(3);
        int j = sorteio(3);

        imprimeComputador();

        do {
            i = Computador.sorteio(3);
            j = Computador.sorteio(3);
        }
        while(verificaPosicaoOcupada(tab, i, j)); //Verifica se as posições já estão ocupadas

        preencheTabuleiro(tab, i, j);
    }
}

//Fazer sorteio
//Verificar se o campo resultado do sorteio esta disponível
//Se sim marcar para o PC
//Se não, repetir até o próximo