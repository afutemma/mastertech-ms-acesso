package com.mastertech.acesso.client;

import com.mastertech.acesso.dto.PortaDTO;
import com.mastertech.acesso.exceptions.PortaOfflineException;

public class PortaClientFallback implements PortaClient {

    @Override
    public PortaDTO getPortaPorId(int id) {
        throw new PortaOfflineException();
    }
}
