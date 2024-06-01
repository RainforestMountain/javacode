package newcom;

public class People {
    public String gender;


    public People() {
    }

    public People(String gender) {
        this.gender = gender;
    }

    /**
     * 获取
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String toString() {
        return "People{gender = " + gender + "}";
    }
}
