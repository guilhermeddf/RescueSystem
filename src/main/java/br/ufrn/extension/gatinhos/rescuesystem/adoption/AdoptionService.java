package br.ufrn.extension.gatinhos.rescuesystem.adoption;

import java.util.List;

public interface AdoptionService {
    void save(Adoption adoption);
    void update(String id, AdoptionDTO adoptionDTO);
    void delete(String id);
    List<Adoption> listAdoptions();
    Adoption findAdoption(String id);
}
