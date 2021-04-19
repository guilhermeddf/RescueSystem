package br.ufrn.extension.gatinhos.rescuesystem.cat;

import java.util.List;

public interface CatService {
    void save(Cat cat);
    void delete(String id);
    Cat findCatById(String id);
    void update(String id, CatDTO catDTO);
    List<Cat> listAll();
}
