package br.salvador.thiago.parametrizacao.service.exception;

public class NotFoundException extends RuntimeException {

    private static final long SerialVersionUID = 1L;

    public NotFoundException(String msg) {
        super(msg);
    }
}
