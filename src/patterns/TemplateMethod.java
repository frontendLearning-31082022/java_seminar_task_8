package patterns;

public class TemplateMethod {

    public static void main(String[] args) {
        FishPizzaMaking.main(null);
        VegetianPizzaMaking.main(null);
    }

    public static abstract class PizzaMaking{
        void doPizza(){
            prepapareDough();
            addIngridients();
            prepareOven();
            bake();
        }
        abstract void addIngridients();
        private void bake() {}
        private void prepareOven() {}
        private void prepapareDough() {}
    }

    static class VegetianPizzaMaking extends TemplateMethod.PizzaMaking {
        public VegetianPizzaMaking(){}
        public static void main(String[] args) {
            VegetianPizzaMaking pizza=new VegetianPizzaMaking();
            pizza.doPizza();
        }
        @Override
        void addIngridients() {
            prepareVegeterian1();
            cookVegetiarian2();
        }
        private void prepareVegeterian1() {}
        private void cookVegetiarian2() {}
    }

    static class FishPizzaMaking extends TemplateMethod.PizzaMaking{
        public static void main(String[] args) {
            FishPizzaMaking pizza=new FishPizzaMaking();
            pizza.doPizza();
        }
        @Override
        void addIngridients() {
            catchOmar();
            collectStars();
        }
        private void catchOmar() {}
        private void collectStars() {}
    }
}
