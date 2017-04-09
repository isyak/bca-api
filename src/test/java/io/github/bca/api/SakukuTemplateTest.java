package io.github.bca.api;

import io.github.bca.api.impl.SakukuTemplate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class SakukuTemplateTest extends AbstractBCATest {

    private SakukuOperations sakukuOperations;

    @Before
    public void setUp() throws Exception {

        sakukuOperations = new SakukuTemplate(getRestTemplate());
    }

    @Test
    public void testPayment() throws Exception {

        SakukuPaymentRequest request = new SakukuPaymentRequest();
        request.setMerchantId("89000");
        request.setMerchantName("Merchant One");
        request.setAmount(new BigDecimal(100.22));
        request.setTax(BigDecimal.ZERO);
        request.setTransactionId("156479");
        request.setCurrencyCode("IDR");
        request.setReferenceId("123465798");
        request.setRequestDate(new Timestamp(System.currentTimeMillis()));
        SakukuPaymentResponse sakukuPaymentResponse = sakukuOperations.create(request);

        Assert.assertNotNull(sakukuPaymentResponse);
        Assert.assertEquals("14486EA88D493A92E0540021281A5568", sakukuPaymentResponse.getPaymentId());
        Assert.assertEquals("156479", sakukuPaymentResponse.getTransactionId());
        Assert.assertEquals("https://10.20.200.82:7003/login?PaymentID=14486EA88D493A92E0540021281A5568", sakukuPaymentResponse.getLandingPageUrl());
    }

    @Test
    public void testGetPaymentStatus() {

        SakukuPaymentStatus sakukuPaymentStatus = sakukuOperations.getStatus("89000", "0FE117D539DF610FE0540021281A5568");

        Assert.assertNotNull(sakukuPaymentStatus);
        Assert.assertEquals("0FE117D539DF610FE0540021281A5568", sakukuPaymentStatus.getPaymentId());
        Assert.assertEquals(new BigDecimal("10000.00"), sakukuPaymentStatus.getAmount());
        Assert.assertEquals("11", sakukuPaymentStatus.getPaymentStatusCode());
        Assert.assertNotNull(sakukuPaymentStatus.getReasonStatus());
        Assert.assertEquals("Transaction on process", sakukuPaymentStatus.getReasonStatus().getEnglish());
    }
}