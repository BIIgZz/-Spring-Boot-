package com.zzh.sell.utils.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import javax.json.Json;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.Date;

/**
 * @Author: zhuZHUzhu
 * @Description:
 * @Date: Created in 17:31 2020/3/16
 * @Modified By:
 */
public class Date2LongSerializer extends JsonSerializer<Date> {
    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeNumber(date.getTime()/1000);
    }
}
