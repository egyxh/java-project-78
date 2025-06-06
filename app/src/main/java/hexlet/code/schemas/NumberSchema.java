package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Number> {

    @Override
    public NumberSchema required() {
        this.setRequired(true);
        this.addCheck("required", num -> null != num);
        return this;
    }

    public NumberSchema positive() {
        this.addCheck("positive", num -> num.doubleValue() > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        this.addCheck("range", num -> null != num && num.doubleValue() >= min && num.doubleValue() <= max);
        return this;
    }

}
