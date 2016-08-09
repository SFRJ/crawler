package services.validation;

import org.jsoup.nodes.Element;

public class ImageValidator implements ElementValidator {

    @Override
    public boolean isElementType(Element element) {
        return element.tagName().equals("img");
    }
}
