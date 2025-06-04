package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public class MapSchema<K, V> extends BaseSchema<Map<K, V>> {

    private int requiredSize;
    private boolean isSizeRequired = false;
    private Map<K, BaseSchema<? super V>> shapeSchemas = new HashMap<K, BaseSchema<? super V>>();

    public MapSchema<K, V> sizeof(final int requiredSize) {
        this.isSizeRequired = true;
        this.requiredSize = requiredSize;
        return this;
    }

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

    @SuppressWarnings("unchecked")
    public <T extends K, U extends V> void shape(final Map<T, BaseSchema<U>> schemas) {
        for (Map.Entry<T, ? extends BaseSchema<?>> entry : schemas.entrySet()) {
            shapeSchemas.put(entry.getKey(), (BaseSchema<? super V>) entry.getValue());
        }

    }

    @Override
    public MapSchema<K, V> required() {
        super.required();
        return this;
    }

}
