package hexlet.code.schemas;

/**
 * Схема валидации для чисел.
 */
public class NumberSchema extends BaseSchema<Number> {

    private boolean isPositive = false;
    private boolean hasRange = false;
    private int rangeMin;
    private int rangeMax;


    /**
     * Метод для установки проверки на положительность числа.
     *
     * @return текущую схему.
     */
    public NumberSchema positive() {
        this.isPositive = true;
        return this;
    }

    /**
     * Метод для установки параметров необходимого диапозона, в котором должно находиться валидное число.
     *
     * @param min минимальное число диапозона (включительно).
     * @param max максимальное число диапозона (включительно).
     * @return текущую схему.
     */
    public NumberSchema range(final int min, final int max) {
        this.hasRange = true;
        this.rangeMin = min;
        this.rangeMax = max;
        return this;
    }

    /**
     * Переопределение абстрактного метода required() из родительского класса {@link BaseSchema},
     * для уникальной валидации именно числа.
     *
     * @param value число, которое проходит проверки на валидность.
     * @return false || true в зависимости от того, валидно число или нет.
     */
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

    /**
     * Переопределение метода required() из родительсокго класса {@link BaseSchema} для корректного чейнинга методов.
     *
     * @return текущую схему.
     */
    @Override
    public NumberSchema required() {
        super.required();
        return this;
    }

}
