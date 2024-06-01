package org.work1;

import java.util.*;

public class SignInService {
    //键是签到码，值是一个包含所有使用该签到码签到的学生的列表。
    // signIn方法用于处理签到操作，getSignInData方法用于查询统计。
    private final Map<String, List<SignIn>> signInData = new HashMap<>();

    public void signIn(String signInCode, String studentId) {
        SignIn signIn = new SignIn(signInCode, studentId);
        if (!signInData.containsKey(signInCode)) {
            signInData.put(signInCode, new ArrayList<>());
        }
        signInData.get(signInCode).add(signIn);
    }

    public List<SignIn> getSignInData(String signInCode) {
        return signInData.get(signInCode);
    }
}
