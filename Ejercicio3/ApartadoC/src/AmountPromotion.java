public class AmountPromotion implements IPromotionStrategy {
    private int amount;

    public AmountPromotion(int amount) {
        assert(amount > 0);
        this.amount = amount;
    }

    @Override
    public double applyPromotion(double basePrice) {
        return basePrice - amount;
    }
    
}
