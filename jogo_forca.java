package aulas_em_casa;
import java.util.Scanner;

public class jogo_forca {

    public static void main(String[] args) {
        // Jogo da forca
        String palavraChave = "lucas";
        String letrasUsadas = "";
        String palavraAdivinhada = "";
        int MAX_TENTATIVAS = 5;

        for (int i = 0; i < palavraChave.length(); i++) {
            palavraAdivinhada += "_";
        }

        for (int tentativas = 0; tentativas < MAX_TENTATIVAS; tentativas++) {
            System.out.printf("Rodada %d. Até agora adivinhada: %s. Qual a sua próxima letra?%n", tentativas + 1, palavraAdivinhada);

            char letraTentada = new Scanner(System.in).next().charAt(0);

            if (letrasUsadas.indexOf(letraTentada) >= 0) {
                System.out.printf("Você já tentou a letra %c.%n", letraTentada);
            } else {
                letrasUsadas += letraTentada;

                if (palavraChave.indexOf(letraTentada) >= 0) {
                    palavraAdivinhada = "";

                    for (int j = 0; j < palavraChave.length(); j++) {
                        palavraAdivinhada += (letrasUsadas.indexOf(palavraChave.charAt(j)) >= 0) ?
                                palavraChave.charAt(j) : "_";
                    }

                    if (!palavraAdivinhada.contains("_")) {
                        System.out.printf("Parabéns! A palavra adivinhada era %s%n", palavraAdivinhada);
                        System.exit(0);
                    } else {
                        System.out.printf("Muito bom! %c existe na palavra. Ainda tem letras escondidas%n", letraTentada);
                    }
                } else {
                    System.out.printf("Infelizmente a letra %c não existe na palavra.%n", letraTentada);
                }
            }
        }

        System.out.printf("Foram %d tentativas. A palavra era '%s'%n", MAX_TENTATIVAS, palavraChave);
    }
}

