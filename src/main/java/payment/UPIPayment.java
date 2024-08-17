package payment;

import invoice.Invoice;

public class UPIPayment extends Payment{

    public UPIPayment(Invoice invoice) {
        super(invoice);
    }

    @Override
    public void process() {

    }
}
