package pl.jmieszaniec.creditcard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

public class CreditCardTest {
    @Test
    void itAllowsToAssignCreditLimit(){
        //arrange
        CreditCard card = new CreditCard();
        //act
        card.assignCredit(BigDecimal.valueOf(1000));
        //assert
        assertEquals(
                BigDecimal.valueOf(1000),
                card.getBalance());

    }
    @Test
    void itDenyCreditLimitBelowThreshold(){
        var card= new CreditCard();
        //CreditCard card = new CreditCard();
        try{
            card.assignCredit(BigDecimal.valueOf(50));
            fail("exception");
        } catch (CreditBelowThresholdException e){
            assert true;
        }
    }
    @Test
    void cantReassignCreditLimit(){
        var card= new CreditCard();
        //CreditCard card = new CreditCard();
        assertThrows(
                CreditBelowThresholdException.class,
                () -> card.assignCredit(BigDecimal.valueOf(100))
        );
        /*try{
            card.assignCredit(BigDecimal.valueOf(50));
            fail("Should throw exception");

        }catch(CreditBelowThresholdException e){
            assertTrue(true);
        }
*/
    }
    @Test
    void itAllowsWithdrawMoney(){
        var card = new CreditCard();
        card.assignCredit(BigDecimal.valueOf(2000));

        card.withdraw( BigDecimal.valueOf(1000));

        assertThrows(
                TransactionDenyException.class,
                () -> card.withdraw(BigDecimal.valueOf(1000))
        );
    }
    @Test
    void itAllowsToPayForSomething() {
        CreditCard card = new CreditCard();
        card.assignCredit(BigDecimal.valueOf(1000));

        card.pay(BigDecimal.valueOf(900));

        assertEquals(
                BigDecimal.valueOf(100),
                card.getBalance()
        );
    }

    @Test
    void itDenyWhenNotSufficientFounds() {
        CreditCard card = new CreditCard();
        card.assignCredit(BigDecimal.valueOf(1000));
        card.pay(BigDecimal.valueOf(900));

        assertThrows(
                NotEnoughMoneyException.class,
                () -> card.pay(BigDecimal.valueOf(200))
        );
    }

}
