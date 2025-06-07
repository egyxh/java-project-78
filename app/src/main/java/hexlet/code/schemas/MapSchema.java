package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema<Map<?, ?>> {

    public MapSchema required() {
        this.setRequired(true);
        return this;
    }

    public MapSchema sizeof(final int size) {
        this.addCheck("sizeof", data -> data.size() == size);
        return this;
    }

    public <T> MapSchema shape(Map<String, BaseSchema<T>> schemas) {
        this.addCheck("shape", data -> {
            for (Map.Entry<String, BaseSchema<T>> entry : schemas.entrySet()) {
                Object value = data.get(entry.getKey());
                if (!entry.getValue()
                        .isValid((T) value)) {
                    return false;
                }
            }
            return true;
        });
        return this;
    }

}
