package exceptionDemo;

public class Cat {

    public void killCat() throws CatUnkillableException {
         throw new CatUnkillableException();
    }

    public void eatCat() {
        throw new CatUneatableException();
    }

    public void eatCat2() throws CatUneatableException {
        throw new CatUneatableException();
    }
}
