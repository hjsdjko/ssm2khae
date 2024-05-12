package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DianyingzhongxinDao;
import com.entity.DianyingzhongxinEntity;
import com.service.DianyingzhongxinService;
import com.entity.vo.DianyingzhongxinVO;
import com.entity.view.DianyingzhongxinView;

@Service("dianyingzhongxinService")
public class DianyingzhongxinServiceImpl extends ServiceImpl<DianyingzhongxinDao, DianyingzhongxinEntity> implements DianyingzhongxinService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DianyingzhongxinEntity> page = this.selectPage(
                new Query<DianyingzhongxinEntity>(params).getPage(),
                new EntityWrapper<DianyingzhongxinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DianyingzhongxinEntity> wrapper) {
		  Page<DianyingzhongxinView> page =new Query<DianyingzhongxinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DianyingzhongxinVO> selectListVO(Wrapper<DianyingzhongxinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DianyingzhongxinVO selectVO(Wrapper<DianyingzhongxinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DianyingzhongxinView> selectListView(Wrapper<DianyingzhongxinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DianyingzhongxinView selectView(Wrapper<DianyingzhongxinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
