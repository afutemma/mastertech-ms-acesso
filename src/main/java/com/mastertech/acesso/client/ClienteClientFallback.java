package com.mastertech.acesso.client;

import com.mastertech.acesso.dto.ClienteDTO;
import com.mastertech.acesso.exceptions.ClienteOfflineException;

public class ClienteClientFallback implements ClienteClient {

    @Override
    public ClienteDTO getClientePorId(int id) {
        throw new ClienteOfflineException();
    }
}
