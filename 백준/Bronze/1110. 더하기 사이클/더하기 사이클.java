import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.next();

        if (number.length() == 1) {
            number = "0" + number;
        }

        int answer = 1;
        String newNumber = makeNewNumber(number);

        while(!number.equals(newNumber)) {
            newNumber = makeNewNumber(newNumber);
            answer++;
        }

        System.out.println(answer);
    }
    public static String makeNewNumber(String number) {
        int sum = 0;
        for (int i = 0; i<number.length(); i++) {
            sum += Character.getNumericValue(number.charAt(i));
        }
        String stringSum = Integer.toString(sum);
        String newValue = String.valueOf(number.charAt(number.length() - 1))
                + stringSum.charAt(stringSum.length() - 1);
        return newValue;
    }
}