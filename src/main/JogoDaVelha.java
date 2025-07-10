package src.main;

import java.util.Scanner;
import src.modos_de_jogo.Creditos;
import src.modos_de_jogo.JogoBase;
import src.modos_de_jogo.JogoDaVelhaComputador;
import src.modos_de_jogo.JogoInfinito;

public class JogoDaVelha {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JogoBase jogoBase = new JogoBase();
        Creditos creditos = new Creditos();
        JogoInfinito jogoInfinito = new JogoInfinito();
        JogoDaVelhaComputador jogoComputador = new JogoDaVelhaComputador();
        do {
            System.out.println("1 _ Contra outro Jogador");
            System.out.println("2 _ Contra o Computador");
            System.out.println("3 _ Modo Infinito");
            System.out.println("4 _ Créditos");
            System.out.println("5 _ Sair");

            System.out.println("Opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    jogoBase.executarJogo();
                    break;
                case 2:
                    jogoComputador.executarJogo();
                    break;
                case 3:
                    jogoInfinito.executarJogo();
                    break;
                case 4:
                    creditos.exibirCreditos();
                    break;
                case 5:
                    System.out.println("Saindo do jogo...");
                    break;
            }

        } while (true);
    }
}
