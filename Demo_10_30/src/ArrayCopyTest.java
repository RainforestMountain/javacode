import java.util.Arrays;

public class ArrayCopyTest {
    public static void main(String[] args) {
        int[] source = {35, 48, 9, 7, 1023, 568};
        int[] dest = new int[source.length];
        //1.for循环
        System.out.println("1.");
        System.out.println("复制前：" + Arrays.toString(dest));
        for (int i = 0; i < source.length; i++) {
            dest[i] = source[i];
        }
        System.out.println("复制后：" + Arrays.toString(dest));
        //重新初始化
        Arrays.fill(dest, 0);

        //2.System类的arraycopy()方法
        System.out.println("2.");
        System.out.println("复制前：" + Arrays.toString(dest));
        System.arraycopy(source, 0, dest, 0, source.length);
        System.out.println("复制后：" + Arrays.toString(dest));
        //重新初始化
        Arrays.fill(dest, 0);

        //3.Arrays类的copyOf()或copyOfRange()方法
        System.out.println("3.");
        System.out.println("复制前：" + Arrays.toString(dest));
        dest = Arrays.copyOf(source, source.length);
        System.out.println("复制后：" + Arrays.toString(dest));
        //重新初始化
        Arrays.fill(dest, 0);
        System.out.println("复制前：" + Arrays.toString(dest));
        dest = Arrays.copyOfRange(source, 0, source.length);
        System.out.println("复制后：" + Arrays.toString(dest));
    }
}
