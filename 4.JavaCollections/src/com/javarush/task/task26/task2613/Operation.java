package com.javarush.task.task26.task2613;

public enum Operation {
    INFO, DEPOSIT, WITHDRAW, EXIT;
    public static Operation getAllowableOperationByOrdinal(Integer i)throws IllegalArgumentException{
        if(i == null || i <= 0 || i>4)throw new IllegalArgumentException();
        switch (i){
            case 1: return INFO;
            case 2: return DEPOSIT;
            case 3: return WITHDRAW;
            case 4: return EXIT;
        }
        return null;
    }
}
