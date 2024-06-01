public class TestDemo4 {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            //转换为字符串,使用contains方法,如果包含"9"就打印出来
            if (String.valueOf(i).contains("9")) {
                System.out.print(i + " ");
            }
        }
    }
}
