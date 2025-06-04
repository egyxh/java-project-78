package hexlet.code.schemas;

public abstract class BaseSchema<T> {

    private boolean isRequired = false;

    public boolean isValid(final T value) {
        if (value == null) {
            return !isRequired;
        }
        return this.checkValid(value);
    }

    public BaseSchema<T> required() {
        this.isRequired = true;
        return this;
    }

    protected abstract boolean checkValid(T value);

    protected boolean getIsRequired() {
        return this.isRequired;
    }

}
