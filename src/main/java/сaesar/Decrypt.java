package ñaesar;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Decrypt {

    private static final char[] ALPHABET = new char[]{'À', 'Á', 'Â', 'Ã', 'Ä', 'Å', '¨', 'Æ', 'Ç', 'È', 'É', 'Ê', 'Ë',
            'Ì', 'Í', 'Î', 'Ï', 'Ð', 'Ñ', 'Ò', 'Ó', '×', 'Ö', '×', 'Ø', 'Ù', 'Ú', 'Û',
            'Ü', 'Ý', 'Þ', 'ß', 'à', 'á', 'â', 'ã', 'ä', 'å', '¸', 'æ', 'ç', 'è', 'é',
            'ê', 'ë', 'ì', 'í', 'î', 'ï', 'ð', 'ñ', 'ò', 'ó', 'õ', 'ö', '÷', 'ø', 'ù',
            'ú', 'û', 'ü', 'ý', 'þ', 'ÿ', '.', ',', '”', ':', '-', '/', '?', ' '}; //72

    private String inPutFile;

    private String encryptString;

  //  private final List<char[]> ALPHABET_LIST = Collections.singletonList(ALPHABET);

    public String InputNewFile(String inPutFile) throws IOException {
        Decrypt decrypt = new Decrypt();

        File file = new File(Controller.getInp());
        Scanner scanner1 = new Scanner(file);

        StringBuilder inPutFile1 = new StringBuilder(scanner1.nextLine());
        while (scanner1.hasNextLine()) {
            inPutFile1 = new StringBuilder(inPutFile1 + "\n" + scanner1.nextLine());
        }
        scanner1.close();

        decrypt.inPutFile = inPutFile1.toString();
        return decrypt.inPutFile;
    }


    public void write(String result) throws IOException{

        BufferedWriter writer = new BufferedWriter(new FileWriter(Controller.getOut()));

        writer.write(result);

        writer.close();
    }


    private String encryptData(String inputStr, int shiftKey) {
        String alphabet = String.valueOf(ALPHABET);
        StringBuilder encryptStr = new StringBuilder("");

        for (int i = 0; i < inputStr.length(); i++) {

            int pos = alphabet.indexOf(inputStr.charAt(i));
            int encryptPos = (shiftKey + pos) % 72;
            char encryptChar = alphabet.charAt(encryptPos);

            encryptStr.append(encryptChar);
        }
        encryptString = encryptStr.toString();
        return encryptString;

    }


    private @NotNull StringBuilder decryptData(String inputStr, int shiftKey) {
        String alphabet = String.valueOf(ALPHABET);
        StringBuilder decryptStr = new StringBuilder("");

        for (int i = 0; i < inputStr.length(); i++) {

            int pos = alphabet.indexOf(inputStr.charAt(i));


            int decryptPos = (pos - shiftKey) % 72;

            if (decryptPos < 0) {
                decryptPos = alphabet.length() + decryptPos;
            }
            char decryptChar = alphabet.charAt(decryptPos);


            decryptStr.append(decryptChar);
        }
        return decryptStr;
    }

    private void brutalForce(String inputStr) {

        String alphabet = String.valueOf(ALPHABET);
        TreeMap<Integer, String> brutalForceMap = new TreeMap<>();

        for (int key = 0; key < 72; key++) {
            StringBuilder encryptStr = new StringBuilder("");
            for (int i = 0; i < inputStr.length(); i++) {

                int poses = alphabet.indexOf(inputStr.charAt(i));
                    int encryptPoses = (key + poses) % 72;
                if (encryptPoses < 0) {
                    encryptPoses = alphabet.length() + encryptPoses;
                }

                char encryptChar = alphabet.charAt(encryptPoses);

                encryptStr.append(encryptChar);
            }
            encryptString = encryptStr.toString();
            brutalForceMap.put(key, encryptString);
        }
        for (Map.Entry<Integer, String> entry: brutalForceMap.entrySet()){
            int index2 = entry.getValue().indexOf(". ");
            int index3 = entry.getValue().indexOf(", ");

            if(index2 > 0 && index3 > 0) {
                System.out.println("key " + entry.getKey() + " = " + entry.getValue());
            }
        }
    }
}