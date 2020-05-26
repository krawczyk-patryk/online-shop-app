package pl.krawczykpatryk.onlineshop.models;

public enum ProductType {

    ELECTRONICS,
    HOME,
    FOOD,
    BEAUTY;

    public String getName() {
        return this.name();
    }
}