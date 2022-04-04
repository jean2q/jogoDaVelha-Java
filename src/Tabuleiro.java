public class Tabuleiro {
    //---------------- Atributos ----------------\\
    private int qtdJogadas = 0;        //Contador de jogadas
    public int mat[][] = new int[3][3];//Cria o tabuleiro, um array bi dimensional
    // 1 - X - Jogador humano
    //-1 - O - Computador
    // 0 - Espaço vazio

    //---------------- Métodos ----------------\\
    protected void incrementaJogadas() { //Método utilizado para contar as jogadas...
        qtdJogadas++;                 //Usado posteriormente para verificar empate...
    }

    protected String situacao() { //Verifica se o jogo ja acabou (Vitória, empate) ou continua;
        if (verificaLinhas() == "PC" || verificaColunas() == "PC" || verificaDiagonais() == "PC") {
            System.out.println("~^~^~ Vitória da máquina ~^~^");
            visualizar();
            return "PC";
        } else if (verificaLinhas() == "Humano" || verificaColunas() == "Humano" || verificaDiagonais() == "Humano") {
            System.out.println("~~~ Parabéns, você ganhou! ~~~");
            visualizar();
            return "Humano";
        }
        else if (qtdJogadas == 9) {
            System.out.println("______Ocorreu um empate!______");
            visualizar();
            return "Empate";
        }
        return "Jogando";
    }

    protected void visualizar() { //Imprime o tabuleiro e o grid de gabarito para jogadas;
        System.out.println("======= Jogo da Velha =======");
        System.out.println("==Tabuleiro==    ==Gabarito==");
        for (int i = 0; i < mat.length; i++) {      //linhas
            for (int j = 0; j < mat.length; j++) {  //colunas
                if (mat[i][j] == 1) {
                    System.out.print(" X |");
                } else if (mat[i][j] == -1) {
                    System.out.print(" O |");
                } else {
                    System.out.print(" - |");
                }
            }
            System.out.print("       ");
            for (int j = 0; j < mat.length; j++) {
                System.out.print(i + 1);
                System.out.print((j + 1) + " ");
            }
            System.out.println();
        }
        System.out.println("=============================");
    }

    private String verificaLinhas() { //Verifica se alguém já ganhou nas linhas;
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                count = count + mat[i][j];
            }
            if (count == -3) {
                return "PC";
            } else if (count == 3) {
                return "Humano";
            }
            count = 0;
        }
        return "Jogando";
    }

    private String verificaColunas() { //Verifica se alguém já ganhou nas colunas;
        int col0 = 0;
        int col1 = 0;
        int col2 = 0;

        for (int i = 0; i < mat.length; i++) {
            col0 = col0 + mat[i][0];
            col1 = col1 + mat[i][1];
            col2 = col2 + mat[i][2];

            if (col0 == -3 || col1 == -3 || col2 == -3) {
                return "PC";
            } else if (col0 == 3 || col1 == 3 || col2 == 3){
                return "Humano";
            }
        }
        return "Jogando";
    }
    private String verificaDiagonais() {//Verifica se alguém já ganhou nas diagonais;
        int diag1 = 0;
        int diag2 = 0;
        for (int i = 0; i < mat.length; i++) {
            diag1 = diag1 + mat[i][i];
            diag2 = diag2 + mat[(mat.length-1)-i][i];
        }
        if (diag1 == -3 || diag2 == -3) {
            return "PC";
        } else if (diag1 == 3 || diag2 == 3) {
            return "Humano";
        }
        return "Jogando";
    }

    protected String inicioJogo(){ //Sorteia quem vai iniciar jogando
        int vez = Computador.sorteio(2);
        if (vez == 0){
            return "PC";
        }
        else{
            return "Jogador";
        }
    }
}
