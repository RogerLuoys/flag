package com.luoys.upgrade.flag.api.bo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class FlagBindBO {

    private String userId;

    private String flagId;

    /**
     * 1-所有者；2-见证人
     */
    private Integer type;

    /**
     * 1-未开始; 2-进行中; 3-暂停; 4-已结束; 5-已达成
     */
    private Integer status;

    private Date gmtCreate;

    private Date gmtModify;

}
