public class TestString {

    public static void main(String[] args) {
        String str = "t_learning_room_count_";
        System.out.println(String.format(str, 4320));

        System.out.println(str.concat("4320"));

        Object obj = null;
        System.out.println(String.valueOf(obj));
    }
}
