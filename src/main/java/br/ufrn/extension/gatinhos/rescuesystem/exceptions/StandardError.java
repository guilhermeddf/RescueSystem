package br.ufrn.extension.gatinhos.rescuesystem.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class StandardError {
    private HttpStatus status;
    private String message;
    private Long timeStamp;
    private String path;
}
