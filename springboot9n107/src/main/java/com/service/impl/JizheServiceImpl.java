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


import com.dao.JizheDao;
import com.entity.JizheEntity;
import com.service.JizheService;
import com.entity.vo.JizheVO;
import com.entity.view.JizheView;

@Service("jizheService")
public class JizheServiceImpl extends ServiceImpl<JizheDao, JizheEntity> implements JizheService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JizheEntity> page = this.selectPage(
                new Query<JizheEntity>(params).getPage(),
                new EntityWrapper<JizheEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JizheEntity> wrapper) {
		  Page<JizheView> page =new Query<JizheView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JizheVO> selectListVO(Wrapper<JizheEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JizheVO selectVO(Wrapper<JizheEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JizheView> selectListView(Wrapper<JizheEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JizheView selectView(Wrapper<JizheEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
