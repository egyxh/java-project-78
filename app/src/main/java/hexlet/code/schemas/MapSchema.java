package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

/**
 * Схема валидации для Map.
 */
public class MapSchema<K, V> extends BaseSchema<Map<K, V>> {

    private int requiredSize;
    private boolean isSizeRequired = false;
    private Map<K, BaseSchema<? super V>> shapeSchemas = new HashMap<K, BaseSchema<? super V>>();

    /**
     * Метод для установки точного значения, которому должен соответствовать размер Map.
     *
     * @param size число - необхожимый размер.
     * @return текущую схему.
     */
    public MapSchema<K, V> sizeof(final int size) {
        this.isSizeRequired = true;
        this.requiredSize = requiredSize;
        return this;
    }

    /**
     * Переопределение абстрактного метода required() из родительского класса {@link BaseSchema},
     * для уникальной валидации именно Map.
     *
     * @param map Map для проверки на валидность.
     * @return false || true в зависимости от того, валиден Map или нет.
     */
    @Override
    protected boolean checkValid(final Map<K, V> map) {
        if (this.isSizeRequired) {
            int size = map.size();
            if (size != this.requiredSize) {
                return false;
            }
        }

        if (null != this.shapeSchemas) {
            for (final Map.Entry<K, BaseSchema<? super V>> entry : this.shapeSchemas.entrySet()) {
                final K key = entry.getKey();
                final BaseSchema<? super V> schema = entry.getValue();
                final V value = map.get(key);

                if (!schema.isValid(value)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Метод для установки пар Key-Value, где ключ - это ключ, к которому применяется проверка на валидность,
     * а значение - это параметры для необходимой проверки.
     *
     * @param schemas Map с парами ключ-проверка валидности для этого ключа.
     */
    @SuppressWarnings("unchecked")
    public <T extends K, U extends V> void shape(final Map<T, BaseSchema<U>> schemas) {
        for (Map.Entry<T, ? extends BaseSchema<?>> entry : schemas.entrySet()) {
            shapeSchemas.put(entry.getKey(), (BaseSchema<? super V>) entry.getValue());
        }

    }

    /**
     * Переопределение метода required() из родительсокго класса {@link BaseSchema} для корректного чейнинга методов.
     *
     * @return текущую схему.
     */
    @Override
    public MapSchema<K, V> required() {
        super.required();
        return this;
    }

}
