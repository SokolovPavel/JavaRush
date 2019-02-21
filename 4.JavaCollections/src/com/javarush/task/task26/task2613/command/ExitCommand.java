package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;

class ExitCommand implements Command {
    @Override
    public void execute() {
        CashMachine.isExit = true;
    }
}
