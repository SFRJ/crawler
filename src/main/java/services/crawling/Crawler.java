package services.crawling;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import services.print.ElementPrinter;

import java.io.IOException;

public class Crawler {

    private Parser linksParser;
    private Parser imagesParser;
    private ElementPrinter elementPrinter;


    public Crawler(Parser linksParser, Parser imagesParser, ElementPrinter elementPrinter) {
        this.linksParser = linksParser;
        this.imagesParser = imagesParser;
        this.elementPrinter = elementPrinter;
    }

    public void crawl(Document page) throws IOException {
        Elements links = page.select("a[href]");
        Elements images = page.select("img");

        elementPrinter.printElements(linksParser.parse(links));
        elementPrinter.printElements(imagesParser.parse(images));
    }

}
