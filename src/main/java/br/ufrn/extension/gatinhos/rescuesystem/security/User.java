package br.ufrn.extension.gatinhos.rescuesystem.security;

import br.ufrn.extension.gatinhos.rescuesystem.adopter.Address;
import br.ufrn.extension.gatinhos.rescuesystem.cat.Cat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document
@Data
public class User {

    @Id
    private String id;
    private String name;
    private String email;
    private String nationalId;
    private LocalDate expeditionDate;
    private Roles userRole;
    private Address address;

    private String username;
    private String password;

    private boolean active;

    private List<Cat> adoptedCats;
}
