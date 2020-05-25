import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Shop")
public class Shop {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;
    private String name;
    @OneToMany(
            mappedBy = "shop",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Product> products = new ArrayList<>();

    public Shop() {}

    public Shop(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private List<Product> getProducts() {
        return this.products;
    }

    public void addProduct(Product p) {
        getProducts().add(p);
        p.setShop(this);
    }

    public void removeProduct(Product p) {
        getProducts().remove(p);
        p.setShop(null);
    }

    @Override
    public String toString() {
        var ret = "";
        ret += "Shop: " + this.name + "\n";
        for (var p : products) {
            ret += "Product: " + p.toString() + "\n";
        }
        return ret;
    }
}
