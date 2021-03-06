package com.javarush.task.task37.task3702;

import com.javarush.task.task37.task3702.male.MaleFactory;
import com.javarush.task.task37.task3702.female.FemaleFactory;

public class FactoryProducer {
    public enum HumanFactoryType {MALE, FEMALE};
    public static AbstractFactory getFactory(HumanFactoryType type){
        if(type == HumanFactoryType.MALE)return new MaleFactory();
        if(type == HumanFactoryType.FEMALE)return new FemaleFactory();
        return null;
    }
}
