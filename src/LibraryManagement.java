import entity.BookLending;
import entity.BookLendingManagement;
import entity.BookListManagement;
import utilities.CheckValidInput;
import entity.ReaderListManagement;

import java.util.Scanner;

public class LibraryManagement {
    public static final int MIN_CHOICE_NUMBER = 0;
    public static final int MAX_CHOICE_NUMBER = 8;

    public static void main(String[] args) {
        inputChoice();
    }

    public static void displayMenu() {
        System.out.println("---------------------------------");
        System.out.println("1. Nhập danh sách bạn đọc mới");
        System.out.println("2. In danh sách bạn đọc");
        System.out.println("3. Nhập đầu sách mới");
        System.out.println("4. In danh sách các đầu sách");
        System.out.println("5. Đăng ký mượn sách");
        System.out.println("6. In danh sách bạn đọc đã mượn sách");
        System.out.println("7. In danh sách bạn đọc đã mượn sách theo tên và số lượng giảm dần");
        System.out.println("8. Tìm kiếm và hiển thị danh sách mượn sách theo tên bạn đọc");
        System.out.println("0. Thoát chương trình");
        System.out.println("---------------------------------");
    }

    private static void inputChoice() {
        int choice;
        boolean isNotExit = true;
        ReaderListManagement readerListManagement = new ReaderListManagement();
        BookListManagement bookListManagement = new BookListManagement();
        BookLendingManagement bookLendingManagement = new BookLendingManagement();
        do {
            displayMenu();
            choice = CheckValidInput.inputValidNumber(MIN_CHOICE_NUMBER, MAX_CHOICE_NUMBER);
            switch (choice) {
                case 0 -> {
                    isNotExit = false;
                    System.out.println("Hẹn gặp lại");
                }
                case 1 -> readerListManagement.inputReaderList();
                case 2 -> readerListManagement.displayReaderList();
                case 3 -> bookListManagement.inputBookList();
                case 4 -> bookListManagement.displayBookList();
                case 5 -> {
                    BookLending bookLending;
                    if (readerListManagement.getReaderList() != null && bookListManagement.getBookList() != null) {
                        bookLending = new BookLending().borrowBook(readerListManagement.getReaderList(), bookListManagement.getBookList());
                        if (bookLending != null) {
                            bookLendingManagement.inputBookLendingList(bookLending);
                        }
                    } else {
                        System.out.println("Danh sách bạn đọc hoặc danh sách đầu sách rỗng");
                    }
                }
                case 6 -> {
                    if (readerListManagement.getReaderList() != null && bookListManagement.getBookList() != null) {
                        bookLendingManagement.displayBookLendingList();
                    } else {
                        System.out.println("Danh sách bạn đọc hoặc danh sách đầu sách rỗng");
                    }
                }

                case 7 -> {
                    BookLending[] sortBookLending = bookLendingManagement.sortBookLendingList();
                    bookLendingManagement.displayBookLendingList(sortBookLending);
                }
                case 8 -> {
                    System.out.println("Nhập tên bạn đọc cần tìm");
                    String readerName = new Scanner(System.in).nextLine();
                    bookLendingManagement.displayByReaderName(readerName);
                }
                default -> {
                    System.out.println("Lựa chọn không hợp lệ");
                    System.out.printf("Vui lòng nhập chữ số nguyên từ %d đến %d\n", MIN_CHOICE_NUMBER, MAX_CHOICE_NUMBER);
                }
            }
        } while (isNotExit);
    }
}
