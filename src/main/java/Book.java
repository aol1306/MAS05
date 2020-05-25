import javax.persistence.Entity;

@Entity
public class Book extends Product {
    private Integer pages;

    Book() {}

    Book(String name) {
        this.setName(name);
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getPages() {
        return pages;
    }

    @Override
    public String toString() {
        var ret = super.toString();
        ret += "\tnumber of pages: " + pages;
        return ret;
    }
}
