package entity;

import statics.BookCategory;
import utilities.CheckValidInput;

import java.util.Scanner;

public class Book {
    private static int GLOBAL_BOOK_ID = 1000;
    private static int MIN_TYPE = 1;
    private static int MAX_TYPE = 4;

    private static int MIN_PUBLISHED_YEAR = 1900;
    private static int MAX_PUBLISHED_YEAR = 2023;
    private String bookId;
    private String bookName;
    private String author;
    private BookCategory category;
    private int publishedYear;

    public Book() {
        this.bookId = "B" + GLOBAL_BOOK_ID++;
    }

    public String getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public Book setBookName(String bookName) {
        this.bookName = bookName;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public BookCategory getCategory() {
        return category;
    }

    public Book setCategory(BookCategory category) {
        this.category = category;
        return this;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public Book setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
        return this;
    }

    public void inputBookInfo() {
        boolean isInvalidType = true;

        System.out.print("Nhập tên sách: ");
        this.bookName = new Scanner(System.in).nextLine();

        System.out.print("Nhập tên tác giả: ");
        this.author = new Scanner(System.in).nextLine();

        do {
            displayBookType();

            int type = CheckValidInput.inputValidNumber(MIN_TYPE, MAX_TYPE);

            switch (type) {
                case 1 -> this.category = BookCategory.NATURAL_SCIENCE;
                case 2 -> this.category = BookCategory.LITERATURE_ART;
                case 3 -> this.category = BookCategory.ELECTRONIC_TELECOMMUNICATION;
                case 4 -> this.category = BookCategory.INFORMATION_TECHNOLOGY;
                default -> System.out.println("Chuyên ngành đã nhập không hợp lệ");
            }

            if (type >= MIN_TYPE && type <= MAX_TYPE) {
                isInvalidType = false;
            }
        } while (isInvalidType);

        System.out.println("Nhập năm xuất bản");
        this.publishedYear = CheckValidInput.inputValidNumber(MIN_PUBLISHED_YEAR, MAX_PUBLISHED_YEAR);
    }

    private void displayBookType() {
        System.out.println("Nhập chuyên ngành, chọn 1 trong 4 loại sau:");
        System.out.printf("1. %s\n", BookCategory.NATURAL_SCIENCE.getCategory());
        System.out.printf("2. %s\n", BookCategory.LITERATURE_ART.getCategory());
        System.out.printf("3. %s\n", BookCategory.ELECTRONIC_TELECOMMUNICATION.getCategory());
        System.out.printf("4. %s\n", BookCategory.INFORMATION_TECHNOLOGY.getCategory());
    }

    public void displayBookInfo() {
        System.out.printf("%-8s | %-20s | %-20s | %-24s | %-16s |\n", this.bookId, this.bookName, this.author, this.category.getCategory(), this.publishedYear);
    }
}
