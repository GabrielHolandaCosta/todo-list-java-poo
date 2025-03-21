import java.util.Scanner;

public class Util {
    private static final Scanner scanner = new Scanner(System.in);

    public static int lerInteiro(String mensagem) {
        int valor;
        while (true) {
            System.out.print(mensagem);
            if (scanner.hasNextInt()) {
                valor = scanner.nextInt();
                scanner.nextLine(); // consumir a quebra de linha
                return valor;
            } else {
                System.out.println("Valor inválido! Por favor, insira um número inteiro.");
                scanner.nextLine(); // limpar o buffer
            }
        }
    }

    public static String lerString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }
}
