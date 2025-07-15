import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Books b1 = new Books("Clean Code", "Robert C. Martin");
        Books b2 = new Books("Effective Java", "Joshua Bloch");

        Library lib = new Library(Arrays.asList(b1, b2));

        for (Books book : lib.getList()) {
            System.out.println(book);
        }
    }
}
