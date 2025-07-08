public class Main {
    public static void main(String[] args) {
        ShopTest test = new ShopTest();

        System.out.println("Test Paper Book");
        test.testPaperBookPurchase();

        System.out.println("\n Test EBook ");
        test.testEBookPurchase();

        System.out.println("\n Test Showcase Book ");
        test.testShowcaseBook();

        System.out.println("\n Test Remove Outdated ");
        test.testRemoveOutdatedBook();
    }
}