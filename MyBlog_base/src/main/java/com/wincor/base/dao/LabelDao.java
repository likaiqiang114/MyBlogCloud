package com.wincor.base.dao;

import com.wincor.base.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

//继承JpaRepository需要传入两个参数，一个是实体类Label一个是主键的类型String
public interface LabelDao extends JpaRepository<Label,String> , JpaSpecificationExecutor<Label> {
}
