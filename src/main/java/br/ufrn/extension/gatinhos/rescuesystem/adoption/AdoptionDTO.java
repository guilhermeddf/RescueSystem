package br.ufrn.extension.gatinhos.rescuesystem.adoption;

import br.ufrn.extension.gatinhos.rescuesystem.cat.Cat;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class AdoptionDTO {

    private LocalDate adoptionDate;
    private List<Cat> adoptionCats;
    private Adopter adopter;
}
