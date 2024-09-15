package dynamicBinding;

public class Demo2 {

    // 1. 先檢查 ref type 知不知道 .xxx 的存在 (是否能夠compile)
    // 2. 只有 instance method (non-static) 會因為 JVM 在 runtime 的時候
    //    通過 Dynamic binding 去 invoke (調用) actual object (Override) 的 代碼
    //
    //    其他的 (fields, static method) 全都直接調用 ref type

    public static void main(String[] argv) {

        // A x = new B();

        A x = new C();

        System.out.println(x.n);            // 1
        System.out.println(((B) x).n);      // 2
        System.out.println(((C) x).n);      // 2 (inhrit B.n)

        x.f();                              // B (inhrit B.f())
        ((B) x).f();                        // B
        ((C) x).f();                        // B

        // x.g();
        ((B) x).g();                        // gggg (C.g())
        ((C) x).g();                        // gggg

        System.out.println(x.m);            // 10
        System.out.println(((B) x).m);      // 20
        System.out.println(((C) x).m);      // 20

        x.k();                              // Static A
        ((B) x).k();                        // Static A
        ((C) x).k();                        // Static C
    }
}
