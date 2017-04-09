package io.github.bca.api;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class InhouseTransferRequestSerializer extends StdSerializer<InhouseTransferRequest> {

    public InhouseTransferRequestSerializer() {
        this(null);
    }

    public InhouseTransferRequestSerializer(Class<InhouseTransferRequest> t) {
        super(t);
    }

    @Override
    public void serialize(InhouseTransferRequest inhouseTransferRequest, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("CorporateID", inhouseTransferRequest.getCorporateId());
        jsonGenerator.writeStringField("SourceAccountNumber", inhouseTransferRequest.getAccountNo());
        jsonGenerator.writeStringField("TransactionID", inhouseTransferRequest.getTransactionId());
        jsonGenerator.writeStringField("TransactionDate", formatDate(inhouseTransferRequest.getTransactionDate()));
        jsonGenerator.writeStringField("ReferenceID", inhouseTransferRequest.getReferenceId());
        jsonGenerator.writeStringField("CurrencyCode", inhouseTransferRequest.getCurrencyCode());
        jsonGenerator.writeStringField("Amount", inhouseTransferRequest.getAmount().setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString());
        jsonGenerator.writeStringField("BeneficiaryAccountNumber", inhouseTransferRequest.getBeneficiaryAccountNo());
        jsonGenerator.writeStringField("Remark1", inhouseTransferRequest.getRemark1());
        jsonGenerator.writeStringField("Remark2", inhouseTransferRequest.getRemark2());
        jsonGenerator.writeEndObject();
    }

    private String formatDate(Date date) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }
}