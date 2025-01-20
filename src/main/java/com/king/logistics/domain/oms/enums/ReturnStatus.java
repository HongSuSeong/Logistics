package com.king.logistics.domain.oms.enums;

public enum ReturnStatus {
    REQUESTED,   // 반품 요청됨
    APPROVED,    // 반품 승인됨
    REJECTED,    // 반품 거절됨
    RECEIVED,    // 반품 상품 수령
    REFUNDED,    // 환불 완료
    CANCELLED    // 반품 요청 취소
}
