package sngular;

public class Operation {

    double n1;
    double n2;
    double res;
    char operation;

    public Operation(double n1, double n2, char operation) {
        this.n1 = n1;
        this.n2 = n2;
        this.operation = operation;
    }

    public double getN1() {
        return n1;
    }

    public void setN1(double n1) {
        this.n1 = n1;
    }

    public double getN2() {
        return n2;
    }

    public void setN2(double n2) {
        this.n2 = n2;
    }

    public char getOperation() {
        return operation;
    }

    public void setOperation(char operation) {
        this.operation = operation;
    }

    public double getRes() {
        return res;
    }

    public void setRes(double res) {
        this.res = res;
    }
}
