package services.crawling;

import org.junit.Test;
import services.print.ElementPrinter;
import org.jsoup.nodes.Document;


import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CrawlerTest {

    private Parser linksParser = mock(Parser.class);
    private Parser imagesParser = mock(Parser.class);
    private ElementPrinter elementPrinter = mock(ElementPrinter.class);
    private Document document = mock(Document.class);
    private Crawler crawler = new Crawler(linksParser, imagesParser, elementPrinter);

     @Test
      public void printsLinks() throws Exception {
         crawler.crawl(document);
         verify(elementPrinter, times(2)).printElements(any());
         verify(linksParser).parse(any());
         verify(imagesParser).parse(any());
      }
}