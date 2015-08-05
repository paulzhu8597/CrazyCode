package com.product.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.product.bean.common.DictItem;
import com.product.entity.ReceiveInfo;
import com.product.mapper.CommonMapper;
import com.product.service.IReceivingMana;
import com.product.util.Common;

@Controller
@RequestMapping("/business/")
public class BusinessController {

	
	@Resource(name="ReceivingManaImpl")
	private IReceivingMana ireceivingmana;
	@Resource
	private CommonMapper commonmapper;

	@RequestMapping("receivingmana")
	public String receivingmana(Model model){

		model.addAttribute("showorgs", ireceivingmana.getAllOrgs());//送货单位
		model.addAttribute("showBringTakeInfos", ireceivingmana.getAllBringTakeInfoPeople());//送货人
		model.addAttribute("showcargoinfos", ireceivingmana.getCargoinfo());//货物名称
		model.addAttribute("showcountorginfos", ireceivingmana.getAllOrginfo());//计数单位
		
		List<DictItem>  irradtypes = new ArrayList<DictItem>();
		irradtypes.add(new DictItem("staticirrad","静态辐射"));
		irradtypes.add(new DictItem("dnyirrad","动态辐射"));
		
		List<DictItem>  timeorgs = new ArrayList<DictItem>();
		timeorgs.add(new DictItem("hour","时"));
		timeorgs.add(new DictItem("minute","分"));
		
		List<DictItem>  irradflags = new ArrayList<DictItem>();
		irradflags.add(new DictItem("firstirrad","首次辐射"));
		irradflags.add(new DictItem("secondirrad","重新辐射"));
		irradflags.add(new DictItem("noirrad","不辐射"));

		
		model.addAttribute("irradtypes", irradtypes);
		model.addAttribute("timeorgs", timeorgs);
		model.addAttribute("irradflags", irradflags);
		return Common.BACKGROUND_PATH + "/businessmana/receivingmana/list";
	}
	
	@ResponseBody
	@RequestMapping("saveReceiveCargo")
	public Map<String,String> saveReceiveCargo(HttpServletRequest request){
		Map<String,String> rtn = new HashMap<String,String>();
		try{
		ReceiveInfo receiveinfo = BusinessControllerHelper.getReceiveInfoObject(request);
		if("1".equals(commonmapper.getChart("checkRepeatOfsaveReceive"))){
			boolean  isreapeat = ireceivingmana.isreapeat(receiveinfo);
			rtn.put("result", "checkrepeat");
			return rtn;
		}
		ireceivingmana.saveReceiveCargo(receiveinfo);
		rtn.put("result", "insertsuccess");
		}catch (Exception e){
			e.printStackTrace();
			rtn.put("result", "inserterror");
			throw new RuntimeException(e.getMessage());
		}
		return rtn;
	}
	
	
	public IReceivingMana getIreceivingmana() {
		return ireceivingmana;
	}

	public void setIreceivingmana(IReceivingMana ireceivingmana) {
		this.ireceivingmana = ireceivingmana;
	}

	public CommonMapper getCommonmapper() {
		return commonmapper;
	}

	public void setCommonmapper(CommonMapper commonmapper) {
		this.commonmapper = commonmapper;
	}
}
