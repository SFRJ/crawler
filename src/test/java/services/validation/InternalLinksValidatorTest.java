package services.validation;

import org.jsoup.nodes.Element;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InternalLinksValidatorTest {

    private final String BASE_URL = "http://javing.blogspot.co.uk";
    private final boolean SUCCEDS = true;
    private final boolean FAILS = false;
    private Element element = mock(Element.class);
    private InternalLinksValidator internalLinksValidator;

    @Test
    public void validationPasses() throws Exception {
        givenAnInternalLinksValidatorWith(BASE_URL);
        givenElementWithinTheSameDomain("abs:href");
        whenTheImageValidatorValidatesIt();
        thenTheValidation(SUCCEDS);
    }

    @Test
    public void validationFails() throws Exception {
        givenAnInternalLinksValidatorWith(BASE_URL);
        givenALinkElementPointingToAnExternalUrl();
        whenTheImageValidatorValidatesIt();
        thenTheValidation(FAILS);
    }

    //givens
    private void givenAnInternalLinksValidatorWith(String baseUrl) {
        internalLinksValidator = new InternalLinksValidator(baseUrl);
    }

    private void givenElementWithinTheSameDomain(String attributeName) {
        when(element.attr(attributeName)).thenReturn(BASE_URL);
    }

    private void givenALinkElementPointingToAnExternalUrl() {
        when(element.attr("abs:href")).thenReturn("some external url");
    }

    //whens
    private void whenTheImageValidatorValidatesIt() {
        internalLinksValidator.isElementType(element);
    }

    //thens
    private void thenTheValidation(boolean expectedValidationResult) {
        assertThat(expectedValidationResult).isEqualTo(expectedValidationResult);
    }

}