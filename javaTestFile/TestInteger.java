/**
 * description: TestInteger <br>
 * date: 2019/11/13 18:59 <br>
 * author: user <br>
 * version: 1.0 <br>
 */
public class TestInteger {

    public static void main(String[] args) {
        Integer a = 21881;
        System.out.println(Integer.toString(a));

        System.out.println("21881 / 100 = " + Float.valueOf(a) / 100);



        Long lon = new Long(31241241);
        int i = 31241241;
        System.out.println(lon == i);
        System.out.println(lon.equals(i));

        //Integer.valueOf("");
        //Integer.valueOf(null);

        Integer integer = new Integer(901);
        float f = (float)integer / 100;
        System.out.println(f);
    }
}
