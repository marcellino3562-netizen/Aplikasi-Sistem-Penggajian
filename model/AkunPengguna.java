package model;

public class AkunPengguna {
    private String username;
    private String password;

  
    public AkunPengguna() {
    }

    public AkunPengguna(String inputUsername, String inputPassword) {
        this.username = inputUsername;
        this.password = inputPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}