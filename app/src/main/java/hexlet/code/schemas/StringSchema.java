package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        this.addCheck("required", str -> null != str && !str.isEmpty());
        return this;
    }

    public StringSchema minLength(int length) {
        this.addCheck("minLength", str -> null != str && str.length() >= length);
        return this;
    }

    public StringSchema contains(String substring) {
        this.addCheck("contains", str -> null != str && str.contains(substring));
        return this;
    }

}
