package Hcl_Assessment2_Corejava_2300320130201;

 public abstract class Book extends LibraryItem {
    private static final double FEE_PER_DAY = 2.0;

    private final String author;
    private final String isbn;

    public Book(String title, int year, String author, String isbn) {
        super(title, year);
        this.author = author;
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public double lateFee(int daysLate) {
        return FEE_PER_DAY * daysLate;
    }

    @Override
    public String toString() {
        return "Book[" + super.toString() + ", " + author + "]";
    }
}

