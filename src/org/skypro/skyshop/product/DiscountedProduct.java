package org.skypro.skyshop.product;

public class DiscountedProduct extends Product{
    private int basePrice;
    
    private int discount;

    public DiscountedProduct(String productName, int basePrice, int discount) {
        super(productName);
        
        if (basePrice < 0) { 
            throw new IllegalArgumentException("Неправильная цена");
        } 

        if (discount >= 0 && discount <= 100) {
            throw new IllegalArgumentException("Неправильная скидка");
        }

        this.basePrice = basePrice;  
        this.discount = discount; 
    }

    @Override
    public int getProductPrice() {
        if (discount == 0) { return basePrice; }
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
