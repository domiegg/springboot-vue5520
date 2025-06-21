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


import com.dao.ShenpiyuanDao;
import com.entity.ShenpiyuanEntity;
import com.service.ShenpiyuanService;
import com.entity.vo.ShenpiyuanVO;
import com.entity.view.ShenpiyuanView;

@Service("shenpiyuanService")
public class ShenpiyuanServiceImpl extends ServiceImpl<ShenpiyuanDao, ShenpiyuanEntity> implements ShenpiyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShenpiyuanEntity> page = this.selectPage(
                new Query<ShenpiyuanEntity>(params).getPage(),
                new EntityWrapper<ShenpiyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShenpiyuanEntity> wrapper) {
		  Page<ShenpiyuanView> page =new Query<ShenpiyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShenpiyuanVO> selectListVO(Wrapper<ShenpiyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShenpiyuanVO selectVO(Wrapper<ShenpiyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShenpiyuanView> selectListView(Wrapper<ShenpiyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShenpiyuanView selectView(Wrapper<ShenpiyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
