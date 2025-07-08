public class ShopTest {

    public void testPaperBookPurchase() {
        BookStore store = new BookStore(null, null);

        store.addBook(new paperBook("111", "SpringBoot Basics", 2018, 100.0, 10));

        try {
            double paid = store.buyBook("111", 2, "dalfathyoc@gmail.com", "123 Cairo street");
            System.out.println("Paid amount = " + paid);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void testEBookPurchase() {
        BookStore store = new BookStore(null, null);

        store.addBook(new Ebook("222", "git for dummies", 2021, 50.0, "PDF"));

        try {
            double paid = store.buyBook("222", 1, "dalfathyoc@gmail.com", "");
            System.out.println("paid amount = " + paid);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void testShowcaseBook() {
        BookStore store = new BookStore(null, null);

        store.addBook(new ShowCaseBook("333", "Harry potter", 1990, 0.0));

        try {
            store.buyBook("333", 1, "dalfathyoc@gmail.com", "cairo");
        } catch (Exception e) {
            System.out.println("Expected Error: " + e.getMessage());
        }
    }

    public void testRemoveOutdatedBook() {
        BookStore store = new BookStore(null, null);
        store.addBook(new paperBook("444", "oldBook", 2000, 30.0, 5));

        Book removed = store.removeIfOutdated(10);
        if (removed != null) {
            System.out.println("Removed old book with isbn " + removed.getIsbn());
        } else {
            System.out.println("no outdated books found.");
        }
    }
}