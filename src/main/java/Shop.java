//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity(name = "Shop")
//public class Shop {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//    private String name;
//    private List<Product> products = new ArrayList<>();
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @OneToMany(
//            mappedBy = "Shop",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    private List<Product> getProducts() {
//        return this.products;
//    }
//
//    public void addProduct(Product p) {
//        getProducts().add(p);
//        p.setShop(this);
//    }
//
//    public void removeProduct(Product p) {
//        getProducts().remove(p);
//        p.setShop(null);
//    }
//
//    @Override
//    public String toString() {
//        var ret = "";
//        ret += "Shop: " + this.name + "\n";
//        for (var p : products) {
//            ret += "Product: " + p.toString() + "\n";
//        }
//        return ret;
//    }
//}
