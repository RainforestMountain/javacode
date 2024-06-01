import java.lang.reflect.Field;

public class SwapUtil {

    public static void swap(Object obj1, String field1Name, Object obj2, String field2Name) throws Exception {
        Field field1 = obj1.getClass().getDeclaredField(field1Name);
        field1.setAccessible(true);
        Field field2 = obj2.getClass().getDeclaredField(field2Name);
        field2.setAccessible(true);

        int temp = field1.getInt(obj1);
        field1.setInt(obj1, field2.getInt(obj2));
        field2.setInt(obj2, temp);
    }

    public static void main(String[] args) throws Exception {
        class Data {
            public int a;
            public int b;

            public Data(int a, int b) {
                this.a = a;
                this.b = b;
            }
        }

        Data data = new Data(10, 20);
        System.out.println("Before swap: a = " + data.a + ", b = " + data.b);
        swap(data, "a", data, "b");
        System.out.println("After swap: a = " + data.a + ", b = " + data.b);
    }
}