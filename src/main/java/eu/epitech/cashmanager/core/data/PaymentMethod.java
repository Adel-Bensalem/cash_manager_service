package eu.epitech.cashmanager.core.data;

import java.util.List;

public class PaymentMethod {
    public String id;
    public String name;
    public List<String> schema;

    public PaymentMethod(String id, String name, List<String> schema) {
        this.id = id;
        this.name = name;
        this.schema = schema;
    }
}
