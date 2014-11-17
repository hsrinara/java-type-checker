package org.hsrinara.typechecker.custom;

public class TypeFactory {
    public static @Price long price(long price) { return price * CustomTypes.price; }

    public static @Quantity long quantity(long quantity) {
        return quantity * CustomTypes.quantity;
    }

    @SuppressWarnings("unsafe")
    private static class CustomTypes {
        private static final @Price long price = (@Price long) 1;
        private static final @Quantity long quantity = (@Quantity long) 1;
    }
}
