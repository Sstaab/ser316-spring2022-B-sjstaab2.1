package test.java;

import main.java.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

public class WhiteBoxGiven {
    public static Collection<Object[]> cartClassUnderTest() {
        Object[][] classes = {
                {Cart0.class},
                {Cart1.class},
                {Cart2.class},
                {Cart3.class},
                {Cart4.class},
                {Cart5.class}
        };
        return Arrays.asList(classes);
    }
    Cart cart;
    Cart cart1;
    Cart cart2;
    Cart cartAge;

    @Before
    public void setUp() throws Exception {
        cart = new Cart(45);
        cart1 = new Cart1(45);
        cart2 = new Cart2(45);
        cartAge = new Cart2(11);
    }

    @After
    public void tearDown() throws Exception {
        cart = null;
        cart1 = null;
        cart2 = null;
        cartAge = null;
    }

    @Test
    public void getTax() {
        assertEquals(4.0, cart.getTax(50, "AZ"), .01);
        assertEquals(4.0, cart1.getTax(50, "AZ"), .01);
        assertEquals(3.5, cart.getTax(50, "CO"), .01);
        assertEquals(4.5, cart.getTax(50, "CA"), .01);
        assertEquals(5, cart.getTax(50, "NY"), .01);
    }

    @Test
    public void TestAddAlcohol() throws UnderAgeException {
        cart1.addItem(new Alcohol());
            double amount = cart1.calcCost();
            assertEquals(8.64,amount, .01);
        cart2.addItem(new Alcohol());
        double amount2 = cart2.calcCost();
        assertEquals(8.64,amount2, .01);
    }
    @Test
    public void TestAddDairy() throws UnderAgeException {
        cart1.addItem(new Dairy());
        double amount = cart1.calcCost();
        assertEquals(3.24,amount, .01);
        cart2.addItem(new Dairy());
        double amount2 = cart2.calcCost();
        assertEquals(3.24,amount2, .01);

    }
    @Test
    public void TestAddProduce() throws UnderAgeException {
        cart1.addItem(new Produce());
        double amount = cart1.calcCost();
        assertEquals(2.16,amount, .01);
        cart2.addItem(new Produce());
        double amount2 = cart2.calcCost();
        assertEquals(2.16,amount2, .01);

    }
    @Test
    public void TestAddFrozenFood() throws UnderAgeException {
        cart1.addItem(new FrozenFood());
        double amount = cart1.calcCost();
        assertEquals(5.4,amount, .01);
        cart2.addItem(new FrozenFood());
        double amount2 = cart2.calcCost();
        assertEquals(5.4,amount2, .01);

    }
    @Test
    public void calcCost() throws UnderAgeException {
      double amount = cart.calcCost();
        assertEquals(0, amount, .01);
    }

    @Test
    public void TestRemove() {
        Product testMeat = new Meat();
        Product testMeat2 = new Meat();
        cart.addItem(testMeat);

        boolean Check = cart.RemoveItem(testMeat);
        assertTrue(Check);
        boolean Check2 = cart.RemoveItem(testMeat2);
        assertFalse(Check2);
    }

    @Test
    public void TestSaved() throws UnderAgeException {
        Product testMeat = new Meat();
        cart.addItem(testMeat);
        double amount = cart.Amount_saved();
        assertEquals(0,amount, .01);


    }
    @Test
    public void TestSavedSale() throws UnderAgeException {
        Product testAlcohol = new Alcohol();
        Product testFFood = new FrozenFood();
        cart.addItem(testAlcohol);
        cart.addItem(testFFood);
        double amount2 = cart.Amount_saved();

        assertEquals(-3, amount2, .01);
    }





    @Test
    public void TestSavedAge() throws UnderAgeException {
        Product testAlcohol = new Alcohol();
        Product testFFood = new FrozenFood();

        cartAge.addItem(testAlcohol);
        cartAge.addItem(testFFood);
        double amount3 = cartAge.Amount_saved();

        assertEquals(0, amount3, .01);
    }
    @Test
    public void TestSavedPSale() throws UnderAgeException {
        Product A = new Produce();
        Product B = new Produce();
        Product C = new Produce();
        Product D = new Produce();
        cart.addItem(A);
        cart.addItem(B);
        cart.addItem(C);
        cart.addItem(D);
        double amount4 = cart.Amount_saved();

        assertEquals(0,amount4, .01);


    }
    @Test
    public void TestSavedPSaleF() throws UnderAgeException {
        Product A = new Produce();
        Product B = new Produce();
        cart.addItem(A);
        cart.addItem(B);

        double amount5 = cart.Amount_saved();

        assertEquals(1,amount5, .01);
    }


}