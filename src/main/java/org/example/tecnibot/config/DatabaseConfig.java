package org.example.tecnibot.config;

public class DatabaseConfig {
    private final String host;
    private final String port;
    private final String service;
    private final String user;
    private final String password;

    public DatabaseConfig(String host, String port, String service, String user, String password) {
        this.host = host;
        this.port = port;
        this.service = service;
        this.user = user;
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public String getService() {
        return service;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getJdbcUrl() {
        return "jdbc:postgresql://" + host + ":" + port + "/" + service;
    }
}