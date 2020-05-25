import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pencil extends Product {
    private Double sharpness;
    Pencil() {}

    Pencil(String name) {
        this.setName(name);
    }

    public Double getSharpness() {
        return sharpness;
    }

    public void setSharpness(Double sharpness) {
        this.sharpness = sharpness;
    }

    @Override
    public String toString() {
        var ret = super.toString();
        ret += "\tsharpness: " + sharpness;
        return ret;
    }
}
