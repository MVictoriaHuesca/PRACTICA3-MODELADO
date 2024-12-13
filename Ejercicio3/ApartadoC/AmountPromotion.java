package Ejercicio3.ApartadoC;
public class AmountPromotion implements IPromotionStrategy {
    private int amount;

    public AmountPromotion(int amount) {
        assert(amount > 0);
        this.amount = amount;
    }

    @Override
    public int applyPromotion(int basePrice) {
        return basePrice - amount;
    }
    
}
