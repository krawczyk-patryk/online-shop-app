package pl.krawczykpatryk.onlineshop.models;

public enum ProductType {

    ELECTRONICS("electronics description"),
    HOME("home description"),
    FOOD("food description"),
    BEAUTY("beauty description");

    private String msg;

    ProductType(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public String getName() {
        return this.name();
    }
}