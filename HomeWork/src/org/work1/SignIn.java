package org.work1;

import java.util.Date;

public class SignIn {
    private String signInCode;
    private String studentId;
    private Date signInTime;

    public SignIn(String signInCode, String studentId) {
        this.signInCode = signInCode;
        this.studentId = studentId;
        this.signInTime = new Date();
    }


    public String getSignInCode() {
        return signInCode;
    }

    public void setSignInCode(String signInCode) {
        this.signInCode = signInCode;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Date getSignInTime() {
        return signInTime;
    }

    public void setSignInTime(Date signInTime) {
        this.signInTime = signInTime;
    }
}

