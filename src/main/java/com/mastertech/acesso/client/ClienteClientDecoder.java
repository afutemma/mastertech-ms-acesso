package com.mastertech.acesso.client;

import com.mastertech.acesso.exceptions.ClienteOfflineException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class ClienteClientDecoder implements ErrorDecoder {

    private ErrorDecoder errorDecoder = new ErrorDecoder.Default();

    @Override
    public Exception decode(String s, Response response) {
        if (response.status() == 400) {
            throw new ClienteOfflineException();
        } else {
            return errorDecoder.decode(s, response);
        }
    }
}
