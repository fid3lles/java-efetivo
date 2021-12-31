package com.effectivejava.builderpattern;

public class BuilderPatternTest {
    public static void main(String[] args) {

        Vehicle vehicle = new Vehicle.Builder("Civic Type-R", "Honda").numberOfDoors(4).numberOfWheels(4).build();

        System.out.println(vehicle.toString());
    }
}
