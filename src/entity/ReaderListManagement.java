package entity;

import utilities.CheckValidInput;

import java.util.Arrays;

public class ReaderListManagement {
    private Reader[] readerList;

    public Reader[] getReaderList() {
        return readerList;
    }

    public void inputReaderList() {
        System.out.println("Nhập số lượng bạn đọc mới");
        int inputNumber = CheckValidInput.inputValidNumber();

        if (readerList == null) {
            readerList = new Reader[inputNumber];
        } else {
            int numberOfReader = readerList.length + inputNumber;
            readerList = Arrays.copyOf(readerList, numberOfReader);
        }

        for (int i = 0; i < readerList.length; i++) {
            if (readerList[i] == null) {
                System.out.printf("Nhập bạn đọc thứ %d\n", (i + 1));
                readerList[i] = new Reader();
                readerList[i].inputReaderInfo();
            }
        }
    }

    public void displayReaderList() {
        if (readerList == null) {
            System.out.println("Danh sách bạn đọc rỗng");
            return;
        }

        System.out.printf("%-10s | %-14s | %-16s | %-13s | %-12s |\n", "Mã bạn đọc", "Họ tên", "Địa chỉ", "Số điện thoại", "Loại bạn đọc");
        for (Reader reader : readerList) {
            if (reader != null) {
                reader.displayReaderInfo();
            }
        }
    }
}
