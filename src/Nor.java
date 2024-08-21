public class Nor extends LogicGate
{

    void calculate() {
        this.status=!(this.dataValues[0]|this.dataValues[1]);
    }
}
