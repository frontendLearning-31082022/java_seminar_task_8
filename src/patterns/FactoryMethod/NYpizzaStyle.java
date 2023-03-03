package patterns.FactoryMethod;


public class NYpizzaStyle extends Company.PizzaFactory {
    @Override
    Pizza createPizza(String id) {
        if (id.equals("cheese300"))return new PizzasTypes.CheesePizza();
        if (id.equals("fish300"))return new PizzasTypes.FishPizza();
        return null;
    }
    @Override
    String getNameHash() {
        return "NYpizzaStyle";
    }

    class PizzasTypes{
        static class CheesePizza extends Pizza{}
        static class FishPizza extends  Pizza{}
    }
}
