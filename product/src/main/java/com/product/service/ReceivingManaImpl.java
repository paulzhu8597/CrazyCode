package com.product.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.product.bean.common.DictItem;
import com.product.entity.BringTakeInfo;
import com.product.entity.Cargoinfo;
import com.product.entity.CountOrgInfo;
import com.product.entity.RadiationInfo;
import com.product.entity.ReceiveInfo;
import com.product.entity.ShippingInfo;
import com.product.entity.TakeCargoInfo;
import com.product.mapper.BringTakeInfoMapper;
import com.product.mapper.CargoinfoMapper;
import com.product.mapper.CountOrginfoMapper;
import com.product.mapper.ReceivingManaMapper;
import com.product.mapper.ShippingInfoMapper;
import com.product.util.LogUtil;

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
		
		//保存收取的货物
		@Transactional(rollbackFor=java.lang.Exception.class)
		public void saveReceiveCargo(ReceiveInfo receiveinfo) {
			String id = receivingmanamapper.checkhaveone(receiveinfo);
			if(null!=id&&!"".equals(id)&&Integer.valueOf(id)>0){
				receiveinfo.setId(id);
				receivingmanamapper.saveReceiveCargoDetail(receiveinfo);
			}
			else
			{
				int gkey = receivingmanamapper.saveReceiveCargoBase(receiveinfo);
				if(gkey==1){
					receivingmanamapper.saveReceiveCargoDetail(receiveinfo);
				}
			}
		}
	
		//数据跟新时 判重
		public String isreapeat(ReceiveInfo receiveinfo) {
			List<ReceiveInfo> reapeatlist  = receivingmanamapper.isreapeat(receiveinfo);
			StringBuffer sb = new StringBuffer("");
			
			if(null!=reapeatlist){
				for(int i=0;i<reapeatlist.size();i++){
					ReceiveInfo ri = reapeatlist.get(i);
					sb.append("送货时间：").append(ri.getReceivetime()).
					append(" 送货单位：").append(ri.getReceiveorgid()).
					append(" 送货人：").append(ri.getReceivepeopleid()).
					append(" 货物 名称：").append(ri.getCargoid()).append("\n");
				}
			}
		
			return sb.toString();
		}
		

	//取得所有已经收取的货物
	public List<ReceiveInfo> getreceivedCargos(Map params) {
			return receivingmanamapper.getReceivedCargos(params);
	}
	
	//根据货物基本信息（id，单位，时间、送货人）得到该信息下有哪些货物
	public List<ReceiveInfo> getDetInfoByReceiveorgId(Map rtntValue) {
		return receivingmanamapper.getDetInfoByReceiveorgId(rtntValue);
	}
	
	//删除一条货物确认信息，连带删除其下属的详情
	public int deleteconfirms(String sqlids) {
		
		return receivingmanamapper.deleteconfirms(sqlids);
	}
	
	//取得所有的待确认货物
	public List<ReceiveInfo> getconfirms(Map params) {
		return receivingmanamapper.getconfirms(params);
	}
	
	//编辑货物详情，得到已有信息
	public ReceiveInfo getEditDetailInfo(Map param) {
		return receivingmanamapper.getEditDetailInfo(param);
	}
	
	//删除一条货物确认的详情
	@Transactional(rollbackFor=java.lang.Exception.class)
	public String deleteConfirDetailInfo(Map param) {
		String rest = "";
		
		try {
			int i = receivingmanamapper.deleteConfirDetailInfo(param);
			if (i >= 1) {
				rest = "ok";
			} else {
				rest = "error:删除0条数据！";
			}
		} catch (Exception e) {
			rest = e.getMessage();
			LogUtil.getLog().error("ReceivingManaImpl.deleteConfirDetailInfo:\n"+rest);
			throw new RuntimeException(rest);
		}
		return rest;
	}
	
	//编辑 货物确认详情后保存操作
	@Transactional(rollbackFor=java.lang.Exception.class)
	public String saveEditConfirDetailInfo(ReceiveInfo receiveinfo) {
		String result = "";
		try {
			int r = receivingmanamapper.saveEditConfirDetailInfo(receiveinfo);
			if(r>0){
				result = "ok";
			}
			else
			{
				result = "error:更新失败！";	
			}
		} catch (Exception e) {
			result = e.getMessage(); 
			LogUtil.getLog().error("ReceivingManaImpl.saveEditConfirDetailInfo:\n"+result);
			throw new RuntimeException(result);
		}
		return result;
	}
	
	
	public String updateConfirmStatus(Map idandstatus) {
		String rtn  = "";
		try {
			int baseresult = receivingmanamapper.updateBaseStatus(idandstatus);
			if (baseresult > 0) {
				receivingmanamapper.updateDetailStatus(idandstatus);
				rtn = "ok";
			}
		} catch (Exception e) {
			rtn = e.getMessage(); 
			LogUtil.getLog().error("ReceivingManaImpl.updateConfirmStatus:\n"+rtn);
			throw new RuntimeException(rtn);
		}
		return rtn;
	}
	
	//得到所偶带辐照货物
	public List<ReceiveInfo> getradiations(Map params) {
		return receivingmanamapper.getradiations(params);
	}
	
	//将某一条货物进行辐照得到已有的货物信息
	public ReceiveInfo getRadiationInfo(String id) {
		return receivingmanamapper.getRadiationInfo(id);
	}
	
	//辐照一批货物
	@Transactional(rollbackFor=java.lang.Exception.class)
	public String setRadiation(RadiationInfo radiationinfo) {
		String rtn = "";
		try {
			int update  = receivingmanamapper.updateReceivedDetailIrradednum(radiationinfo);
			int result = receivingmanamapper.setRadiation(radiationinfo);
			if (result > 0) {
				rtn = "ok";
			} else {
				rtn = "error:插入失败！";
			}
		} catch (Exception e) {
			rtn = e.getMessage(); 
			LogUtil.getLog().error("ReceivingManaImpl.setRadiation:\n"+rtn);
			throw new RuntimeException(rtn);
		}
		return rtn;
	}
	
	public List<RadiationInfo> queryAllCurrentRadiations() {
		return receivingmanamapper.queryAllCurrentRadiations();
	}
	
	@Transactional(rollbackFor=java.lang.Exception.class)
	public String updateRadiationStatus(String id) {
		String result = "";
		try {
			int re = receivingmanamapper.updateRadiationStatus(id);
			if (re > 0) {
				result = "ok";
			} else {
				result = "error:跟新失败！";
			}
		} catch (Exception e) {
			result = e.getMessage(); 
			LogUtil.getLog().error("ReceivingManaImpl.updateRadiationStatus:\n"+result);
			throw new RuntimeException(result);
		}
		return result;
	}
	
	@Transactional(rollbackFor=java.lang.Exception.class)
	public String saveTakeCargoe(TakeCargoInfo takecargoinfo) {
		String result = "";
		try {
			Integer count = -1;
			count =  receivingmanamapper.doRepeatTakeCargo(takecargoinfo);
			if(null!=count && !"null".equals(count) && !"".equals(count) && count!=-1){
				takecargoinfo.setBaseid(String.valueOf(count));
				receivingmanamapper.updateHaveTakeCargoCount(takecargoinfo);
				receivingmanamapper.saveTakeCargoDetail(takecargoinfo);
				result = "ok";
			}else{
				//取货后跟新已取货物数量字段
				int updatecount = receivingmanamapper.updateHaveTakeCargoCount(takecargoinfo);
				if (updatecount > 0) {
					int base = receivingmanamapper.saveTakeCargoBase(takecargoinfo);
					int detail = receivingmanamapper.saveTakeCargoDetail(takecargoinfo);
					if ((base + detail) == 2) {
						result = "ok";
					}
				}
			}
		} catch (Exception e) {
			result = e.getMessage(); 
			LogUtil.getLog().error("ReceivingManaImpl.saveTakeCargoe:\n"+result);
			throw new RuntimeException(result);
		}
		return result;
	}
	
	public List<TakeCargoInfo> getHaveTakedCargoes(Map<String, Object> params) {
		return receivingmanamapper.getHaveTakedCargoes(params);
	}

	
	public List<TakeCargoInfo> queryHaveTakedCargoeDetail(String id) {
		return receivingmanamapper.queryHaveTakedCargoeDetailByBaseId(id);
	}
	
	public List<RadiationInfo> getAllTakeCargoes(Map<String, Object> params) {
		return receivingmanamapper.getAllTakeCargoes(params);
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
