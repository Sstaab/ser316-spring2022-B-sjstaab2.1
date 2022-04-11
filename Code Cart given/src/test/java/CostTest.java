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
public class CostTest {

        private Class<Cart> classUnderTest;

        @SuppressWarnings("unchecked")
        public CostTest(Object classUnderTest) {
            this.classUnderTest = (Class<Cart>) classUnderTest;
        }

        // Define all classes to be tested
        @Parameterized.Parameters
        public static Collection<Object[]> cartClassUnderTest() {
            Object[][] classes = {
                    {Cart.class},
            };
            return Arrays.asList(classes);
        }

        private Cart createCart(int age) throws Exception {
            Constructor<Cart> constructor = classUnderTest.getConstructor(Integer.TYPE);
            return constructor.newInstance(age);
        }

    Cart cart;
    double cartExpected;
    @org.junit.Before
    public void setUp() throws Exception {

        // all carts should be set up like this

        // cart created with an age 40 shopper
        cart = createCart(40);
        for (int i = 0; i < 2; i++) {
            cart.addItem(new Alcohol());
        }
        for (int i = 0; i < 3; i++) {
            cart.addItem(new Dairy());
        }
        for (int i = 0; i < 4; i++) {
            cart.addItem(new Meat());
        }

        cartExpected = 0;
    }

    @Test
    public void calcCostCartsAge() throws UnderAgeException {
        double amount = cart.calcCost();

        assertEquals(cartExpected, amount, .01);

    }
    }
