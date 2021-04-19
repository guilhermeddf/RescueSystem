package br.ufrn.extension.gatinhos.rescuesystem.cat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cat {
    private String picture;
    private String name;
    private Age age;
    private CatStatus status;
    private boolean adopted = false;
}
