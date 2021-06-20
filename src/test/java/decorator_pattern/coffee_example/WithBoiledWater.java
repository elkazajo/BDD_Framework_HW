package decorator_pattern.coffee_example;

import decorator_pattern.coffee_example.interfaces.Coffee;

public class WithBoiledWater extends CoffeeDecorator{
    public WithBoiledWater(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + boiled water";
    }

    @Override
    public int getCost() {
        return super.getCost() + 100;
    }
}
