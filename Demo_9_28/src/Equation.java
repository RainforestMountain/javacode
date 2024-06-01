public class Equation {
    //复数系下的一元二次方程求解
    public double a;
    public double b;
    public double c;

    public Equation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static void main(String[] args) {

        Equation equation = new Equation(9, 0, 1);
        System.out.println("a=" + equation.gettera());
        System.out.println("b=" + equation.setterb());
        System.out.println("c=" + equation.getterc());
        System.out.println("equation:" + equation.a + " * x * x +" + equation.b + " * x +" + equation.c + "= 0");
        System.out.println("Root1=" + equation.getRoot1());
        System.out.println("Root2=" + equation.getRoot2());
    }

    public double gettera() {
        return a;
    }

    public double setterb() {
        return b;
    }

    public double getterc() {
        return c;
    }

    public double getDiscriminant() {
        return b * b - 4 * a * c;
    }

    public String getRoot1() {
        if (getDiscriminant() < 0) {
            return ((-b) / (2 * a) + "+" + (Math.sqrt(Math.abs(getDiscriminant()))) / (2 * a) + "i");
        }
        return ((-b) / (2 * a) + "+" + (Math.sqrt(getDiscriminant())) / (2 * a) + "");
    }

    public String getRoot2() {
        if (getDiscriminant() < 0) {
            return ((-b) / (2 * a) + "-" + (Math.sqrt(Math.abs(getDiscriminant()))) / (2 * a) + "i");
        }
        return ((-b) / (2 * a) + "-" + (Math.sqrt(getDiscriminant())) / (2 * a) + "");
    }
}