package io.temporal.demo;

public class UserInfo {
    private String userToken;

    public UserInfo(String userToken) {
        this.userToken = userToken;
    }

    public String getUserToken() {
        return this.userToken;
    }

}
