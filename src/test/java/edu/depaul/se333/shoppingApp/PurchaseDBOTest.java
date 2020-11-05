package edu.depaul.se333.shoppingApp;

import static org.junit.jupiter.api.Assertions.*;

import edu.depaul.se433.shoppingapp.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import static org.mockito.Mockito.*;


public class PurchaseDBOTest {
    @Test
    void savePurchase(){
        PurchaseDBO pDBO = mock(PurchaseDBO.class);
        ShoppingCart shoppingCart;
        Bill b = new Bill(49,10,0.06,74.2);
        PurchaseAgent pAgent = new PurchaseAgent(pDBO);
        Purchase item = Purchase.make("Shivam", LocalDate.now(), b.total(),"IL",String.valueOf(ShippingType.STANDARD));
        pAgent.save(item);
        verify(pDBO).savePurchase(item);


    }


    
}
