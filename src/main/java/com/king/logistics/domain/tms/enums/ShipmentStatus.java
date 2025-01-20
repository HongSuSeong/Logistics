package com.king.logistics.domain.tms.enums;

public enum ShipmentStatus {
    PENDING,          // 대기 중 (선적 준비 완료, 출발 대기)
    IN_PROGRESS,      // 진행 중 (선적이 진행 중)
    COMPLETED,        // 완료됨 (선적이 완료됨)
    SHIPPED,          // 선적됨 (선적이 끝나고 배송 대기 상태)
    CANCELLED,        // 취소됨 (선적이 취소됨)
    DELIVERED,        // 배송 완료 (선적 후 배송 완료됨)
    RETURNED          // 반품됨 (선적 후 반품)
}
