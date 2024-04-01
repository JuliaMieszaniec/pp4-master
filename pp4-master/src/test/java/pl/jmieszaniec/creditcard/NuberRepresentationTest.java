package pl.jmieszaniec.creditcard;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NuberRepresentationTest {

    @Test
    void itTestsDouble(){
        double a = 0.02;
        double b = 0.03;
        System.out.println(b-a);
    }

    @Test
    void itTestsBigDecimal(){
        BigDecimal a = new BigDecimal("0.002");
        BigDecimal b = new BigDecimal("0.002");
    }
}


