import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        boolean bo = true;
        while (bo) {
        /*
        读取文件
         */
            //File file=new File("C:\\Users\\swagg\\IdeaProjects\\CmdShop\\src\\users.xlsx");//导入工作簿
            InputStream in = Class.forName("Test").getResourceAsStream("/users.xlsx");
            ReadUserExcel readUserExcel = new ReadUserExcel();//创建对象
            User users[] = readUserExcel.readExcel(in);
        /*
        输入用户名密码进行登陆验证
         */
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入用户名");
            String username = sc.next();
            System.out.println("请输入密码");
            String password = sc.next();
        /*
        验证
         */
            for (int i = 0; i < users.length; i++) {
                if (username.equals(users[i].getUsername()) && password.equals(users[i].getPassword())) {
                    System.out.println("登录成功");
                    bo = false;
                    break;
                }
                else {
                    System.out.println("登录失败");
                }
            }
        }
    }
}
