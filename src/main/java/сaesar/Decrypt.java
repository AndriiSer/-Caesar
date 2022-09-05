package ñaesar;


import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Decrypt {
    private static final char[] ALPHABET = new char[]{'À', 'Á', 'Â', 'Ã', 'Ä', 'Å', '¨', 'Æ', 'Ç', 'È', 'É',
            'Ê', 'Ë', 'Ì', 'Í', 'Î', 'Ï', 'Ð', 'Ñ', 'Ò', 'Ó', '×', 'Ö', '×', 'Ø', 'Ù',
            'Ú', 'Û', 'Ü', 'Ý', 'Þ', 'ß', 'à', 'á', 'â', 'ã', 'ä', 'å', '¸', 'æ', 'ç',
            'è', 'é', 'ê', 'ë', 'ì', 'í', 'î', 'ï', 'ð', 'ñ', 'ò', 'ó', 'õ', 'ö', '÷',
            'ø', 'ù', 'ú', 'û', 'ü', 'ý', 'þ', 'ÿ', '.', ',', '”', ':', '-', '/', '?', ' '}; //72
    private String fileNameInput;
    private String fileNameOutput;
    private String outputString;
    private int shiftKey;

    public String getFileNameInput() {
        return fileNameInput;
    }

    public void setFileNameInput(String fileNameInput) {
        this.fileNameInput = fileNameInput;
    }

    public void setFileNameOutput(String fileNameOutput) {
        this.fileNameOutput = fileNameOutput;
    }

    public void setShiftKey(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    public int getShiftKey() {
        return shiftKey;
    }

    String readFile(String fileNameInput) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileNameInput))) {
            StringBuilder inputString = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                inputString.append(line).append(System.lineSeparator());
            }

            return inputString.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeFile(String fileNameOutput, String result) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileNameOutput));
        writer.write(result);
        writer.close();
    }

    void encryptData(String inputString, int shiftKey) throws IOException {
        String alphabet = String.valueOf(ALPHABET);
        StringBuilder encryptStr = new StringBuilder("");
        for (int i = 0; i < inputString.length(); i++) {
            int pos = alphabet.indexOf(inputString.charAt(i));
            int encryptPos = (shiftKey + pos) % 72;
            char encryptChar = alphabet.charAt(encryptPos);
            encryptStr.append(encryptChar);
        }

        outputString = encryptStr.toString();
        writeFile(fileNameOutput, outputString);
    }

    void decryptData(String inputStr, int shiftKey) throws IOException {
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

        outputString = decryptStr.toString();
        writeFile(fileNameOutput, outputString);
    }

    void brutalForce(String inputStr) throws IOException {
        String alphabet = String.valueOf(ALPHABET);
        TreeMap<Integer, String> brutalForceMap = new TreeMap<>();
        Decrypt decrypt = new Decrypt();
        for (int shiftKey = 0; shiftKey < 72; shiftKey++) {
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
            brutalForceMap.put(shiftKey, String.valueOf(decryptStr));

        }
        for (Map.Entry<Integer, String> entry : brutalForceMap.entrySet()) {
            int index2 = entry.getValue().indexOf(". ");
            int index3 = entry.getValue().indexOf(", ");
            if (index2 > 0 && index3 > 0) {
                writeFile(fileNameOutput, entry.getValue());
                System.out.println("key " + entry.getKey() + " = " + entry.getValue());
            }
        }
    }
}