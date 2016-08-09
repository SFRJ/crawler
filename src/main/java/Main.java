import org.jsoup.nodes.Document;
import services.crawling.Crawler;
import services.crawling.Parser;
import services.print.ElementPrinter;
import services.validation.ImageValidator;
import services.validation.InternalLinksValidator;

import java.io.IOException;

import static java.lang.System.exit;
import static org.jsoup.Jsoup.connect;

public class Main {

    public static final String LINKS = "FOUND LINKS";
    public static final String IMAGES = "FOUND IMAGES";

    public static void main(String[] args) throws IOException {
        userInputValidation(args);
        String baseUrl = args[0];
        Document page = connect(baseUrl).get();
        //Dependencies injection
        Crawler crawler = new Crawler(
                new Parser(LINKS, new InternalLinksValidator(baseUrl)),
                new Parser(IMAGES, new ImageValidator()),
                new ElementPrinter());

        System.out.println("Scanning " + baseUrl + " for links and images...");
        crawler.crawl(page);

    }

    private static void userInputValidation(String[] args) {
        if(args.length != 1) {
            System.out.println("Please provide a url and run the program again");
            exit(0);
        }
    }

}
