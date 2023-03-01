package patterns.State.PrinterPackage;

public class Printer3D {
    private State3Dprinter state;
    private long filamentLenght;

    Object file3Dmodel = null;

    public Printer3D(long filamentLenght) {
        this.filamentLenght = filamentLenght;
        this.state = new ReadyToPrint(this);
    }

    void setState(State3Dprinter state) {
        this.state = state;
    }

    public void runPrint() {state.runPrint();}
    public void stopPrint() {state.stopPrint();}
    public void load3Dmodel() {state.load3Dmodel();}
    public void unLoadFilament() {state.unLoadFilament();}
    public void increaseSpeed() {state.increaseSpeed();}


}


interface State3Dprinter {

    void runPrint();

    void stopPrint();

    void load3Dmodel();

    void unLoadFilament();

    void increaseSpeed();

}


class ReadyToPrint implements State3Dprinter {

    Printer3D printer3D;

    public ReadyToPrint(Printer3D printer3D) {
        this.printer3D = printer3D;
    }


    @Override
    public void runPrint() {
        if (printer3D.file3Dmodel == null) {
            System.out.println("Load 3d model at first!");
            return;
        }

        System.out.println("Lets go");
        printer3D.setState(new PrintingTime(printer3D));
    }

    @Override
    public void stopPrint() {
        System.out.println("Nothing to stop!");
    }

    @Override
    public void load3Dmodel() {
        printer3D.file3Dmodel=new Object();
        System.out.println("New 3d model added");
    }

    @Override
    public void unLoadFilament() {
        System.out.println("Filament removed");
    }

    @Override
    public void increaseSpeed() {
        System.out.println("Speed increased");
    }
}


class FillamentOver implements State3Dprinter {
    public FillamentOver(Printer3D printer3D) {
        this.printer3D = printer3D;
    }

    Printer3D printer3D;

    @Override
    public void runPrint() {
        System.out.println("Need filament! Can't run!");
    }

    @Override
    public void stopPrint() {
        System.out.println("AlreadyStopped");
    }

    @Override
    public void load3Dmodel() {
        System.out.println("New 3d model added");
    }

    @Override
    public void unLoadFilament() {
        System.out.println("No filament.Nothing unload!");
    }

    @Override
    public void increaseSpeed() {
        System.out.println("Speed increased");
    }
}

class AutoReScan implements State3Dprinter {
    public AutoReScan(Printer3D printer3D) {
        this.printer3D = printer3D;
    }

    Printer3D printer3D;

    @Override
    public void runPrint() {
        System.out.println("No free thread!Error!");
    }

    @Override
    public void stopPrint() {
        System.out.println("Stop scanning");
        printer3D.setState(new ReadyToPrint(printer3D));
    }

    @Override
    public void load3Dmodel() {
        System.out.println("Can't! Error");
    }

    @Override
    public void unLoadFilament() {
        System.out.println("Can't! Error");
    }

    @Override
    public void increaseSpeed() {
        System.out.println("Can't! Error");
    }
}

class PrintingTime implements State3Dprinter {
    Printer3D printer3D;

    public PrintingTime(Printer3D printer3D) {
        this.printer3D = printer3D;
    }


    @Override
    public void runPrint() {
        System.out.println("Error! Printing already!");
    }

    @Override
    public void stopPrint() {
        System.out.println("Stopped");
        printer3D.setState(new ReadyToPrint(printer3D));
    }

    @Override
    public void load3Dmodel() {
        System.out.println("Error! Printing already!");
    }

    @Override
    public void unLoadFilament() {
        System.out.println("Error! Printing already!");
    }

    @Override
    public void increaseSpeed() {
        System.out.println("Speed increased");
    }
}


