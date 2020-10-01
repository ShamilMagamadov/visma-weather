package no.visma;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


class WeatherControllerTest {

    WeatherController weatherController = new WeatherController();

    @Test
    public void test(){
        String result = weatherController.getNow();
        assertThat(result, is("pent"));
    }
}
