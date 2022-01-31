import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

class HelloWorldTest implements WithAssertions {

    private static final Pattern EXPECTED_RESPONSE = Pattern.compile("Hello .+, I am .+");

    @DisplayName("Your code should introduce you if the user's name is null")
    @Test
    public void testBuildResponseChecksNull() {
        assertThat(HelloWorld.buildResponse(null)).as("the response should have the form 'Hello, I am <your name>").startsWith("Hello, I am");
    }

    @DisplayName("When the user provides their name, you should greet them and introduce yourself.")
    @Test
    public void testBuildResponse() {
        String response = HelloWorld.buildResponse("Alice");
        assertThat(response).as("the response should have the form 'Hello Alice, I am <your name>'").matches(EXPECTED_RESPONSE);
    }

}