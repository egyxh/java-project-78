package hexlet.code.schemas;

/**
 * Схема валидации строк.
 */
public class StringSchema extends BaseSchema<String> {

    private int minStringLength = 0;
    private String stringShouldContains;

    /**
     * Метод для установки минимальной длины строки в условия валидации.
     *
     * @param minLength число, обозначающее минимальрную длину строки.
     * @return текущую схему.
     */
    public StringSchema minLength(final int minLength) {
        this.minStringLength = minLength;
        return this;
    }

    /**
     * Метод для установки подстроки в условия валидации (Проверяемая строка должна содержать данную подстроку).
     *
     * @param str строка для проверки на валидность.
     * @return текущую схему.
     */
    public StringSchema contains(final String str) {
        this.stringShouldContains = str;
        return this;
    }

    /**
     * Переопределение абстрактного метода required() из родительского класса {@link BaseSchema},
     * для уникальной валидации именно строки.
     *
     * @param val строка, которая проходит проверки на валидность.
     * @return false || true в зависимости от того, валидна строка или нет.
     */
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

    /**
     * Переопределение метода required() из родительсокго класса {@link BaseSchema} для корректного чейнинга методов.
     *
     * @return текущую схему.
     */
    @Override
    public StringSchema required() {
        super.required();
        return this;
    }

}
