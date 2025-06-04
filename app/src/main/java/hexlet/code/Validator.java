package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

/**
 * Класс-фабрика для создания схем валидации различных типов данных.
 */

public class Validator {

    /**
     * Создает схему валидации строк.
     *
     * @return новый экземпляр{@link StringSchema}
     */
    public StringSchema string() {
        return new StringSchema();
    }

    /**
     * Создает схему валидации чисел.
     *
     * @return новый экземпляр{@link NumberSchema}
     */
    public NumberSchema number() {
        return new NumberSchema();
    }

    /**
     * Создает схему валидации для Map.
     *
     * @return новый экземпляр{@link MapSchema}
     */
    public MapSchema map() {
        return new MapSchema();
    }

}
