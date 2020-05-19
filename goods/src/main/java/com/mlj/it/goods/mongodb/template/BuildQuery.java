package com.mlj.it.goods.mongodb.template;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * 构建query
 * @author wym
 */
@Slf4j
public class BuildQuery {

    /**
     * 获取query
     * @param criteriaList
     * @return
     */
    public static Query getQuery(List<Criteria> ... criteriaList){
        List<Criteria>[] criteriaList1 = criteriaList;
        Query query = null;
        if(criteriaList1.length > 1){
            Criteria or = or(criteriaList1);
            query = buildQuery(or);
        }else if(!criteriaList1[0].isEmpty()){
            Criteria and = and(criteriaList1[0]);
            query = buildQuery(and);
        }
        if (query == null){
            query = new Query();
        }
        return query;
    }

    /**
     * 获取query,分页
     * @param page
     * @param size
     * @param query
     * @return
     */
    public static Query setPage(Query query, int page,int size){
        if (query == null){
            query = new Query();
        }
        Pageable pageRequest = PageRequest.of(page, size);
        return query.with(pageRequest);
    }

    /**
     * 获取query,排序
     * @param query
     * @param order
     * @param sort
     * @return
     */
    public static Query setSort(Query query, Sort.Direction order, String sort){
        if (query == null){
            query = new Query();
        }
        Sort by = Sort.by(order, sort);
        return query.with(by);
    }

    /**
     * 获取query,分页 排序
     * @param page
     * @param size
     * @param sort
     * @param order
     * @param query
     * @return
     */
    public static Query setPageAndOrder(Query query, int page, int size, Sort.Direction order, String sort){
        if (query == null){
            query = new Query();
        }
        Sort by = Sort.by(order, sort);
        return query.with(by);
    }

    /**
     * build查询语句
     * @param criteria
     * @return
     */
    private static Query buildQuery(Criteria criteria){
        if(criteria == null ){
            return null;
        }
        Query query = new Query();
        Query queryRes = query.addCriteria(criteria);
        return queryRes;
    }

    /**
     * 生成mongodb 与查询子句
     * @param criteriaList
     * @return
     */
    private static Criteria and(List<Criteria> criteriaList){
        if (criteriaList == null){
            return null;
        }

        Criteria criteria[]  = new Criteria[]{};
        Criteria[] criteria1 = criteriaList.toArray(criteria);

        Criteria res = new Criteria().andOperator(criteria1);
        return res;
    }

    /**
     * 生成mongodb 或查询子句
     * @param criteriaList
     * @return
     */
    private static Criteria or(List<Criteria>[] criteriaList){
        List<Criteria> criteriaArray = new ArrayList<>();
        for (List<Criteria> criteriaListItem: criteriaList) {
            criteriaArray.add(and(criteriaListItem));
        }
        Criteria criteria[]  = new Criteria[]{};
        Criteria[] criteria1 = criteriaArray.toArray(criteria);


        Criteria orOperator = new Criteria().orOperator(criteria1);
        return orOperator;
    }

}
