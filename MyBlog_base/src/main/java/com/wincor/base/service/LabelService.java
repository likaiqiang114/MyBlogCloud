package com.wincor.base.service;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Pattern;
import com.wincor.base.dao.LabelDao;
import com.wincor.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LabelService {
    @Autowired
    private LabelDao labelDao ;

    @Autowired
    private IdWorker idWorker;

    public List<Label> findAll(){
        return labelDao.findAll();
    }

    public Label findById(String id){
        return labelDao.findById(id).get();
    }

    //既能做保存又能做更新的labelDao.save
    public void save(Label label){
        label.setId(idWorker.nextId()+"");
        labelDao.save(label);
    }

    public void update(Label label){
        labelDao.save(label);
    }

    public void deleteById(String id){
        labelDao.deleteById(id);
    }

    public List<Label> findSearch(Label label) {
        //下面的没有写Specification接口的实现类，而是用匿名内部类的方法做的
       return  labelDao.findAll(new Specification<Label>(){
            /**
             *
              * @param root  根对象，也就是说把条件封装到哪个对象中。例如：where 列名 = label.getid，这个列名要从根对象去拿
             * @param query 封装的都是查询关键字 如order by,group by等，一般没什么用，如果需要会写到SQL中，和sort没多大区别
             * @param cb 用来封装条件对象的，如果直接返回null，表示不需要任何条件
             * @return
             */

            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //new一个集合，存放所有的条件（每个predicate就是一个条件）
                List<Predicate> list = new ArrayList<>();
                if (label.getLabelname()!= null && !"".equals(label.getLabelname())) {
                    Predicate predicate = cb.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");// where labelname  like "%"小明"%"
                    list.add(predicate);
                }
                if (label.getState()!= null &&!"".equals(label.getState())) {
                    Predicate predicate = cb.equal(root.get("state").as(String.class), label.getState() );// where state  = 1
                    list.add(predicate);
                }
                //new一个数组作为最终返回值的条件
                Predicate[] parr = new Predicate[list.size()];
                //把list直接转成数组
                list.toArray(parr);
                //and中可以放数组,这句相当于where labelname  like "%"小明"%" and state  = 1
                return cb.and(parr);


            }

       });

    }

    public Page<Label> pageQuery(Label label, int page, int size) {
        //封装分页对象
        Pageable pageable = PageRequest.of(page-1,size);//这个框架从0开始，但是页码传过来是以第一页开始，所以有“-1”操作1-1=0
        return labelDao.findAll(new Specification<Label>(){
            /**
             *
             * @param root  根对象，也就是说把条件封装到哪个对象中。例如：where 列名 = label.getid，这个列名要从根对象去拿
             * @param query 封装的都是查询关键字 如order by,group by等，一般没什么用，如果需要会写到SQL中，和sort没多大区别
             * @param cb 用来封装条件对象的，如果直接返回null，表示不需要任何条件
             * @return
             */

            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //new一个集合，存放所有的条件（每个predicate就是一个条件）
                List<Predicate> list = new ArrayList<>();
                if (label.getLabelname()!= null && !"".equals(label.getLabelname())) {
                    Predicate predicate = cb.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");// where labelname  like "%"小明"%"
                    list.add(predicate);
                }
                if (label.getState()!= null &&!"".equals(label.getState())) {
                    Predicate predicate = cb.equal(root.get("state").as(String.class), label.getState() );// where state  = 1
                    list.add(predicate);
                }
                //new一个数组作为最终返回值的条件
                Predicate[] parr = new Predicate[list.size()];
                //把list直接转成数组
                list.toArray(parr);
                //and中可以放数组,这句相当于where labelname  like "%"小明"%" and state  = 1
                return cb.and(parr);


            }

        },pageable);
    }
}
