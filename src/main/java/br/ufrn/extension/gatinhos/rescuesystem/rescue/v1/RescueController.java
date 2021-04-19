package br.ufrn.extension.gatinhos.rescuesystem.rescue.v1;

import br.ufrn.extension.gatinhos.rescuesystem.rescue.Rescue;
import br.ufrn.extension.gatinhos.rescuesystem.rescue.RescueService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/rescue")
@Slf4j
public class RescueController {
    private final RescueService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void save(@RequestBody Rescue rescue){
        service.save(rescue);
        log.debug(String.format("saving a rescue from %s", rescue.getRescuedCats().get(0)));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Rescue> listAll(){

        return service.listAll();
    }
}
