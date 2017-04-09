package io.github.bca.api;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SakukuPaymentRequestSerializer extends StdSerializer<SakukuPaymentRequest> {

    public SakukuPaymentRequestSerializer() {
        this(null);
    }

    public SakukuPaymentRequestSerializer(Class<SakukuPaymentRequest> t) {
        super(t);
    }

    @Override
    public void serialize(SakukuPaymentRequest sakukuPaymentRequest, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("MerchantID", sakukuPaymentRequest.getMerchantId());
        jsonGenerator.writeStringField("MerchantName", sakukuPaymentRequest.getMerchantName());
        jsonGenerator.writeStringField("TransactionID", sakukuPaymentRequest.getTransactionId());
        jsonGenerator.writeStringField("ReferenceID", sakukuPaymentRequest.getReferenceId());
        jsonGenerator.writeStringField("RequestDate",formatTimestamp(sakukuPaymentRequest.getRequestDate()));
        jsonGenerator.writeStringField("Amount", sakukuPaymentRequest.getAmount().setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString());
        jsonGenerator.writeStringField("Tax", sakukuPaymentRequest.getTax().setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString());
        jsonGenerator.writeStringField("CurrencyCode", sakukuPaymentRequest.getCurrencyCode());
        jsonGenerator.writeStringField("Description", sakukuPaymentRequest.getDescription());
        jsonGenerator.writeStringField("CallbackURL", sakukuPaymentRequest.getCallbackUrl());
        jsonGenerator.writeEndObject();
    }

    /**
     * Generate BCA Timestamp base on ISO 8601 Format
     *
     * @return Timestamp
     */
    private String formatTimestamp(Timestamp timestamp) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        return dateFormat.format(timestamp);
    }
}
