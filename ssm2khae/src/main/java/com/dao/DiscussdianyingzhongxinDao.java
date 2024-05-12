package com.dao;

import com.entity.DiscussdianyingzhongxinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussdianyingzhongxinVO;
import com.entity.view.DiscussdianyingzhongxinView;


/**
 * 电影中心评论表
 * 
 * @author 
 * @email 
 * @date 2022-05-02 17:10:35
 */
public interface DiscussdianyingzhongxinDao extends BaseMapper<DiscussdianyingzhongxinEntity> {
	
	List<DiscussdianyingzhongxinVO> selectListVO(@Param("ew") Wrapper<DiscussdianyingzhongxinEntity> wrapper);
	
	DiscussdianyingzhongxinVO selectVO(@Param("ew") Wrapper<DiscussdianyingzhongxinEntity> wrapper);
	
	List<DiscussdianyingzhongxinView> selectListView(@Param("ew") Wrapper<DiscussdianyingzhongxinEntity> wrapper);

	List<DiscussdianyingzhongxinView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussdianyingzhongxinEntity> wrapper);
	
	DiscussdianyingzhongxinView selectView(@Param("ew") Wrapper<DiscussdianyingzhongxinEntity> wrapper);
	

}
