package com.product.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.product.mapper.CargoinfoMapper;
import com.product.util.Common;

@Controller
@RequestMapping("/system/")
public class SystemController {

	@Resource
	private CargoinfoMapper cargoinfomapper;

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

	@ResponseBody
    @RequestMapping("/cargoinfo/getOneCargo")
	public Cargoinfo getOneCargo(@RequestParam(value = "idAndName") String idAndName){
		Map params = new HashMap();
		params.put("id", idAndName.split("@_@")[0]);
		params.put("cargoname", idAndName.split("@_@")[1]);
		Cargoinfo cargoinfo =  cargoinfomapper.getOneCargo(params);
		return cargoinfo;
	}
	
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
	
	public CargoinfoMapper getCargoinfomapper() {
		return cargoinfomapper;
	}

	public void setCargoinfomapper(CargoinfoMapper cargoinfomapper) {
		this.cargoinfomapper = cargoinfomapper;
	}

}
