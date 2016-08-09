package services.validation;

import org.jsoup.nodes.Element;

public class InternalLinksValidator implements ElementValidator {

    private String baseUrl;

    public InternalLinksValidator(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public boolean isElementType(Element element) {
        return element.attr("abs:href").contains(baseUrl);
    }

}
