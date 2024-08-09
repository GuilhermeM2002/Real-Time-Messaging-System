package br.com.challenges.user.core.useCases;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;

public interface MessagesQuantifierUseCase {
    void messagesQuantifier(GenericRecord dto) throws JsonProcessingException;
}
