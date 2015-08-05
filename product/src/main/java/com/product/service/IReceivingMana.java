package com.product.service;

import java.util.List;
import java.util.Map;

import com.product.bean.common.DictItem;
import com.product.entity.ReceiveInfo;

public interface IReceivingMana {

	List<DictItem> getAllOrgs();
    List <DictItem> getAllBringTakeInfoPeople();
    List<DictItem> getCargoinfo();
    List<DictItem> getAllOrginfo();
	void saveReceiveCargo(ReceiveInfo receiveinfo);
	boolean isreapeat(ReceiveInfo receiveinfo);
    
}
