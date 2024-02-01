public class NumberConverter {
    int[] digits;
    int base;
    String[] acceptedNumberInputs;

    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            digits[i] = d;
        }
        this.base = base;
        acceptedNumberInputs = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "+", "/"};
    }

    public boolean validBase(){
        return base >= 1 && base <= 64;
    }

    public boolean validNumber() {
        String[] validNumbers = new String[base];
        for (int i = 0; i < validNumbers.length; i++) {
            validNumbers[i] = acceptedNumberInputs[i];
        }
        for (int digit : digits) {
            boolean isValidNumber = false;
            for (String number : validNumbers) {
                if (Integer.parseInt(number) == digit) {
                    isValidNumber = true;
                }
            }
            if (!isValidNumber) {
                return false;
            }
        }
        return true;
    }

    public int[] numToArray(String numberAsString){
        int[] numArray = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String digit = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(digit);
            numArray[i] = d;
        }
        return numArray;
    }

    public int arrayToNum(int[] numArray) {
        String numStr = "";
        for (int num : numArray) {
            numStr += num;
        }
        return Integer.parseInt(numStr);
    }

    public String arrayToStr(String[] numArray) {
        String str = "";
        for (String num : numArray) {
            str += num;
        }
        return str;
    }

    public String arrayToStr2(int[] numArray) {
        String str = "";
        for (int num : numArray) {
            str += String.valueOf(num);
        }
        return str;
    }

    public String reverseStr(String str) {
        String newStr = "";
        for (int i = str.length(); i > 0; i--) {
            newStr += str.substring(i-1, i);
        }
        return newStr;
    }

    public int[] getDigits() {
        return digits;
    }

    public void setDigits(int[] digits) {
        this.digits = digits;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int[] convertToDecimal() {
        int num = 0;
        for (int i = 0; i < digits.length; i++){
            num += (int) (digits[i] * Math.pow(base, digits.length - i - 1));
        }
        return numToArray(String.valueOf(num));
    }

    public int[] convertToBinary() {
        int decimalConversion = arrayToNum(convertToDecimal());
        String num = "";
        int remainder = 0;
        while (decimalConversion != 0){
            remainder = decimalConversion % 2;
            num += remainder;
            decimalConversion /= 2;
        }
        String[] strArray = reverseStr(num).split("");
        int[] intArray = new int[strArray.length];
        for (int i = 0; i < intArray.length; i++){
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        return intArray;
    }

    public int[] convertToOctal() {
        int decimalConversion = arrayToNum(convertToDecimal());
        String num = "";
        int remainder = 0;
        while (decimalConversion != 0){
            remainder = decimalConversion % 8;
            num += remainder;
            decimalConversion /= 8;
        }
        String[] strArray = reverseStr(num).split("");
        int[] intArray = new int[strArray.length];
        for (int i = 0; i < intArray.length; i++){
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        return intArray;
    }

    public String[] convertToHex() {
        int decimalConversion = arrayToNum(convertToDecimal());
        String num = "";
        int remainder = 0;
        while (decimalConversion != 0){
            remainder = decimalConversion % 16;
            num += acceptedNumberInputs[remainder];
            decimalConversion /= 16;
        }
        String[] strArray = reverseStr(num).split("");
        return strArray;
    }

    public String[] convertFrom1To64(int base){
        int decimalConversion = arrayToNum(convertToDecimal());
        String num = "";
        int remainder = 0;
        while (decimalConversion != 0){
            remainder = decimalConversion % base;
            num += acceptedNumberInputs[remainder];
            decimalConversion /= base;
        }
        String[] strArray = reverseStr(num).split("");
        return strArray;
    }

}