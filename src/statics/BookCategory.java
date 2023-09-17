package statics;

public enum BookCategory {
    NATURAL_SCIENCE("Khoa học tự nhiên"),
    LITERATURE_ART("Văn học – Nghệ thuật"),
    ELECTRONIC_TELECOMMUNICATION("Điện tử Viễn thông"),
    INFORMATION_TECHNOLOGY("Công nghệ thông tin");

    private String category;

    BookCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
