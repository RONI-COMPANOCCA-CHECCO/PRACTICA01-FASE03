import java.util.HashMap;

public class Branch {
    private String id;
    private String name;
    private String address;
    private HashMap<Book, Integer> bookCopies;

    public Branch(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.bookCopies = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void addBookCopy(Book book, int copies) {
        bookCopies.put(book, copies);
    }

    public int getBookCopies(Book book) {
        return bookCopies.getOrDefault(book, 0);
    }
    public void printBranchInfo() {
        System.out.println("Sucursal: " + getName());
        System.out.println("ID: " + getId());
        System.out.println("Dirección: " + getAddress());
        System.out.println("Libros en la sucursal:");

        for (Book book : bookCopies.keySet()) {
            int copies = bookCopies.get(book);
            System.out.println(" - Libro: " + book.getTitle() + ", Ejemplares: " + copies);
        }
    }
}


