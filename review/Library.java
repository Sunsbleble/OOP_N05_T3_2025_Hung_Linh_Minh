import java.util.List;
import java.util.ArrayList;

public class Library {
    private final List<Books> books;

    // Constructor mặc định
    public Library() {
        this.books = new ArrayList<>();
    }

    // Constructor với danh sách sách
    public Library(List<Books> b) {
        this.books = b;
    }

    // Lấy danh sách sách
    public List<Books> getList() {
        return books;
    }
}
