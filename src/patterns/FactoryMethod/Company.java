package patterns.FactoryMethod;

import javax.swing.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Company {
    HashMap<String, PizzaFactory>typesFactoring=new HashMap<>();
    public Company(PizzaFactory[] StylesAvailibleAtCompany) {
        Arrays.stream(StylesAvailibleAtCompany).forEach(x->typesFactoring.put(x.getNameHash(),x));
    }
    public Pizza makePizzaForSelling(String id){
        //by id choose what factoring and type pizza - some reference table need
        return typesFactoring.get("NYpizzaStyle").makePizzaForSelling(id);
    }

    public static void main(String[] args) {
        Company pizzaCompany=new Company(new PizzaFactory[]{new ChickagoPizzaStyle()
                ,new NYpizzaStyle()});
        Pizza pizzaNYcheese= pizzaCompany.makePizzaForSelling("cheese300");
    }

    abstract static class PizzaFactory{
        public Pizza makePizzaForSelling(String id){
            Pizza pizza = createPizza(id);
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
            return pizza;
        }
        abstract Pizza createPizza(String id);
        abstract String getNameHash();
    }
}
