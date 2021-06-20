package decorator_pattern.coffee_example;

import decorator_pattern.coffee_example.interfaces.Coffee;

public class WithSugar extends CoffeeDecorator{
    public WithSugar(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + sugar";
    }

    @Override
    public int getCost() {
        return super.getCost() + 50;
    }
}
