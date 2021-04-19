package br.ufrn.extension.gatinhos.rescuesystem.adopter;

import br.ufrn.extension.gatinhos.rescuesystem.cat.Cat;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
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
    private LocalDate expeditionDate;

    private Address address;
    private List<Cat> adoptedCats;
}
