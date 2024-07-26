package OpenClosedPrinciple.Logger;

public class FileLogger implements ILogger {

    private String filename;

    public FileLogger(String filename) {
        this.filename = filename;
    }

    public void log(String message) {
        System.out.println("Message written to file");
    }
}
