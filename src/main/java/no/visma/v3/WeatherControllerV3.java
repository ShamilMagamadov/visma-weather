package no.visma.v3;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@RestController
@RequestMapping("v3")
@RequiredArgsConstructor
public class WeatherControllerV3 {

    private final WeatherRepository repository;

    @GetMapping("now")
    public WeatherEntity getNow(@RequestParam String param) {
        System.out.println(param);
        LocalDateTime nowIsh = LocalDateTime.now().plusHours(1).truncatedTo(ChronoUnit.HOURS);
        return repository.findByTime(nowIsh);
    }
}
