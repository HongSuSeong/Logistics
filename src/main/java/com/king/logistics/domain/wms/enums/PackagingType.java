package com.king.logistics.domain.wms.enums;

public enum PackagingType {
    BOX, // 일반적인 박스 포장
    BAG, // 봉지 포장
    PALLET, // 팔레트 포장
    ROLL, // 롤 형태의 포장
    ENVELOPE, // 봉투 포장 (문서 등 작은 물품)
    TUBE, // 원통형 포장 (주로 긴 물건)
    BULK, // 대량 포장 (개별 포장 없이 대량으로)
    CRATE // 나무 상자 포장
}
