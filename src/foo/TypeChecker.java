package foo;

import org.checkerframework.checker.units.UnitsTools;
import org.checkerframework.checker.units.qual.m;
import org.checkerframework.checker.units.qual.mm;

import static foo.TypeChecker.TypeConverter.price;
import static foo.TypeChecker.TypeConverter.quantity;

public class TypeChecker {
    @SuppressWarnings("unsafe")
    static class MyTypes {
        private static final @m int m = (@m int) UnitsTools.m;
        private static final @mm int mm = (@mm int) UnitsTools.mm;
        private static final @Px long price = (@Px long) 1;
        private static final @Qty long quantity= (@Qty long) 1;
    }

    public static class TypeConverter {
        public static @Px long price(long price) {
            return price * MyTypes.price;
        }

        public static @Qty long quantity(long quantity) {
            return quantity * MyTypes.quantity;
        }
    }

    private void check() {
        @m final int meters = 4 * MyTypes.m;
        @mm final int millimeters = 4 * MyTypes.mm;
        takesMeters(meters);
//        takesMeters(millimeters);
        @Px long price = 3 * MyTypes.price;
//        takesMeters(price);
//        takesMeters(234);
//        takesAPrice(millimeters);
        takesAPrice(price);
        takesAPrice(price(3));
        takesAPrice(quantity(5));
    }

    private void takesMeters(@m int meters) {

    }

    private void takesAPrice(@Px long price) {

    }

    public static void main(String[] args) {
        new TypeChecker().check();
    }
}
