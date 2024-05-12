package com.entity.view;

import com.entity.DiscussdianyingzhongxinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 电影中心评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-05-02 17:10:35
 */
@TableName("discussdianyingzhongxin")
public class DiscussdianyingzhongxinView  extends DiscussdianyingzhongxinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussdianyingzhongxinView(){
	}
 
 	public DiscussdianyingzhongxinView(DiscussdianyingzhongxinEntity discussdianyingzhongxinEntity){
 	try {
			BeanUtils.copyProperties(this, discussdianyingzhongxinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
