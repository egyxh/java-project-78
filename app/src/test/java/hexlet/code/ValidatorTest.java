package hexlet.code;

import java.util.HashMap;
import java.util.Map;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorTest {

    private Validator v;

    @BeforeEach
    void setUpValidator() {
        v = new Validator();
    }

    @Test
    void testStringSchemaBasic() {
        StringSchema schema = v.string();
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid("test"));

        schema.required();
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));
        assertTrue(schema.isValid("test"));
    }

    @Test
    void testStringSchemaContains() {
        StringSchema schema = v.string().required();
        schema.contains("third");

        assertTrue(schema.isValid("test for third project"));
        assertFalse(schema.isValid("just a test"));
    }

    @Test
    void testStringSchemaMinLength() {
        StringSchema schema = v.string().required();
        schema.minLength(5);

        assertTrue(schema.isValid("test for third project"));
        assertTrue(schema.isValid("aTest"));
        assertFalse(schema.isValid("test"));
    }

    @Test
    void testNumberSchemaBasic() {
        NumberSchema schema = v.number();
        assertTrue(schema.isValid(null));

        schema.required();
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(4.0));
        assertTrue(schema.isValid(10));
    }

    @Test
    void testNumberSchemaPositive() {
        NumberSchema schema = v.number().positive();

        assertFalse(schema.isValid(-1));
        assertFalse(schema.isValid(0));
        assertTrue(schema.isValid(1.0));
    }

    @Test
    void testNumberSchemaRange() {
        NumberSchema schema = v.number().range(5, 10);

        assertFalse(schema.isValid(-1));
        assertTrue(schema.isValid(6));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(12));
    }

    @Test
    void testMapSchemaRequiredSize() {
        MapSchema schema = v.map();

        assertTrue(schema.isValid(null));
        schema.required();
        assertFalse(schema.isValid(null));

        assertTrue(schema.isValid(new HashMap<>()));
        Map<String, String> map = Map.of("key", "value", "key2", "value2");
        assertTrue(schema.isValid(map));

        schema.sizeOf(2);
        assertTrue(schema.isValid(map));
        assertFalse(schema.isValid(new HashMap<>()));
    }

    @Test
    void testMapSchemaShapeValid() {
        MapSchema schema = v.map();
        schema.required();

        Map<String, BaseSchema<String>> shape = new HashMap<>();
        shape.put("name", v.string().required().minLength(3));
        shape.put("email", v.string().required().contains("@"));

        schema.shape(shape);

        Map<String, String> validData = Map.of("name", "Alice", "email", "alice@gmail.com");
        Map<String, String> invalidName = Map.of("name", "Jo", "email", "jo@gmail.com");
        Map<String, String> invalidEmail = Map.of("name", "Bobby", "email", "bobbygmail.com");
        assertTrue(schema.isValid(validData));
        assertFalse(schema.isValid(invalidName));
        assertFalse(schema.isValid(invalidEmail));
    }

}
