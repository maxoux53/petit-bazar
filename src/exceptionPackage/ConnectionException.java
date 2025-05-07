package exceptionPackage;

import java.sql.SQLException;

public class ConnectionException extends Exception {
    public ConnectionException(String message){
        super(message);
    }
}