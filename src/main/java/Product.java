public class Product {
    private String pID;
    private String pName;
    private Float price;
    private String pDesc;
    static private int pNum;

    public String getpID() {
        return pID;
    }

    public void setpID(String pID) {
        this.pID = pID;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getpDesc() {
        return pDesc;
    }

    public void setpDesc(String pDesc) {
        this.pDesc = pDesc;
    }

    public static int getpNum() {
        return pNum;
    }

    public static void setpNum(int pNum) {
        Product.pNum = pNum;
    }
}


