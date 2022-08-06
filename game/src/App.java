import java.util.Random;
import java.util.Scanner;
import java.lang.Thread;

public class App {
    public static void main(String[] args) throws Exception {
        int numero = randomNumber();
        int tentativas = 0;
        title();
        game(numero, tentativas);
    }

    public static void title() {
        System.out.println("###############");
        System.out.println("ACERTE O NUMERO");
        System.out.println("###############");
    }

    public static void game(int numero, int tentativas) {
        Scanner ler = new Scanner(System.in);

        while(true){
            try {
                System.out.print("Digite um número entre 0 e 100: ");
                int chute = ler.nextInt();

                if(chute > 100 || chute < 0){
                    Thread.sleep(2000);
                    System.out.println("Ops! Apenas números entre 0 e 100. Tente de novo.");
                    Thread.sleep(2000);
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                } else if(chute < numero){
                    Thread.sleep(2000);
                    System.out.println("O número correto é maior que " + chute + "! Tente de novo.");
                    tentativas ++;
                    Thread.sleep(2000);
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                } else if(chute > numero){
                    Thread.sleep(2000);
                    System.out.println("O número correto é menor que " + chute + "! Tente de novo.");
                    tentativas ++;
                    Thread.sleep(2000);
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                } else if(chute == numero){
                    Thread.sleep(2000);
                    System.out.println("PARABÉNS, você acertou em " + tentativas + " tentativas");
                    System.out.println("O número correto é " + numero);
                    Thread.sleep(1000);
                    System.out.print("Deseja jogar novamente: [0- sim  1- não]: ");
                    int opcao = ler.nextInt();
                    if(opcao == 0){
                        Thread.sleep(1500);
                        System.out.println("Reiniciando o jogo...");
                        Thread.sleep(1500);
                        numero = randomNumber();
                        tentativas = 0;
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        title();
                        continue;
                    } else if(opcao == 1){
                        Thread.sleep(1500);
                        System.out.println("Finalizando... ");
                        break;
                    }
                }
                
            } catch (Exception e) {
               System.out.println("O NUMERO TEM QUE SER INTEIRO!");
               break;
            }
            
        }
    }

    public static int randomNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(100);

        return randomNumber;
    }
}
