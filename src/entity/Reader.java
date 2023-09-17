package entity;

import statics.ReaderType;
import utilities.CheckValidInput;

public class Reader extends Person {
    private static int GLOBAL_ID = 10000;
    private static int MIN_TYPE = 1;
    private static int MAX_TYPE = 3;
    private int id;
    private ReaderType readerType;

    public Reader() {
        this.id = GLOBAL_ID;
        GLOBAL_ID++;
    }

    public int getId() {
        return id;
    }

    public ReaderType getReaderType() {
        return readerType;
    }

    @Override
    public void inputReaderInfo() {
        boolean isInvalidType = true;
        super.inputReaderInfo();

        do {
            displayReaderType();

            int type = CheckValidInput.inputValidNumber(MIN_TYPE, MAX_TYPE);

            switch (type) {
                case 1 -> this.readerType = ReaderType.STUDENT;
                case 2 -> this.readerType = ReaderType.POST_STUDENT;
                case 3 -> this.readerType = ReaderType.TEACHER;
                default -> System.out.println("Loại bạn đọc đã nhập không hợp lệ");
            }

            if (type >= MIN_TYPE && type <= MAX_TYPE) {
                isInvalidType = false;
            }
        } while (isInvalidType);
    }

    public void displayReaderInfo() {
        System.out.printf("%-10s | %-14s | %-16s | %-13s | %-12s |\n", this.id, this.name, this.address, this.address, this.readerType.getType());
    }

    private void displayReaderType() {
        System.out.println("Nhập loại bạn đọc, chọn 1 trong 3 loại sau:");
        System.out.printf("1. %s\n", ReaderType.STUDENT.getType());
        System.out.printf("2. %s\n", ReaderType.POST_STUDENT.getType());
        System.out.printf("3. %s\n", ReaderType.TEACHER.getType());
    }
}
