public class Profesor extends Human{
    private String materie;

    @Override
    public void doWork() {

    }

    @Override
    public void greeting() {

    }

    @Override
    public String toString() {
        String temp=new String("");
        temp +="Prof. "+super.nume+" "+super.prenume+"\n";
        temp +="\tFac. "+super.facultate+"\n";
        temp +="\tVarsta "+super.varsta+"\n";
        temp +="\tMaterie "+this.materie+"\n";

        return temp;
    }

    public Profesor(String nume, String prenume, String facultate, int varsta, String materie){
        super(nume,prenume,facultate,varsta);
        this.materie=new String(materie);
    }
}
