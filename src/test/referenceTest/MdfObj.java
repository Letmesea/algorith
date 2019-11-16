package test.referenceTest;

public class MdfObj {
    public static void main(String[] s){
        Obj obj = new Obj(10);
        obj.modify(obj);
        System.out.print(obj.age);
    }
}
class Obj{
    Integer age;
    public Obj(int age){
        this.age=age;
    }
    public void modify(Obj obj){
        obj.age=100;
    }
}
