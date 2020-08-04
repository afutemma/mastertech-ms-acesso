package com.mastertech.acesso.client;

import com.mastertech.acesso.exceptions.PortaNaoEncontradaException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class PortaClientDecoder implements ErrorDecoder {

    private ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {
        if (response.status() == 400) {
            throw new PortaNaoEncontradaException();
        } else {
            return errorDecoder.decode(s, response);
        }
    }
}
