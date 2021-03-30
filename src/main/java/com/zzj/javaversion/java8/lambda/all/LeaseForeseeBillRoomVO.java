package com.zzj.javaversion.java8.lambda.all;

import lombok.Data;

import java.io.Serializable;

/**
 * 预账单
 **/
@Data
public class LeaseForeseeBillRoomVO implements Serializable {

    private Integer roomId;

    private String roomName;

    private String floorName;

    private String buildingName;
}
