package src.modos_de_jogo;

import java.util.Scanner;

public class JogoDaVelha01 {
    private char[][] matriz;
    private int contador;
    int jogador1;
    int jogador2;
    char simbolo;
    boolean jogadaFeita;

    public void inicializaçãoMatriz() {
        this.matriz = new char[3][3];
        this.jogador1 = 1;
        this.jogador2 = 0;
        valoresNaMatriz();
    }

    private void valoresNaMatriz() {
        this.contador = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = Character.forDigit(contador, 10);;
                contador++;
            }
        }
    }

    public void printTabuleiro() {
        System.out.println("+---+---+---+");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + matriz[i][j] + " ");
            }
            System.out.println("|");
            System.out.println("+---+---+---+");
        }
    }

    public void mudaJogador() {
        if (jogador1 == 1 && simbolo == 'X') {
            jogador1 = 0;
            jogador2 = 1;
            simbolo = 'O';
        }else if (jogador2 == 1 && simbolo == 'O') {
            jogador2 = 0;
            jogador1 = 1;
            simbolo = 'X';
        }
    }

    public boolean jogada(int posicao) {
        boolean mudou;
        mudou = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Character.getNumericValue(matriz[i][j]) == posicao) {
                    if (matriz[i][j] == 'X' || matriz[i][j] == 'O') {
                        System.out.println("Esta posição já está ocupada. Escolha outra!");
                        return false; // Jogada inválida
                    }
                    matriz[i][j] = simbolo; // Atribui o simbolo ('X' ou 'O')
                    return true; // Jogada válida e feita
                }
            }
        }
        System.out.println("Esta posição já está ocupada. Escolha outra!"); // Se o loop terminar e não encontrou
        return false; // Posição inválida (não encontrada)
    }

    public void limparTela() {
        System.out.print("\n\n\n\n\n\n");
    }

    public void executarJogo() {
        Scanner scanner = new Scanner(System.in);

        String player1;
        String player2;
        int posicao;
        simbolo = 'X';
        int numJogadas = 0;


        System.out.println("=-==-=-==-=-==-=-==-=-==-=-==-=-==" +
                "\n Bem vindo ao jogo da velha!" +
                "\n Cadastre os jogadores abaixo\n" +
                "=-==-=-==-=-==-=-==-=-==-=-==-=-==");
        System.out.print("Player 1:" +
                "\n--> ");
        player1 = scanner.nextLine();
        System.out.print("Player 2: " +
                "\n--> ");
        player2 = scanner.nextLine();
        System.out.println("Aperte enter para iniciar o jogo");
        scanner.nextLine();

        limparTela();
        inicializaçãoMatriz();
        while (numJogadas < 9) {
            printTabuleiro();
            if (jogador1 == 1) {
                System.out.println("Sua vez de jogar " + player1);
            }else if (jogador2 == 1){
                System.out.println("Sua vez de jogar " + player2);
            }
            System.out.println("Qual posição deseja jogar?");
            posicao = -1; // Valor inicial para garantir que entra no loop de validação

            while (true) {
                if (scanner.hasNextInt()) {
                    posicao = scanner.nextInt();

                    if (posicao >= 1 && posicao <= 9) { // Verifica se o numero esta no intervalo correto
                        break; // Sai do loop de input se for um número válido
                    } else {
                        System.out.println("Por favor, digite um número entre 1 e 9.");
                    }
                } else {
                    System.out.println("Entrada inválida. Por favor, digite um número.");
                    scanner.next(); // Consome a entrada inválida
                }
            }
            jogadaFeita = jogada(posicao);
            if (jogadaFeita) {
                numJogadas++;
                // verificar resultado
                mudaJogador();
            }else{
                System.out.println("Posição inválida. Tente novamente!");
            }

        }
    }
}

