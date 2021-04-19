package br.ufrn.extension.gatinhos.rescuesystem.rescuer;

import br.ufrn.extension.gatinhos.rescuesystem.adopter.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rescuer {
    private String name;
    private String email;
    private String nationalId;

   // @JsonSerialize(converter = LocalDateConverter.class)
    private LocalDate expeditionDate;

    private Address address;
}
