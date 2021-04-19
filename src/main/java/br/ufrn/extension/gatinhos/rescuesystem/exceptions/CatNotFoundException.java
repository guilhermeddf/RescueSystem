package br.ufrn.extension.gatinhos.rescuesystem.exceptions;

public class CatNotFoundException extends RuntimeException{
    public CatNotFoundException(String message){
        super(message);
    }

    public CatNotFoundException(){
    }
}
