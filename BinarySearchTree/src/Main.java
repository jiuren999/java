import java.util.Comparator;
import java.util.Objects;

class Animal implements Comparable<Animal> {
        public int age;
        public String name;

        public Animal(int age,String name){
            this.age=age;
            this.name=name;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return age == animal.age && Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }



    @Override
    public int compareTo(Animal o) {
        return this.age - o.age;
    }
}

//姓名比较器
class Name implements Comparator<Animal>{

    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.name.compareTo(o2.name);
    }
}
//年龄比较器
class Age implements Comparator<Animal>{

    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.age-o2.age;
    }
}


public class Main {
    public static void main(String[] args) {

        Animal dog=new Animal(4,"wangwang");
        Animal cat=new Animal(2,"miaomiao");
        Name name = new Name();
        Age age = new Age();

        System.out.println(name.compare(dog,cat));
        System.out.println(age.compare(dog,cat));
    }
}
