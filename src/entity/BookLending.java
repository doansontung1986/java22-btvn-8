package entity;

import utilities.CheckValidInput;

import java.util.Scanner;

public class BookLending {
    private static final int NUMBER_OF_BOOK_COVER = 5;
    private Reader reader;
    private Book[] borrowBookCoverList = new Book[NUMBER_OF_BOOK_COVER];
    private int[] numberOfBookEachCoverList = new int[NUMBER_OF_BOOK_COVER];
    private String[] borrowStatusList = new String[NUMBER_OF_BOOK_COVER];

    public Reader getReader() {
        return reader;
    }

    public int getNumberOfBorrowBook() {
        return borrowBookCoverList.length * numberOfBookEachCoverList.length;
    }

    public Book[] getBorrowBookCoverList() {
        return borrowBookCoverList;
    }

    public int[] getNumberOfBookEachCoverList() {
        return numberOfBookEachCoverList;
    }

    public BookLending borrowBook(Reader[] readerList, Book[] bookList) {
        System.out.println("Nhập mã bạn đọc ");
        int readerId = CheckValidInput.inputValidNumber();
        this.reader = findReader(readerList, readerId);
        if (this.reader == null) {
            System.out.println("Mã người đọc không tồn tại");
            return null;
        }

        System.out.println("Nhập đầu sách ");
        String bookName = new Scanner(System.in).nextLine();
        Book book = findBookName(bookList, bookName);

        if (book == null) {
            System.out.println("Mã sách không tồn tại");
            return null;
        }

        System.out.println("Nhập số sách muốn mượn ");
        int quantity = CheckValidInput.inputValidNumber(1, 3);

        System.out.println("Nhập tình trạng của đầu sách ");
        String status = new Scanner(System.in).nextLine();

        for (int i = 0; i < borrowBookCoverList.length; i++) {
            if (borrowBookCoverList[i] == null) {
                if (!checkBookExistInBorrowList(book.getBookName())) {
                    borrowBookCoverList[i] = book;
                    borrowStatusList[i] = status;
                }

                if (numberOfBookEachCoverList[i] + quantity <= 3) {
                    numberOfBookEachCoverList[i] += quantity;
                } else {
                    System.out.println("Không thể mượn quá 3 cuốn sách cho mỗi đầu sách");
                    return null;
                }
                return this;
            } else {
                System.out.println("Chỉ có thể mượn tối đa 5 đầu sách");
                return null;
            }
        }

        return null;
    }

    public void displayBorrowList() {
        for (int i = 0; i < borrowBookCoverList.length; i++) {
            if (borrowBookCoverList[i] != null) {
                System.out.printf("%-16s | %-16s |%-20s |%-20s |\n", this.reader.getName(), borrowBookCoverList[i].getBookName(), numberOfBookEachCoverList[i], borrowStatusList[i]);
            }
        }
    }

    private boolean checkBookExistInBorrowList(String bookName) {
        for (Book book : this.borrowBookCoverList) {
            if (book != null && book.getBookName().equals(bookName)) {
                return true;
            }
        }
        return false;
    }

    private Reader findReader(Reader[] readerList, int readerId) {
        for (Reader reader : readerList) {
            if (reader.getId() == readerId) {
                return reader;
            }
        }
        return null;
    }

    private Book findBookName(Book[] bookList, String bookName) {
        for (Book book : bookList) {
            if (book.getBookName().equals(bookName)) {
                return book;
            }
        }
        return null;
    }
}
