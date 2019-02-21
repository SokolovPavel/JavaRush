package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.view.View;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.LinkedList;
import java.util.List;

public class Model {
    private View view;
    private Provider[] providers;

    public Model(View view, Provider... providers) {
        try{
            if(view == null)throw new Exception();
            this.view = view;
            if(providers.length==0)throw new Exception();
            this.providers = providers;
        }
        catch(Exception e){
            throw new IllegalArgumentException();
        }
    }
    public void selectCity(String city){
        List<Vacancy> list = new LinkedList<>();
        for(Provider provider : providers){
            list. addAll(provider.getJavaVacancies(city));
        }
        view.update(list);
    }
}
