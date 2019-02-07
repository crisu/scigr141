package ro.sci;

public class Book {

    private int nrPagini;
    private String nume;

    public int getNrPagini() {
        return nrPagini;
    }

    public void setNrPagini(int numaroarecare) {
        nrPagini = numaroarecare;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume1) {
        nume = nume1;
    }

    @Override
    public String toString() {
        return "Book{" +
                "nrPagini=" + nrPagini +
                ", nume='" + nume + '\'' +
                '}';
    }
}
