package br.ufrn.extension.gatinhos.rescuesystem.adopter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String streetName;
    private String number;
    private String neighbourhood;
    private String city;
}
