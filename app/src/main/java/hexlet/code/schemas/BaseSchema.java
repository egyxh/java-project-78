package hexlet.code.schemas;

/**
 * Базовый абстрактный класс для всех схем валидации.
 *
 * @param <T> тип преданного значения, которое должно пройти валидацию.
 */
public abstract class BaseSchema<T> {

    private boolean isRequired = false;

    /**
     * Проверяет данные на валидность.
     *
     * @param value данные для проверки.
     * @return уникальную проверку для данных в зависимости от их типа
     * (Например: StringSchema.checkValid(value) для строк).
     */
    public boolean isValid(final T value) {
        if (value == null) {
            return !isRequired;
        }
        return this.checkValid(value);
    }

    /**
     * Метод добавляет проверку на NotNull.
     *
     * @return текущую схему.
     */
    public BaseSchema<T> required() {
        this.isRequired = true;
        return this;
    }

    /**
     * Абстрактный метод для дочерних классов, который реализовывает уникальную проверку для каждого типа данных.
     *
     * @param value данные для проверки на валидность.
     * @return false || true в зависимости от того,валидна строка или нет.
     */
    protected abstract boolean checkValid(T value);

    /**
     * Геттер для поля isRequired класса BaseSchema.
     *
     * @return значение поля isRequired.
     */
    protected boolean getIsRequired() {
        return this.isRequired;
    }

}
