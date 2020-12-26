import java.io.File;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        /*
        读取文件
         */
        File file=new File("C:\\Users\\swagg\\IdeaProjects\\CmdShop\\src\\users.xlsx");//导入工作簿
        ReadExcel readExcel=new ReadExcel();//创建对象
        User users[]=readExcel.readExcel(file);
        /*
        输入用户名密码进行登陆验证
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username=sc.next();
        System.out.println("请输入密码");
        String password=sc.next();
        /*
        验证
         */
        for(User user:users){
            if(username.equals(user.getUsername()) && password.equals(user.getPassword())){
                System.out.println("登录成功");
            }
        }
    }
}
