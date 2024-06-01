public class Test {
    public static void main(String[] args) {
        try {
            method();
        } catch (NullPointerException e) {
            e.printStackTrace(System.out);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace(System.err);
        }
    }

    public static void method() throws RuntimeException {
        int[] array = new int[100];
        //array = null;
        array[100] = 0;
    }
}
