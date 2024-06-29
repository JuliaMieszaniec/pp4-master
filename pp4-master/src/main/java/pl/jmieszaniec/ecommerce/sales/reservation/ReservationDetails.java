package pl.jmieszaniec.ecommerce.sales.reservation;

public class ReservationDetails {
    private String reservationId;
    private String paymentUrl;

    public ReservationDetails(String reservationId, String paymentUrl) {
        this.reservationId = reservationId;
        this.paymentUrl = paymentUrl;
    }

    public ReservationDetails() {
    }
    public String getPaymentUrl() {
        return "http://fake-payment-gateway/123abc";
    }

    public String getReservationId() {
        return "123abc";
    }
}
