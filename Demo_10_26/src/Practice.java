/**
 * @author <a href="mailto:"
 * {@code @description} 类型转换代码
 */
public class Practice {
    public static void main(String[] args) {
        //int,long自动转换float会丢失精度,long自动转换为double会丢失精度
        int n = 123456789;
        float f = n;
        System.out.println(f);
        long l = 123456789;
        f = l;
        System.out.println(f);
        long r = 12345678912345789L;
        double d = r;
        System.out.println(d);

        //位数多的数据类型转换成位数少的数据类型需要强转，long（8字节）到float（4字节）除外
        double di = 137.45;
        byte b = (byte) di;
        System.out.println(b);

        //表达式类型自动提升，比如整型提升，byte,short,char 参加表达式运算-> int,常量表达式不会发生类型提升
        //byte/short/char/int/long+float 参加表达式运算->float
        //byte/short/char/int/long/float+double 参与表达式运算-> double

        long L1 = 12345789456L;
        System.out.println(L1 + 3.6f);
    }
}
