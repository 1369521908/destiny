package com.gz.destinylegends.controller.base;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gz.destinylegends.util.api.ApiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 预处理
 * @Author by xueqichang
 * @Email 1369521908@qq.com
 * @Date 2019/9/28 11:51
 */
public class BaseController<M extends BaseMapper<T>, T> {

    protected Map<String, Object> getDataTable(IPage<?> pageInfo) {
        Map<String, Object> rspData = new HashMap<>(2);
        rspData.put("rows", pageInfo.getRecords());
        rspData.put("total", pageInfo.getTotal());
        return rspData;
    }

    @Autowired
    private M baseMapper;

    @GetMapping("/{id}")
    public Object get(@PathVariable(value = "id") Integer id) {
        T entity = baseMapper.selectById(id);
        if (null != entity) {
            return ApiUtil.success(entity);
        } else {
            return ApiUtil.notSearch();
        }
    }

    @GetMapping
    public Object page(T entity,
                       @RequestParam(value = "size", defaultValue = "10") Integer size,
                       @RequestParam(value = "current", defaultValue = "1") Integer current) {
        QueryWrapper<T> wrapper = new QueryWrapper<>(entity);
        Page<T> page = new Page<>(current, size);
        return ApiUtil.success(baseMapper.selectPage(page, wrapper));
    }

    @GetMapping("/list")
    public Object list(T entity) {
        QueryWrapper<T> wrapper = new QueryWrapper<>(entity);
        return ApiUtil.success(baseMapper.selectList(wrapper));
    }


    @PostMapping("/save")
    public Object save(@Valid T entity) {
        baseMapper.insert(entity);
        return ApiUtil.success(entity);
    }

    @PutMapping("/update")
    public Object update(@Valid T entity) {
        baseMapper.updateById(entity);
        return ApiUtil.success(entity);
    }


    @DeleteMapping("/{id}")
    public Object delete(@PathVariable(value = "id") Integer id) {
        int i = baseMapper.deleteById(id);
        return ApiUtil.success();
    }

}
