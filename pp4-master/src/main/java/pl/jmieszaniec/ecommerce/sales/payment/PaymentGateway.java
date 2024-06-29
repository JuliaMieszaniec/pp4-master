package pl.jmieszaniec.ecommerce.sales.payment;

public interface PaymentGateway {
    public PaymentDetails registerPayment(RegisterPaymentRequest registerPaymentRequest);
}
