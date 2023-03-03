package task_2;

// 3. Есть интерфейс RoundHole - описание круглое отверстия (имеет радиус) double getRadius()
// Есть интерфейс RoundPeg - описание круглого колышка (тоже есть радиус)
// Есть класс RoundHoleMachine, у которой метод, принмает RoundPeg, возвращает RoundHole
// Есть интерфейс SquarePeg - описание квадратного колышка (имеет длину стороны кварата)
// Реализовать адаптер для SquarePeg в RoundHoleMachine
public class Holes {
    public static void main(String[] args) {
        RoundPeg roundPeg = new RoundPeg() {
            int radius = 10;

            @Override
            public double getRadius() {
                return radius;
            }
        };

        RoundHole roundHole = RoundHoleMachine.getHole(roundPeg);

        SquarePeg squarePeg = new SquarePeg() {
            int oneSide = 16;

            @Override
            public int getSquareOneLenght() {
                return oneSide;
            }
        };

        RoundHole roundHole2 = RoundHoleMachine.getHole(squarePeg);
        new String();

    }
}

interface RoundHole {
    //круглое отверстие
    double getRadius();
}

interface RoundPeg {
    // круглый колышек
    double getRadius();
}

class RoundHoleMachine {
    static RoundHole getHole(RoundPeg roundPeg) {
        RoundHole roundHole = new RoundHole() {
            double radius = roundPeg.getRadius() + 0.02;

            @Override
            public double getRadius() {
                return radius;
            }
        };
        return roundHole;
    }

    public static RoundHole getHole(SquarePeg squarePeg) {
        double squareDiagonal = squarePeg.getSquareOneLenght() * Math.sqrt(2);
        squareDiagonal = squareDiagonal + 0.02;

        double radius = squareDiagonal;

        return new RoundHole() {
            @Override
            public double getRadius() {
                return radius;
            }
        };
    }
}

interface SquarePeg {
    // квадратный колышек
    int getSquareOneLenght();
}