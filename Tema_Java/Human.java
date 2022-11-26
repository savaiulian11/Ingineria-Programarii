public class Human implements IHuman, Comparable<Human> {
    protected String nume;
    protected String prenume;
    protected String facultate;
    int varsta;
    @Override
    public void doWork() {
    }

    @Override
    public void greeting() {
    }

    @Override
    public int compareTo(Human o) {
        if(this.varsta > o.varsta)
            return 1;
        if(this.varsta < o.varsta)
            return -1;
        return 0;
    }

    public Human(String nume, String prenume, String facultate, int Varsta){
        this.nume=new String(nume);
        this.prenume=new String(prenume);
        this.facultate=new String(facultate);
        this.varsta=varsta;
    }
}
