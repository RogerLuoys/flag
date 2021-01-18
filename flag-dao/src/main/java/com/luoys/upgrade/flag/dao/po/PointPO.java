package com.luoys.upgrade.flag.dao.po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * point
 * @author luoys
 */
@Data
public class PointPO implements Serializable {
    private Integer id;

    private String pointId;

    private String ownerId;

    /**
     * 总积分
     */
    private Integer usablePoint;

    /**
     * 可用积分
     */
    private Integer expendPoint;

    /**
     * 未使用
     */
    private Integer type;

    /**
     * 1-正常；2-冻结
     */
    private Integer status;

    private Date gmtCreate;

    private Date gmtModified;

    private static final long serialVersionUID = 1L;
}