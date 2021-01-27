import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Order {
    private User user;
    private Product products[];
    private int productAmmout;
    private float totalPrice;
    private float finalPay;
    private String orderDate;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public int getProductAmmout() {
        return productAmmout;
    }

    public void setProductAmmout(int productAmmout) {

        this.productAmmout = productAmmout;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public float getFinalPay() {
        return finalPay;
    }

    public void setFinalPay(float finalPay) {
        this.finalPay = finalPay;
    }

    public String getOrderDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        orderDate = df.format(new Date());// new Date()为获取当前系统时间
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
