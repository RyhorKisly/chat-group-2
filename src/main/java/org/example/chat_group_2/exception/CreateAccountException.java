package org.example.chat_group_2.exception;

public class CreateAccountException extends Exception{
    public CreateAccountException(){
        super("Fill in all the fields");
    }

    public CreateAccountException(String message){
        super(message);
    }
}
