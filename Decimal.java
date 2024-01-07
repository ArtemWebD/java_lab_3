package lab_3;

public class Decimal {
    private Number integer;
    private Number fractional;
    private char sign;
    private float value;

    public void setSign() {
        if (value < 0) {
            sign = '-';
        } else if (value > 0) {
            sign = '+';
        } else {
            sign = '\0';
        }
    }

    public void separate() {
        int temp = (int) value;
        float n;
        integer = createNumber(temp);
        fractional = createNumber(Math.abs(modf(value, &n)));
    }

    public static Decimal createDecimal(Number integer, Number fractional) {
        Decimal decimal = new Decimal();
        decimal.sign = '\0';

        if (integer.getSign() == '\0') {
            decimal.sign = fractional.getSign();
        } else {
            decimal.sign = integer.getSign();
        }

        absNumber(integer);
        absNumber(fractional);

        decimal.integer = integer;
        decimal.fractional = fractional;

        decimal.value = integer.getValue() + fractional.getValue() / 10.0;

        return decimal;
    }

    public static Decimal createDecimal(float value) {
        Decimal decimal = new Decimal();
        decimal.sign = '\0';
        decimal.value = value;

        if (value < 0) {
            decimal.sign = '-';
        } else if (value > 0) {
            decimal.sign = '+';
        }

        decimal.separate();

        return decimal;
    }

    public void print() {
        System.out.println(value);
    }

    public void add(Decimal sumDecimal) {
        value += sumDecimal.getValue();
        setSign();
        separate();
    }

    public void add(Number number) {
        value += number.getValue();
        setSign();
        separate();
    }

    public void multiply(Decimal factor) {
        value *= factor.getValue();
        setSign();
        separate();
    }

    public void multiply(Number factor) {
        value *= factor.getValue();
        setSign();
        separate();
    }

    public void divide(Decimal divider) {
        value /= divider.getValue();
        setSign();
        separate();
    }

    public void divide(Number divider) {
        value /= divider.getValue();
        setSign();
        separate();
    }

    public char getSign() {
        return sign;
    }

    public void abs() {
        value = Math.abs(value);
        absNumber(integer);
        absNumber(fractional);
        sign = '+';
    }

    private static Number createNumber(int value) {
        Number number = new Number();
        number.setValue((float) value);
        number.setSign((value < 0) ? '-' : '\0');
        return number;
    }

    private static void absNumber(Number number) {
        number.setValue(Math.abs(number.getValue()));
        number.setSign('\0');
    }

    private static float modf(float value, float[] n) {
        n[0] = (float) Math.floor(value);
        return value - n[0];
    }
}

