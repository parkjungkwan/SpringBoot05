package com.example.demo.utils;

import java.util.List;

import com.example.demo.domains.ArticleDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
@Component
public class Crawler extends Proxy {
    @Autowired Printer printer;
    @Autowired Box<ArticleDto> artBox;
    public Box<?> crawling(String url){
        printer.accept("크롤링 대상 URL : "+url);
        try{
            Document rawData = Jsoup.connect(url).timeout(10 * 1000).get();
            Elements titles = rawData.select("a[class=albumTitle hyrend]");
            Elements contents = rawData.select("aside[class=recommendReview] h1");
            System.out.println("======= 값 할당 ======");
            for(int i=0; i< artBox.size(); i++){
                for(Element e : titles) artBox.get(i).setTitle(e.text());
                for(Element e : contents) artBox.get(i).setContent(e.text());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return artBox;
    }
}
