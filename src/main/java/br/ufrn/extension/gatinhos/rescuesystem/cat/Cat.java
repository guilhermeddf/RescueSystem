package br.ufrn.extension.gatinhos.rescuesystem.cat;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
public class Cat {
    private String picture;
    private String name;
    private Age age;
    private CatHealthStatus healthStatus;
    private boolean adopted = false;
}
