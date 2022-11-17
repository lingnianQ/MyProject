package org.mybatis.configuration;

import java.util.HashMap;

public class Configuration {
    String driver;
    String url;
    String username;
    String password;
    HashMap<String,SqlMapper> sqlMappers;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public HashMap<String, SqlMapper> getSqlMappers() {
        return sqlMappers;
    }

    public void setSqlMappers(HashMap<String, SqlMapper> sqlMappers) {
        this.sqlMappers = sqlMappers;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "driver='" + driver + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sqlMappers=" + sqlMappers +
                '}';
    }
}
