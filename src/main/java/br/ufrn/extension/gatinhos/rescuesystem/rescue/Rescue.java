package br.ufrn.extension.gatinhos.rescuesystem.rescue;

import br.ufrn.extension.gatinhos.rescuesystem.adopter.Address;
import br.ufrn.extension.gatinhos.rescuesystem.adopter.RescueStatus;
import br.ufrn.extension.gatinhos.rescuesystem.cat.Cat;
import br.ufrn.extension.gatinhos.rescuesystem.rescuer.Rescuer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Rescue {
    @Id
    private String id;
    private Address address;
    private List<Cat> rescuedCats;
    private List<Rescuer> rescuers;
    private RescueStatus rescueStatus;
    private String extraData;

    //@JsonSerialize(converter = LocalDateConverter.class)
    private LocalDate rescueDate;
}
