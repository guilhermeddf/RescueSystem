package br.ufrn.extension.gatinhos.rescuesystem.rescue;

import br.ufrn.extension.gatinhos.rescuesystem.adopter.Address;
import br.ufrn.extension.gatinhos.rescuesystem.adopter.RescueStatus;
import br.ufrn.extension.gatinhos.rescuesystem.cat.Cat;
import br.ufrn.extension.gatinhos.rescuesystem.rescuer.Rescuer;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class RescueDTO {
    private Address address;
    private List<Cat> rescuedCats;
    private List<Rescuer> rescuers;
    private RescueStatus rescueStatus;
    private String extraData;
    private LocalDate rescueDate;
}
