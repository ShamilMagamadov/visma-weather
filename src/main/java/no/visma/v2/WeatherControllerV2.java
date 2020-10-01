package no.visma.v2;

import lombok.RequiredArgsConstructor;
import no.visma.kurs.domain.WeatherResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.time.LocalDateTime;
import static java.util.Comparator.comparing;

@RestController
@RequestMapping("v2")
@RequiredArgsConstructor
public class WeatherControllerV2 {
    private final WeatherFetcher weatcherFetcher;

    @GetMapping("now")
    public String get(){
        WeatherResponse weatherResponse = weatcherFetcher.getCurrent();
        WeatherResponse.Properties.TimeSerie timeSerie = weatherResponse.getProperties().getTimeseries().stream().
                filter(t -> t.getTime().isAfter(LocalDateTime.now()))
                //.min(comparing(t -> t.getTime())).
                .findFirst().
                        orElseThrow(RuntimeException::new);
        return formatResponse(timeSerie);
    }

    private String formatResponse(WeatherResponse.Properties.TimeSerie timeSerie){
        WeatherResponse.Properties.TimeSerie.WeatherData.Instant.Details details = timeSerie.getData().getInstant().getDetails();
        return String.format("Temperatur: %s C, vindfart: %s m/s, skyarealbruk: %s",
                details.getAirTemperature(),
                details.getWindSpeed(),
                details.getCloudAreaFraction());
    }
}
