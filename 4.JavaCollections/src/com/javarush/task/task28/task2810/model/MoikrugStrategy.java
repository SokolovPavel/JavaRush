package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class MoikrugStrategy implements Strategy {
    //private final String URL_FORMAT = "https://moikrug.ru/vacancies?page=%d&q=java+%s&type=all";
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";
    private static final String REFERRER = "https://moikrug.ru";
    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> list = new LinkedList<>();
        int page = 0;
        while (true) {
            //if(page>9)break;
            try {
                Document doc = getDocument(searchString, page);
                page++;
                Elements el = doc.getElementsByClass("job");
                if(el.isEmpty())break;
                for (Element e : el) {
                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(e.getElementsByClass("title").attr("title"));
                    vacancy.setCity(e.getElementsByClass("location").text());
                    vacancy.setCompanyName(e.getElementsByClass("company_name").text());
                    Elements elSalary = e.getElementsByClass("count");
                    vacancy.setSalary(elSalary.size() == 0 ? "" : elSalary.first().text());
                    vacancy.setSiteName(REFERRER);
                    vacancy.setUrl(REFERRER + e.getElementsByClass("title").first().getElementsByTag("a").attr("href"));
                    list.add(vacancy);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
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
