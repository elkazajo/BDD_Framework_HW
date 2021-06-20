package decorator_pattern.coffee_example;

import decorator_pattern.coffee_example.interfaces.Coffee;

public class Espresso implements Coffee {

    @Override
    public String getDescription() {
        return "espresso";
    }

    @Override
    public int getCost() {
        return 500;
    }
}
