package task_1.src_code.game;


class Test{}
class MyClass {
    static void myStaticMethod() {
        System.out.println("Im in sta1");
    }
}

class MySubClass extends MyClass {

    static void  myStaticMethod() {
        System.out.println("Im in sta123");
    }
}

class My {
    public static void main(String arg[]) {

        MyClass myObject = new MyClass();
        myObject.myStaticMethod();
        // should be written as
        MyClass.myStaticMethod();
        // calling from subclass name
        MySubClass.myStaticMethod();
        myObject = new MySubClass();
        myObject.myStaticMethod();
        // still calls the static method in MyClass, NOT in MySubClass
    }
}