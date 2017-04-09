package io.github.bca.api;

import io.github.bca.api.impl.BCAErrorHandler;
import io.github.bca.api.impl.BCATransactionInterceptor;
import io.github.bca.api.impl.Oauth2Template;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;

public abstract class AbstractBCATest {

    private static final String CLIENT_ID = "91f92308-cabc-456b-856f-4fc0c8f38bdb";

    private static final String CLIENT_SECRET = "23234dcf-0c52-43d8-8339-d94b833ad86c";

    private static final String API_KEY = "b2cf2551-df37-4b0c-b835-cbc98d5d802b";

    private static final String API_SECRET = "1bdaa2a2-b669-499e-bed1-f2c0eeae0753";

    protected RestTemplate getRestTemplate() {

        RestTemplate restTemplate = new RestTemplate();

        Oauth2Operations oauth2Operations = new Oauth2Template();
        AccessGrant accessGrant = oauth2Operations.getToken(CLIENT_ID, CLIENT_SECRET);

        restTemplate.setInterceptors(Collections.singletonList(new BCATransactionInterceptor(accessGrant.getAccessToken(), API_KEY, API_SECRET)));
        restTemplate.setErrorHandler(new BCAErrorHandler());

        return restTemplate;
    }

    protected Date toDate(int year, int month, int day) {

        Calendar calendar = new GregorianCalendar(year, month - 1, day);
        return new Date(calendar.getTimeInMillis());
    }
}
