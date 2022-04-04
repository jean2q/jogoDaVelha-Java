import java.util.Scanner;
public class Jogo{
    public static void main(String[] args) {
        Tabuleiro tab = new Tabuleiro();
        Jogador jogador = new Jogador();
        Scanner input = new Scanner(System.in);
        Computador myComp = null;

        String vez = tab.inicioJogo();                //Sorteia quem vai iniciar jogando

        myComp = selecionaDificuldade(input, myComp); //seleciona qual polimorfismo da classe computador será utilizada
                                                      //(dificuldade)

        fluxoDeJogo(tab,vez,jogador, myComp);         //Realiza a troca da vez, imprime o grid, incrementa a qtd de jogadas
                                                      //Chama as funções que realizam as jogadas
    }

    public static void fluxoDeJogo(Tabuleiro tab, String vez, Jogador jogador, Computador myComp){
        do
        {
            if (vez == "Jogador") {
                tab.visualizar();
                tab.incrementaJogadas();
                jogador.jogar(tab);
                vez = "PC";
            }
            else if (vez == "PC") {
                tab.incrementaJogadas();
                myComp.jogar(tab);
                vez = "Jogador";
            }
        }
        while(tab.situacao() == "Jogando");
    }

    public static Computador selecionaDificuldade(Scanner input, Computador myComp){

        int opcao = 0;
        do {
            System.out.println("Escolha a dificuldade 1, 2 ou 3:");
            opcao = input.nextInt();
        }
        while(opcao > 3 || opcao <= 0);

        if(opcao == 1) {
            System.out.println("//////Dificuldade 1 selecionada");
            myComp = new ComputadorA();
            return myComp;
        }
        else if(opcao == 2){
            System.out.println("//////Dificuldade 2 selecionada");
            myComp = new ComputadorB();
            return myComp;
        }
        else if(opcao == 3){
            System.out.println("//////Dificuldade 2 selecionada");
            myComp = new ComputadorC();
            return myComp;
        }
        return myComp;
    }
}
