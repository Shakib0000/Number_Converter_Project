public class NumberConverter {
    int[] digits;
    int base;

    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            digits[i] = d;
        }
        this.base = base;
    }

    public String displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }
        return o;
    }

    public int[] getDigits() {
        return digits;
    }

    public int[] convertToDecimal() {
        if (base == 2) {
            int num = 0;
            for (int i = 0; i < digits.length; i++) {
                if (digits[i] == 1) {
                    num += (int) Math.pow(2, digits.length - 1 - i);
                }
            }
            String numStr = String.valueOf(num);
            int[] newArray = new int[numStr.length()];
            for (int i = 0; i < newArray.length; i++) {
                newArray[i] = Integer.parseInt(numStr.substring(i, i + 1));
            }
            return newArray;
        }
        if (base == 8) {
            int num = 0;
            for (int i = 0; i < digits.length; i++) {
                num += digits[i] * (int) Math.pow(8, digits.length - 1 - i);
            }
            String numStr = String.valueOf(num);
            int[] newArray = new int[numStr.length()];
            for (int i = 0; i < newArray.length; i++) {
                newArray[i] = Integer.parseInt(numStr.substring(i, i + 1));
            }
            return newArray;
        }
        return null;
    }

    public int[] convertToBinary() {
        if (base == 10) {
            int num = Integer.parseInt(displayOriginalNumber());

            int[] newArray = new int[99999999];
            int counter = 0;

            while (num > 0) {
                newArray[counter] = num % 2;
                num /= 2;
                counter++;
            }
            System.out.print("Binary number: ");
            for (int i = counter - 1; i >= 0; i--) {
                System.out.print(newArray[i]);
            }
            return newArray;
        }
        if (base == 8) {
            int newArray[] = convertToDecimal();
            String str = "";
            for (int i = 0; i < newArray.length; i++) {
                str += String.valueOf(newArray[i]);
            }
            int newNum = Integer.parseInt(str);
            NumberConverter decimalConversion = new NumberConverter(newNum, 10);
            int newArray2[] = decimalConversion.convertToBinary();
        }
        return null;
    }

    public int[] convertToOctal() {
        if (base == 10) {
            int num = Integer.parseInt(displayOriginalNumber());

            int[] newArray = new int[99999999];
            int counter = 0;

            while (num != 0) {
                newArray[counter] = num % 8;
                num /= 8;
                counter++;
            }
            System.out.print("Octal number: ");
            for (int i = counter - 1; i >= 0; i--) {
                System.out.print(newArray[i]);
            }
            return newArray;
        }
        if (base == 2) {
            int newArray[] = convertToDecimal();
            String str = "";
            for (int i = 0; i < newArray.length; i++) {
                str += String.valueOf(newArray[i]);
            }
            int newNum = Integer.parseInt(str);
            NumberConverter decimalConversion = new NumberConverter(newNum, 10);
            int newArray2[] = decimalConversion.convertToOctal();
        }
        return null;
    }
}

