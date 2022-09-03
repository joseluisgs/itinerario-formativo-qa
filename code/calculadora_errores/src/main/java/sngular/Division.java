package sngular;

public class Division extends Operation {

    double div = 0;

    public Division(double n1, double n2) {
        super(n1, n2, '/');
        if(n2==0) throw new ArithmeticException("Division by zero!");
        else this.div = n1 / n2;
        // this.setRest(n1)
        this.setRes(this.div);
    }

}
