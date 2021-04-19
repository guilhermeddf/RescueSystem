package br.ufrn.extension.gatinhos.rescuesystem.cat;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CatDTO {
    private String name;
    private Age age;
    private boolean adopted = false;
}
