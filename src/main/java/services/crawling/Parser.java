package services.crawling;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import services.validation.ElementValidator;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static final String IMG = "img";
    public static final String ABS = "abs";
    public static final String SRC = "src";
    public static final String HREF = "href";
    public static final String A = "a";

    private String whatDoIWantToFind;
    private ElementValidator elementValidator;

    private List<String> foundElements = new ArrayList<>();

    public Parser(String whatDoIWantToFind, ElementValidator elementValidator) {
        this.whatDoIWantToFind = whatDoIWantToFind;
        this.elementValidator = elementValidator;
    }

    public List<String> parse(Elements elements) {
        System.out.println(whatDoIWantToFind);
        for (Element element : elements) {
            if(validatorKnowsThe(element))
                if(isAnImage(element, IMG)) {
                    foundElements.add(element.attr(ABS + ":" + SRC));
                } else if (isALink(element, A) && doesntContainImage(element)){
                    foundElements.add(element.attr(ABS + ":" + HREF));
                }
        }
        return foundElements;
    }

    private boolean isALink(Element element, String linkTagName) {
        return element.tagName().equals(linkTagName);
    }

    private boolean isAnImage(Element element, String img) {
        return element.tagName().equals(img);
    }

    private boolean validatorKnowsThe(Element element) {
        return elementValidator.isElementType(element);
    }

    private boolean doesntContainImage(Element element) {
        return !element.toString().contains(IMG);
    }
}
