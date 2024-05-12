package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DianyingzhongxinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DianyingzhongxinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DianyingzhongxinView;


/**
 * 电影中心
 *
 * @author 
 * @email 
 * @date 2022-05-02 17:10:35
 */
public interface DianyingzhongxinService extends IService<DianyingzhongxinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DianyingzhongxinVO> selectListVO(Wrapper<DianyingzhongxinEntity> wrapper);
   	
   	DianyingzhongxinVO selectVO(@Param("ew") Wrapper<DianyingzhongxinEntity> wrapper);
   	
   	List<DianyingzhongxinView> selectListView(Wrapper<DianyingzhongxinEntity> wrapper);
   	
   	DianyingzhongxinView selectView(@Param("ew") Wrapper<DianyingzhongxinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DianyingzhongxinEntity> wrapper);
   	

}

