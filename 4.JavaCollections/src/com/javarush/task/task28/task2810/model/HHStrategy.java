package com.javarush.task.task28.task2810.model;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.lang.String;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class HHStrategy implements Strategy {
    //private final String URL_FORMAT = "https://spb.hh.ru/search/vacancy?area=2&clusters=true&enable_snippets=true&text=java+%s&page=%d";
    //private static final String URL_FORMAT = "http://javarush.ru/testdata/big28data.html";
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";
    private static final String REFERRER = "https://hh.ua/";
    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> list = new LinkedList<>();
        int page = 0;
        while (true) {
            if(page>9)break;
            try {
                Document doc = getDocument(searchString, page);
                page++;
                Elements el = doc.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
                if(el.isEmpty())break;
                for (Element e : el) {
                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(e.select("[data-qa=vacancy-serp__vacancy-title]").first().text( ));
                    vacancy.setCity(e.select("[data-qa=vacancy-serp__vacancy-address]").first().text());
                    vacancy.setCompanyName(e.select("[data-qa=vacancy-serp__vacancy-employer]").first().text());
                    Elements elSalary = e.select("[data-qa=vacancy-serp__vacancy-compensation]");
                    //System.out.println(elSalary.first().text());
                    vacancy.setSalary(elSalary.size() == 0 ? "" : elSalary.first().text());
                    vacancy.setSiteName(REFERRER);
                    vacancy.setUrl(e.select("[data-qa=vacancy-serp__vacancy-title]").first().attr("href"));
                    //vacancy.
                    list.add(vacancy);
                }
            } catch (Exception e) {
            }
        }
        return list;
    }

    public HHStrategy() {

    }

    protected Document getDocument(String searchString, int page) throws IOException{
        org.jsoup.nodes.Document doc = null;

        try {
            String s = String.format(URL_FORMAT,searchString,page);
            doc = Jsoup.connect(s).get();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
    }
}
