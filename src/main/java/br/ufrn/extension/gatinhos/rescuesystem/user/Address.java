package br.ufrn.extension.gatinhos.rescuesystem.user;

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
    private String extraData;
    private String cep;
    private boolean noScape;

}
