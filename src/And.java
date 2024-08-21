public class And extends LogicGate
{

    public And()
    {
        super.setConnections(2);
    }

    void calculate()
    {
        this.status=this.dataValues[0]&this.dataValues[1];
    }
}
