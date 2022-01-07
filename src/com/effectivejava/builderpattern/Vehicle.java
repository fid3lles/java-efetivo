package com.effectivejava.builderpattern;

import java.lang.reflect.Field;

public class Vehicle {

  private final String vehicleModel;
  private final String vehicleBrand;
  private final int numberOfWheels;
  private final int numberOfDoors;

  public static class Builder {
    // obrigatory params:
    private final String vehicleModel;
    private final String vehicleBrand;

    // optional params:
    private int numberOfWheels = 0;
    private int numberOfDoors = 0;

    public Builder(String vehicleModel, String vehicleBrand) {
      this.vehicleModel = vehicleModel;
      this.vehicleBrand = vehicleBrand;
    }

    public Builder numberOfWheels(int val) {
      numberOfWheels = val;
      return this;
    }

    public Builder numberOfDoors(int val) {
      numberOfDoors = val;
      return this;
    }

    public Vehicle build() {
      return new Vehicle(this);
    }
  }

  private Vehicle(Builder builder) {
    vehicleModel = builder.vehicleModel;
    vehicleBrand = builder.vehicleBrand;
    numberOfWheels = builder.numberOfWheels;
    numberOfDoors = builder.numberOfDoors;
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    String newLine = System.getProperty("line.separator");

    result.append(this.getClass().getName() + "{");
    result.append(newLine);

    // determine fields declared in this class only (no fields of superclass)
    Field[] fields = this.getClass().getDeclaredFields();

    // print field names paired with their values
    for (Field field : fields) {
      result.append("  ");
      try {
        result.append(field.getName());
        result.append(": ");
        // requires access to private field:
        result.append(field.get(this));
      } catch (IllegalAccessException ex) {
        System.out.println(ex);
      }
      result.append(newLine);
    }
    result.append("}");

    return result.toString();
  }
}