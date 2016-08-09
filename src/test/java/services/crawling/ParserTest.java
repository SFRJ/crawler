package services.crawling;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import services.validation.ElementValidator;

import java.util.List;

import static java.lang.System.lineSeparator;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ParserTest {

    public static final String EXPECTED_IMAGE_ELEMENT = "image element";
    public static final String EXPECTED_LINK_ELEMENT = "link element";
    public static final String IMAGES = "IMAGES";
    public static final String LINKS = "LINKS";

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    private ElementValidator elementValidator = mock(ElementValidator.class);
    private Element element = mock(Element.class);
    private Parser parser;
    private Elements someElements = new Elements();
    private List<String> result;

    @Test
    public void printsTheNameOfTheTypeOfElementsWeIntendToFind() throws Exception {
        parser = new Parser("IMAGES", elementValidator);
        result = parser.parse(someElements);
        thenTheConsolePrintsMessage();
    }

    @Test
    public void findsImages() throws Exception {
        when(element.attr(anyString())).thenReturn(EXPECTED_IMAGE_ELEMENT);
        when(elementValidator.isElementType(element)).thenReturn(true);
        when(element.tagName()).thenReturn("img");

        parser = new Parser(IMAGES, elementValidator);
        someElements.add(element);

        result = parser.parse(someElements);
        assertThat(result.get(0)).isEqualTo(EXPECTED_IMAGE_ELEMENT);
    }

    @Test
    public void findsLinks() throws Exception {
        when(element.attr(anyString())).thenReturn(EXPECTED_LINK_ELEMENT);
        when(elementValidator.isElementType(element)).thenReturn(true);
        when(element.tagName()).thenReturn("a");

        parser = new Parser(IMAGES, elementValidator);
        someElements.add(element);

        result = parser.parse(someElements);
        assertThat(result.get(0)).isEqualTo(EXPECTED_LINK_ELEMENT);

    }

    private void thenTheConsolePrintsMessage() {
        assertThat(systemOutRule.getLog()).isEqualTo("IMAGES" + lineSeparator());
    }

}