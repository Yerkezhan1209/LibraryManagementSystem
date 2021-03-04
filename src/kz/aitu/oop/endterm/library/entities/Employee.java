package kz.aitu.oop.endterm.library.entities;

public class Employee {
    private int id;
    private String name;
    private String surname;
    private boolean gender;
    private int age;
    private int salary;

    public Employee() { }

    public Employee(String name, String surname, boolean gender, int age, int salary) {
        setName(name);
        setSurname(surname);
        setGender(gender);
        setAge(age);
        setSalary(salary); }

    public Employee(int id, String name, String surname, boolean gender, int age, int salary) {
        setId(id);
        setName(name);
        setSurname(surname);
        setGender(gender);
        setAge(age);
        setSalary(salary); }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public boolean getGender() { return gender; }

    public void setGender(boolean gender) { this.gender = gender; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public int getSalary() { return salary; }

    public void setSalary(int salary) { this.salary = salary; }

    @Override
    public String toString() {
        return "| Employee  ||  " + "id=" + id + " | name='" + name + '\'' +
                " | surname='" + surname + '\'' + " | gender=" + (gender ? "Male" : "Female") +
                " | age=" + age + " | salary=" + salary + '|'; }
}
