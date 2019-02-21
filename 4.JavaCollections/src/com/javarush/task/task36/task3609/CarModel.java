package com.javarush.task.task36.task3609;


public class CarModel {
    private String brand;
    private String model;
    public CarController carController;



    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSpeed() {
        return carController.speed;
    }

    public void setSpeed(int speed) {
        carController.speed = speed;
    }

    public int getMaxSpeed() {
        return carController.maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        carController.maxSpeed = maxSpeed;
    }
}