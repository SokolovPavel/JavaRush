package com.javarush.task.task26.task2613.command;


import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;

import java.util.Collection;
import java.util.Map;

class InfoCommand implements Command {
    @Override
    public void execute() {
        Collection<CurrencyManipulator> manipulators;
        manipulators = CurrencyManipulatorFactory.getAllCurrencyManipulators();
        boolean nomoney = true;
        for (CurrencyManipulator manipulator : manipulators) {
            if(manipulator.hasMoney()){
                ConsoleHelper.writeMessage(manipulator.getCurrencyCode() + " - " + manipulator.getTotalAmount());
                nomoney = false;
            }

        }
        if(nomoney)ConsoleHelper.writeMessage("No money available.");
    }
}
