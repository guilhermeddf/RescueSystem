package br.ufrn.extension.gatinhos.rescuesystem.user;

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

    private Address address;
    private String cnh;
    private UserStatus status;
    private List<Roles> userRoles;
    private String username;
    private String password;
    private boolean active;
    private boolean driveAvailability;
    private String neighbourhoodAvailability;
}
