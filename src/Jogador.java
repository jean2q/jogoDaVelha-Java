import java.util.Scanner;

public class Jogador {
    public void jogar(Tabuleiro tab){
        Scanner input = new Scanner(System.in);

        int pos[] = recebeRetornaInputs(tab, input); //Chama a função que recebe e valida os inputs do usuario,
                                                     //Atribuindo o retorno para a variável[array] pos;

        preencheTabuleiro(tab, pos);                //preenche o tabuleiro na posição indicada;
    }

    private boolean verificaJogada(Tabuleiro tab, int i, int j){//VERIFICA SE A JOGADA É VALIDA, TRUE SE FOR VALIDA, FALSE SE FOR INVALIDA
        if (i > 2 || i < 0 || j > 2 || j < 0){ //Verifica se as posições são invalidas (maior ou menor que o tamanho do grid)
            return false;
        }
        else if(tab.mat[i][j] == 1 || tab.mat[i][j] == -1){ //Verifica se as posições já estão ocupadas
            return false;
        }
        else{
            return true;
        }
    }

    private int[] recebeRetornaInputs(Tabuleiro tab, Scanner input){ //Recebe e valida os inputs, retornando um array com a posição a ser preenchida
        int[] pos = {0,0};

        System.out.println(".....Faça sua jogada! (X)....");
        System.out.print("Linha: ");
        pos[0] = input.nextInt()-1;
        System.out.print("Coluna: ");
        pos[1] = input.nextInt()-1;

        while(verificaJogada(tab, pos[0], pos[1]) == false) {
            System.out.println("Jogada inválida, tente novamente:");
            pos = recebeRetornaInputs(tab, input);
        }

        return pos;
    }

    private void preencheTabuleiro(Tabuleiro tab, int[] pos){
        tab.mat[pos[0]][pos[1]] = 1;
    }
}
