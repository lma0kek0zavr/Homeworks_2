package org.skypro.skyshop.product;

public class DiscountedProduct extends Product{
    private int basePrice;
    
    private int discount;

    public DiscountedProduct(String productName, int basePrice, int discount) {
        super(productName);
        this.basePrice = basePrice;
        this.discount = discount;
    }

    @Override
    public int getProductPrice() {
        return basePrice - (basePrice * discount / 100);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
    
    @Override
    public String toString() { 
        return super.getProductName() + " " + getProductPrice() + " (" + discount + "%" + ")";
    }
}
