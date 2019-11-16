package test.referenceTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {
    //一个引用变量只能唯一指向一个对象，而一个对象可以有过个引用变量来引用
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        MyDate a;//声明一个引用变量，引用变量在占中开辟内存空间
        a = new MyDate();//在堆中创建一个对象，并把对象的地址赋值给引用变量
        MyDate b = new MyDate();
        MyDate c = new MyDate();
        MyDate d = c;//将c引用变量中保存的地址赋值给b变量

        a.show();    //2017/11/17
        b.show();    //2017/11/17
        c.show();    //2017/11/17
        d.show();    //2017/11/17

        //a、b互不影响
        a.month = 12;
        a.show();    //2017/12/17
        b.show();    //2017/11/17
        b.day = 20;
        a.show();    //2017/12/17
        b.show();    //2017/11/20

        //c、d指向同一个地址，所有相互影响
        c.year = 1949;
        c.show();    //1949/11/17
        d.show();    //1949/11/17
        d.month = 10;
        c.show();    //1949/10/17
        d.show();    //1949/10/17

        d= new MyDate();
        c.show();
        d.show();
    }
}
class MyDate {
    public int year = 2017;
    public int month = 11;
    public int day = 17;

    public void show() {
        System.out.println(year+"/"+month+"/"+day);
    }
}