package Builder;
/*
* Builder can be used to have a better performance, once
* he references himself to access attributes
* and add more readability to the code
*/
// Builder
public class Person {
    private String firstName;
    private String lastName;
    private String username;
    private String email;

    public Person(String email, String firstName, String lastName, String username) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
    }

    @Override
    public String toString() {
        return "Person{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public static final class PersonBuilder {
        private String email;
        private String firstName;
        private String lastName;
        private String username;

        public PersonBuilder() {
        }

        public PersonBuilder email(String email) {
            this.email = email;
            return this;
        }

        public PersonBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder username(String username) {
            this.username = username;
            return this;
        }

        public Person build() {
            return new Person(email, firstName, lastName, username);
        }
    }
}
