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
            InputStream inProduct = Class.forName("Test").getResourceAsStream("/product.xlsx");
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
                    /*
                    登陆成功后显示商品目录
                     */
                    System.out.println("以下是商城中的商品");
                    ReadProductExcel readProductExcel = new ReadProductExcel();
                    Product products[] = readProductExcel.getAllExcel(inProduct);
                    for (Product product : products) {
                        System.out.print(product.getpID());
                        System.out.print("\t" + product.getpName());
                        System.out.print("\t" + product.getPrice());
                        System.out.println("\t" + product.getpDesc());
                    }

                    System.out.println("请输入想要购买的商品ID添加商品到购物车");
                    String pID = sc.next();

                    /*
                    创建一个购物车
                     */
                    int count=0;
                    Product carts[] = new Product[3];
                    /*
                    查找是否有该商品信息，有的话就返回商品信息
                     */
                    inProduct = null;
                    inProduct = Class.forName("Test").getResourceAsStream("/product.xlsx");
                    Product product= readProductExcel.getProductById(pID, inProduct);
                    if(product!=null){
                        carts[count++]=product;
                    }

                    System.out.println("继续添加购物车请按1");
                    System.out.println("查看购物车请按2");


                    break;
                } else {
                    System.out.println("登录失败");
                }
            }
        }
    }
}
