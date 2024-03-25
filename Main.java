import java.util.Map;
import java.util.Scanner;


public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int result;
    public static void main(String[] args) {
        System.out.println("Введите выражение из двух чисел от 0 до 10, использовать можно как арабские так и римские цифры!");

        String userInput = scanner.nextLine();
        String result = calc(userInput);

    }
    public static String calc(String userInput){
        Map<String, Integer> rimMap = Map.of("I", 1, "II", 2,
                "III", 3, "IV",
                4, "V", 5,
                "VI", 6, "VII", 7,
                "VIII", 8, "IX", 9,
                "X", 10);
        boolean isArabic;

        String[] blacks = userInput.split(" ");
        int len1=userInput.length();
        if(len1>6){
            System.out.println("Некорректное количество символов");
            return userInput;
        } else if(len1<2) {
            System.out.println("Некорректное количество символов");
            return userInput;
        }
        String num1 = blacks[0];
        String oper = blacks[1];
        String num2 = blacks[2];
        Integer arabNum1;
        Integer arabNum2;
        try {
            arabNum1 = Integer.parseInt(num1);
            arabNum2 = Integer.parseInt(num2);
            isArabic = true;

        } catch (Exception exception) {
            arabNum1 = rimMap.get(num1);
            arabNum2 = rimMap.get(num2);
            isArabic = false;

        }
        if (arabNum1 == null || arabNum2 == null||arabNum1>10||arabNum2>10||arabNum1<0||arabNum2<0) {
            throw new RuntimeException("Некорретные символы");
        }

        switch (oper) {
            case "+":
                result = arabNum1 + arabNum2;
                break;
            case "*":
                result = arabNum1 * arabNum2;
                break;
            case "/":
                result = arabNum1 / arabNum2;
                break;
            case "-":
                result = arabNum1 - arabNum2;
                break;
            default:
                throw new RuntimeException("введена не корректная операция");
        }
        if (isArabic) {
            System.out.println(result);
        } else {
            if (result < 1) {
                throw new RuntimeException("В римской системе нет отрицательных значений!");
            }
            StringBuilder resultString = new StringBuilder();
            if (result >= 100) {
                resultString.append("c");
                result = result - 100;
            }
            if (result >= 90) {
                resultString.append("XC");
                result = result - 90;
            }
            if (result >= 50) {
                resultString.append("L");
                result = result - 50;
            }
            if (result >= 40) {
                resultString.append("XL");
                result = result - 40;
            }
            while (result >= 10) {
                resultString.append("X");
                result = result - 10;
            }
            if (result == 9) {
                resultString.append("IX");
                result = result - 9;
            }
            if (result >= 5) {
                resultString.append("V");
                result = result - 5;
            }
            if (result >= 4) {
                resultString.append("IV");
                result = result - 4;
            }
            while (result >= 1) {
                resultString.append("I");
                result = result - 1;
            }
            System.out.println(resultString);


        }


        return userInput;
    }
}
