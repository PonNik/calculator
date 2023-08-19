import java.util.Scanner;

public class Main {
    public static String calc(String input) throws Exception {
        ParserString ps = new ParserString(input);

        String[] operands;
        operands = ps.getOperands();
        if (isArabic(operands[0]) && isArabic(operands[1])){
            if (Integer.parseInt(operands[0]) > 0 && Integer.parseInt(operands[0]) <= 10 && Integer.parseInt(operands[1]) > 0 && Integer.parseInt(operands[1]) <= 10) {
                int result = 0;
                switch (operands[2]) {
                    case "+":
                        result = Integer.parseInt(operands[0]) + Integer.parseInt(operands[1]);
                        break;
                    case "-":
                        result = Integer.parseInt(operands[0]) - Integer.parseInt(operands[1]);
                        break;
                    case "*":
                        result = Integer.parseInt(operands[0]) * Integer.parseInt(operands[1]);
                        break;
                    case "/":
                        result = Integer.parseInt(operands[0]) / Integer.parseInt(operands[1]);
                        break;
                }
                return String.valueOf(result);
            }
            else{
                String exc = "The task of working with numbers from 1 to 10 is provided";
                throw new Exception(exc);
            }
        } else if (!isArabic(operands[0]) && !isArabic(operands[1])) {
            if (Roman.parseInt(operands[0]) > 0 && Roman.parseInt(operands[0]) <= 10 && Roman.parseInt(operands[1]) > 0 && Roman.parseInt(operands[1]) <= 10) {
                int result = 0;
                switch (operands[2]) {
                    case "+":
                        result = Roman.parseInt(operands[0]) + Roman.parseInt(operands[1]);
                        break;
                    case "-":
                        result = Roman.parseInt(operands[0]) - Roman.parseInt(operands[1]);
                        break;
                    case "*":
                        result = Roman.parseInt(operands[0]) * Roman.parseInt(operands[1]);
                        break;
                    case "/":
                        result = Roman.parseInt(operands[0]) / Roman.parseInt(operands[1]);
                        break;
                }
                return Roman.parseStr(result);
            }
            else{
                String exc = "The task of working with numbers from I to X is provided";
                throw new Exception(exc);
            }
        }
        else {
            String exc = "Different number systems are used simultaneously";
            throw new Exception(exc);
        }
    }
    public static boolean isArabic(String str) {
        return str.matches("[0-9]+");
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        System.out.println(calc(str));


        // checking numbers for Arabic or Roman
    }
}