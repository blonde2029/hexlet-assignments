package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

// BEGIN
class AppTest {
    @Test
    void testImage() {
        String[][] arr = {
                {"*", "*", "*", "*"},
                {"*", " ", " ", "*"},
                {"*", " ", " ", "*"},
                {"*", "*", "*", "*"},
        };
        String[][] expected = {
                {"*", "*", "*", "*","*", "*", "*", "*"},
                {"*", "*", "*", "*","*", "*", "*", "*"},
                {"*", "*", " ", " "," ", " ", "*", "*"},
                {"*", "*", " ", " "," ", " ", "*", "*"},
                {"*", "*", " ", " "," ", " ", "*", "*"},
                {"*", "*", " ", " "," ", " ", "*", "*"},
                {"*", "*", "*", "*","*", "*", "*", "*"},
                {"*", "*", "*", "*","*", "*", "*", "*"},
        };
        String[][] actual = App.enlargeArrayImage(arr);
        assertThat(actual).isEqualTo(expected);
    }
}
// END
