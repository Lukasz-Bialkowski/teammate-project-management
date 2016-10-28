package com.university.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@JsonDeserialize(using = TaskPriority.MyEnumDeserializer.class)
public enum TaskPriority {
    CRITICAL(0, "CRITICAL"), HIGH(1, "HIGH"), NORMAL(2, "NORMAL"), LOW(3, "LOW");

    private Integer ordinal;
    private String value;

    TaskPriority(int ordinal, String value) {
        this.ordinal = ordinal;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(Integer ordinal) {
        this.ordinal = ordinal;
    }

    public static class MyEnumDeserializer extends StdDeserializer<TaskPriority> {
        public MyEnumDeserializer() {
            super(TaskPriority.class);
        }

        @Override
        public TaskPriority deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
            final JsonNode jsonNode = jp.readValueAsTree();
            String ordinal = jsonNode.get("ordinal").asText();
            String value = jsonNode.get("value").asText();

            for (TaskPriority me : TaskPriority.values()) {
                if (me.getOrdinal().equals(Integer.parseInt(ordinal)) && me.getValue().equals(value)) {
                    return me;
                }
            }
            throw dc.mappingException("Cannot deserialize TaskPriority from ordinal: " + ordinal + " and value: " + value);
        }
    }
}
