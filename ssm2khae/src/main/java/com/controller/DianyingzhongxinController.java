package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DianyingzhongxinEntity;
import com.entity.view.DianyingzhongxinView;

import com.service.DianyingzhongxinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 电影中心
 * 后端接口
 * @author 
 * @email 
 * @date 2022-05-02 17:10:35
 */
@RestController
@RequestMapping("/dianyingzhongxin")
public class DianyingzhongxinController {
    @Autowired
    private DianyingzhongxinService dianyingzhongxinService;


    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DianyingzhongxinEntity dianyingzhongxin, 
		HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		dianyingzhongxin.setUserid((Long)request.getSession().getAttribute("userId"));
    	}

        EntityWrapper<DianyingzhongxinEntity> ew = new EntityWrapper<DianyingzhongxinEntity>();
		PageUtils page = dianyingzhongxinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dianyingzhongxin), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DianyingzhongxinEntity dianyingzhongxin, 
		HttpServletRequest request){
        EntityWrapper<DianyingzhongxinEntity> ew = new EntityWrapper<DianyingzhongxinEntity>();
		PageUtils page = dianyingzhongxinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dianyingzhongxin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DianyingzhongxinEntity dianyingzhongxin){
       	EntityWrapper<DianyingzhongxinEntity> ew = new EntityWrapper<DianyingzhongxinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( dianyingzhongxin, "dianyingzhongxin")); 
        return R.ok().put("data", dianyingzhongxinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DianyingzhongxinEntity dianyingzhongxin){
        EntityWrapper< DianyingzhongxinEntity> ew = new EntityWrapper< DianyingzhongxinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( dianyingzhongxin, "dianyingzhongxin")); 
		DianyingzhongxinView dianyingzhongxinView =  dianyingzhongxinService.selectView(ew);
		return R.ok("查询电影中心成功").put("data", dianyingzhongxinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DianyingzhongxinEntity dianyingzhongxin = dianyingzhongxinService.selectById(id);
		dianyingzhongxin.setClicknum(dianyingzhongxin.getClicknum()+1);
		dianyingzhongxin.setClicktime(new Date());
		dianyingzhongxinService.updateById(dianyingzhongxin);
        return R.ok().put("data", dianyingzhongxin);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DianyingzhongxinEntity dianyingzhongxin = dianyingzhongxinService.selectById(id);
		dianyingzhongxin.setClicknum(dianyingzhongxin.getClicknum()+1);
		dianyingzhongxin.setClicktime(new Date());
		dianyingzhongxinService.updateById(dianyingzhongxin);
        return R.ok().put("data", dianyingzhongxin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DianyingzhongxinEntity dianyingzhongxin, HttpServletRequest request){
    	dianyingzhongxin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dianyingzhongxin);
    	dianyingzhongxin.setUserid((Long)request.getSession().getAttribute("userId"));

        dianyingzhongxinService.insert(dianyingzhongxin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DianyingzhongxinEntity dianyingzhongxin, HttpServletRequest request){
    	dianyingzhongxin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dianyingzhongxin);

        dianyingzhongxinService.insert(dianyingzhongxin);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DianyingzhongxinEntity dianyingzhongxin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dianyingzhongxin);
        dianyingzhongxinService.updateById(dianyingzhongxin);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        dianyingzhongxinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<DianyingzhongxinEntity> wrapper = new EntityWrapper<DianyingzhongxinEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}
		if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		wrapper.eq("userid", (Long)request.getSession().getAttribute("userId"));
    	}


		int count = dianyingzhongxinService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DianyingzhongxinEntity dianyingzhongxin, HttpServletRequest request,String pre){
        EntityWrapper<DianyingzhongxinEntity> ew = new EntityWrapper<DianyingzhongxinEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        
        params.put("order", "desc");
		PageUtils page = dianyingzhongxinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dianyingzhongxin), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（按收藏推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,DianyingzhongxinEntity dianyingzhongxin, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "dianyingleixing";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "dianyingzhongxin").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<DianyingzhongxinEntity> dianyingzhongxinList = new ArrayList<DianyingzhongxinEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                dianyingzhongxinList.addAll(dianyingzhongxinService.selectList(new EntityWrapper<DianyingzhongxinEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<DianyingzhongxinEntity> ew = new EntityWrapper<DianyingzhongxinEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = dianyingzhongxinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dianyingzhongxin), params), params));
        List<DianyingzhongxinEntity> pageList = (List<DianyingzhongxinEntity>)page.getList();
        if(dianyingzhongxinList.size()<limit) {
            int toAddNum = (limit-dianyingzhongxinList.size())<=pageList.size()?(limit-dianyingzhongxinList.size()):pageList.size();
            for(DianyingzhongxinEntity o1 : pageList) {
                boolean addFlag = true;
                for(DianyingzhongxinEntity o2 : dianyingzhongxinList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    dianyingzhongxinList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(dianyingzhongxinList.size()>limit) {
            dianyingzhongxinList = dianyingzhongxinList.subList(0, limit);
        }
        page.setList(dianyingzhongxinList);
        return R.ok().put("data", page);
    }





}
