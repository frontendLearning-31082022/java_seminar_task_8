package patterns.FactoryMethod;

public class ChickagoPizzaStyle  extends Company.PizzaFactory{
    @Override
    Pizza createPizza(String id) {
        if (id.equals("cheese400"))return new PizzasTypes.CheesePizza();
        if (id.equals("fish400"))return new PizzasTypes.FishPizza();
        return null;
    }
    @Override
    String getNameHash() {
        return "ChickagoPizzaStyle";
    }

    class PizzasTypes{
        static class CheesePizza extends Pizza{}
        static class FishPizza extends  Pizza{}
    }
}
