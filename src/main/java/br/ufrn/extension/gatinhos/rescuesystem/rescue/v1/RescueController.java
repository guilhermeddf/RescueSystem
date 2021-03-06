package br.ufrn.extension.gatinhos.rescuesystem.rescue.v1;

import br.ufrn.extension.gatinhos.rescuesystem.rescue.Rescue;
import br.ufrn.extension.gatinhos.rescuesystem.rescue.RescueDTO;
import br.ufrn.extension.gatinhos.rescuesystem.rescue.RescueService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Rescue> listAll(){
        return service.listRescues();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Rescue findRescue(@PathVariable String id){
        return service.findRescue(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateRescue(@PathVariable String id, @RequestBody RescueDTO rescueDTO) {
        service.update(id, rescueDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}/delete")
    public void deleteRescue(@PathVariable String id){
        service.delete(id);
    }
}
