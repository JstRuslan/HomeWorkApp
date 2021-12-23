package less7;

public class HomeWork7 {

    public static void main(String[] args) {
        Cat[] cat = new Cat[5];
        cat[0] = new Cat("Барон", 5,10);
        cat[1] = new Cat("Гав", 1,5);
        cat[2] = new Cat("Обжора", 20,20);
        cat[3] = new Cat("Белка", 7,12);
        cat[4] = new Cat("Ляля", 3,5);

        Plate bowlCat=new Plate(15);
        for (Cat i: cat) {
            bowlCat.printInfo();
            i.eat(bowlCat);
        }
    }
}
