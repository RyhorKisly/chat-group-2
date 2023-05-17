package org.example.chat_group_2.exception;

public class LogInException extends Exception{
    public LogInException(){
        super("!!!incorrect login or password!!!");
    }

    public LogInException(String message){
        super(message);
    }
}
