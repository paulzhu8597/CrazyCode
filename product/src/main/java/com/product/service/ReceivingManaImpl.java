package com.product.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.product.bean.common.DictItem;
import com.product.entity.BringTakeInfo;
import com.product.entity.Cargoinfo;
import com.product.entity.CountOrgInfo;
import com.product.entity.ReceiveInfo;
import com.product.entity.ShippingInfo;
import com.product.mapper.BringTakeInfoMapper;
import com.product.mapper.CargoinfoMapper;
import com.product.mapper.CountOrginfoMapper;
import com.product.mapper.ReceivingManaMapper;
import com.product.mapper.ShippingInfoMapper;

@Service(value="ReceivingManaImpl")
public class ReceivingManaImpl implements IReceivingMana {
	@Resource
	private ReceivingManaMapper receivingmanamapper;
	@Resource
	private ShippingInfoMapper  shippinginfoMapper;//送货信息
	@Resource
	private BringTakeInfoMapper  bringtakeinfoMapper;//送取货人
	@Resource
	private CargoinfoMapper cargoinfomapper; //货物信息
	@Resource
	private CountOrginfoMapper countorginfomapper; //单位信息
	
	/**
	 * 货物送货单位
	 */
	public List<DictItem> getAllOrgs() {
		List<DictItem> showorgs = new ArrayList<DictItem>();
		List<ShippingInfo> orgs =  shippinginfoMapper.getAllOrgs();
		DictItem dict = null;
		for(int i=0;i<orgs.size();i++){
			dict = new DictItem();
			dict.setDictid(orgs.get(i).getId());
			dict.setDictname(orgs.get(i).getOrgname());
			showorgs.add(dict);
		}
		return showorgs;
	}
	
	/**
	 * 获取送货人
	 */
	public List<DictItem> getAllBringTakeInfoPeople() {
		List<DictItem> showBringTakeInfos = new  ArrayList<DictItem>();
		List<BringTakeInfo> BringTakeInfos =  bringtakeinfoMapper.getAllBringTakeInfoPeople();
		DictItem dict = null;
		for(int i=0;i<BringTakeInfos.size();i++){
			dict = new DictItem();
			dict.setDictid(BringTakeInfos.get(i).getId());
			dict.setDictname(BringTakeInfos.get(i).getName());
			showBringTakeInfos.add(dict);
		}
		return showBringTakeInfos;
	}
	
	/**
	 * 货物货物信息
	 */
	 public  List<DictItem> getCargoinfo()
	 {
		 List<Cargoinfo>  cargoinfos =  cargoinfomapper.getCargoinfo(new HashMap());
		 List<DictItem> showcargoinfos = new ArrayList<DictItem>();
		 DictItem dict = null;
			for(int i=0;i<cargoinfos.size();i++){
				dict = new DictItem();
				dict.setDictid(String.valueOf(cargoinfos.get(i).getId()));
				dict.setDictname(cargoinfos.get(i).getCargoname());
				showcargoinfos.add(dict);
			}
		 return showcargoinfos;
	 }
	
	 /**
	  * 货物计数单位
	  */
		public List<DictItem> getAllOrginfo() {
			 List<CountOrgInfo>  orginfos =  countorginfomapper.getAllOrginfo();
			 List<DictItem> showorginfos = new ArrayList<DictItem>();
			 DictItem dict = null;
				for(int i=0;i<orginfos.size();i++){
					dict = new DictItem();
					dict.setDictid(String.valueOf(orginfos.get(i).getId()));
					dict.setDictname(orginfos.get(i).getOrgname());
					showorginfos.add(dict);
				}
			 return showorginfos;
		}
		
		@Transactional(rollbackFor=java.lang.Exception.class)
		public void saveReceiveCargo(ReceiveInfo receiveinfo) {
			int gkey = receivingmanamapper.saveReceiveCargoBase(receiveinfo);
			if(gkey==1){
				receivingmanamapper.saveReceiveCargoDetail(receiveinfo);
			}
		}
	
		public boolean isreapeat(ReceiveInfo receiveinfo) {
			// TODO Auto-generated method stub
			return false;
		}
		
	public ReceivingManaMapper getReceivingmanamapper() {
		return receivingmanamapper;
	}
	public void setReceivingmanamapper(ReceivingManaMapper receivingmanamapper) {
		this.receivingmanamapper = receivingmanamapper;
	}
	public ShippingInfoMapper getShippinginfoMapper() {
		return shippinginfoMapper;
	}
	public void setShippinginfoMapper(ShippingInfoMapper shippinginfoMapper) {
		this.shippinginfoMapper = shippinginfoMapper;
	}
	public BringTakeInfoMapper getBringtakeinfoMapper() {
		return bringtakeinfoMapper;
	}
	public void setBringtakeinfoMapper(BringTakeInfoMapper bringtakeinfoMapper) {
		this.bringtakeinfoMapper = bringtakeinfoMapper;
	}
}
