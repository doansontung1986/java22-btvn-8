package utilities;

import java.util.Scanner;

public class CheckValidInput {

    public static boolean isValidNumeric(String numberStr) {
        if (numberStr == null) {
            return false;
        }

        try {
            Double.parseDouble(numberStr);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return true;
    }

    public static int inputValidNumber() {
        String numberStr;
        do {
            System.out.print("Nhập 1 số nguyên: ");
            numberStr = new Scanner(System.in).nextLine();

            if (!isValidNumeric(numberStr)) {
                PrintMessage.printErrorMessage();
            }

        } while (!isValidNumeric(numberStr));

        return (int) Double.parseDouble(numberStr);
    }

    public static int inputValidNumber(int minChoiceNumber, int maxChoiceNumber) {
        String choiceStr;
        do {
            System.out.print("Nhập 1 số nguyên: ");
            choiceStr = new Scanner(System.in).nextLine();

            if (!isValidNumeric(choiceStr)) {
                PrintMessage.printErrorMessage(minChoiceNumber, maxChoiceNumber);
                continue;
            }

            if (!(Double.parseDouble(choiceStr) >= minChoiceNumber && Double.parseDouble(choiceStr) <= maxChoiceNumber)) {
                PrintMessage.printErrorMessage(minChoiceNumber, maxChoiceNumber);
            }

        } while (!isValidNumeric(choiceStr) || !(Double.parseDouble(choiceStr) >= minChoiceNumber && Double.parseDouble(choiceStr) <= maxChoiceNumber));

        return (int) Double.parseDouble(choiceStr);
    }
}
