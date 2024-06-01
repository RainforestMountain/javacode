package org.work1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 创建签到服务
        SignInService signInService = new SignInService();

        // 创建学生
        Student student1 = new Student("1", "Alice");
        Student student2 = new Student("2", "Bob");
        Student student3 = new Student("3", "Charlie");

        // 教师生成签到码
        String signInCode = "123456";

        // 学生进行签到操作
        signInService.signIn(signInCode, student1.getId());
        signInService.signIn(signInCode, student2.getId());
        signInService.signIn(signInCode, student3.getId());

        // 查询统计
        List<SignIn> signInData = signInService.getSignInData(signInCode);
        for (SignIn signIn : signInData) {
            System.out.println("Student ID: " + signIn.getStudentId() + ", Sign In Time: " + signIn.getSignInTime());
        }
    }
}
