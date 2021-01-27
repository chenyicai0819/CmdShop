import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Test {
    static int count = 0;
    static Product carts[] = new Product[3];
    static Scanner sc = new Scanner(System.in);

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


                    while (true) {
                        System.out.println("继续添加购物车请按1");
                        System.out.println("查看购物车请按2");
                        System.out.println("结账请按3");
                        System.out.println("退出请按4");
                        int choose = sc.nextInt();
                        if (choose == 1) {
                            shopping(inProduct);
                        } else if (choose == 2) {
                            viewCarts();
                        } else if (choose == 3) {
                            Order order = new Order();
                            order.setUser(users[i]);

                            Product products[] = new Product[count];
                            int num = 0;
                            for (int j = 0; j < carts.length; j++) {
                                if (carts[j] != null) {
                                    products[j] = carts[j];
                                }
                            }
                            order.setProducts(products);
                            //下订单

                            Map<Integer,Integer> ammount=new HashMap<Integer,Integer>();
                            ammount.put(1111,2);
                            ammount.put(2222,1);
                            order.setProductAmmout(ammount);

                            CreateOrder.createOrder(order);

                        } else if (choose == 4) {
                            break;
                        }
                    }
                    break;
                } else if (i == users.length - 1) {
                    System.out.println("登录失败");
                }
            }
        }
    }

    public static void shopping(InputStream inProduct) throws ClassNotFoundException {
        inProduct = null;
        inProduct = Class.forName("Test").getResourceAsStream("/product.xlsx");
        System.out.println("以下是商城中的商品");
        ReadProductExcel readProductExcel = new ReadProductExcel();
        Product products[] = readProductExcel.getAllExcel(inProduct);
        for (Product newproduct : products) {
            System.out.print(newproduct.getpID());
            System.out.print("\t" + newproduct.getpName());
            System.out.print("\t" + newproduct.getPrice());
            System.out.println("\t" + newproduct.getpDesc());
        }
        System.out.println("请输入想要购买的商品ID添加商品到购物车");
        String pID = sc.next();
        inProduct = null;
        inProduct = Class.forName("Test").getResourceAsStream("/product.xlsx");
        Product product = readProductExcel.getProductById(pID, inProduct);
        if (count == carts.length) {
            System.out.println("购物车已满");
        } else {
            System.out.println("所购买的商品的价格为" + product.getPrice());
            if (product != null) {
                carts[count++] = product;
            }
        }
    }

    public static void viewCarts() {
        System.out.println("这是您的购物车");
        for (Product gouwuche : carts) {
            if (gouwuche != null) {
                System.out.print(gouwuche.getpID());
                System.out.print("\t" + gouwuche.getpName());
                System.out.print("\t" + gouwuche.getPrice());
                System.out.println("\t" + gouwuche.getpDesc());
            }
        }
    }
}