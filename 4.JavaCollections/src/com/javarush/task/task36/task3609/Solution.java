package com.javarush.task.task36.task3609;

/* 
Рефакторинг MVC
*/

public class Solution {
    public static void main(String[] args) {
        //Fetch car record from the database
        CarModel model = retrieveCarFromDatabase();

        //Create a view : to show car's speed on speedometer(console)
        model.carController.updateView();

        //Update model data
        model.carController.speedUp(15);
        model.carController.updateView();

        //Update model data
        model.carController.speedUp(50);
        model.carController.updateView();

        //Update model data
        model.carController.speedDown(7);
        model.carController.updateView();
    }

    private static CarModel retrieveCarFromDatabase() {
        CarModel currentCar = new CarModel();
        currentCar.setBrand("Nissan");
        currentCar.setModel("Almera classic");
        SpeedometerView view = new SpeedometerView();
        currentCar.carController = new CarController(currentCar, view);
        currentCar.setSpeed(0);
        currentCar.setMaxSpeed(200);

        return currentCar;
    }
}