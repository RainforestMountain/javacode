public class StringTest {


    public static boolean isAdmin(String userId) {

        //System.out.println(("abc" == "abc"));
        return userId.toLowerCase() == "admin";
    }

    public static void main(String[] args) {
        //System.out.println(isAdmin("Admin"));
        String s1 = "abc";
        String s2 = new String("abc");
        String s3 = "abc";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);


    }
}
