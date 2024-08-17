package payment;

import invoice.Invoice;

public class CashPayment extends Payment{
    public CashPayment(Invoice invoice) {
        super(invoice);
    }

    @Override
    public void process() {

    }
}
