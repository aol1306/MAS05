import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity(name = "Product")
public class Product {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;
    private String name;
    @Basic(optional = true)
    private Double weight;
    private LocalDate introductionDate;
    @ManyToOne
    private Shop shop;

    Product() {}

    Product(String name) {
        this.setName(name);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
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

    public Shop getShop() {
        return this.shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

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
