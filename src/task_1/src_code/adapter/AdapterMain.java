package task_1.src_code.adapter;

public class AdapterMain {

    public static void main(String[] args) {
        Computer computer = new Computer();

        Mouse mouse = new Mouse();

//        computer.accept(mouse);
        computer.accept(new MouseUsbAdapter(mouse));
    }

}
