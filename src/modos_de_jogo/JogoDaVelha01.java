package src.modos_de_jogo;

public class JogoDaVelha01 {
    private int[][] matriz;
    private int contador = 0;

    public void inicializaçãoMatriz() {
        this.matriz = new int[3][3];
        valoresNaMatriz();
    }

    private void valoresNaMatriz() {
        this.contador = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = contador;
                contador++;
            }
        }
    }

    public void printTabuleiro() {
        System.out.println("+---+---+---+");
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                System.out.print("| " + matriz[i][j] + " ");
            }
            System.out.println("|");
            System.out.println("+---+---+---+");
        }
    }

    public void executarJogo() {
        inicializaçãoMatriz();
        printTabuleiro();
    }
}

