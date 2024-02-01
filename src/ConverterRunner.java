import java.util.Locale;
import java.util.Scanner;

class ConverterRunner {

    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Pick an option:\n(A) Choose a base of 2, 8, 10, or 16 for your number and convert it to the other three bases\n(B) Choose a base 10 number and convert it to any base from 1-64\n");

        Scanner s = new Scanner(System.in);
        String choice = s.nextLine().toUpperCase();
        while (!choice.equals("A") && !choice.equals("B")) {
            System.out.print("Invalid input. Pick an option:\n(A) Choose a base of 2, 8, 10, or 16 for your number and convert it to the other three bases\n(B) Choose a base 10 number and convert it to any base from 1-64");
            choice = s.nextLine().toUpperCase();
        }

        if (choice.equals("A")) {
            System.out.print("You can choose the bases 2, 8, 10, or 16. Which do you choose: ");
            choice = s.nextLine();
            int base = Integer.parseInt(choice);

            System.out.print("\nGreat, now pick a number in base " + base + ": ");
            choice = s.nextLine();
            int number = Integer.parseInt(choice);

            NumberConverter numberConverter = new NumberConverter(number, base);
            while (!numberConverter.validBase() || !numberConverter.validNumber()) {
                System.out.print("\nSeems like either the base or number you inputted was invalid. Try again.\nYou can choose the bases 2, 8, 10, or 16. Which do you choose: ");
                choice = s.nextLine();
                base = Integer.parseInt(choice);

                System.out.print("\nGreat, now pick a number in base " + base + ": ");
                choice = s.nextLine();
                number = Integer.parseInt(choice);
                numberConverter = new NumberConverter(base, number);
            }
            if (base == 2) {
                System.out.println("Base 8: " + numberConverter.arrayToNum(numberConverter.convertToOctal()));
                System.out.println("Base 10: " + numberConverter.arrayToNum(numberConverter.convertToDecimal()));
                System.out.println("Base 16: " + numberConverter.arrayToStr(numberConverter.convertToHex()));
            }
            else if (base == 8) {
                System.out.println("Base 2: " + numberConverter.arrayToNum(numberConverter.convertToBinary()));
                System.out.println("Base 10: " + numberConverter.arrayToNum(numberConverter.convertToDecimal()));
                System.out.println("Base 16: " + numberConverter.arrayToStr(numberConverter.convertToHex()));
            }
            else if (base == 10) {
                System.out.println("Base 2: " + numberConverter.arrayToNum(numberConverter.convertToBinary()));
                System.out.println("Base 8: " + numberConverter.arrayToNum(numberConverter.convertToOctal()));
                System.out.println("Base 16: " + numberConverter.arrayToStr(numberConverter.convertToHex()));
            }
            else if (base == 16) {
                System.out.println("Base 2: " + numberConverter.arrayToNum(numberConverter.convertToBinary()));
                System.out.println("Base 8: " + numberConverter.arrayToNum(numberConverter.convertToOctal()));
                System.out.println("Base 10: " + numberConverter.arrayToNum(numberConverter.convertToDecimal()));
            }
            else {
                System.out.println("You picked a valid base and valid number in that base but it wasn't in base 2, 8, 10, or 16..");
            }
        }

        if (choice.equals("B")) {
            System.out.print("Choose a base from 1-64: ");
            choice = s.nextLine();
            int base = Integer.parseInt(choice);

            System.out.print("\nGreat, now pick a number in base 10: ");
            choice = s.nextLine();
            int number = Integer.parseInt(choice);

            NumberConverter numberConverter = new NumberConverter(number, 10);
            while (base < 1 || base > 64) {
                System.out.print("\nSeems like the base you entered was invalid, enter a base from 1-64: ");
                choice = s.nextLine();
                base = Integer.parseInt(choice);
                numberConverter = new NumberConverter(base, number);
            }
            System.out.println("Base " + base + ": " + numberConverter.arrayToStr(numberConverter.convertFrom1To64(base)));
        }
    }
}

