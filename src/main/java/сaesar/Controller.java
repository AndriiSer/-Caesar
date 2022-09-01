package сaesar;

import java.io.IOException;
import java.util.Scanner;

public class Controller {
    private static String inp;

    private static String out;

    public static String getInp() {
        return inp;
    }

    public static String getOut() {
        return out;
    }

    public static void main(String[] args) throws IOException {
     Decrypt decrypt = new Decrypt();
        System.out.println("Введите путь к файлу с которого читать текст");
        Scanner scanner = new Scanner(System.in);
        inp = scanner.nextLine();
        decrypt.InputNewFile(inp);
        System.out.println("Введите путь к файлу в который будем записывать");
        out = scanner.nextLine();
        decrypt.write(out);
        while (true) {
            System.out.println("Введите: \n 1 - Если нужно зашифровать. \n 2 - Если нужно розшифровать \n 3 - Если нужно взломать");
            int choosing = scanner.nextInt();
            if (choosing == 1) {

            }
            if (choosing == 2) {

            }
            if (choosing == 3) {

            } else {
                System.out.println("Некоректный ввод");
            }
        }
    }
}
