import com.sample.app.Main;
import junit.framework.TestCase;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class MainTest extends TestCase {

    private Main main;

    @Before
    public void setUp() {
        main = new Main();
    }

    @Test
    public void test_shouldSayHello() {
        // given
        String expected = "Hello!";
        // when
        String actual = main.sayHello();
        // then
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    public void test_shouldNotSayHi() {
        // given
        String hi = "Hi";
        // when
        String expected = main.sayHello();
        // then
        assertThat(expected).isNotEqualTo(hi);
    }

    @Test
    public void test_dateAndTimeShouldBeCurrent() {
        // given
        DateTime dateTime = new DateTime();
        String expected = getDateTimeString(dateTime);
        // when
        String currentDateTime = main.getCurrentDateTime();
        // then
        assertThat(currentDateTime).isEqualTo(expected);
    }

    @Test
    public void test_currentDateAndTimeShouldNotBeInPast() {
        // given
        DateTime dateTime = new DateTime().minusDays(1);
        String expected = getDateTimeString(dateTime);
        // when
        String currentDateTime = main.getCurrentDateTime();
        // then
        assertThat(currentDateTime).isNotEqualTo(expected);
    }

    @Test
    public void test_currentDateAndTimeShouldNotBeInFuture() {
        // given
        DateTime dateTime = new DateTime().plusDays(1);
        String expected = getDateTimeString(dateTime);
        // when
        String currentDateTime = main.getCurrentDateTime();
        // then
        assertThat(currentDateTime).isNotEqualTo(expected);
    }

    private String getDateTimeString(DateTime dateTime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        return dateTime.toString(dateTimeFormatter);
    }
}
