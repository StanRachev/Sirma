package SingleResponsibilityPrinciple.Book;

public class GetSummaryBook {
    private String title;
    private String author;
    private int pages;

    public GetSummaryBook(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public String getBookSummary() {
        return this.title + " by " + this.author;
    }
}