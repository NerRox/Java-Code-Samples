package SimpleTasks;

import java.util.Scanner;
import java.io.File;

@SuppressWarnings("ALL")
public class Converter {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
//        System.out.println(busCrash(211, new int[] {465, 453, 981, 463, 1235, 871, 475, 981}));
//        System.out.println(busCrash(211, new int[] {871, 205, 123, 871, 1681}));
//        System.out.println(autg("acggtgttat"));
//        System.out.println(isPasswordStrengthOK("Password1234"));

//        System.out.println(xmlToJson("<jdk>1.8.9</jdk>"));
//        System.out.println(xmlToJson("<tagger/>"));
//        System.out.println(jsonToXml("{\"success\": null }"));
//        System.out.println(xmlToJson("<host>127.0.0.1</host>"));
//        System.out.println(jsonToXml("{\"jdk\" : \"1.8.9\"}"));


//        String toConvert = scanner.nextLine();
//
//        if (toConvert.startsWith("<")) {
//            System.out.println(xmlToJson(toConvert));
//        }
//
//        if (toConvert.startsWith("{")) {
//            System.out.println(jsonToXml(toConvert));
//        }


//        Проверка путей на абсолютность и полчуение абсолютного пути.
        File f = new File("C:\\Go");
        f.isAbsolute();
        f.getAbsolutePath();

//        Получение пути, имени файла и родительского пути
        String path1 = f.getPath();
        String name = f.getName();
        String parent = f.getParent();
    }

    public static String busCrash(int busHeight, int[] bridges) {
        int index = -1;
        for (int j = 0; j < bridges.length; j++) {
            if (bridges[j] <= busHeight) {
                index = j;
                break;
            }
        }
        if (index == -1)
            return "Will not crash";
        else
            return "Will crash on bridge " + (index + 1);
    }

    public static double autg (String input) {
        String input1 = input.toLowerCase();
        int strLen = input.length();

        int cAndG = 0;

        for (char ch : input1.toCharArray()) {
            if (ch == 'c') {
                cAndG++;
            }

            if (ch ==  'g') {
                cAndG++;
            }
        }
        double perCent = (double) cAndG/strLen;
        return perCent * 100;
    }

    public static boolean isPasswordStrengthOK(String password) {
        return password.length() >= 12
                & password.matches(".*[0-9]+.*")
                & password.matches(".*[A-Z]+.*")
                & password.matches(".*[a-z]+.*");
    }

    //    TODO Завершить xmlToJson конвертер
    public static String xmlToJson(String xml) {
        String tag = "";

        if (xml.endsWith("/>")) {
            tag = xml.substring(1,xml.length() - 2);
            return "{\""+ tag + "\": null }";
        }

        int i = 0;
        for (char ch : xml.toCharArray()) {
            i++;
            if (ch == '>') {
                tag = xml.substring(1, i-1);
                break;
            }
        }

        xml = xml.replaceAll(tag, "")
                .replaceAll("<", "")
                .replaceAll(">","");
        xml = xml.substring(0, xml.length()-1);

        return "{\"" + tag + "\":\"" + xml + "\"}";
    }
    //    TODO Завершить jsonToXml конвертер
    public static String jsonToXml(String json) {
        if (json.contains("null")) {
            String tag = json.substring(2, json.length() - 9);
            return "<" + tag + "/>";
        }

        int j = 0;
        String key = "";
        String value = "";
        for (char cha : json.toCharArray()) {
            j++;
            if (cha == ':') {
                key = json.substring(2, j-3);
                value = json.substring(j+2, json.length()-2);
                break;
            }
        }

        return "<" + key + ">" + value + "</" + key + ">";
    }
}