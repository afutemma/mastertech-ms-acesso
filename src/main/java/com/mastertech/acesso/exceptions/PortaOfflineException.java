package com.mastertech.acesso.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_GATEWAY, reason = "O sistema de porta se encontra offline")
public class PortaOfflineException extends RuntimeException {
}
