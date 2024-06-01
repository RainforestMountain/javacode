public @interface Enhancement {
    int id();

    String synopsis();

    String engineer() default "unsigned";

    String data() default "unKnown";
}
