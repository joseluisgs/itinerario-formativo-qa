package sngular;

public class Addition extends Operation {

    double suma;

    public Addition(double n1, double n2) {
        super(n1, n2, '+');
        this.suma = n1 + n2;
        this.setRes(this.suma);
    }
}
