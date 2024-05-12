package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussdianyingzhongxinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussdianyingzhongxinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussdianyingzhongxinView;


/**
 * 电影中心评论表
 *
 * @author 
 * @email 
 * @date 2022-05-02 17:10:35
 */
public interface DiscussdianyingzhongxinService extends IService<DiscussdianyingzhongxinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussdianyingzhongxinVO> selectListVO(Wrapper<DiscussdianyingzhongxinEntity> wrapper);
   	
   	DiscussdianyingzhongxinVO selectVO(@Param("ew") Wrapper<DiscussdianyingzhongxinEntity> wrapper);
   	
   	List<DiscussdianyingzhongxinView> selectListView(Wrapper<DiscussdianyingzhongxinEntity> wrapper);
   	
   	DiscussdianyingzhongxinView selectView(@Param("ew") Wrapper<DiscussdianyingzhongxinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussdianyingzhongxinEntity> wrapper);
   	

}

