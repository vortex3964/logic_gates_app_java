public class Xor extends LogicGate{


    public Xor()
    {
        super.setConnections(2);
    }

    void calculate() {
        this.status=this.dataValues[0]^this.dataValues[1];
    }
}
