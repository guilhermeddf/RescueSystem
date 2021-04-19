package br.ufrn.extension.gatinhos.rescuesystem.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticateUser implements Serializable {
    private String username;
    private String password;
}
