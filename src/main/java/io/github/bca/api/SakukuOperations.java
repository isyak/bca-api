package io.github.bca.api;

public interface SakukuOperations {

    SakukuPaymentResponse create(SakukuPaymentRequest sakukuPaymentRequest);

    SakukuPaymentStatus getStatus(String merchantId, String paymentId);
}
