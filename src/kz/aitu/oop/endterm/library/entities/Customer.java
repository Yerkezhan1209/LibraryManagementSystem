package kz.aitu.oop.endterm.library.entities;

public class Customer {
    private int id;
    private String name;
    private String surname;
    private boolean gender;
    private String dateOfBirth;
    private String email;

    public Customer() { }

    public Customer(String name, String surname, boolean gender, String dateOfBirth, String email) {
        setName(name);
        setSurname(surname);
        setGender(gender);
        setDateOfBirth(dateOfBirth);
        setEmail(email); }

    public Customer(int id, String name, String surname, boolean gender, String dateOfBirth, String email) {
        setId(id);
        setName(name);
        setSurname(surname);
        setGender(gender);
        setDateOfBirth(dateOfBirth);
        setEmail(email); }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public boolean getGender() { return gender; }

    public void setGender(boolean gender) { this.gender = gender; }

    public String getDateOfBirth() { return dateOfBirth; }

    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "| Customer  ||  " + "id=" + id + " | name='" + name + '\'' +
                " | surname='" + surname + '\'' + " | gender=" + (gender ? "Male" : "Female") +
                " | dateOfBirth='" + dateOfBirth + '\'' + " | email='" + email + '\'' + '|'; }
}
