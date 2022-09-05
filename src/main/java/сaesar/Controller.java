package сaesar;

import java.io.IOException;
import java.util.Scanner;

public class Controller {

    public static void main(String[] args) throws IOException {
     Decrypt decrypt = new Decrypt();
        System.out.println("Введите путь к файлу с которого читать текст");
        Scanner scanner = new Scanner(System.in);
        decrypt.setFileNameInput(scanner.nextLine());
        System.out.println("Введите путь к файлу в который будем записывать");
        decrypt.setFileNameOutput(scanner.nextLine());

        while (true) {
            System.out.println("Введите: \n 1 - Если нужно зашифровать. \n 2 - Если нужно розшифровать \n 3 - Если нужно взломать");
            int choosing = scanner.nextInt();
            if (choosing == 1) {
                System.out.println("Введите ключ");
                decrypt.setShiftKey(scanner.nextInt());
                decrypt.decryptData(decrypt.readFile(decrypt.getFileNameInput()),decrypt.getShiftKey());
                break;
            }
            if (choosing == 2) {
                System.out.println("Введите ключ");
                decrypt.setShiftKey(scanner.nextInt());
                decrypt.encryptData(decrypt.readFile(decrypt.getFileNameInput()),decrypt.getShiftKey());
                break;
            }
            if (choosing == 3) {
                decrypt.brutalForce(decrypt.readFile(decrypt.getFileNameInput()));
                break;
            } else {
                System.out.println("Некоректный ввод");
            }
        }
    }
}
