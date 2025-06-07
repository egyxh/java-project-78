package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        addCheck("required", str -> !str.isEmpty());
        this.setRequired(true);
        return this;
    }

    public StringSchema minLength(int length) {
        this.addCheck("minLength", str -> str.length() >= length);
        return this;
    }

    public StringSchema contains(String substring) {
        this.addCheck("contains", str -> str.contains(substring));
        return this;
    }

}
