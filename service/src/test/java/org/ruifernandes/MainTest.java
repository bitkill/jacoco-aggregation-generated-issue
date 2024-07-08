package org.ruifernandes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.ruifernandes.model.Foo;

public class MainTest {

    @BeforeAll
    public static void testStarted() {
        System.out.println("Test started");
    }

    @Test
    @DisplayName("Tests converting from Foo to Bar")
    public void testConversion() {
        var input = new Foo("samesame", 123);
        var converter = new FooBarConverter();
        var output = converter.apply(input);

        Assertions.assertNotNull(output);
        Assertions.assertEquals(input.getText(), output.getText());
    }
}
