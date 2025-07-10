package src.main;

import src.modos_de_jogo.Creditos;
import src.modos_de_jogo.JogoBase;
import src.modos_de_jogo.JogoInfinito;

import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JogoBase jogoBase = new JogoBase();
        Creditos creditos = new Creditos();
        JogoInfinito jogoInfinito = new JogoInfinito();

        do {
            System.out.println("\n ---- Menu Principal ----");
            System.out.println("| 1 _ Jogador vs Jogador |");
            System.out.println("| 2 _ computador         |"); // Não feito
            System.out.println("| 3 _ Modo infinito      |");
            System.out.println("| 4 _ Créditos           |");
            System.out.println("| 5 _ Sair               |");
            System.out.println(" ------------------------");

            System.out.print("Opção: ");
            int opcao = scanner.nextInt();

            if (opcao < 1 || opcao > 5) {
                System.out.println("Opção inválida, tente novamente");
            }

            if (opcao == 5) {
                break;
            }

            switch (opcao) {
                case 1:
                    jogoBase.executarJogo();
                    break;
                case 2:
                    break;
                case 3:
                    jogoInfinito.executarJogo();
                    break;
                case 4:
                    creditos.exibirCreditos();
                    break;
            }

        } while (true);

        System.out.println( "Obrigado por jogar!");
        System.out.println( "Fim do programa!");

        scanner.close();
    }
}
