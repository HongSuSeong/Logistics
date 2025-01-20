package com.king.logistics.domain.oms.enums;

public enum OrderStatus {
        PENDING,    // 주문 대기
        PROCESSING, // 처리 중
        SHIPPED,    // 배송 완료
        DELIVERED,  // 고객에게 전달됨
        CANCELLED   // 주문 취소됨
}
