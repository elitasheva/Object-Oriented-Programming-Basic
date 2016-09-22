package problem2.models;

public class Book {

    private final int MIN_LENGTH_TITLE = 3;
    private String author;
    private String title;
    private double price;

    public Book(String author, String title, double price) {
        this.setAuthor(author);
        this.setTitle(title);
        this.setPrice(price);
    }

    protected String getTitle() {
        return title;
    }

    protected void setTitle(String title) {
        if (title.length() < MIN_LENGTH_TITLE) {
            throw new IllegalArgumentException("Title not valid!");
        }
        this.title = title;
    }

    protected String getAuthor() {
        return author;
    }

    protected void setAuthor(String author) {
        String[] params = author.split("\\s+");
        if (params.length > 1){
            String secondName = params[1];
            if (Character.isDigit(secondName.charAt(0))) {
                throw new IllegalArgumentException("Author not valid!");
            }
        }
        this.author = author;
    }

    protected double getPrice() {
        return price;
    }

    protected void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Title: ").append(this.getTitle())
                .append(System.lineSeparator())
                .append("Author: ").append(this.getAuthor())
                .append(System.lineSeparator())
                .append("Price: ").append(this.getPrice())
                .append(System.lineSeparator());
        return sb.toString();

    }
}
