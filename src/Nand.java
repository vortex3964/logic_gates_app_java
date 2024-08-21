public class Nand extends LogicGate{


    public Nand()
    {
        super.setConnections(2);
    }

    void calculate() {
        this.status=!(this.dataValues[0]&this.dataValues[1]);
    }
}
