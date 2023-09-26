package cn.gzsendi.main;

import cn.gzsendi.oop.ClassDefineShowing;

public class ClassDefineShowingMain {

    public static void main(String[] args) {

        // class 即 类型，是一个模版，我们先将一定的行为定义为一个模版，这里的 ClassDefineShowing 就是一个模版
        // 然后如果需要使用这个类型（模版），得先按类型生成一个新的对象，这个对象里来自类型的各个属性可以自行修改成任何合规的值
        // 就像使用 ppt 模版来做一个新的 ppt，改改标题，内容，图片，就生成了一个新的 ppt，
        // 格式：类型名 对象(也叫实例)名 = new 类型名(构造参数值，如果有的话)，
        // new 类型名：这里即是调用了类型的构造方法：ClassDefineShowing()
        ClassDefineShowing classDefineShowing = new ClassDefineShowing();
        /// 以下3行会报错，因为此类跟 ClassDefineShowing 位于另一个包，也不是子类，访问受限了
//        System.out.println(classDefineShowing.accessDefault);
//        System.out.println(classDefineShowing.accessPrivate);
//        System.out.println(classDefineShowing.accessProtected);
        System.out.println(classDefineShowing.accessPublic);

        System.out.println("修改私有属性 accessPrivate 之前值为：" + classDefineShowing.getAccessPrivate());
        classDefineShowing.setAccessPrivate("change-the-private-access-property");
        System.out.println("修改私有属性 accessPrivate 之后值为：" + classDefineShowing.getAccessPrivate());

        String message = "2023-09-25|13600001111|申请账号注册";
        classDefineShowing.printMessage(message);


        // 原来的模版不受影响，根据模版生成的多个ppt彼此也不相互影响，这里生成的多个对象的实例级别属性也彼此不相互影响
        ClassDefineShowing classDefineShowing2 = new ClassDefineShowing();
        System.out.println("另一个实例 classDefineShowing2 的 accessPrivate 值为：" + classDefineShowing2.getAccessPrivate());

        // 但类型里的 static 修饰的属性属于类型级别的属性，任何一个对象里修改了全局所有地方都可以看得到
        // 以下两种方法都可以覆盖掉类属性 staticValue 的值，即
        ClassDefineShowing.staticValue = "";
        classDefineShowing.staticValue = "1";
        System.out.println(ClassDefineShowing.staticValue);
    }
}
