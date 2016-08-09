package services.print;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.List;

import static java.lang.System.lineSeparator;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class ElementPrinterTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    private List<String> elements;
    private ElementPrinter elementPrinter = new ElementPrinter();


    @Test
      public void printsAllElements() throws Exception {
         givenSomeElements();
         whenThePrinterIsAskedToPrintThem();
         thenTheConsolePrintsAllTheLinks();
      }

    private void thenTheConsolePrintsAllTheLinks() {
        assertThat(systemOutRule.getLog()).isEqualTo(
                "link-A" + lineSeparator() +
                "link-B" + lineSeparator() +
                "link-C" + lineSeparator());
    }

    //givens
    private void givenSomeElements() {
        elements = asList("link-A", "link-B", "link-C");
    }

    //whens
    private void whenThePrinterIsAskedToPrintThem() {
        elementPrinter.printElements(elements);
    }

}