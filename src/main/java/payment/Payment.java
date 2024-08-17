package payment;

import invoice.Invoice;

import java.util.UUID;

public abstract class Payment {
    private String paymentId;
    private Invoice invoice;

    public Payment(Invoice invoice) {
        this.paymentId = UUID.randomUUID().toString();
        this.invoice = invoice;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public abstract void process();
}
