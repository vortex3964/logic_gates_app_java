public class GatesOnBoard {

    private int inputwire1;
    private int inputwire2;
    private int outputwire;
    private int row;
    private int col;
    LogicGate gate;

    public GatesOnBoard(LogicGate gate, int col, int row, int inputwire1, int outputwire)
    {
        this.gate=gate;
        this.col=col;
        this.inputwire1=inputwire1;
        this.outputwire=outputwire;
        this.row=row;
    }

    public GatesOnBoard(LogicGate gate, int col, int row, int inputwire1, int inputwire2, int outputwire)
    {
        this(gate,col,row,inputwire1,outputwire);
        this.inputwire2=inputwire2;
    }

    public int getInputwire1() {
        return inputwire1;
    }



    public int getInputwire2() {
        return inputwire2;
    }

    public int getOutputwire() {
        return outputwire;
    }

    public void setOutputwire(int outputwire) {
        this.outputwire=outputwire;
    }

    public int getRow() {
        return row;
    }


    public int getCol() {
        return col;
    }


    public LogicGate getGate() {
        return gate;
    }

    public boolean Calc(boolean...var)
    {
        this.gate.setValues(gate.getCons(),var);
        this.gate.calculate();
        return this.gate.getOutput();
    }

}
