import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8 or 10): ");

        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        while (!choice.equals("2") && !choice.equals("8") && !choice.equals("10")) {
            System.out.print("Invalid input. Enter the base of your number (2, 8 or 10): ");
            choice = s.nextLine();
        }
        int base = Integer.parseInt(choice);
        System.out.print("Enter your number: ");
        String number = s.nextLine();
        if (base == 2) {
            boolean pass = false;
            while (!pass) {
                pass = true;
                for (int i = 0; i < number.length(); i++) {
                    if (!number.substring(i, i + 1).equals("0") && !number.substring(i, i + 1).equals("1"))  {
                        pass = false;
                    }
                }
                if (!pass) {
                    System.out.print("Invalid input, enter your number in base 2: ");
                    number = s.nextLine();
                }
            }
        }
        if (base == 8) {
            boolean pass = false;
            while (!pass) {
                pass = true;
                for (int i = 0; i < number.length(); i++) {
                    if (!number.substring(i, i + 1).equals("0") && !number.substring(i, i + 1).equals("1") && !number.substring(i, i + 1).equals("2") && !number.substring(i, i + 1).equals("3") && !number.substring(i, i + 1).equals("4") && !number.substring(i, i + 1).equals("5") && !number.substring(i, i + 1).equals("6") && !number.substring(i, i + 1).equals("7"))  {
                        pass = false;
                    }
                }
                if (!pass) {
                    System.out.print("Invalid input, enter your number in base 8: ");
                    number = s.nextLine();
                }
            }
        }
        if (base == 10) {
            boolean pass = false;
            while (!pass) {
                pass = true;
                for (int i = 0; i < number.length(); i++) {
                    if (!number.substring(i, i + 1).equals("0") && !number.substring(i, i + 1).equals("1") && !number.substring(i, i + 1).equals("2") && !number.substring(i, i + 1).equals("3") && !number.substring(i, i + 1).equals("4") && !number.substring(i, i + 1).equals("5") && !number.substring(i, i + 1).equals("6") && !number.substring(i, i + 1).equals("7") && !number.substring(i, i + 1).equals("8") && !number.substring(i, i + 1).equals("9"))  {
                        pass = false;
                    }
                }
                if (!pass) {
                    System.out.print("Invalid input, enter your number in base 10: ");
                    number = s.nextLine();
                }
            }
        }
        int n = Integer.parseInt(number);

        s.close();

        NumberConverter nc = new NumberConverter(n, base);
        if (base == 2) {
            int newArray[] = nc.convertToDecimal();
            System.out.println("\n");
            System.out.print("Decimal number: ");
            for (int i = 0; i < newArray.length; i++) {
                System.out.print(newArray[i]);
            }
            System.out.println("\n");
            nc.convertToOctal();
        }
        else if (base == 8) {
            int newArray[] = nc.convertToDecimal();
            System.out.println("\n");
            System.out.print("Decimal number: ");
            for (int i = 0; i < newArray.length; i++) {
                System.out.print(newArray[i]);
            }
            System.out.println("\n");
            nc.convertToBinary();
        }
        else {
            System.out.println("\n");
            nc.convertToBinary();
            System.out.println("\n");
            nc.convertToOctal();
        }
    }
}

