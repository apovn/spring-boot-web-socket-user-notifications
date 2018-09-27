package netgloo.domain;

/**
 * Created by tri.tran on 9/25/2018.
 */
public class RequestInfo {

    private String user;

    @Override
    public String toString() {
        return "RequestInfo{" +
                "user='" + user + '\'' +
                '}';
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
