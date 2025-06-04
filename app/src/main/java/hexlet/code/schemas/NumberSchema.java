package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Number> {

    private boolean isPositive = false;
    private boolean hasRange = false;
    private int rangeMin;
    private int rangeMax;


    public NumberSchema positive() {
        this.isPositive = true;
        return this;
    }

    public NumberSchema range(final int min, final int max) {
        this.hasRange = true;
        this.rangeMin = min;
        this.rangeMax = max;
        return this;
    }

    @Override
    protected boolean checkValid(final Number value) {
        if (this.isPositive && value.doubleValue() < 1) {
            return false;
        }
        if (this.hasRange && (value.doubleValue() < this.rangeMin || value.doubleValue() > this.rangeMax)) {
            return false;
        }
        return true;
    }

    @Override
    public NumberSchema required() {
        super.required();
        return this;
    }

}
