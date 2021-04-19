package br.ufrn.extension.gatinhos.rescuesystem.adoption;

import br.ufrn.extension.gatinhos.rescuesystem.cat.Cat;
import br.ufrn.extension.gatinhos.rescuesystem.user.Address;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document
@Data
@Builder
public class Adopter implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;
    private String email;
    private String nationalId;

    private Address address;
    private List<Cat> adoptedCats;
    private boolean hasAnimals;
    private boolean isolation;
}
