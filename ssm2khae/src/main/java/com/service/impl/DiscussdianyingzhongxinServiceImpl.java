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


import com.dao.DiscussdianyingzhongxinDao;
import com.entity.DiscussdianyingzhongxinEntity;
import com.service.DiscussdianyingzhongxinService;
import com.entity.vo.DiscussdianyingzhongxinVO;
import com.entity.view.DiscussdianyingzhongxinView;

@Service("discussdianyingzhongxinService")
public class DiscussdianyingzhongxinServiceImpl extends ServiceImpl<DiscussdianyingzhongxinDao, DiscussdianyingzhongxinEntity> implements DiscussdianyingzhongxinService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussdianyingzhongxinEntity> page = this.selectPage(
                new Query<DiscussdianyingzhongxinEntity>(params).getPage(),
                new EntityWrapper<DiscussdianyingzhongxinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussdianyingzhongxinEntity> wrapper) {
		  Page<DiscussdianyingzhongxinView> page =new Query<DiscussdianyingzhongxinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussdianyingzhongxinVO> selectListVO(Wrapper<DiscussdianyingzhongxinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussdianyingzhongxinVO selectVO(Wrapper<DiscussdianyingzhongxinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussdianyingzhongxinView> selectListView(Wrapper<DiscussdianyingzhongxinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussdianyingzhongxinView selectView(Wrapper<DiscussdianyingzhongxinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
