package less7;

public class Cat {

    private String name;
    private boolean stateBellyful;
    private int fullBellyful;
    private int currentBellyful;

    public Cat(String name, int currentBellyful, int fullBellyful) {
        this.name = name;
        this.currentBellyful = currentBellyful;
        this.fullBellyful = fullBellyful;
        if (currentBellyful==fullBellyful)
            stateBellyful=true;
        else stateBellyful=false;
    }

    public void setStateBellyful(boolean stateBellyful) {
        this.stateBellyful = stateBellyful;
    }

    public boolean getStateBellyful() {
        return stateBellyful;
    }

    public void eat(Plate bowl) {
        if (getStateBellyful())
            System.out.printf("%s сыт!!!\n", name);
        else
            if(bowl.decreaseFood(fullBellyful - currentBellyful)){
            currentBellyful = fullBellyful;
            setStateBellyful(true);
            System.out.printf("%s поел(а)... Сытость - %b\n", name, getStateBellyful());
            }

    }
}
