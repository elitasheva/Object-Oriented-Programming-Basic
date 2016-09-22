package problem2.models;

public class GoldenEditionBook extends Book {

    private final double CONST_PRICE = 0.3;

    public GoldenEditionBook(String title, String author, double price) {
        super(title, author, price);
    }

    @Override
    protected double getPrice() {
        return super.getPrice() + super.getPrice()*CONST_PRICE;
    }
}
