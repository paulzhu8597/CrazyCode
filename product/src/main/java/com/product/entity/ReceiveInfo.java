package com.product.entity;
/**
 * 收获管理
 * @author wzq
 *
 */
public class ReceiveInfo {
	private String id;             //receivemgrbase
	private String receivetime;    //receivemgrbase  收货日期
	private String receiveorgid; //receivemgrbase  送货单位 shippinginfo：orgname
	private String receivepeopleid;  //receivemgrbase  送货人 bringtakeinfo：name
	private String telnum;         //receivemgrbase  联系电话
	private String receivemgrid;   //receivemgrdetail 收获管理基本信息id ReceiveMgrBase：id
	private String cargoid;        //货物名称 cargoinfo：id
	private String cargocount;     //货物数量
	private String countorg;       //数量单位 orginfo：orgname
	private String cargoweight;    //货物重量(吨)
	private String funguscount;    //含菌数
	private String reqreagent;     //要求剂量(kgy)
	private String irradtype;      //辐照方式 cargoinfo：irradtype
	private String irradtime;      //辐照时间
	private String irradtimeorg;   //辐照时间单位
	private String irradflag;      //辐照类型：首次辐照、重新辐照、不辐照
	private String asCurrentRecord;//是否依照当前记录
	public String getAsCurrentRecord() {
		return asCurrentRecord;
	}
	public void setAsCurrentRecord(String asCurrentRecord) {
		this.asCurrentRecord = asCurrentRecord;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReceivetime() {
		return receivetime;
	}
	public void setReceivetime(String receivetime) {
		this.receivetime = receivetime;
	}
	public String getTelnum() {
		return telnum;
	}
	public void setTelnum(String telnum) {
		this.telnum = telnum;
	}
	public String getReceivemgrid() {
		return receivemgrid;
	}
	public void setReceivemgrid(String receivemgrid) {
		this.receivemgrid = receivemgrid;
	}
	public String getCargocount() {
		return cargocount;
	}
	public void setCargocount(String cargocount) {
		this.cargocount = cargocount;
	}
	public String getCountorg() {
		return countorg;
	}
	public void setCountorg(String countorg) {
		this.countorg = countorg;
	}
	public String getCargoweight() {
		return cargoweight;
	}
	public void setCargoweight(String cargoweight) {
		this.cargoweight = cargoweight;
	}
	public String getFunguscount() {
		return funguscount;
	}
	public void setFunguscount(String funguscount) {
		this.funguscount = funguscount;
	}
	public String getReqreagent() {
		return reqreagent;
	}
	public void setReqreagent(String reqreagent) {
		this.reqreagent = reqreagent;
	}
	public String getIrradtype() {
		return irradtype;
	}
	public void setIrradtype(String irradtype) {
		this.irradtype = irradtype;
	}
	public String getIrradtime() {
		return irradtime;
	}
	public void setIrradtime(String irradtime) {
		this.irradtime = irradtime;
	}
	public String getIrradtimeorg() {
		return irradtimeorg;
	}
	public void setIrradtimeorg(String irradtimeorg) {
		this.irradtimeorg = irradtimeorg;
	}
	public String getIrradflag() {
		return irradflag;
	}
	public void setIrradflag(String irradflag) {
		this.irradflag = irradflag;
	}
	public String getCargoid() {
		return cargoid;
	}
	public void setCargoid(String cargoid) {
		this.cargoid = cargoid;
	}
	public String getReceiveorgid() {
		return receiveorgid;
	}
	public void setReceiveorgid(String receiveorgid) {
		this.receiveorgid = receiveorgid;
	}
	public String getReceivepeopleid() {
		return receivepeopleid;
	}
	public void setReceivepeopleid(String receivepeopleid) {
		this.receivepeopleid = receivepeopleid;
	}
	@Override
	public String toString() {
		return "ReceiveInfo [id=" + id + ", receivetime=" + receivetime
				+ ", receiveorgid=" + receiveorgid + ", receivepeopleid="
				+ receivepeopleid + ", telnum=" + telnum + ", receivemgrid="
				+ receivemgrid + ", cargoid=" + cargoid + ", cargocount="
				+ cargocount + ", countorg=" + countorg + ", cargoweight="
				+ cargoweight + ", funguscount=" + funguscount
				+ ", reqreagent=" + reqreagent + ", irradtype=" + irradtype
				+ ", irradtime=" + irradtime + ", irradtimeorg=" + irradtimeorg
				+ ", irradflag=" + irradflag + ", asCurrentRecord="
				+ asCurrentRecord + ", getAsCurrentRecord()="
				+ getAsCurrentRecord() + ", getId()=" + getId()
				+ ", getReceivetime()=" + getReceivetime() + ", getTelnum()="
				+ getTelnum() + ", getReceivemgrid()=" + getReceivemgrid()
				+ ", getCargocount()=" + getCargocount() + ", getCountorg()="
				+ getCountorg() + ", getCargoweight()=" + getCargoweight()
				+ ", getFunguscount()=" + getFunguscount()
				+ ", getReqreagent()=" + getReqreagent() + ", getIrradtype()="
				+ getIrradtype() + ", getIrradtime()=" + getIrradtime()
				+ ", getIrradtimeorg()=" + getIrradtimeorg()
				+ ", getIrradflag()=" + getIrradflag() + ", getCargoid()="
				+ getCargoid() + ", getReceiveorgid()=" + getReceiveorgid()
				+ ", getReceivepeopleid()=" + getReceivepeopleid()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}
