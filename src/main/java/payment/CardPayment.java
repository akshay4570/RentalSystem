package payment;

import invoice.Invoice;

public class CardPayment extends Payment{

    public CardPayment(Invoice invoice) {
        super(invoice);
    }

    @Override
    public void process() {

    }
}
