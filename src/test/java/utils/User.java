package utils;

public class User {
    private final String phoneNumber;
    private final String login;
    private final String password;


    public User(String phoneNumber, String login, String password) {
        this.phoneNumber = phoneNumber;
        this.login = login;
        this.password = password;

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public static class UserBuilder {
        private String phoneNumber;
        private String login;
        private String password;

        public UserBuilder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public UserBuilder setLogin(String login) {
            this.login = login;
            return this;
        }

        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            return new User(phoneNumber, login, password);
        }
    }
}
