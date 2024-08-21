public class Not extends LogicGate{

    public Not()
    {
        super.setConnections(1);
    }

    void calculate() {
        this.status=!this.dataValues[0];
    }
}
