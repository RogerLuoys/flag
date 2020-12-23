package com.luoys.upgrade.flag.api.bo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class FlagDetailBO extends FlagBO {

    // flag 关联的任务信息
    private List<TaskBO> tasks;

    // flag 关联的账户信息
    private String ownerId;
    private String ownerName;
    private String witnessId;
    private String witnessName;


}
