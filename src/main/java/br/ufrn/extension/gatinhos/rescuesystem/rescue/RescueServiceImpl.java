package br.ufrn.extension.gatinhos.rescuesystem.rescue;

import br.ufrn.extension.gatinhos.rescuesystem.exceptions.RescueNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RescueServiceImpl implements RescueService{
    private final RescueRepository repository;

    @Override
    public void save(Rescue rescue) {
        repository.save(rescue);
    }

    @Override
    public Rescue findRescue(String id) {
        return repository.findById(id).orElseThrow(RescueNotFoundException::new);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public void update(String id, RescueDTO rescueDTO) {
        Rescue r = repository.findById(id).orElseThrow(RescueNotFoundException::new);

    }

    @Override
    public List<Rescue> listRescues() {
        return repository.findAll();
    }
}
