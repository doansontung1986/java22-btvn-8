package utilities;

public class PrintMessage {
    public static void printErrorMessage() {
        System.out.println("Vui lòng nhập chữ số nguyên");
    }

    public static void printErrorMessage(int minChoiceNumber, int maxChoiceNumber) {
        System.out.printf("Vui lòng nhập chữ số nguyên từ %d đến %d\n", minChoiceNumber, maxChoiceNumber);
    }
}
