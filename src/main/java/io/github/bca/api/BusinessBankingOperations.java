package io.github.bca.api;

import java.sql.Date;

public interface BusinessBankingOperations {

    AccountBalance getBalance(String corporateId, String ... accountNo);

    AccountStatement getStatement(String corporateId, String accountNo, Date startDate, Date endDate);

    InhouseTransferResponse inhouseTransfer(InhouseTransferRequest inhouseTransferRequest);
}
