package entity;

import java.util.Arrays;

public class BookLendingManagement {
    private BookLending[] bookLendingList = new BookLending[100];

    public BookLending[] getBookLendingList() {
        return bookLendingList;
    }

    public void inputBookLendingList(BookLending bookLending) {
        for (int i = 0; i < bookLendingList.length; i++) {
            if (bookLendingList[i] == null && !checkExistBookLendingInfo(bookLending)) {
                bookLendingList[i] = bookLending;
            }
        }
    }

    public boolean checkExistBookLendingInfo(BookLending bookLending) {
        for (BookLending lending : bookLendingList) {
            if (lending != null && (lending.getReader().getId() == bookLending.getReader().getId())) {
                return true;
            }
        }
        return false;
    }

    public void displayBookLendingList() {
        if (bookLendingList == null) {
            System.out.println("Danh sách đầu sách rỗng");
            return;
        }

        System.out.printf("%-16s | %-16s |%-20s |%-20s |\n", "Tên bạn đọc", "Tên sách", "Số đầu sách đã mượn", "Số sách mỗi đầu sách đã mượn");
        for (BookLending bookLending : bookLendingList) {
            if (bookLending != null) {
                bookLending.displayBorrowList();
            }
        }
    }

    public void displayBookLendingList(BookLending[] bookLendingList) {
        if (bookLendingList == null) {
            System.out.println("Danh sách đầu sách rỗng");
            return;
        }

        System.out.printf("%-16s | %-16s |%-8s |%-8s |\n", "Tên bạn đọc", "Tên sách", "Số đầu sách đã mượn", "Số sách mỗi đầu sách đã mượn");
        for (BookLending bookLending : bookLendingList) {
            if (bookLending != null) {
                bookLending.displayBorrowList();
            }
        }
    }

    public BookLending[] sortBookLendingList() {
        if (bookLendingList == null) {
            System.out.println("Danh sách đầu sách rỗng");
            return null;
        }

        BookLending[] sortBookLendingList = Arrays.copyOf(bookLendingList, bookLendingList.length);

        for (int i = 0; i < sortBookLendingList.length - 1; i++) {
            for (int j = i; j < sortBookLendingList.length; j++) {
                if (sortBookLendingList[i] != null && sortBookLendingList[j] != null) {
                    if (sortBookLendingList[i].getReader().getName().compareTo(sortBookLendingList[j].getReader().getName()) > 0 || sortBookLendingList[i].getNumberOfBorrowBook() < sortBookLendingList[j].getNumberOfBorrowBook())
                        swap(sortBookLendingList, i, j);
                }
            }
        }

        return sortBookLendingList;
    }

    private void swap(BookLending[] bookLendingList, int i, int j) {
        BookLending temp = bookLendingList[i];
        bookLendingList[i] = bookLendingList[j];
        bookLendingList[j] = temp;
    }

    public void displayByReaderName(String readerName) {
        System.out.printf("%-16s | %-16s |%-8s |%-8s |\n", "Tên bạn đọc", "Tên sách", "Số đầu sách đã mượn", "Số sách mỗi đầu sách đã mượn");
        for (int i = 0; i < bookLendingList.length; i++) {
            if (bookLendingList[i] != null && bookLendingList[i].getReader().getName().equals(readerName)) {
                bookLendingList[i].displayBorrowList();
            }
        }
    }
}
