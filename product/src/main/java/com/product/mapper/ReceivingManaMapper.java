package com.product.mapper;

import com.product.entity.ReceiveInfo;

/**
 * 收货管理mapper
 * @author wzq
 *
 */
public interface ReceivingManaMapper {

	int saveReceiveCargoBase(ReceiveInfo receiveinfo);
	int saveReceiveCargoDetail(ReceiveInfo receiveinfo);

}
