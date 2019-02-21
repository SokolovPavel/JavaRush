package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.Operation;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {
    private CommandExecutor(){}
    private final static Map<Operation, Command> allKnownCommandsMap = new HashMap<>();
    static{
        allKnownCommandsMap.put(Operation.DEPOSIT,new DepositCommand());
        allKnownCommandsMap.put(Operation.INFO,new InfoCommand());
        allKnownCommandsMap.put(Operation.EXIT,new ExitCommand());
        allKnownCommandsMap.put(Operation.WITHDRAW,new WithdrawCommand());
    }
    public static final void execute(Operation operation){
        allKnownCommandsMap.get(operation).execute();
    }
}
