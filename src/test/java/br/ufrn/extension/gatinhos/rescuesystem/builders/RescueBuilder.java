package br.ufrn.extension.gatinhos.rescuesystem.builders;

import br.ufrn.extension.gatinhos.rescuesystem.cat.Age;
import br.ufrn.extension.gatinhos.rescuesystem.cat.Cat;
import br.ufrn.extension.gatinhos.rescuesystem.cat.CatHealthStatus;
import br.ufrn.extension.gatinhos.rescuesystem.rescue.Rescue;
import br.ufrn.extension.gatinhos.rescuesystem.rescue.RescueStatus;
import br.ufrn.extension.gatinhos.rescuesystem.user.Address;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class RescueBuilder {
    public static Rescue.RescueBuilder createRescue(){
        return Rescue.builder()
                .id("uuid")
                .extraData("Informações adicionais")
                .rescuedCats(createCatList())
                //.rescuers(createRescuerList())
                .address(createAddress().build())
                .rescueStatus(RescueStatus.ATENDIDO)
                .rescueDate(LocalDate.of(2021, 1, 1));

    }

    public static Address.AddressBuilder createAddress(){
        return Address.builder()
                .city("Natal")
                .neighbourhood("Lagoa Nova")
                .number("58")
                .streetName("Rua um");
    }
    public static List<Cat> createCatList(){
        return Collections.singletonList(createCat());
    }

    /*public static Rescuer.RescuerBuilder createRescuer(){
        return Rescuer.builder()
                .nationalId("2001020047974")
                .email("email")
                .name("Guilherme")
                .expeditionDate(LocalDate.of(2021, 1, 1))
                .address(createAddress().build());
    }
    public static List<Rescuer> createRescuerList(){
        return Collections.singletonList(createRescuer().build());
    }*/

    public static Cat createCat(){
        return Cat.builder()
                .adopted(false)
                .age(Age.FILHOTE)
                .healthStatus(CatHealthStatus.DOENTE)
                .name("Du Shit")
                .picture("picture")
                .build();
    }
}
