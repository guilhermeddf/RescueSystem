package br.ufrn.extension.gatinhos.rescuesystem.adoption.v1;

import br.ufrn.extension.gatinhos.rescuesystem.adoption.Adoption;
import br.ufrn.extension.gatinhos.rescuesystem.adoption.AdoptionDTO;
import br.ufrn.extension.gatinhos.rescuesystem.adoption.AdoptionService;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("v1/adoption")
public class AdoptionController {
    private final AdoptionService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void save (@RequestBody Adoption adoption){
        service.save(adoption);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Adoption> listAll(){
        return service.listAdoptions();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Adoption findRescue(@PathVariable String id){
        return service.findAdoption(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateRescue(@PathVariable String id, @RequestBody AdoptionDTO adoptionDTO) {
        service.update(id, adoptionDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}/delete")
    public void deleteRescue(@PathVariable String id){
        service.delete(id);
    }
}
