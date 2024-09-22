package exceptionDemo;

public class Driver {

    public static float divide(int num1, int num2) {
        if (num2 == 0)
            throw new AreYouStupidError();
        return num1 / num2;
    }

    /*
        apple 1 + 2
        如果 extends 的是 Exception (compile time)
            1. 一定要在 method header 去 declare "throws ......"
            2. 一定 要在 "最後" 放在 try {}

        如果 extends 的是 RuntimeException
            1. 可以選擇是否要在 method header 去 declare "throws ......"
            2. 可以選擇是否要 在 "最後" 放在 try {}
     */

    public static void main(String[] argv) {
//        divide(3, 0);

        Cat mua = new Cat();
        Owner vc = new Owner();

        // 不行！！！
        // mua.killCat();
        // vc.killMyCat();

        // 可以
        // mua.eatCat();

        try {
            // int a = 1 / 0;
            System.out.println("killing cat");
            mua.killCat();

            System.out.println("eating cat");
            mua.eatCat();

            System.out.println("feels so good");
            // vc.killMyCat();

        } catch (CatUnkillableException e1) {
            System.out.println("WHY THE FUCK ARE YOU TRYING TO KILL CUTE CATS :)");
        } catch (CatUneatableException e2) {
            System.out.println("U WANNA EAT CAT ?????");
        } catch (ArithmeticException e3) {
            System.out.println("你到底 幹什麼？？？？");
        }
        finally {
            System.out.println("Cats are always cute :3");
        }

        System.out.println("Im still here :o");

    }
}
