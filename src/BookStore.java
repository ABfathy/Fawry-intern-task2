import java.util.*;
public class BookStore {
    private Map<String, Book> inventory = new HashMap<>();
    private ShippingService shippingService;
    private MailService mailService;

    public BookStore(ShippingService shippingService, MailService mailService) {
        this.shippingService = shippingService;
        this.mailService = mailService;
    }

    public void addBook(Book book) {
        inventory.put(book.getIsbn(), book);
    }

    public Book removeIfOutdated(int maxAge) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (Iterator<Map.Entry<String, Book>> it = inventory.entrySet().iterator(); it.hasNext();) {
            Book book = it.next().getValue();
            if (currentYear - book.getPublishYear() > maxAge) {
                it.remove();
                return book;
            }
        }
        return null;
    }

    public double buyBook(String isbn, int quantity, String email, String address) {
        Book book = inventory.get(isbn);
        if (book == null) {
            throw new IllegalArgumentException("Book with ISBN " + isbn + " not found.");
        }
        book.sell(quantity, email, address, shippingService, mailService);
        return book.getPrice() * quantity;
    }
}