package exceptionDemo;

public class Owner {
    private Cat myCat = new Cat();

    public void killMyCat() throws CatUnkillableException {
        this.myCat.killCat();
    }
}
