package com.example.demo.annotations;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class TrimDeserializer extends JsonDeserializer<String> {
    @Override
    public String deserialize(JsonParser parser, DeserializationContext ctx) throws IOException {
        String str = parser.getText();

        if (str == null) {
            return null;
        }

        return str.trim();
    }
}