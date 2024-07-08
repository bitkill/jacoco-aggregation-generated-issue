package org.ruifernandes;

import java.util.function.Function;

import org.ruifernandes.model.Bar;
import org.ruifernandes.model.Foo;

public class FooBarConverter implements Function<Foo, Bar> {

    @Override
    public Bar apply(Foo foo) {
        return new Bar(foo.getText());
    }
}
