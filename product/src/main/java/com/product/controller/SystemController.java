package com.product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.product.entity.Cargoinfo;
import com.product.mapper.BringTakeInfoMapper;
import com.product.mapper.CargoinfoMapper;
import com.product.mapper.CountOrginfoMapper;
import com.product.mapper.ShippingInfoMapper;
import com.product.util.Common;
/**
 * 基本信息部分只是简单的增删改查，没有复杂业务逻辑简单起见不设置server层，直接在controller下调用mapper访问数据库
 * @author wzq
 *
 */

@Controller
@RequestMapping("/system/")
public class SystemController {

	@Resource
	private CargoinfoMapper cargoinfomapper;//货物信息
	@Resource
	private ShippingInfoMapper  shippinginfoMapper;//送货信息
	@Resource
	private BringTakeInfoMapper  bringtakeinfoMapper;//送取货人
	@Resource
	private CountOrginfoMapper  orginfoMapper;//单位信息
//==================================================================货物信息
	/**
	 * 得到货物信息列表
	 * @param model
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("cargoinfo")
	public String cargoinfo(Model model,
			@RequestParam(value = "pageNow") String pageNow,
			@RequestParam(value = "pageSize") String pageSize) {
		Map params = new HashMap();
		params.put("pageNow",
				Integer.valueOf(pageNow) * Integer.valueOf(pageSize));
		params.put("pageSize", Integer.valueOf(pageSize));
		model.addAttribute("cargoes", cargoinfomapper.getCargoinfo(params));
		params.put("table", "cargoinfo");
		params.put("pagerecode", cargoinfomapper.getCount(params));
		params.put("totalpage", Common.getPagetotalByPageSize(
				(String) params.get("pagerecode"), pageSize));
		params.put("pageNow", Integer.valueOf(pageNow));
		model.addAttribute("params", params);
		return Common.BACKGROUND_PATH + "/system/cargoinfo/list";
	}

	/**
	 * 分页查询货物
	 * @param model
	 * @param cargoname
	 * @param pageNow
	 * @param pageSize
	 * @param isfromsearch
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/cargoinfo/findByPage")
	public List<Cargoinfo> findByPage(Model model,
			@RequestParam(value = "cargoname") String cargoname,
			@RequestParam(value = "pageNow") String pageNow,
			@RequestParam(value = "pageSize") String pageSize,
			@RequestParam(value = "isfromsearch") String isfromsearch)
			throws Exception {
		if ("true".equals(isfromsearch)) {
			pageNow = "0";
			pageSize = "20";
		}
		Map params = new HashMap();
		params.put("cargoname", cargoname);
		params.put("pageNow",
				Integer.valueOf(pageNow) * Integer.valueOf(pageSize));
		params.put("pageSize", Integer.valueOf(pageSize));
		params.put("table", "cargoinfo");
		if (Common.isNotEmpty(cargoname)) {
			params.put("where", " cargoname like '%" + cargoname + "%'");
		}
		return cargoinfomapper.getCargoinfo(params);
	}

	/**
	 * 根据条件获取某张表的记录数
	 * @param cargoname
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/cargoinfo/getCount")
	public String getCount(@RequestParam(value = "cargoname") String cargoname) {
		Map params = new HashMap();
		params.put("table", "cargoinfo");
		if (Common.isNotEmpty(cargoname)) {
			params.put("where", " cargoname like '%" + cargoname + "%'");
		}
		return cargoinfomapper.getCount(params);
	}

	/**
	 * 添加一条货物信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/cargoinfo/doAddCargo")
	public String doAddCargo(HttpServletRequest request) {
		String rtn = "ok";
		try {
			String addcargoname = request.getParameter("addcargoname");
			Map addcargonameparam = new HashMap();
			addcargonameparam.put("addcargoname", addcargoname);
			    if(cargoinfomapper.isrepeat(addcargonameparam)>=1){
			    	rtn = "货物【"+addcargoname+"】已经存在!";
			    	return rtn;
			    }
				cargoinfomapper.addcargo(new Cargoinfo(
						Common.stringDefaultOfEmpty(addcargoname,""),
						Common.stringDefaultOfEmpty(request.getParameter("org"),""),
						Common.stringDefaultOfEmpty(request.getParameter("irradtype"),""),
						Common.stringDefaultOfEmpty(request.getParameter("irradtime"),""),
						Common.stringDefaultOfEmpty(request.getParameter("timeorg"),"")));
		} catch (Exception e) {
			e.printStackTrace();
			rtn = e.getMessage();
		}
		return rtn;
	}

	/**
	 * 根据条件得到一条货物记录
	 * @param idAndName
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/cargoinfo/getOneCargo")
	public Cargoinfo getOneCargo(@RequestParam(value = "idAndName") String idAndName){
		Map params = new HashMap();
		params.put("id", idAndName.split("@_@")[0]);
		params.put("cargoname", idAndName.split("@_@")[1]);
		Cargoinfo cargoinfo =  cargoinfomapper.getOneCargo(params);
		return cargoinfo;
	}
	
	/**
	 * 保存编辑后的货物
	 * @param request
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/cargoinfo/saveEditCargo")
	public String saveEditCargo(HttpServletRequest request){
		String rtn = "ok";
		try {
			String addcargoname = request.getParameter("addcargoname");
				cargoinfomapper.saveEditCargo(new Cargoinfo(
						Common.stringDefaultOfEmpty(addcargoname,""),
						Common.stringDefaultOfEmpty(request.getParameter("org"),""),
						Common.stringDefaultOfEmpty(request.getParameter("irradtype"),""),
						Common.stringDefaultOfEmpty(request.getParameter("irradtime"),""),
						Common.stringDefaultOfEmpty(request.getParameter("timeorg"),"")));
		} catch (Exception e) {
			e.printStackTrace();
			rtn = e.getMessage();
		}
		return rtn;
	}
	
	/**
	 * 根据条件删除一条货物记录
	 * @param request
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/cargoinfo/deleteCargo")
	public String deleteCargo(HttpServletRequest request){
		String rtn = "ok";
		String idAndName = request.getParameter("idAndName");
		try{
		if(Common.isNotEmpty(idAndName)){
			Map params = new HashMap();
			params.put("id", idAndName.split("@_@")[0]);
			params.put("cargoname", idAndName.split("@_@")[1]);
			cargoinfomapper.deleteByAttribute(params);
		}
		}catch (Exception e){
			rtn = e.getMessage();
		}
		return rtn;
	}
	
	//==================================================================送货信息
	
	
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

	public CountOrginfoMapper getOrginfoMapper() {
		return orginfoMapper;
	}

	public void setOrginfoMapper(CountOrginfoMapper orginfoMapper) {
		this.orginfoMapper = orginfoMapper;
	}

	public CargoinfoMapper getCargoinfomapper() {
		return cargoinfomapper;
	}

	public void setCargoinfomapper(CargoinfoMapper cargoinfomapper) {
		this.cargoinfomapper = cargoinfomapper;
	}

}
