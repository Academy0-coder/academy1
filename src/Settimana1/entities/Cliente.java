package Settimana1.entities;

public class Cliente extends Person {
    private String email;

    public Cliente (String name, String surname, String email) {
        super(name,surname);
        this.email = email;
    }

    public Cliente() {
        super();
    }

    public String getName() {
        return super.getName();
    }

    public void setName(String name) {
        super.setName(name);
    }

    public String getSurname() {
        return super.getSurname();
    }

    public void setSurname(String surname) {
        super.setSurname(surname);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                super.toString() +
                ", email='" + email + '\'' +
                '}';
    }
}
