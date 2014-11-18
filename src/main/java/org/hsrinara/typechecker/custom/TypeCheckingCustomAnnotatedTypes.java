package org.hsrinara.typechecker.custom;

import java.util.concurrent.Callable;

import static org.hsrinara.typechecker.custom.TypeFactory.price;
import static org.hsrinara.typechecker.custom.TypeFactory.quantity;

public class TypeCheckingCustomAnnotatedTypes {

    private static void takesAPrice(@Price long price) {
        System.out.println("Received price: " + price);
    }

    private static void takesALong(long nonAnnotatedType) {
        System.out.println("Received a long: " + nonAnnotatedType);
    }

    private static void takesAPriceInAGeneric(Callable<@Price Long> callable) throws Exception {
        System.out.println("Received callable with price: " + callable.call());
    }

    private static long returnsALong() {
        return 300;
    }

    private static @Price long returnsAPrice() {
        return price(100);
    }

    public static void main(String[] args) throws Exception {
        // Statements that pass compilation
        takesAPrice(price(100));
        takesALong(price(100));
        takesAPriceInAGeneric(new Callable<@Price Long>() {
            @Override
            public @Price Long call() throws Exception {
                return price(100);
            }
        });
        takesAPriceInAGeneric(() -> price(100));
        takesAPriceInAGeneric(TypeCheckingCustomAnnotatedTypes::returnsAPrice);


        // Statements that fail compilation
//        takesAPrice(quantity(5));

//        takesAPrice(1234);

//        takesAPriceInAGeneric(new Callable<@Price Long>() {
//            @Override
//            public Long call() throws Exception {
//                return price(100);
//            }
//        });

//        takesAPriceInAGeneric(new Callable<Long>() {
//            @Override
//            public @Price Long call() throws Exception {
//                return price(100);
//            }
//        });

//        takesAPriceInAGeneric(() -> 100L);

//        takesAPriceInAGeneric(() -> quantity(100));

//        takesAPriceInAGeneric(TypeCheckingCustomAnnotatedTypes::returnsALong);
    }
}
