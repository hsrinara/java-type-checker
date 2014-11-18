package org.hsrinara.typechecker.custom;

public class TypeFactory {
    public static @Price long price(long price) { return price * CustomTypes.price; }

    public static @Quantity long quantity(long quantity) {
        return quantity * CustomTypes.quantity;
    }
}
