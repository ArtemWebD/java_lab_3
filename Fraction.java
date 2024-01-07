package lab_3;

public class Fraction {
    private Number numeric;
    private Number denominator;
    private char sign;
    private double value;

    public void setSign() {
        if (value > 0) {
            sign = '+';
        } else if (value < 0) {
            sign = '-';
        } else {
            sign = '\0';
        }
    }

    public int getDivider(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getDivider(b, a % b);
    }

    public int getMax() {
        if (value < 1) {
            return denominator.getValue();
        }
        return numeric.getValue();
    }

    public int getMin() {
        if (value < 1) {
            return numeric.getValue();
        }
        return denominator.getValue();
    }

    public void reduce() {
        int maxDivider = getDivider(getMax(), getMin());
        numeric.setValue(numeric.getValue() / maxDivider);
        denominator.setValue(denominator.getValue() / maxDivider);
    }

    public static Fraction createFraction(Number numeric, Number denominator) {
        Fraction fraction = new Fraction();
        fraction.value = numeric.getValue() * 1.0 / denominator.getValue();
        fraction.numeric = numeric;
        fraction.denominator = denominator;
        fraction.setSign();
        return fraction;
    }

    public static Fraction createFraction(Number value) {
        return createFraction(value, value);
    }

    public void print() {
        char sign;
        if (this.sign == '-') {
            sign = '-';
        } else {
            sign = '\0';
        }
        System.out.println(sign + Math.abs(numeric.getValue()) + "/" + Math.abs(denominator.getValue()));
    }

    public void add(Number number) {
        Fraction temp = createFraction(number, new Number(1));
        add(temp);
    }

    public void add(Fraction sumFraction) {
        Fraction temp = sumFraction;
        multiplyNumber(numeric, temp.denominator);
        multiplyNumber(temp.numeric, denominator);
        multiplyNumber(denominator, temp.denominator);

        if (sign == '-') {
            numeric.setSign(sign);
            numeric.setValue(numeric.getValue() * -1);
        }

        if (temp.sign == '-') {
            temp.numeric.setSign(sumFraction.sign);
            temp.numeric.setValue(temp.numeric.getValue() * -1);
        }

        addNumber(numeric, temp.numeric);

        reduce();

        value = numeric.getValue() * 1.0 / denominator.getValue();
        absNumber(numeric);
        setSign();
    }

    public void multiply(Fraction factor) {
        multiplyNumber(numeric, factor.numeric);
        multiplyNumber(denominator, factor.denominator);
        reduce();
        value *= factor.value;
        setSign();
    }

    public void multiply(Number factor) {
        Fraction temp = createFraction(factor, new Number(1));
        multiply(temp);
    }

    public void divide(Fraction divider) {
        Number temp = divider.numeric;
        divider.numeric = divider.denominator;
        divider.denominator = temp;
        multiply(divider);
    }

    public void divide(Number divider) {
        Fraction temp = createFraction(divider, new Number(1));
        divide(temp);
    }

    public char getSign() {
        return sign;
    }

    public void abs() {
        value = Math.abs(value);
        absNumber(numeric);
        absNumber(denominator);
        setSign();
    }

    private void absNumber(Number number) {
        number.setValue(Math.abs(number.getValue()));
        number.setSign('\0');
    }

    private void addNumber(Number a, final Number b) {
        if (a.getSign() == '\0' && b.getSign() == '\0') {
            a.setValue(a.getValue() + b.getValue());
        } else if (a.getSign() == '\0' && b.getSign() == '-') {
            if (a.getValue() >= b.getValue()) {
                a.setValue(a.getValue() - b.getValue());
            } else {
                a.setValue(b.getValue() - a.getValue());
                a.setSign('-');
            }
        } else if (a.getSign() == '-' && b.getSign() == '\0') {
            if (a.getValue() >= b.getValue()) {
                a.setValue(a.getValue() - b.getValue());
            } else {
                a.setValue(b.getValue() - a.getValue());
                a.setSign('\0');
            }
        } else if (a.getSign() == '-' && b.getSign() == '-') {
            a.setValue(a.getValue() + b.getValue());
            a.setSign('-');
        }
    }

    private void multiplyNumber(Number a, final Number b) {
        a.setValue(a.getValue() * b.getValue());
        if (a.getSign() != b.getSign()) {
            a.setSign('-');
        } else {
            a.setSign('\0');
        }
    }
}

