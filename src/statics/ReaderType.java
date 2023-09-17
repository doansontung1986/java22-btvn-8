package statics;

public enum ReaderType {
    STUDENT("Sinh viên"),
    POST_STUDENT("Học viên cao học"),
    TEACHER("Giáo viên");
    private String type;

    ReaderType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
