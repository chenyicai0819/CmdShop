import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Map;

public class Order {
    private User user;
    private Product products[];
    private Map<Integer,Integer> productAmmout;
    private Map<Integer,Float> totalAmountPerProduct;
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

    public Map<Integer, Integer> getProductAmmout() {
        return productAmmout;
    }

    public void setProductAmmout(Map<Integer, Integer> productAmmout) {
        this.productAmmout = productAmmout;
    }

    public Map<Integer, Float> getTotalAmountPerProduct() {
        return totalAmountPerProduct;
    }

    public void setTotalAmountPerProduct(Map<Integer, Float> totalAmountPerProduct) {
        this.totalAmountPerProduct = totalAmountPerProduct;
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
