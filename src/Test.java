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
                    int count = 0;
                    Product carts[] = new Product[3];
                    /*
                    查找是否有该商品信息，有的话就返回商品信息
                     */
                    inProduct = null;
                    inProduct = Class.forName("Test").getResourceAsStream("/product.xlsx");
                    Product product = readProductExcel.getProductById(pID, inProduct);
                    System.out.println("所购买的商品的价格为" + product.getPrice());
                    if (product != null) {
                        carts[count++] = product;
                    }


                    int buying = 1;
                    while (buying == 1) {
                        System.out.println("继续添加购物车请按1");
                        System.out.println("查看购物车请按2");
                        System.out.println("结账请按3");
                        int choose = sc.nextInt();
                        int panduan = 1;
                        if (choose == 1) {

                            inProduct = null;
                            inProduct = Class.forName("Test").getResourceAsStream("/product.xlsx");
                            System.out.println("以下是商城中的商品");
                            readProductExcel = new ReadProductExcel();
                            products = readProductExcel.getAllExcel(inProduct);
                            for (Product newproduct : products) {
                                System.out.print(newproduct.getpID());
                                System.out.print("\t" + newproduct.getpName());
                                System.out.print("\t" + newproduct.getPrice());
                                System.out.println("\t" + newproduct.getpDesc());
                            }
                            System.out.println("请输入想要购买的商品ID添加商品到购物车");
                            pID = sc.next();
                            inProduct = null;
                            inProduct = Class.forName("Test").getResourceAsStream("/product.xlsx");
                            product = readProductExcel.getProductById(pID, inProduct);
                            System.out.println("所购买的商品的价格为" + product.getPrice());
                            if (product != null) {
                                carts[count++] = product;
                            }
                        } else if (choose == 2) {
                            System.out.println("这是您的购物车");
                            for (Product gouwuche : carts) {
                                if (gouwuche != null) {
                                    System.out.print(gouwuche.getpID());
                                    System.out.print("\t" + gouwuche.getpName());
                                    System.out.print("\t" + gouwuche.getPrice());
                                    System.out.println("\t" + gouwuche.getpDesc());
                                }
                            }

                        } else if (choose == 3) {
                            System.out.println("您购买的商品为：");
                            /*
                            if (carts != null) {
                                for (int is = 0; is < carts.length; is++) {
                                    System.out.println(carts[is].getPrice());
                                }
                            }
                             */
                            for (Product p : carts) {
                                if (p != null) {
                                    System.out.print("\t" +p.getpName());
                                    System.out.println("\t" +p.getPrice()+"RMB");
                                }
                            }
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

}
