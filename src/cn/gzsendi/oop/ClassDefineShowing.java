// 此类的包名，假如有多个地方存在同一个类名，可以放在不同的包名下区别
package cn.gzsendi.oop;

// 引入项目外的其他依赖类
import java.util.Random;

/**
 * 此类主要用于演示一个类里的各种元素的定义过程，没有什么业务逻辑上的含义
 *
 * 这里一般可以加上类注释，解释该类用途，代表意义
 * @author linzh 作者
 * @date 2023-09-25 日期
 *
 * class 关键字定义类型
 */
public class ClassDefineShowing {

    /** ================================类型属性定义==============================
     * 开始
     * */
    //定义格式： 属性类型 属性名
    int notImportantProperty;
    // 直接在定义的时候赋值
    String notImportantPropertyWithInitValue = "string";

    // 访问限制符
    // 默认访问控制符，只能在同一个包内访问。没有修饰符的类、方法和变量只能在同一个包内的其他类中被访问，其他包中的类无法访问
    String accessDefault;
    // 受保护的访问控制符，可以被同一个包内的类访问，以及其他包中的子类访问。被protected修饰的类、方法和变量可以在同一个包内的其他类中被访问，以及其他包中的子类中被访问。
    protected String accessProtected;
    // 私有访问控制符，只能在声明它的类内部访问。被private修饰的类、方法和变量只能在同一个类中被访问，其他类无法访问。
    private String accessPrivate;
    // 公共访问控制符，可以被任何类访问。被public修饰的类、方法和变量可以在任何地方被访问。
    public String accessPublic;

    // 常量定义
    // final 定义不可变值，定义时必须赋值
    final String couldNotChangeAgain = "final-value";
    // static 定义类型级别的属性，可变，使用 类型名.变量名 引用，如：System.out.println(ClassDefineShowing.staticValue); ClassDefineShowing.staticValue = "another-static-value"
    public static String staticValue = "static-value";
    public static String anotherStaticValue;
    // 常量值定义，不可变值，使用 类型名.变量名 引用，如：System.out.println(ClassDefineShowing.FINAL_STATIC_VALUE);
    public static final String FINAL_STATIC_VALUE = "final-static-value";
    /** 结束
     *  ================================类型属性定义============================== */


    /** ================================静态代码块定义==============================
     * 开始
     *
     * 注意，此 static {} 静态代码块里仅仅只能访问被 static 关键字修饰的属性，
     * 其他属性属于实例级别的，此处无法访问，原因是此时 实例级别的 属性尚未在内存里生成
     * */
    static {
        anotherStaticValue = "another-another-static-value";
        System.out.println("对 anotherStaticValue 进行赋值：" + anotherStaticValue);
    }
    /** 结束
     *  ================================静态代码块定义============================== */



    /** ================================类型方法定义==============================
     * 开始
     * */

    /**
     * 带参构造方法
     * @param notImportantProperty notImportantProperty属性值
     * @param accessDefault accessDefault属性值
     * @param accessProtected  accessProtected属性值
     * @param accessPrivate accessPrivate属性值
     * @param accessPublic accessPublic属性值
     */
    public ClassDefineShowing(int notImportantProperty, String accessDefault, String accessProtected, String accessPrivate, String accessPublic) {
        this.notImportantProperty = notImportantProperty;
        this.accessDefault = accessDefault;
        this.accessProtected = accessProtected;
        this.accessPrivate = accessPrivate;
        this.accessPublic = accessPublic;
        // static 属性在实例级别依旧可被重复赋值，不过此操作属于全局性的，即此处修改整个应用程序都可以看到新的赋值
        staticValue = "value-assign-again";

        System.out.println("实例初始化赋值完成！！");
    }

    /**
     * 无参构造方法，比如不想外部传递参数来控制属性值，
     * 或者在执行构造方法时无法提供特定属性值，想在执行构造方法之后先拿到实例引用，后续另行对属性值赋值
     */
    public ClassDefineShowing() {
        System.out.println("初始化生成一个 Main 实例(对象)！！");
        this.notImportantProperty = new Random().nextInt();
        this.accessDefault = "accessDefault";
        this.accessProtected = "accessProtected";
        this.accessPrivate = "accessPrivate";
        this.accessPublic = "accessPublic";
    }

    // accessPrivate 属于私有属性，外部无法访问到，此处提供 public 级别的方法提供类外部代码获取值
    public String getAccessPrivate() {
        return accessPrivate;
    }

    // accessPrivate 属于私有属性，外部无法访问到，此处提供 public 级别的方法对其赋值，
    // 在方法体中我们可以对传入的参数值进行一定的逻辑判断，比如防止恶意的值传递进来
    public void setAccessPrivate(String accessPrivate) {
        if (accessPrivate != null && accessPrivate.matches("[符合要求的值]+"))
            this.accessPrivate = accessPrivate;
        else {
            throw new IllegalArgumentException("accessPrivate 赋值不合规：" + accessPrivate);
        }
    }

    /**
     * 打印消息
     * @param message 消息参数值
     */
    public void printMessage(String message) {
        String[] messageArray = parseMessage(message);
        System.out.println(messageArray[0] + ", 号码：[" + messageArray[1] + "] 执行了 [" + messageArray[2] + "] ");
    }

    /**
     * 解析入参
     * @param originMessage originMessage
     * @return 数组形式的格式
     * @throws IllegalArgumentException 如果参数格式错误，将抛出 IllegalArgumentException 异常
     */
    private String[] parseMessage(String originMessage) {
        if (!originMessage.contains("-")) throw new IllegalArgumentException("message 不合规");
        String[] messageArray = originMessage.split("\\|");
        if (messageArray.length != 3) throw new IllegalArgumentException("message 不合规");
        return messageArray;
    }


    /**
     * 结束
     * ================================类型方法定义============================== */

    public static void main(String[] args) {
        // 以下 main 函数体在另一个包 cn.sendi.mian 下的 ClassDefineShowingMain 类中也存在，为了方便演示 private, protected, default, public 的访问限制符的作用

        // class 即 类型，是一个模版，我们先将一定的行为定义为一个模版，这里的 ClassDefineShowing 就是一个模版
        // 然后如果需要使用这个类型（模版），得先按类型生成一个新的对象，这个对象里来自类型的各个属性可以自行修改成任何合规的值
        // 就像使用 ppt 模版来做一个新的 ppt，改改标题，内容，图片，就生成了一个新的 ppt，
        // 格式：类型名 对象(也叫实例)名 = new 类型名(构造参数值，如果有的话)，
        // new 类型名：这里即是调用了类型的构造方法：ClassDefineShowing()
        ClassDefineShowing classDefineShowing = new ClassDefineShowing();
        System.out.println(classDefineShowing.accessDefault);
        System.out.println(classDefineShowing.accessPrivate);
        System.out.println(classDefineShowing.accessProtected);
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
