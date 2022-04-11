package test.java;

import main.java.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collection;

import main.java.Cart0;
import main.java.Cart1;
import main.java.Cart2;
import main.java.Cart3;
import main.java.Cart4;
import main.java.Cart5;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BlackBoxGiven {

    private Class<Cart> classUnderTest;

    @SuppressWarnings("unchecked")
    public BlackBoxGiven(Object classUnderTest) {
        this.classUnderTest = (Class<Cart>) classUnderTest;
    }

    // Define all classes to be tested
    @Parameterized.Parameters
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

    private Cart createCart(int age) throws Exception {
        Constructor<Cart> constructor = classUnderTest.getConstructor(Integer.TYPE);
        return constructor.newInstance(age);
    }

    // A sample Cart

    Cart cart1;
    Cart cart1_2;
    Cart cart1_3;
    double cart1Expected;

    @org.junit.Before
    public void setUp() throws Exception {

        // all carts should be set up like this

        // cart created with an age 40 shopper
        cart1 = createCart(40);
        for (int i = 0; i < 2; i++) {
            cart1.addItem(new Alcohol());
        }
        for(int i = 0; i < 3; i++) {
            cart1.addItem(new Dairy());
        }
        for(int i = 0; i < 4; i++) {
            cart1.addItem(new Meat());
        }

        cart1Expected = 70.2;


        cart1_2 = createCart(10);
        for (int i = 0; i < 2; i++) {
            cart1_2.addItem(new Alcohol());
        }
        for(int i = 0; i < 3; i++) {
            cart1_2.addItem(new Dairy());
        }
        for(int i = 0; i < 4; i++) {
            cart1_2.addItem(new Meat());
        }


        cart1_3 = createCart(20);
        for (int i = 0; i < 2; i++) {
            cart1_3.addItem(new Alcohol());
        }
        for(int i = 0; i < 3; i++) {
            cart1_3.addItem(new Dairy());
        }
        for(int i = 0; i < 4; i++) {
            cart1_3.addItem(new Meat());
        }
    }

    // sample test
    @Test
    public void calcCostCartsAge() throws UnderAgeException {
        double amount = cart1.calcCost();
        double amount2 = cart1_2.calcCost();
        assertEquals(cart1Expected, amount, .01);
        assertEquals(cart1Expected, amount2, .01);

    }
    @Test
    public void calcCostCartsAgeFail() throws UnderAgeException {
        double amount3 = cart1_3.calcCost();
        assertEquals(cart1Expected, amount3, .01);
    }



}