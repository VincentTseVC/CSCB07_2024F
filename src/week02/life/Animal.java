package week02.life;

// Access Modifier
//  default:    package only
//  public:     entire Project
//  private:    only this class
//  protected:  only this class and all its child classes + same package


// Abstract Class
//  - Same as Regular class (可以有 instance/static fields, instance/static methods)
//  - ONLY TWO DIFF:
//      (1)     Cannot be instantiated (不可被創建)
//              ex: Animal vc = new Animal()
//
//      (2)     Can have Abstract Methods

public abstract class Animal {

    // instance variable (fields / attribute)
    private String name;
    private int age;

    // static member belong to the class itself.
    // all objects (instances) share the same static value
    public static int numberOfAnimals = 0;

    // Default constructor (no params)
//    public Animal() {
//        name = "No Name";
//        age = 1;
//    }

    public Animal(String animal_name, int age) {
        name = animal_name;
        this.age = age;
        numberOfAnimals += 1;
    }

    // Method Overload
    //  同一個class 裡 重複定義 一樣的 methods
    //  - Same function name
    //  - Same return Type
    //  - Diff param Types / number of params

    public Animal(String animal_name) {
        this(animal_name, 1); // 叫 上面那個 constructor
    }

    // Accessors (Getters / Setters)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return this.speak() + ": " + name + " " + this.age;
    }


    // Abstract Method:
    //  - 只有 method header (signature)
    //  - 任何 child class 都必須 完成 (implement) 這個 method 的 body
    public abstract String speak();
}
