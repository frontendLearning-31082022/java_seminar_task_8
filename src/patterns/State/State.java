package patterns.State;

import patterns.State.PrinterPackage.Printer3D;

public class State {
    public static void main(String[] args) {
        Printer3D printer3D=new Printer3D(10000);

        printer3D.stopPrint();
        printer3D.runPrint();
        printer3D.load3Dmodel();
        printer3D.runPrint();
        printer3D.increaseSpeed();
    }
}
