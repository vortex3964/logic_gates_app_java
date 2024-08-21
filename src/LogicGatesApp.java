import java.util.ArrayList;
import java.util.Scanner;

public class LogicGatesApp {
    public static void main(String[] args)
    {
        System.out.println("logic gates app the values in the breadboard are by default false");

        //read a Circuit file and output to a results fill

        /*commands:
        * and column_of_breadboard row_of_breadboard connection_slot1 connection_slot2 output_slot_of_the_next_column
        * or  column_of_breadboard row_of_breadboard connection_slot1 connection_slot2 output_slot_of_the_next_column
        * xor column_of_breadboard row_of_breadboard connection_slot1 connection_slot2 output_slot_of_the_next_column
        * nand column_of_breadboard row_of_breadboard connection_slot1 connection_slot2 output_slot_of_the_next_column
        * not column_of_breadboard row_of_breadboard connection_slot  output_slot_of_the_next_column
        * nor column_of_breadboard row_of_breadboard connection_slot1 connection_slot2 output_slot_of_the_next_column
        * switch column_of_breadboard row_of_breadboard value_that_you_want (1=true and 0=false)
        * */

        FileHandler handler=new FileHandler();
        ArrayList<GatesOnBoard> gates =new ArrayList<>();
        Breadboard brd=new Breadboard();

        ArrayList<String> data=handler.getData();

        for(String s:data)
        {
            Scanner buf=new Scanner(s);
            buf.useDelimiter("[, \n]+");

            String row;
            String column;
            String w1;
            String w2;
            String out;

            switch (buf.next().toLowerCase())
            {
                case"and":
                    column=buf.next();
                    row=buf.next();
                    w1=buf.next();
                    w2=buf.next();
                    out=buf.next();
                    gates.add(new GatesOnBoard(new And(),Integer.parseInt(column),Integer.parseInt(row),Integer.parseInt(w1),Integer.parseInt(w2),Integer.parseInt(out)));
                    break;
                case"or":
                    column=buf.next();
                    row=buf.next();
                    w1=buf.next();
                    w2=buf.next();
                    out=buf.next();
                    gates.add(new GatesOnBoard(new Or(),Integer.parseInt(column),Integer.parseInt(row),Integer.parseInt(w1),Integer.parseInt(w2),Integer.parseInt(out)));
                    break;
                case"xor":
                    column=buf.next();
                    row=buf.next();
                    w1=buf.next();
                    w2=buf.next();
                    out=buf.next();
                    gates.add(new GatesOnBoard(new Xor(),Integer.parseInt(column),Integer.parseInt(row),Integer.parseInt(w1),Integer.parseInt(w2),Integer.parseInt(out)));
                    break;
                case"nand":
                    column=buf.next();
                    row=buf.next();
                    w1=buf.next();
                    w2=buf.next();
                    out=buf.next();
                    gates.add(new GatesOnBoard(new Nand(),Integer.parseInt(column),Integer.parseInt(row),Integer.parseInt(w1),Integer.parseInt(w2),Integer.parseInt(out)));
                    break;
                case"not":
                    column=buf.next();
                    row=buf.next();
                    w1=buf.next();
                    out=buf.next();
                    gates.add(new GatesOnBoard(new Not(),Integer.parseInt(column),Integer.parseInt(row),Integer.parseInt(w1),Integer.parseInt(out)));
                    break;
                case "switch":
                    column=buf.next();
                    row=buf.next();
                    boolean val= buf.next().equals("1");
                    brd.setValue(Integer.parseInt(column),Integer.parseInt(row),val);
                    break;
                case"nor":
                    column=buf.next();
                    row=buf.next();
                    w1=buf.next();
                    w2=buf.next();
                    out=buf.next();
                    gates.add(new GatesOnBoard(new Nor(),Integer.parseInt(column),Integer.parseInt(row),Integer.parseInt(w1),Integer.parseInt(w2),Integer.parseInt(out)));
                    break;
                default:
                    System.out.println("not an option");
                    break;
            }

        }
        brd.add_component(gates);
        brd.calculateOutput();
        //brd.printResults();
    }
}
