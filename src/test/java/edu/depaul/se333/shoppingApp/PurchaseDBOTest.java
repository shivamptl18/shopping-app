package edu.depaul.se333.shoppingApp;

import static org.junit.jupiter.api.Assertions.*;

import edu.depaul.se433.shoppingapp.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.naming.Name;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.mockito.Mockito.*;


class PurchaseDBOTest {
    @Test
    @DisplayName("Vaildates item purchase is saved with database")
    void savePurchase(){
        PurchaseDBO pDBO = mock(PurchaseDBO.class);
        PurchaseAgent pAgent = new PurchaseAgent(pDBO);
        ArrayList<Purchase> pList = new ArrayList<>();
        Bill b = new Bill(49,10,0.06,74.2);
        Purchase item = Purchase.make("Shivam", LocalDate.now(), b.total(),"IL",String.valueOf(ShippingType.STANDARD));
        when(pDBO.getPurchases()).thenReturn(pList);
        pAgent.save(item);
        verify(pDBO).savePurchase(item);

    }




    @Test
    @DisplayName("Test Average Purchase Amount ")
    void testAvgPurchaseAmt(){
        PurchaseDBO pDBO = mock(PurchaseDBO.class);
        PurchaseAgent pAgent = new PurchaseAgent(pDBO);
        ArrayList<Purchase> pList = new ArrayList<>();
        Purchase p1 = Purchase.make("John", LocalDate.now(),40.00, "NY", "STANDARD");
        Purchase p2 = Purchase.make("Mike", LocalDate.now(),60.00, "FL", "NEXT_DAY");
        pList.add(p1);
        pList.add(p2);
        when(pDBO.getPurchases()).thenReturn(pList);
        double avg = (p1.getCost() + p2.getCost()) / 2;
        assertEquals(avg, pAgent.averagePurchase());

    }




}
