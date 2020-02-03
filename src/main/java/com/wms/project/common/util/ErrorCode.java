package com.wms.project.common.util;

import lombok.AllArgsConstructor;

// 错误码统一管理
@AllArgsConstructor
public enum  ErrorCode {
    NO_JWT(-1001,"没有JWT信息"),
    JWT_ERROR(-1002,"JWT加密错误");

    public final Integer code;
    public final String msg;
}
