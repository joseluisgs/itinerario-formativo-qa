package sngular;

public class Substraction extends Operation {

    double rest;

    public Substraction(double n1, double n2) {
        super(n1, n2, '-');
        this.rest = n1 - n2;
        // este comentario no tiene sentido
        this.setRes(this.rest);
    }
}
