package pl.jmieszaniec.ecommerce.sales;

import org.springframework.web.bind.annotation.*;
import pl.jmieszaniec.ecommerce.sales.offering.Offer;
import pl.jmieszaniec.ecommerce.sales.reservation.AcceptOfferRequest;
import pl.jmieszaniec.ecommerce.sales.reservation.ReservationDetails;
//import org.springframework.web.bind.annotation.GetMapping;

public class SalesController {
    SalesFacade sales;

    public SalesController(SalesFacade salesFacade){

        this.sales=sales;
    }
    @GetMapping("/api/current-offer")
    Offer getCurrentOffer(){
        var customerId = getCurrentCustomerId();
        return sales.getCurrentOffer(customerId);
    }
    @PostMapping("/api/add-product/{productId}")
    void addProduct(@PathVariable(name = "productId") String productId){
        var customerId = getCurrentCustomerId();
        sales.addProduct(customerId, productId);
    }

    @PostMapping("/api/accept-offer")
    ReservationDetails acceptOffer(@RequestBody AcceptOfferRequest acceptOfferRequest) {
        var customerId = getCurrentCustomerId();
        return sales.acceptOffer(customerId, acceptOfferRequest);
    }
    private String getCurrentCustomerId(){
        return "Julia";
    }
}
