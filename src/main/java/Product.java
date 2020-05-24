import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Basic(optional = true)
    private Double weight;
    private LocalDate introductionDate;
//    private Shop shop;

    Product() {}

    Product(String name) {
        this.setName(name);
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getWeight() {
        return this.weight;
    }

    public void setIntroductionDate(LocalDate introductionDate) {
        this.introductionDate = introductionDate;
    }

    public LocalDate getIntroductionDate() {
        return this.introductionDate;
    }

    @Transient
    public int getMonthsSinceIntroduction() {
        return Period.between(getIntroductionDate(), LocalDate.now()).getMonths();
    }

//    @ManyToOne
//    public Shop getShop() {
//        return this.shop;
//    }
//
//    public void setShop(Shop shop) {
//        this.shop = shop;
//    }

    @Override
    public String toString() {
        var ret = "";
        ret += name;
        if (weight != null) {
            ret += " weight: " + weight;
        }
        return ret;
    }

}
