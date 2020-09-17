package br.salvador.thiago.parametrizacao.validation.rules;

import java.util.Arrays;
import java.util.List;

public class IsValueInRangeOrExceptRule implements Rule {
    private Object toCheck;
    private List<Object> rangeValues;

    public IsValueInRangeOrExceptRule(Object toCheck, List<Object> rangeValues) {
        if(rangeValues == null)
            throw new NullPointerException("Erro na classe 'IsValueInRange', " +
                    "tentiva de passar o parâmetro 'listToCheck' nulo");

        this.toCheck = toCheck;
        this.rangeValues = rangeValues;
    }

    @Override
    public void doLogic(String paramName) {
        if(!rangeValues.contains(toCheck)) {
            throw new IllegalArgumentException("Parâmetro '" + paramName +
                    "' só aceita os valores " + Arrays.toString(this.rangeValues.toArray()));
        }
    }
}
