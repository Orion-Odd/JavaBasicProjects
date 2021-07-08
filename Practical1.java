import java.util.Scanner;

class Complex
{
    private int x, y;    //real - imaginary
    Scanner sc = new Scanner(System.in);

    Complex(int real, int imaginary){
        x = real;
        y = imaginary;
    }

    public static void addTwoComplex(Complex c1, Complex c2){
        int r,i;
        r = c1.x + c2.x;
        i = c1.y + c2.y;
        System.out.println("Final complex number: "+r+" + "+i+"i");
    }

    public static void multiplyTwoComplex(Complex c1, Complex c2){
        int r, i;              //(x+yi)(u+vi) = (xu - yv) + (xv + yu)i       -> Rule for multiplication
        r = c1.x*c2.x - c1.y*c2.y;
        i = c1.x*c2.y + c1.y*c2.x;
        System.out.println("Final Complex number: "+r+" + "+i+"i");
    }

    @Override
    public String toString(){
        return x+ " +i"+y; 
    }
}

public class Practical1 
{
    public static void main(String[] args) {
        Complex c1 = new Complex(3,2);
        Complex c2 = new Complex(1,4);
        Complex.addTwoComplex(c1,c2);
        Complex.multiplyTwoComplex(c1, c2);
        System.out.println(c1.toString());
    }
}
 
