package task_1.src_code.adapter;

public class MouseUsbAdapter implements Usb {

    private final Mouse mouse;

    public MouseUsbAdapter(Mouse mouse) {
        this.mouse = mouse;
    }

}
