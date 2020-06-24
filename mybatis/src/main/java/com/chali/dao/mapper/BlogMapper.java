package com.chali.dao.mapper;

import com.chali.entity.Blog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author chali
 * @desc BlogMapper
 * @date 2020-06-18-4:52 下午
 */
@Mapper
public interface BlogMapper {

    Blog selectBlog(Long id);
}
