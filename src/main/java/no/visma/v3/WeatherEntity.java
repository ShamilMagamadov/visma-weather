package no.visma.v3;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import static no.visma.v3.WeatherEntity.TABLE_NAME;

@Data // Getter and Setter
@Entity // Dette er en entitet som skal oppdages av Spring og kobles mot en database. Representer en tabell
@Table(name = TABLE_NAME)
@Builder // Trenger NoArgsConstructor.
@NoArgsConstructor // Tar inn alle og ingen parametere.
@AllArgsConstructor // Tar inn alle parmetere.
public class WeatherEntity {
    public static final String TABLE_NAME = "T_WEATHER";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // Lager kolonner for tabellen
    private LocalDateTime time;
    private String temperatur;
    private String vindhastighet;
    private String broek;


}
