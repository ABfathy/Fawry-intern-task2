public class paperBook extends Book{

    private int stock;
    public paperBook(String isbn, String title, int publishYear, double price, int stock){
        super(isbn,title,publishYear,price);
        this.stock = stock;

    }

    @Override
    public void sell(int quantity, String email, String address, ShippingService shipService, MailService mailService) {
        if (stock < quantity) {
            throw new IllegalArgumentException("Not enough stock for book:" + getIsbn());
        }

        stock -= quantity;
        System.out.println( getTitle() + " of quantity: " + quantity + " ordered for shipping to address " + address
                + " with total price of " + (quantity * getPrice()));

        if(shipService != null){
            shipService.ship(address,getTitle());
        }

    }
}
