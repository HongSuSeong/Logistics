package com.king.logistics.domain.tms.enums;

public enum DeliveryStatus {
    PENDING,      // 대기 중 (배송 준비 완료, 발송 대기)
    SHIPPED,      // 발송됨 (배송이 시작됨)
    IN_TRANSIT,   // 배송 중 (물류 센터를 지나고 있음)
    DELIVERED,    // 배송 완료 (배송이 완료됨)
    CANCELLED,    // 취소됨 (배송이 취소됨)
    FAILED        // 배송 실패 (배송에 문제가 발생)
}
