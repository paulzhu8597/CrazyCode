package com.product.controller;

import javax.servlet.http.HttpServletRequest;

import com.product.entity.ReceiveInfo;

public class BusinessControllerHelper {
	public static ReceiveInfo getReceiveInfoObject(HttpServletRequest request) {
		String receivetime = request.getParameter("receivetime");
		String showorgs = request.getParameter("showorgs");
		String showBringTakeInfos = request.getParameter("showBringTakeInfos");
		String telnum = request.getParameter("telnum");
		String cargoname = request.getParameter("cargoname");
		String cargocount = request.getParameter("cargocount");
		String showcountorginfos = request.getParameter("showcountorginfos");
		String reqreagent = request.getParameter("reqreagent");
		String irradtime = request.getParameter("irradtime");
		String timeorgs = request.getParameter("timeorgs");
		String irradflags = request.getParameter("irradflags");
		String asCurrentRecord = request.getParameter("asCurrentRecord");
		
		ReceiveInfo receiveinfo = new ReceiveInfo();
		receiveinfo.setReceivetime(receivetime);
		receiveinfo.setReceiveorgid(showorgs);
		receiveinfo.setReceivepeopleid(showBringTakeInfos);
		receiveinfo.setTelnum(telnum);
		receiveinfo.setCargoid(cargoname);
		receiveinfo.setCargocount(cargocount);
		receiveinfo.setCountorg(showcountorginfos);
		receiveinfo.setReqreagent(reqreagent);
		receiveinfo.setIrradtime(irradtime);
		receiveinfo.setIrradtimeorg(timeorgs);
		receiveinfo.setIrradflag(irradflags);
		receiveinfo.setAsCurrentRecord(asCurrentRecord);
		return receiveinfo;
		
	}
}
