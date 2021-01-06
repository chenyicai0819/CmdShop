import java.util.Date;

public class Order {
    private User user;
    private Product products[];
    private int productAmmout;
    private float totalPrice;
    private float finalPay;
    private Date orderDate;

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

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
