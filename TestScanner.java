import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Scanner;

/**
 * description: TestScanner <br>
 * date: 2019/12/11 15:39 <br>
 * author: user <br>
 * version: 1.0 <br>
 */
public class TestScanner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入：");
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            System.out.println("输入的数据是：" + str);
            System.out.print("请输入：");
        }
    }
}
