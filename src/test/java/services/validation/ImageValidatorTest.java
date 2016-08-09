package services.validation;

import org.jsoup.nodes.Element;
import org.junit.Test;
import org.mockito.stubbing.OngoingStubbing;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ImageValidatorTest {

    public static final boolean SUCCEDS = true;
    public static final boolean FAILS = false;
    private Element element = mock(Element.class);
    private ImageValidator imageValidator = new ImageValidator();
    private boolean validationResult;

    @Test
    public void passesValidation() throws Exception {
        givenAnImageElementWithTagName("img");
        whenTheImageValidatorValidatesIt();
        thenTheValidation(SUCCEDS);
    }

    @Test
    public void failsValidation() throws Exception {
        givenAnImageElementWithTagName("wrong tag name");
        whenTheImageValidatorValidatesIt();
        thenTheValidation(FAILS);
    }

    private void whenTheImageValidatorValidatesIt() {
        validationResult = imageValidator.isElementType(element);
    }

    private OngoingStubbing<String> givenAnImageElementWithTagName(String tagName) {
        return when(element.tagName()).thenReturn(tagName);
    }

    private void thenTheValidation(boolean expected) {
        assertThat(validationResult).isEqualTo(expected);
    }

}