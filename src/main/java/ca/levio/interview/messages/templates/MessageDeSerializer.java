package ca.levio.interview.messages.templates;

import ca.levio.interview.dtos.NotificationMessagingDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;

import java.io.IOException;

public class MessageDeSerializer {//implements Deserializer<NotificationMessagingDto> {
/*
    public static final ObjectMapper mapper = JsonMapper.builder()
            .findAndAddModules()
            .build();

    @Override
    public NotificationMessagingDto deserialize(String topic, byte[] data) {
        try {
            return mapper.readValue(data, NotificationMessagingDto.class);
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }*/
}