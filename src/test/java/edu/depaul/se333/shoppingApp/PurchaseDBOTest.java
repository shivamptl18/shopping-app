package edu.depaul.se333.shoppingApp;

import static org.junit.jupiter.api.Assertions.*;

import edu.depaul.se433.shoppingapp.*;
import org.junit.jupiter.api.Test;

import javax.naming.Name;
import java.time.LocalDate;
import static org.mockito.Mockito.*;


class PurchaseDBOTest {
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

    @Test
    void getCustomerName(){
        Purchase name = mock(Purchase.class);
        ShoppingCart shoppingCart;




    }

    @Test
    void getPurchaseDate(){
        PurchaseDBO name = mock(PurchaseDBO.class);
        ShoppingCart shoppingCart;



    }

    @Test
    void getCost(){
        PurchaseDBO name = mock(PurchaseDBO.class);
        ShoppingCart shoppingCart;


    }



    @Test
    void getState(){
        PurchaseDBO name = mock(PurchaseDBO.class);
        ShoppingCart shoppingCart;


    }


    @Test
    void getShipping(){
        PurchaseDBO name = mock(PurchaseDBO.class);
        ShoppingCart shoppingCart;


    }




    
}
