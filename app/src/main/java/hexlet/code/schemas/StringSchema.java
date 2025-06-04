package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {

    private int minStringLength = 0;
    private String stringShouldContains;

    public StringSchema minLength(final int minLength) {
        this.minStringLength = minLength;
        return this;
    }

    public StringSchema contains(final String str) {
        this.stringShouldContains = str;
        return this;
    }

    @Override
    protected boolean checkValid(final String val) {
        if (val.isEmpty() && this.getIsRequired()) {
            return false;
        }
        if (val.length() < this.minStringLength) {
            return false;
        }

        if (this.stringShouldContains != null && !val.contains(this.stringShouldContains)) {
            return false;
        }
        return true;
    }

    @Override
    public StringSchema required() {
        super.required();
        return this;
    }

}
