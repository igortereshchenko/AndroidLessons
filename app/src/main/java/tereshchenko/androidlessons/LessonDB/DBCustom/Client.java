package tereshchenko.androidlessons.LessonDB.DBCustom;

/**
 * Created by Igor on 5/21/2017.
 */

public class Client {

    private long code;
    private String name;
    private String email;

    Client(long code, String name, String email){
        this.code = code;
        this.name = name;
        this.email = email;
    }
    public long getCode() {
        return code;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return this.name + " : " + this.email;
    }
}