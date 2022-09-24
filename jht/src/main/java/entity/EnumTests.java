package entity;

/**
 * @author sytsnb@gmail.com
 * @date 2022 2022/9/24 16:30
 */
public class EnumTests {

    public static void main(String[] args) {
        Sex.MALE.doMethod();
    }

}

/**
 * MALE,
 * FEMALE,
 * NONE
 */
enum Sex {
    MALE{
        @Override
        public void doMethod(){
            System.out.println("MALE--");
        }
    },
    FEMALE,
    NONE;

    private Sex() {
    }

    private Sex(String name){
    }
    public void doMethod(){
        System.out.println("Sex.doMethod");
    }
}

class Product {
    Sex gender=Sex.NONE;
}