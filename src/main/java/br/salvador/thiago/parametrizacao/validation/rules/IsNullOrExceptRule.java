package br.salvador.thiago.parametrizacao.validation.rules;

public class IsNullOrExceptRule implements Rule {
    private Object object;

    public IsNullOrExceptRule(Object object) {
        this.object = object;
    }

    @Override
    public void doLogic(String paramName) {
        if(object == null) {
            throw new NullPointerException("Parâmetro '" + paramName +
                    "' não deve ser nulo");
        }
    }
}
