public class Ebook extends Book{

    private String fileType;

    public Ebook(String isbn, String title, int year, double price, String fileType){
        super(isbn,title,year,price);

        this.fileType = fileType;
    }

    @Override
    public void sell(int quantity, String email, String address, ShippingService shipService, MailService mailService) {

        if (quantity > 1) {
            throw new IllegalArgumentException("you are buying duplicates of the same Ebook.");
        }

        System.out.println(getTitle() + " ordered for email delivery to " + email +
                " with total price of " + (getPrice()));

        if (mailService != null) {
            mailService.sendEmail(email, getTitle(), fileType);
        }

    }
}
