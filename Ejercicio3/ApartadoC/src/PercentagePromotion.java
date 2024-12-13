package Ejercicio3.ApartadoC;
public class PercentagePromotion implements IPromotionStrategy {
    private double percentage;

    public PercentagePromotion(int percentage) {
        assert(percentage > 0);
        this.percentage = percentage;
    }

    @Override
    public double applyPromotion(double basePrice) {
        return basePrice - (basePrice * (percentage / 100));
    }
    
}
