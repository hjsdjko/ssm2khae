package com.dao;

import com.entity.DianyingzhongxinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DianyingzhongxinVO;
import com.entity.view.DianyingzhongxinView;


/**
 * 电影中心
 * 
 * @author 
 * @email 
 * @date 2022-05-02 17:10:35
 */
public interface DianyingzhongxinDao extends BaseMapper<DianyingzhongxinEntity> {
	
	List<DianyingzhongxinVO> selectListVO(@Param("ew") Wrapper<DianyingzhongxinEntity> wrapper);
	
	DianyingzhongxinVO selectVO(@Param("ew") Wrapper<DianyingzhongxinEntity> wrapper);
	
	List<DianyingzhongxinView> selectListView(@Param("ew") Wrapper<DianyingzhongxinEntity> wrapper);

	List<DianyingzhongxinView> selectListView(Pagination page,@Param("ew") Wrapper<DianyingzhongxinEntity> wrapper);
	
	DianyingzhongxinView selectView(@Param("ew") Wrapper<DianyingzhongxinEntity> wrapper);
	

}
