package io.github.bca.api;

import io.github.bca.api.impl.BusinessBankingTemplate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Date;

public class BusinessBankingTemplateTest extends AbstractBCATest {

    private BusinessBankingTemplate businessBankingTemplate;

    @Before
    public void setUp() throws Exception {

        businessBankingTemplate = new BusinessBankingTemplate(getRestTemplate());
    }

    @Test
    public void testGetBalance() {

        AccountBalance accountBalance = businessBankingTemplate.getBalance("BCAAPI2016", "0201245680");

        Assert.assertNotNull(accountBalance);
        Assert.assertEquals(1, accountBalance.getAccountList().size());
        Assert.assertTrue(accountBalance.getAccountErrorList().isEmpty());

        Account account = accountBalance.getAccountList().get(0);
        Assert.assertEquals("0201245680", account.getNo());
        Assert.assertEquals("IDR", account.getCurrencyCode());
        Assert.assertEquals(new BigDecimal("118849999.53"), account.getBalance());
        Assert.assertEquals(new BigDecimal("118849999.53"), account.getAvailableBalance());
        Assert.assertEquals(new BigDecimal("0.00"), account.getFloatAmount());
        Assert.assertEquals(new BigDecimal("0.00"), account.getHoldAmount());
        Assert.assertEquals(new BigDecimal("0.00"), account.getPlafond());
    }

    @Test
    public void testGetStatement() {

        Date fromDate = toDate(2016, 8,30);
        Date endDate = toDate(2016, 9, 1);

        AccountStatement accountStatement = businessBankingTemplate.getStatement("BCAAPI2016", "0201245680", fromDate, endDate);

        Assert.assertNotNull(accountStatement);
        Assert.assertEquals("IDR", accountStatement.getCurrencyCode());
        Assert.assertEquals(new BigDecimal("90725000.00"), accountStatement.getStartBalance());

        Assert.assertNotNull(accountStatement.getAccountStatementDetailList());
        Assert.assertEquals(15, accountStatement.getAccountStatementDetailList().size());
    }

    @Test
    public void testTransferInhouse() throws Exception {

        InhouseTransferRequest request = new InhouseTransferRequest();
        request.setCorporateId("BCAAPI2016");
        request.setAccountNo("0201245680");
        request.setTransactionId("00000001");
        request.setTransactionDate(new Date(System.currentTimeMillis()));
        request.setReferenceId("12345/PO/2016");
        request.setCurrencyCode("IDR");
        request.setAmount(new BigDecimal(10000.5456));
        request.setBeneficiaryAccountNo("0201245681");
        request.setRemark1("Transfer Test");
        request.setRemark2("Online Transfer");

        InhouseTransferResponse inhouseTransferResponse = businessBankingTemplate.inhouseTransfer(request);
        Assert.assertNotNull(inhouseTransferResponse);
        Assert.assertEquals("00000001", inhouseTransferResponse.getTransactionId());
        Assert.assertEquals("12345/PO/2016", inhouseTransferResponse.getReferenceId());
        Assert.assertEquals("Success", inhouseTransferResponse.getStatus());
    }
}
