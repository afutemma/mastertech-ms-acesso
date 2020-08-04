package com.mastertech.acesso.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "O usuário informado não existe")
public class ClienteNaoEncontradoException extends RuntimeException {
}
