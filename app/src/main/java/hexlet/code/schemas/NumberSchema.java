package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Number> {

    public NumberSchema required() {
        this.setRequired(true);
        return this;
    }

    public NumberSchema positive() {
        this.addCheck("positive", num -> num.doubleValue() > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        this.addCheck("range", num -> num.doubleValue() >= min && num.doubleValue() <= max);
        return this;
    }

}
