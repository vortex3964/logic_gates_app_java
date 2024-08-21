import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private static File input=new File("Circuit.txt");
    private static File output=new File("Output.txt");
    private ArrayList<String> data;
    private PrintWriter writer;

    public FileHandler()
    {
        try {
            this.writer=new PrintWriter(output);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.saveData(input);
    }

    public void saveData(File input)
    {
        this.data=new ArrayList<>();
        try
        {
            Scanner buff=new Scanner(input);
            buff.useDelimiter("\n");
            while(buff.hasNext())
            {
                this.data.add(buff.nextLine());
            }
        }
        catch (Exception e)
        {
            System.out.print("the file couldn't open");
        }
    }

    public void printData()
    {
        for(String s:this.data)
        {
            System.out.println(s);
        }
    }

    public ArrayList<String> getData() {
        return data;
    }

    public void writeTofile(String s)
    {
        writer.println(s);
        writer.flush();
    }

}
