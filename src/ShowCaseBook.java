public class ShowCaseBook extends Book {
    public ShowCaseBook(String isbn, String title, int year, double price) {
        super(isbn, title, year, price);
    }

    @Override
    public void sell(int quantity, String email, String address,
                     ShippingService shipService, MailService mailService) {
        throw new UnsupportedOperationException("Showcase books are not for sale");
    }
}