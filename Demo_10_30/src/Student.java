public class Student {
    private String name;
    private int id;
    private int grade;

    public Student(String name, int id, int grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public static void main(String[] args) {
        var students = new Student[]{new Student("zhangsan", 14, 1),
                new Student("zhaoliu", 15, 2),
                new Student("wangwu", 16, 3),
                new Student("liyun", 17, 4),
                new Student("lisi", 18, 1)};
        for (var student : students) {
            System.out.println(student.toString());
        }
    }

    @Override
    public String toString() {
        return ("name : " + name + " id : " + id + " grade : " + grade);
    }

}
