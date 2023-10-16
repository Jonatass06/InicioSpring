package net.weg.api.exception;

public class InvalidIndex extends Exception{

    public InvalidIndex() {
        super("You can't use this index to this object");
    }
}
