public class Results {
    private boolean result=false;
    private boolean eligible=false;



    public void setResult(boolean val)
    {
        this.result=val;
        this.eligible=true;
    }

    public boolean GetResult() {
        return this.result;
    }

    public boolean isEligible() {
        return this.eligible;
    }

    public void overwrite()
    {
        this.eligible=false;
    }
}
