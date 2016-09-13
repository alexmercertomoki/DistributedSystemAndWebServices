package HackLab;


public class HackLabModel {

    /**
     * Username supplied by the user
     */
    private String username;

    /**
     * Password supplied by the user
     */
    private String password;

    /**
     * Store any error that occurred during login
     */
    private String error;

    private boolean errorOccurred = false;

    /**
     * Constructor for HackLab Model
     *
     * @param username
     * @param password
     */
    public HackLabModel(String username, String password) {
        this.username = username;
        this.password = password;
        doLogin();
    }

    /**
     * Method that performs the login operation
     */
    private void doLogin() {
        Hashes hashes = new Hashes(password, "md5");
        if (!"admin".equals(username) || !"1281088BE42137360E0F26613DE23656".equals(hashes.getHexString())) {
            error = "Error! Username or password incorrect";
            errorOccurred = true;
        }
    }

    public boolean errorOccured() {
        return errorOccurred;
    }

    public String getLoginError() {
        return error;
    }

}
