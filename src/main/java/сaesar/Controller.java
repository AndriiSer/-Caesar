package �aesar;

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
        System.out.println("������� ���� � ����� � �������� ������ �����");
        Scanner scanner = new Scanner(System.in);
        inp = scanner.nextLine();
        decrypt.InputNewFile(inp);
        System.out.println("������� ���� � ����� � ������� ����� ����������");
        out = scanner.nextLine();
        decrypt.write(out);
        while (true) {
            System.out.println("�������: \n 1 - ���� ����� �����������. \n 2 - ���� ����� ������������ \n 3 - ���� ����� ��������");
            int choosing = scanner.nextInt();
            if (choosing == 1) {

            }
            if (choosing == 2) {

            }
            if (choosing == 3) {

            } else {
                System.out.println("����������� ����");
            }
        }
    }
}
