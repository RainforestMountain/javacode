import cn.hutool.core.io.FileUtil;

import java.io.File;

public class CommonsIODemo {
    public static void main(String[] args) {
        File file = FileUtil.file("E:\\java_code\\IODemo2\\ccc\\b.txt");
        System.out.println(file);
        System.out.println(file.exists());

        System.out.println(FileUtil.touch(file));
        System.out.println(file.exists());

    }
}
