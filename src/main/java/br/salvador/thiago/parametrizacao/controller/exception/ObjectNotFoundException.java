package br.salvador.thiago.parametrizacao.controller.exception;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(Object identifier, String entity) {
        super("Não foi possível encontrar " + entity + " de identificador " + identifier.toString());
    }
}
