package br.ufrn.extension.gatinhos.rescuesystem.rescue;

import java.util.List;

public interface RescueService {
    void save(Rescue rescue);
    Rescue findRescue(String id);
    void delete(String id);
    void update(String id, RescueDTO rescueDTO);
    List<Rescue> listRescues();
}
