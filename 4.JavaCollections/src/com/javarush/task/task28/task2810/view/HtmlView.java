package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import jdk.nashorn.internal.runtime.ECMAException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HtmlView implements View {
    private Controller controller;
    private final String filePath = "./4.JavaCollections/src/" + this.getClass().getPackage().getName().replace('.', '/') + "/vacancies.html";
    @Override
    public void update(List<Vacancy> vacancies) {
        updateFile(getUpdatedFileContent(vacancies));
    }

    public String getUpdatedFileContent(List<Vacancy> vacancies){
        String content = "";
        try {
            Document doc = getDocument();
            Element Tempel_full = doc.getElementsByClass("template").first();
            Element Tempel = Tempel_full.clone();
            Tempel.removeAttr("style");
            Tempel.removeClass("template");

            Elements els = doc.select("tr[class=vacancy]");
            els.remove();

            for(Vacancy vacancy : vacancies){
                Element el = Tempel.clone();
                el.getElementsByClass("city").get(0).text(vacancy.getCity());
                el.getElementsByClass("salary").get(0).text(vacancy.getSalary());
                el.getElementsByClass("companyName").get(0).text(vacancy.getCompanyName());
                el.getElementsByTag("a").get(0).attr("href",vacancy.getUrl());
                el.getElementsByTag("a").get(0).text(vacancy.getTitle());
                Tempel_full.before(el.outerHtml());
            }
            content = doc.outerHtml();
        }
        catch (Exception e){
            e.printStackTrace();
            return "Some exception occurred";
        }
        return content;
    }
    private void updateFile(String content){
        try (FileWriter writer = new FileWriter(filePath)){
            writer.write(content);
        }
        catch (Exception e){
            System.out.println("IOException");
        }
    }

    protected Document getDocument() throws IOException{
        return Jsoup.parse(new File(filePath),"UTF-8");
    }

    public void userCitySelectEmulationMethod(){
        controller.onCitySelect("Odessa");
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }
}
