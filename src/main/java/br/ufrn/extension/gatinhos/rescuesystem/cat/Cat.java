package br.ufrn.extension.gatinhos.rescuesystem.cat;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document
@Data
@Builder
public class Cat {
    @Id
    private String id;
    private String name;
    private String race;

    private Gender gender;
    private boolean castrated;
    private boolean fiv = false;
    private boolean felv = false;

    private String fur;

    private String characteristics;

    private List<Vaccine> vaccineList;
    private String deathCause;
    private LocalDate deathDate;

    private boolean captured;
    private Age age;
    private CatHealthStatus healthStatus;
    private boolean adopted = false;
    private boolean decease;
    private boolean disappeared;

    private String picture;
}
