// Trong phần này, chúng ta sẽ tìm hiểu về Java Reflection API, hỗ trợ bởi gói java.lang.reflect.
/*
 * - Reflection là khả năng của một lớp hoặc đối tượng để kiểm tra chính nó.
 * - Reflection cho phép mã Java nhìn vào đối tượng (hay chính xác hơn là lớp của đối tượng) và xác định cấu trúc của nó.
 * - Các phương thức trong class Class:
 *   + Field[] getFields(): Lấy ra tất cả các biến public của class và các biến được kế thừa từ superclass.
 *   + Field getField(String name): Lấy ra biến public có tên name của class hoặc được kế thừa từ superclass.
 *   + Field[] getDeclaredFields(): Lấy ra tất cả các biến của class, bao gồm cả private, protected, default và public, nhưng không bao gồm biến của superclass.
 *   + Field getDeclaredField(String name): Lấy ra biến có tên name của class, bao gồm cả private, protected, default và public, nhưng không bao gồm biến của superclass.
 *   + Method[] getMethods(): Lấy ra tất cả các phương thức public của class và được kế thừa từ superclass.
 *   + Method getMethod(String name, Class<?>... parameterTypes): Lấy ra phương thức public có tên name và kiểu tham số parameterTypes của class hoặc được kế thừa từ superclass.
 *   + Method[] getDeclaredMethods(): Lấy ra tất cả các phương thức của class, bao gồm cả private, protected, default và public, nhưng không bao gồm phương thức của superclass.
 *   + Method getDeclaredMethod(String name, Class<?>... parameterTypes): Lấy ra phương thức có tên name và kiểu tham số parameterTypes của class, bao gồm cả private, protected, default và public, nhưng không bao gồm phương thức của superclass.
 *   + Constructor<?>[] getConstructors(): Lấy ra tất cả các constructor public của class.
 *   + Constructor<?> getConstructor(Class<?>... parameterTypes): Lấy ra constructor public với kiểu tham số parameterTypes của class.
 *   + Constructor<?>[] getDeclaredConstructors(): Lấy ra tất cả các constructor của class, bao gồm cả private, protected, default và public, nhưng không bao gồm constructor của superclass.
 *   + Constructor<?> getDeclaredConstructor(Class<?>... parameterTypes): Lấy ra constructor với kiểu tham số parameterTypes của class, bao gồm cả private, protected, default và public, nhưng không bao gồm constructor của superclass.
 *   + Class<?>[] getInterfaces(): Lấy ra tất cả các interface mà class này triển khai.
 *   + Class[] getDeclaredClasses(): Lấy ra tất cả các inner class được khai báo bên trong class này.
 */

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@SuppressWarnings("all")
class Dinosaur {

    public String species;

    Dinosaur(String species) {
        this.species = species;
    }

    public void roar() {
        System.out.println("Roar");
    }

    private void eat() {
        System.out.println("Eat");
    }

    protected void sleep() {
        System.out.println("Sleep");
    }
}

@SuppressWarnings("all")
class BabyDinosaur extends Dinosaur {

    private int weight;
    private int age;

    BabyDinosaur(String species, int weight, int age) {
        super(species);
        this.weight = weight;
        this.age = age;
    }

    public void play() {
        System.out.println("Play");
    }

    private void crawl() {
        System.out.println("Crawl");
    }

    protected void run() {
        System.out.println("Run");
    }
}

public class Reflection {
    public static void main(String[] args) {
        Class<?> dinosaur = Dinosaur.class;

        System.out.println("--Methods of Dinosaur class");
        Method[] methods = dinosaur.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        System.out.println("--Fields of Dinosaur class");
        Field[] fields = dinosaur.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        Class<?> babyDinosaur = BabyDinosaur.class;

        System.out.println("--Fields of BabyDinosaur class");
        Field[] subfields = babyDinosaur.getFields();
        for (Field field : subfields) {
            System.out.println(field.getName());
        }
    }
}
