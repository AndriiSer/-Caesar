package �aesar;

import java.io.IOException;
import java.util.Scanner;

public class Controller {

    public static void main(String[] args) throws IOException {
     Decrypt decrypt = new Decrypt();
        System.out.println("������� ���� � ����� � �������� ������ �����");
        Scanner scanner = new Scanner(System.in);
        decrypt.setFileNameInput(scanner.nextLine());
        System.out.println("������� ���� � ����� � ������� ����� ����������");
        decrypt.setFileNameOutput(scanner.nextLine());

        while (true) {
            System.out.println("�������: \n 1 - ���� ����� �����������. \n 2 - ���� ����� ������������ \n 3 - ���� ����� ��������");
            int choosing = scanner.nextInt();
            if (choosing == 1) {
                System.out.println("������� ����");
                decrypt.setShiftKey(scanner.nextInt());
                decrypt.decryptData(decrypt.readFile(decrypt.getFileNameInput()),decrypt.getShiftKey());
                break;
            }
            if (choosing == 2) {
                System.out.println("������� ����");
                decrypt.setShiftKey(scanner.nextInt());
                decrypt.encryptData(decrypt.readFile(decrypt.getFileNameInput()),decrypt.getShiftKey());
                break;
            }
            if (choosing == 3) {
                decrypt.brutalForce(decrypt.readFile(decrypt.getFileNameInput()));
                break;
            } else {
                System.out.println("����������� ����");
            }
        }
    }
}
