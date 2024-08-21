public class Or extends LogicGate
{

    public Or()
    {
        super.setConnections(2);
    }


    void calculate() {
        this.status=this.dataValues[0]|this.dataValues[1];
    }
}
