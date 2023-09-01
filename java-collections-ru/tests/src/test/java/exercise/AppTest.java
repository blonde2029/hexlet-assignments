package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {
    private static final List<Integer> numbers = List.of(1,2,3,4);

    @Test
    void testTake() {
        // BEGIN
        List<Integer> expected = List.of(1,2);
        List<Integer> actual = App.take(numbers, 2);
        assertThat(actual).isEqualTo(expected);

        assertThat(App.take(numbers, 10)).isEqualTo(numbers);
        // END
    }
    @Test
    void testTakeEmpty() {
        List<Integer> expected = new ArrayList<>();
        assertThat(App.take(numbers, 0)).isEqualTo(expected);
    }
    @Test
    void testTakeNotEmpty() {
        assertThat(App.take(numbers, 1)).isNotEmpty();
    }
    @Test
    void testTakeSize() {
        assertThat(App.take(numbers, 2)).size().isEqualTo(2);
    }
    @Test
    void testTakeContains() {
        assertThat(App.take(numbers, 3)).contains(3);
    }

}
