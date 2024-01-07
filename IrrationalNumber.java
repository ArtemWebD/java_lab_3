package lab_3;

public class IrrationalNumber {
    private float value;
    private char sign;

    public void setSign() {
        if (value > 0) {
            sign = '+';
        } else if (value < 0) {
            sign = '-';
        } else {
            sign = '\0';
        }
    }

    public static IrrationalNumber createIrrationalNumber(float value) {
        IrrationalNumber irrationalNumber = new IrrationalNumber();
        irrationalNumber.value = value;
        irrationalNumber.setSign();
        return irrationalNumber;
    }

    public void print() {
        System.out.println(value + "...");
    }

    public void add(IrrationalNumber sumNumber) {
        value += sumNumber.value;
        setSign();
    }

    public void add(Number sumNumber) {
        value += sumNumber.getValue();
        setSign();
    }

    public void add(float sumValue) {
        value += sumValue;
        setSign();
    }

    public void multiply(IrrationalNumber factor) {
        value *= factor.value;
        setSign();
    }

    public void multiply(Number factor) {
        value *= factor.getValue();
        setSign();
    }

    public void multiply(float factor) {
        value *= factor;
        setSign();
    }

    public void divide(IrrationalNumber divider) {
        value /= divider.value;
        setSign();
    }

    public void divide(Number divider) {
        value /= divider.getValue();
        setSign();
    }

    public void divide(float divider) {
        value /= divider;
        setSign();
    }

    public char getSign() {
        return sign;
    }

    public void abs() {
        value = Math.abs(value);
        sign = '+';
    }
}

