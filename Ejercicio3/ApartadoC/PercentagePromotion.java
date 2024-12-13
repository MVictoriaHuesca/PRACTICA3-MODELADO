package Ejercicio3.ApartadoC;
public class PercentagePromotion implements IPromotionStrategy {
    private int percentage;

    public PercentagePromotion(int percentage) {
        assert(percentage > 0);
        this.percentage = percentage;
    }

    @Override
    public int applyPromotion(int basePrice) {
        return basePrice - (basePrice * percentage / 100);
    }
    
}
