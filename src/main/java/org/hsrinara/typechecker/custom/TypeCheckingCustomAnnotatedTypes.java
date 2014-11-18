package org.hsrinara.typechecker.custom;

import static org.hsrinara.typechecker.custom.TypeFactory.price;
import static org.hsrinara.typechecker.custom.TypeFactory.quantity;

public class TypeCheckingCustomAnnotatedTypes {

    private static void takesAPrice(@Price long price) {
        System.out.println("Received price: " + price);
    }

    public static void main(String[] args) {
        takesAPrice(price(100));
        takesAPrice(quantity(5));  // should fail compilation ...
    }
}
