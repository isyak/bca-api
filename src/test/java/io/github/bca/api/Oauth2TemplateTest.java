package io.github.bca.api;

import io.github.bca.api.impl.Oauth2Template;
import org.junit.Test;

public class Oauth2TemplateTest {

    @Test
    public void test() {

        try {
            Oauth2Template oauthTokenTemplate = new Oauth2Template();
            AccessGrant accessGrant = oauthTokenTemplate.getToken("91f92308-cabc-456b-856f-4fc0c8f38bdb", "23234dcf-0c52-43d8-8339-d94b833ad86c");
            System.out.println("accessGrant = " + accessGrant);
        }
        catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
