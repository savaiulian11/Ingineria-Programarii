public class Student extends Human{
    private int anStudiu;

    @Override
    public void doWork() {
    }

    @Override
    public void greeting() {
    }

    @Override
    public String toString() {
        String temp=new String("");
        temp +="Sd. "+super.nume+" "+super.prenume+"\n";
        temp +="\tAnul "+this.anStudiu+"\n";
        temp +="\tFac. "+super.facultate+"\n";
        temp +="\tVarsta "+super.varsta+"\n";

        return temp;
    }

    public Student(String nume, String prenume, String facultate, int varsta, int anStudiu){
        super(nume,prenume,facultate,varsta);
        this.anStudiu=anStudiu;
    }
}
