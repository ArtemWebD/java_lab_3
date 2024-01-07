package lab_3;

public class Variable {
    private float value;
    private char sign;

    public Variable() {
        value = 0;
        sign = '\0';
    }

    public void setVariable(Number number) {
        value = number.getValue();
        sign = number.getSign();
    }

    public void setVariable(Decimal number) {
        value = number.getValue();
        sign = number.getSign();
    }

    public void setVariable(Fraction number) {
        value = number.getValue();
        sign = number.getSign();
    }

    public void setVariable(IrrationalNumber number) {
        value = number.getValue();
        sign = number.getSign();
    }

    public char getSign() {
        return sign;
    }

    public void absVariable() {
        sign = '+';
        value = Math.abs(value);
    }
}

