package io.github.bca.api;

import io.github.bca.api.impl.GeneralInformationTemplate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GeneralInformationTemplateTest extends AbstractBCATest {

    private GeneralInformationTemplate generalInformationTemplate;

    @Before
    public void setUp() throws Exception {

        generalInformationTemplate = new GeneralInformationTemplate(getRestTemplate());
    }

    @Test
    public void testGetTimeDepositRates() {

        TimeDeposit timeDeposit = generalInformationTemplate.getTimeDepositRates();

        Assert.assertNotNull(timeDeposit);
        Assert.assertEquals("SUKU BUNGA BCA DEP RP BERLAKU MULAI 24 APRIL 2009", timeDeposit.getDescription1());
        Assert.assertEquals("SUKU BUNGA BCA DEP USD BERLAKU MULAI 1 APRIL 2009", timeDeposit.getDescription2());
        Assert.assertEquals("TGKT BUNGA YG WAJAR YG DIJAMIN LPS UTK PERIODE 15 APR 2009 S/D 14 MEI 2009", timeDeposit.getDescription3());

        Assert.assertNotNull(timeDeposit.getTimeDepositProducts());
        Assert.assertEquals(3, timeDeposit.getTimeDepositProducts().size());
    }

    @Test
    public void testGetExchangeRates() {

        List<ExchangeRate> exchangeRateList = generalInformationTemplate.getExchangeRates(RateType.E_RATE);

        Assert.assertNotNull(exchangeRateList);
        Assert.assertEquals(3, exchangeRateList.size());
    }

    @Test
    public void testGetNearestATM() {

        NearestATMRequest nearestATMRequest = new NearestATMRequest();
        nearestATMRequest.setLatitude(-6.1900718d);
        nearestATMRequest.setLongitude(106.797190d);
        nearestATMRequest.setRadius(20);

        List<ATM> atmList = generalInformationTemplate.getNearestATM(nearestATMRequest);

        Assert.assertNotNull(atmList);
        Assert.assertEquals(3, atmList.size());
    }
}