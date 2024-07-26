package SingleResponsibilityPrinciple.Invoice;

public class PrintInvoice {
    private double amount;
    private String customerName;
    private String address;

    public PrintInvoice(double amount, String customerName, String address) {
        this.amount = amount;
        this.customerName = customerName;
        this.address = address;
    }

    public void printInvoice() {
        System.out.println("Printing invoice");
    }
}
