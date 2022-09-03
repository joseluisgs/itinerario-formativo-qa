package sngular;

public class Subtraction extends Operation {

    double rest;

    public Subtraction(double n1, double n2) {
        super(n1, n2, '-');
        this.rest = n1 - n2;
        this.setRes(this.rest);
    }
}
