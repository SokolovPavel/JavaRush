package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.*;
import com.javarush.task.task28.task2810.view.HtmlView;
import com.javarush.task.task28.task2810.view.View;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

public class Aggregator {

    public static void main(String[] args){
        org.jsoup.nodes.Document doc = null;
        try {


//This will get you cookies

            Connection connection = Jsoup.connect("https://pin7.ru/");
            connection.get();
            Connection.Response res = connection
                    .method(Connection.Method.GET)
                    .execute();
            connection.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");
            doc = connection.data("fgo","Вход","fpin","777").post();
            doc = connection.get();
            //data("fgo","%D0%92%D1%85%D0%BE%D0%B4","fpin","777")

        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        doc.clone();
        //HtmlView view = new HtmlView();
        //Model model = new Model(view,new Provider(new HHStrategy()),new Provider(new MoikrugStrategy()));
        //Controller controller = new Controller(model);
        //view.setController(controller);
        //view.userCitySelectEmulationMethod();
    }
}
