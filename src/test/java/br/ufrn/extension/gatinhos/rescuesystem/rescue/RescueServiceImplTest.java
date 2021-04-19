package br.ufrn.extension.gatinhos.rescuesystem.rescue;

import br.ufrn.extension.gatinhos.rescuesystem.adopter.Address;
import br.ufrn.extension.gatinhos.rescuesystem.adopter.RescueStatus;
import br.ufrn.extension.gatinhos.rescuesystem.exceptions.RescueNotFoundException;
import br.ufrn.extension.gatinhos.rescuesystem.rescuer.Rescuer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertAll;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Tag("service")
@DataMongoTest
@ExtendWith(SpringExtension.class)
public class RescueServiceImplTest {
    @Autowired
    private RescueRepository repository;

    @BeforeEach
    public void dataSetup(){
        Rescue r = RescueBuilder.createRescue().build();
        repository.save(r);
    }

    @Test
    @DisplayName("Deve retornar os dados de um resgate")
    void shouldReturnARescue(){
        Rescue rescue = repository.findById("uuid").orElseThrow(RescueNotFoundException::new);

        assertAll("rescue",
                () -> assertThat(rescue.getRescueStatus(), is(RescueStatus.ATENDIDO)),
                () -> assertThat(rescue.getExtraData(), is("Informações adicionais")),
                () -> assertThat(rescue.getId(), is("uuid")),
                () -> assertThat(rescue.getRescueDate(), is(LocalDate.of(2021,1, 1)))

        );

        Address rescueAddress = rescue.getAddress();
        assertAll("rescueAddress",
                () -> assertThat(rescueAddress.getCity(), is("Natal")),
                () -> assertThat(rescueAddress.getNeighbourhood(), is("Lagoa Nova")),
                () -> assertThat(rescueAddress.getNumber(), is("58")),
                () -> assertThat(rescueAddress.getStreetName(), is("Rua um"))
        );

        Rescuer rescuer = rescue.getRescuers().get(0);
        assertAll("rescuer",
                () -> assertThat(rescuer.getEmail(), is("email")),
                () -> assertThat(rescuer.getName(), is("Guilherme")),
                () -> assertThat(rescuer.getNationalId(), is("2001020047974")),
                () -> assertThat(rescuer.getExpeditionDate(), is(LocalDate.of(2021, 1, 1)))
        );
    }

    @Test
    @DisplayName("Deve retornar um erro se um resgate não for encontrado")
    void shouldThrowRescueNotFoundException(){
        assertThrows(RescueNotFoundException.class,
                () -> repository.findById("").orElseThrow(RescueNotFoundException::new));
    }
}
