public class Person {
    String name;
    int speed;

    public Person() {
        name = "Unknown";
        speed = 0;
    }

    public Person(String Name) {
        name = Name;
        speed = 0;
    }

    public Person(String Name, int Speed) {
        name = Name;
        speed = Speed;
    }

    public void printPerson() {
        System.out.println("Name: " + name + ", Speed: " + speed);
    }

    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person("Ece");
        Person person3 = new Person("ece", 5);

        person1.printPerson();
        person2.printPerson();
        person3.printPerson();
    }
}
