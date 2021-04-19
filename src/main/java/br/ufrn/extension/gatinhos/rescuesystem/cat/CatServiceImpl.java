package br.ufrn.extension.gatinhos.rescuesystem.cat;

import br.ufrn.extension.gatinhos.rescuesystem.exceptions.CatNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatServiceImpl implements CatService {
    private final CatRepository catRepository;

    @Override
    public void save(Cat cat) {
        catRepository.save(cat);
    }

    public void delete(String id){
       Cat c = catRepository.findById(id).orElseThrow(CatNotFoundException::new);
       catRepository.delete(c);
    }

    public Cat findCatById(String id) {
        return catRepository.findById(id).orElseThrow(CatNotFoundException::new);
    }

    public void update(String id, CatDTO catDTO) {
        Cat c = catRepository.findById(id).orElseThrow(CatNotFoundException::new);
        c.setAdopted(catDTO.isAdopted());
        c.setAge(catDTO.getAge());
        c.setName(catDTO.getName());
        catRepository.save(c);
    }

    public List<Cat> listAll(){
        return catRepository.findAll();
    }

}
