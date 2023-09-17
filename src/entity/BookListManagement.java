package entity;

import utilities.CheckValidInput;

import java.util.Arrays;

public class BookListManagement {
    private Book[] bookList;

    public Book[] getBookList() {
        return bookList;
    }

    public void inputBookList() {
        System.out.println("Nhập số lượng đầu sách mới");
        int inputNumber = CheckValidInput.inputValidNumber();

        if (bookList == null) {
            bookList = new Book[inputNumber];
        } else {
            int numberOfReader = bookList.length + inputNumber;
            bookList = Arrays.copyOf(bookList, numberOfReader);
        }

        for (int i = 0; i < bookList.length; i++) {
            if (bookList[i] == null) {
                System.out.printf("Nhập đầu sách thứ %d\n", (i + 1));
                bookList[i] = new Book();
                bookList[i].inputBookInfo();
            }
        }
    }

    public void displayBookList() {
        if (bookList == null) {
            System.out.println("Danh sách đầu sách rỗng");
            return;
        }

        System.out.printf("%-8s | %-20s | %-20s | %-24s | %-16s |\n", "Mã sách", "Tên sách", "Tác giả", "Chuyên ngành", "Năm xuất bản");
        for (Book book : bookList) {
            if (book != null) {
                book.displayBookInfo();
            }
        }
    }
}
