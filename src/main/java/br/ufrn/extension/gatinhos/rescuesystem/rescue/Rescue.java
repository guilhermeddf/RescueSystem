package br.ufrn.extension.gatinhos.rescuesystem.rescue;

import br.ufrn.extension.gatinhos.rescuesystem.cat.Cat;
import br.ufrn.extension.gatinhos.rescuesystem.user.Address;
import br.ufrn.extension.gatinhos.rescuesystem.user.Rescuer;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@Document
public class Rescue {
    @Id
    private String id;
    private Address address;
    private List<Cat> rescuedCats;
    private List<Rescuer> rescuers;
    private RescueStatus rescueStatus;
    private String extraData;
    private LocalDate rescueDate;
    private LocalDate creationDate;
    private String materials;
}
