package no.visma.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherControllerV1 {
    @GetMapping("now")
    public String getNow() {
        return "pent";
    }
}
