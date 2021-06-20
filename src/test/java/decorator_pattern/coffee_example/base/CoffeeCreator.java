package decorator_pattern.coffee_example.base;

import decorator_pattern.coffee_example.*;
import decorator_pattern.coffee_example.interfaces.Coffee;

public class CoffeeCreator {

    public static void main(String[] args) {
        Coffee espresso = new Espresso();
        printCoffee(espresso);

        Coffee americano = new WithBoiledWater(new Espresso());
        printCoffee(americano);

        Coffee sweetAmericano = new WithBoiledWater(new WithSugar(new Espresso()));
        printCoffee(sweetAmericano);

        Coffee sweetAmericanoWithMilk = new WithBoiledWater(new WithMilk(new WithSugar(espresso)));
        printCoffee(sweetAmericanoWithMilk);

    }

    public static void printCoffee(Coffee coffee) {
        System.out.println("Ingredients: " + coffee.getDescription()
                + " Cost: " + coffee.getCost());
    }

}
