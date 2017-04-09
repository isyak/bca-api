package io.github.bca.api.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bca.api.BCAException;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;

public class BCAErrorHandler extends DefaultResponseErrorHandler {

    @Override
    public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {

        ErrorWrapper errorWrapper = extractErrorFromResponse(clientHttpResponse);
        throw new BCAException(errorWrapper.getErrorCode(), errorWrapper.getMessages());
    }

    private ErrorWrapper extractErrorFromResponse(ClientHttpResponse clientHttpResponse) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(clientHttpResponse.getBody(), ErrorWrapper.class);
    }
}