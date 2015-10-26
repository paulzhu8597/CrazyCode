package com.product.mapper;

import java.util.List;
import java.util.Map;

import com.product.entity.ShippingInfo;
/**
 * 送货信息mapper
 * @author wzq
 *
 */
public interface ShippingInfoMapper {

	List<ShippingInfo> getAllOrgs();
     
	List<ShippingInfo> fuzzyQueryByName(Map param);
}
