package no.visma.v3;

import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;

public interface WeatherRepository extends CrudRepository<WeatherEntity, Long> {
    WeatherEntity findByTime(LocalDateTime time);
}
