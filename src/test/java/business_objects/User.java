package business_objects;

public class User {
    private static final String MAIL_URL = "https://mail.ru/";
    private static final String USER_NAME = "selenium.tester";
    private static final String USER_PASSWORD = "PRARppro3*u3";
    private static final String MAIL_ADDRESS = "selenium.tester@mail.ru";
    private static final String MAIL_SUBJECT = "Hello";
    private static final String MAIL_TEXT = "Hello World!";
    private static final String FOLDER_NAME = "Test Folder";

    public String getMailUrl() {
        return MAIL_URL;
    }

    public String getUserName() {
        return USER_NAME;
    }

    public String getUserPassword() {
        return USER_PASSWORD;
    }

    public String getMailAddress() {
        return MAIL_ADDRESS;
    }

    public String getMailSubject() {
        return MAIL_SUBJECT;
    }

    public String getMailText() {
        return MAIL_TEXT;
    }

    public String getFolderName() {
        return FOLDER_NAME;
    }
}
