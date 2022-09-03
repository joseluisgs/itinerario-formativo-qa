package sngular;

public class Addition extends Operation {

    double add;

    public Addition(double n1, double n2) {
        super(n1, n2, '+');
        this.add = n1 + n2;
        this.setRes(this.add);
    }
}
