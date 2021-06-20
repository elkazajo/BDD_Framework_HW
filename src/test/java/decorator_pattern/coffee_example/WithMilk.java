package decorator_pattern.coffee_example;

import decorator_pattern.coffee_example.interfaces.Coffee;

public class WithMilk extends CoffeeDecorator{
    public WithMilk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + milk";
    }

    @Override
    public int getCost() {
        return super.getCost() + 100;
    }
}
