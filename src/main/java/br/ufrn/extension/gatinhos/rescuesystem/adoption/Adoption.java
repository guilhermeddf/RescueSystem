package br.ufrn.extension.gatinhos.rescuesystem.adoption;

import br.ufrn.extension.gatinhos.rescuesystem.cat.Cat;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@Document
public class Adoption {
    @Id
    private String id;
    private LocalDate adoptionDate;
    private List<Cat> adoptionCats;
    private Adopter adopter;
}
