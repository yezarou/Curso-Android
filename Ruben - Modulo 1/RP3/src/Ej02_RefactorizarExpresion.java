public class Ej02_RefactorizarExpresion {
    public static void main(String[] args) {
        boolean x, b = true;

        /*
        if (b) {
            x = true;
        } else {
            x = false;
        }
        */

        x=b;

        System.out.println(x);
        System.out.println(b);
    }
}
