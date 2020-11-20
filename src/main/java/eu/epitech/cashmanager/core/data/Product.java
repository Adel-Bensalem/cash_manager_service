package eu.epitech.cashmanager.core.data;

public class Product {
    public String id;
    public String name;
    public Float price;
    public String picture;

    public Product(String id, String name, Float price, String picture) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.picture = picture;
    }
}
