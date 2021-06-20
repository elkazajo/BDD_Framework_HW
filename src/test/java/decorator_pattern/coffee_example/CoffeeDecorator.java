package decorator_pattern.coffee_example;

import decorator_pattern.coffee_example.interfaces.Coffee;

public abstract class CoffeeDecorator implements Coffee {

    private Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription();
    }

    @Override
    public int getCost() {
        return coffee.getCost();
    }
}
