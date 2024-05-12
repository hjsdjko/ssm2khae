package com.entity.vo;

import com.entity.DianyingzhongxinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 电影中心
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-05-02 17:10:35
 */
public class DianyingzhongxinVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 海报
	 */
	
	private String haibao;
		
	/**
	 * 电影类型
	 */
	
	private String dianyingleixing;
		
	/**
	 * 导演
	 */
	
	private String daoyan;
		
	/**
	 * 主演
	 */
	
	private String zhuyan;
		
	/**
	 * 时长
	 */
	
	private String shizhang;
		
	/**
	 * 上映日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date shangyingriqi;
		
	/**
	 * 制片地区
	 */
	
	private String zhipiandiqu;
		
	/**
	 * 电影简介
	 */
	
	private String dianyingjianjie;
		
	/**
	 * 评分
	 */
	
	private Float pingfen;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * 点击次数
	 */
	
	private Integer clicknum;
		
	/**
	 * 用户id
	 */
	
	private Long userid;
				
	
	/**
	 * 设置：海报
	 */
	 
	public void setHaibao(String haibao) {
		this.haibao = haibao;
	}
	
	/**
	 * 获取：海报
	 */
	public String getHaibao() {
		return haibao;
	}
				
	
	/**
	 * 设置：电影类型
	 */
	 
	public void setDianyingleixing(String dianyingleixing) {
		this.dianyingleixing = dianyingleixing;
	}
	
	/**
	 * 获取：电影类型
	 */
	public String getDianyingleixing() {
		return dianyingleixing;
	}
				
	
	/**
	 * 设置：导演
	 */
	 
	public void setDaoyan(String daoyan) {
		this.daoyan = daoyan;
	}
	
	/**
	 * 获取：导演
	 */
	public String getDaoyan() {
		return daoyan;
	}
				
	
	/**
	 * 设置：主演
	 */
	 
	public void setZhuyan(String zhuyan) {
		this.zhuyan = zhuyan;
	}
	
	/**
	 * 获取：主演
	 */
	public String getZhuyan() {
		return zhuyan;
	}
				
	
	/**
	 * 设置：时长
	 */
	 
	public void setShizhang(String shizhang) {
		this.shizhang = shizhang;
	}
	
	/**
	 * 获取：时长
	 */
	public String getShizhang() {
		return shizhang;
	}
				
	
	/**
	 * 设置：上映日期
	 */
	 
	public void setShangyingriqi(Date shangyingriqi) {
		this.shangyingriqi = shangyingriqi;
	}
	
	/**
	 * 获取：上映日期
	 */
	public Date getShangyingriqi() {
		return shangyingriqi;
	}
				
	
	/**
	 * 设置：制片地区
	 */
	 
	public void setZhipiandiqu(String zhipiandiqu) {
		this.zhipiandiqu = zhipiandiqu;
	}
	
	/**
	 * 获取：制片地区
	 */
	public String getZhipiandiqu() {
		return zhipiandiqu;
	}
				
	
	/**
	 * 设置：电影简介
	 */
	 
	public void setDianyingjianjie(String dianyingjianjie) {
		this.dianyingjianjie = dianyingjianjie;
	}
	
	/**
	 * 获取：电影简介
	 */
	public String getDianyingjianjie() {
		return dianyingjianjie;
	}
				
	
	/**
	 * 设置：评分
	 */
	 
	public void setPingfen(Float pingfen) {
		this.pingfen = pingfen;
	}
	
	/**
	 * 获取：评分
	 */
	public Float getPingfen() {
		return pingfen;
	}
				
	
	/**
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
				
	
	/**
	 * 设置：点击次数
	 */
	 
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}
				
	
	/**
	 * 设置：用户id
	 */
	 
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
	/**
	 * 获取：用户id
	 */
	public Long getUserid() {
		return userid;
	}
			
}
