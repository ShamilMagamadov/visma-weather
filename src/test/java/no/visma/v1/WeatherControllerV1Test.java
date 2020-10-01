package no.visma.v1;

import no.visma.v1.WeatherControllerV1;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;


class WeatherControllerV1Test {

    WeatherControllerV1 weatherController = new WeatherControllerV1();

    @Test
    public void test(){
        String result = weatherController.getNow();
        assertThat(result, is("pent"));
        assertThat(result, containsString("pe"));
    }
}
