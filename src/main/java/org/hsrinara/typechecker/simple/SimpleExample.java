package org.hsrinara.typechecker.simple;

import org.checkerframework.checker.units.qual.kmPERh;
import org.checkerframework.checker.units.qual.m;
import org.checkerframework.checker.units.qual.mPERs;
import org.checkerframework.checker.units.qual.s;

public class SimpleExample {
    @SuppressWarnings("unsafe") private static final @org.checkerframework.checker.units.qual.m int m = (@m int)1; // define 1 meter
    @SuppressWarnings("unsafe") private static final @org.checkerframework.checker.units.qual.s int s = (@s int)1; // define 1 second

    public static void main(String[] args) {
        @m double meters = 5.0 * m;
        @s double seconds = 2.0 * s;
//        @kmPERh double speed = meters / seconds; // <-- doesn't compile
        @mPERs double speed = meters / seconds;

        System.out.println("Speed: " + speed);
    }
}
