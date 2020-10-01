package no.visma.v2;

import no.visma.kurs.domain.WeatherResponse;
import no.visma.kurs.domain.WeatherResponse.Properties;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static no.visma.kurs.domain.WeatherResponse.Properties.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherControllerV2Test {

    @Mock
    private WeatherFetcher weatherFetcher;

    @InjectMocks
    private WeatherControllerV2 controller;

    @Test
    public void get() {

        WeatherResponse weatherResponse = new WeatherResponse();
        Properties properties = new Properties();
        List<TimeSerie> timeSeries = new ArrayList<>();
        TimeSerie timeSerie1 = new WeatherResponse.Properties.TimeSerie();
        TimeSerie timeSerie2 = new WeatherResponse.Properties.TimeSerie();
        TimeSerie.WeatherData weatherData = new WeatherResponse.Properties.TimeSerie.WeatherData();
        TimeSerie.WeatherData.Instant instant = new TimeSerie.WeatherData.Instant();
        TimeSerie.WeatherData.Instant.Details details = new TimeSerie.WeatherData.Instant.Details();
        weatherResponse.setProperties(properties);
        properties.setTimeseries(timeSeries);
        timeSeries.add(timeSerie1);
        timeSerie1.setData(weatherData);
        weatherData.setInstant(instant);
        instant.setDetails(details);
        details.setAirTemperature(100.0);
        details.setCloudAreaFraction(200.0);
        details.setWindSpeed(300.0);
        timeSerie1.setTime(LocalDateTime.now().plusHours(1));

        when(weatherFetcher.getCurrent()).thenReturn(weatherResponse);

        String result = controller.get();

        assertThat(result, containsString("100.0"));
        assertThat(result, containsString("200.0"));
        assertThat(result, containsString("300.0"));
    }
}