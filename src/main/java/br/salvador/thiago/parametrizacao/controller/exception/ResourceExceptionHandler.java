package br.salvador.thiago.parametrizacao.controller.exception;

import br.salvador.thiago.parametrizacao.controller.ParametroProdutoEsteiraController;
import br.salvador.thiago.parametrizacao.controller.exception.message.Field;
import br.salvador.thiago.parametrizacao.controller.exception.message.StandardError;
import br.salvador.thiago.parametrizacao.controller.exception.message.ValidationError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(ParametroProdutoEsteiraController.class);

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        StandardError standardError = new StandardError(
                HttpStatus.BAD_REQUEST,
                ex.getMessage(),
                ex.getClass().getSimpleName(),
                LocalDateTime.now()
        );

        this.logger.error(standardError.toString(), ex);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ValidationError validationError = new ValidationError();
        validationError.setException(ex.getClass().getSimpleName());
        validationError.setHttpStatus(HttpStatus.BAD_REQUEST);
        validationError.setMessage("Erro de validação");
        validationError.setDateTime(LocalDateTime.now());
;
        for(FieldError field : ex.getBindingResult().getFieldErrors()) {
            validationError.addField(new Field(field.getField(), field.getDefaultMessage()));
        }

        this.logger.error(validationError.toString(), ex);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationError);
    }

    @ExceptionHandler({
            IllegalArgumentException.class,
            NullPointerException.class,
            ObjectNotFoundException.class
    })
    public ResponseEntity<Object> handleWith(Exception ex) {
        StandardError standardError = new StandardError(
                HttpStatus.BAD_REQUEST,
                ex.getMessage(),
                ex.getClass().getSimpleName(),
                LocalDateTime.now()
        );

        this.logger.error(standardError.toString(), ex);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
    }
}
