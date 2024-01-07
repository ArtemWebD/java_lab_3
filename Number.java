package lab_3;

public class Number {
	private int value;
    private char sign;

    public Number(int val) {
        value = val;
        setSign();
    }

    public void printNumber() {
        System.out.println(value);
    }

    public void addNumber(Number sumNumber) {
        value += sumNumber.value;
        setSign();
    }

    public void multiplyNumber(Number factor) {
        value *= factor.value;
        setSign();
    }

    public void divideNumber(Number divider) {
        value /= divider.value;
        setSign();
    }

    public char getSign() {
        return sign;
    }

    public void absNumber() {
        value = Math.abs(value);
        setSign();
    }

    private void setSign() {
        sign = (value > 0) ? '+' : ((value < 0) ? '-' : '\0');
    }
}
