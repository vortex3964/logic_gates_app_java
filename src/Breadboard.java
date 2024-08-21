
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;

public class Breadboard {
    private final static int ROWS=10;
    private final static int COLS=3;
    private static boolean[][] board=new boolean[COLS][ROWS];
    private static Results[] results=new Results[ROWS];
    private ArrayList<ArrayList<GatesOnBoard>> components=new ArrayList<>();

    public void add_component(ArrayList<GatesOnBoard> component)
    {
        components.add(component);
    }

    static
    {
        for (int i=0;i<ROWS;i++)
        {
            results[i]=new Results();
        }
    }

    public void calculateOutput()
    {
        PrintWriter writer;
        for(ArrayList<GatesOnBoard> comp:this.components)
        {
            for(GatesOnBoard gate:comp)
            {
                try
                {
                    writer=new PrintWriter("Output.txt");
                    board[gate.getCol()+1][gate.getOutputwire()]=gate.Calc(board[gate.getCol()][gate.getInputwire1()],board[gate.getCol()][gate.getInputwire2()]);
                    System.out.println("the result of gate "+gate.getGate().getClass().getName()+" at column:"+gate.getCol()+" row:"+gate.getRow()+" is:"+board[gate.getCol()+1][gate.getOutputwire()]);

                    writer.println("the result of gate "+gate.getGate().getClass().getName()+" at column:"+gate.getCol()+" row:"+gate.getRow()+" is:"+board[gate.getCol()+1][gate.getOutputwire()]);
                    writer.flush();
                    writer.close();
                }
                catch(Exception e)
                {

                    Results temp=new Results();
                    temp.setResult(gate.Calc(board[gate.getCol()][gate.getInputwire1()],board[gate.getCol()][gate.getInputwire2()]));
                    results[gate.getOutputwire()]=temp;
                }
            }
        }
        this.printResults();
    }

    public void setValue(int col,int row,boolean val)
    {
        board[col][row]=val;
    }



    public void printResults()
    {
        PrintWriter writer=null;
        try
        {
            writer=new PrintWriter("Output.txt");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        int index=0;
        for(int i=0;i<ROWS;i++)
        {
            if(results[i].isEligible())
            {
                index++;
                System.out.println("the result of the circuit "+index+" is:"+results[i].GetResult());
                try {
                    Objects.requireNonNull(writer).println("the result of the circuit " + index + " is:" + results[i].GetResult());
                    writer.flush();
                    writer.close();
                }
                catch (Exception e)
                {
                    System.out.println("something went wrong with the writer");
                }
            }
        }
    }


}
