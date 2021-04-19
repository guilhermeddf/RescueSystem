package br.ufrn.extension.gatinhos.rescuesystem.adoption;

import br.ufrn.extension.gatinhos.rescuesystem.exceptions.AdoptionNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdoptionServiceImpl implements AdoptionService{

    private final AdoptionRepository repository;

    @Override
    public void save(Adoption adoption) {
        repository.save(adoption);
    }

    @Override
    public void update(String id, AdoptionDTO adoptionDTO) {
        Adoption adoption = repository.findById(id).orElseThrow(AdoptionNotFoundException::new);
        adoption.setAdopter(adoptionDTO.getAdopter());
        adoption.setAdoptionCats(adoptionDTO.getAdoptionCats());
        repository.save(adoption);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Adoption> listAdoptions() {
        return repository.findAll();
    }

    @Override
    public Adoption findAdoption(String id) {
        return repository.findById(id).orElseThrow(AdoptionNotFoundException::new);
    }
}
