package SingleResponsibilityPrinciple.Invoice;

public class SaveInvoice {
    String customerName;
    String address;

    public SaveInvoice(String customerName, String address) {
        this.customerName = customerName;
        this.address = address;
    }

    public void saveInvoice() {
        System.out.println("Saving invoice");
    }
}
