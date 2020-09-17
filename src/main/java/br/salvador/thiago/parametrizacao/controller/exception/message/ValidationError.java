package br.salvador.thiago.parametrizacao.controller.exception.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor @AllArgsConstructor
@Getter
@ToString
public class ValidationError extends StandardError {

    private List<Field> fields = new ArrayList<>();

    public void addField(Field field) {
        this.fields.add(field);
    }
}
