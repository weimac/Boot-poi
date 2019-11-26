package com.wk.po;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;

@Data
public class Weiuser implements Serializable {

    @Excel(name = "id")
    private Long id;

    @Excel(name = "openid")
    private String openid;

    @Excel(name = "nickname")
    private String nickname;

    private static final long serialVersionUID = 1L;

}