package less7;

public class Plate {
    private int foodCount;

    public Plate(int foodCount) {
        this.foodCount = foodCount;
    }

    public int getFoodCount() {
        return foodCount;
    }

    public void setFoodCount(int foodCount) {
        this.foodCount = foodCount;
    }

    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Plate{" + "foodCount=" + foodCount + '}';
    }

    public boolean decreaseFood(int catEatFoodCount) {
        if (getFoodCount()<catEatFoodCount) {
            System.out.println("В кошачье миске недостаточно еды!!!");
            return false;
        }
        else {
            foodCount -= catEatFoodCount;
            return true;
        }
    }
}
