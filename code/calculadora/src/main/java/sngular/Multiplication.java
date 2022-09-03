package sngular;

public class Multiplication extends Operation {

    double multi;

    public Multiplication(double n1, double n2) {
        super(n1, n2, '*');
        this.multi = n1 * n2;
        this.setRes(this.multi);
    }
}
