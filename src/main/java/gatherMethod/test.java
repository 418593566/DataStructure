package gatherMethod;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class test {
    public static void main(String[] args) {
        Collection co = new ArrayList<>();

        co.add(new Person("Tom",20));
        System.out.println(co);
        System.out.println(co.contains(new Person("Tom",20)));
    }
}






class Person{
    private String name;
    private int age;

    public Person() {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }
}
