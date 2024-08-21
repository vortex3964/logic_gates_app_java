import java.util.ArrayList;

abstract class LogicGate
{
   private final static int MAX=2;
   private final static int Min=1;

   protected boolean[] dataValues=new boolean[MAX];
   protected boolean status;
   abstract void calculate();

   private int connections;

   public void setConnections(int ins)
   {
       this.connections=ins;
   }


   public void setValues(int connections,boolean...var)
   {
       for(int i=0;i<connections;i++)
       {
           dataValues[i]=var[i];
       }
   }

   public boolean getOutput()
   {
       return this.status;
   }

   public int getCons()
   {
       return this.connections;
   }

}
