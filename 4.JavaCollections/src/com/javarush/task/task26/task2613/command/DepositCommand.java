package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;

class DepositCommand implements Command {
    @Override
    public void execute() {
        String val = ConsoleHelper.askCurrencyCode();
        String[] s = ConsoleHelper.getValidTwoDigits(val);
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(val);
        manipulator.addAmount(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
    }
}
