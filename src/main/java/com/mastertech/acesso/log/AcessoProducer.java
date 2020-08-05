package com.mastertech.acesso.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AcessoProducer {

    @Autowired
    private KafkaTemplate<String, AcessoLog> producer;

    public void enviarAoKafka(AcessoLog log) {
        producer.send("spec3-amanda-futemma-1", log);
    }

}
