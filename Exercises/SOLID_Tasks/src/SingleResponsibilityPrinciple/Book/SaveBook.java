package SingleResponsibilityPrinciple.Book;

public class SaveBook {
    private String title;
    private String author;
    private int pages;

    public SaveBook(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public void saveToDatabase() {
        System.out.println("Saving to database");
    }
}
