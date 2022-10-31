package it.unibo.exceptions.fakenetwork.impl;

import java.io.IOException;

public class NetworkException extends IOException{
    public NetworkException() {
        super("Network error: no response");
    }
    public NetworkException(final String messageBeingSent) {
        super("Network error while sending message: " + messageBeingSent);
    }
}
