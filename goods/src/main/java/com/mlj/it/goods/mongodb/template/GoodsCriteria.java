package com.mlj.it.goods.mongodb.template;

import com.mlj.it.goods.mongodb.document.Goods;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author wym
 */
public class GoodsCriteria {

    protected List<Criteria> oredCriteria;

    /**
     "_id" : ObjectId("5ebe6871e5cf832ee0fb44d3"),
     "goods_sn" : "343453535",
     "name" : "yym",
     "price" : NumberInt(150),
     "is_del" : NumberInt(1),
     "category_list" : [
     {
     "categoryName" : "tianshi",
     "level" : NumberInt(1)
     },
     {
     "categoryName" : "mogui",
     "level" : NumberInt(2)
     }
     ],
     "imgs" : [
     "4545.com",
     "4545.com"
     ],
     */
    public GoodsCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void clear() {
        oredCriteria.clear();
    }


    // _id
    public GoodsCriteria andIdEqualTo(ObjectId value) {
        if (value == null) {
            throw new RuntimeException("Value for condition cannot be null");
        }
        oredCriteria.add(Criteria.where("_id").is(value));

        return this;
    }

    public GoodsCriteria andIdNotEqualTo(ObjectId value) {
        if (value == null) {
            throw new RuntimeException("Value for condition cannot be null");
        }
        oredCriteria.add(Criteria.where("_id").ne(value));

        return this;
    }

    public GoodsCriteria andIdGreaterThan(ObjectId value) {
        if (value == null) {
            throw new RuntimeException("Value for condition cannot be null");
        }
        oredCriteria.add(Criteria.where("_id").gt(value));

        return this;
    }

    public GoodsCriteria andIdGreaterThanOrEqualTo(ObjectId value) {
        if (value == null) {
            throw new RuntimeException("Value for condition cannot be null");
        }
        oredCriteria.add(Criteria.where("_id").gte(value));

        return this;
    }

    public GoodsCriteria andIdLessThan(ObjectId value) {
        if (value == null) {
            throw new RuntimeException("Value for condition cannot be null");
        }
        oredCriteria.add(Criteria.where("_id").lt(value));

        return this;
    }

    public GoodsCriteria andIdLessThanOrEqualTo(ObjectId value) {
        if (value == null) {
            throw new RuntimeException("Value for condition cannot be null");
        }
        oredCriteria.add(Criteria.where("_id").lte(value));

        return this;
    }

    public GoodsCriteria andIdIn(List<ObjectId> values) {
        if (values == null) {
            throw new RuntimeException("Values for condition cannot be null");
        }
        oredCriteria.add(Criteria.where("_id").in(values));

        return this;
    }

    public GoodsCriteria andIdNotIn(List<ObjectId> values) {
        if (values == null) {
            throw new RuntimeException("Values for condition cannot be null");
        }
        oredCriteria.add(Criteria.where("_id").nin(values));

        return this;
    }


    //name
    public GoodsCriteria andNameEqualTo(String value) {
        if (value == null) {
            throw new RuntimeException("Value for condition cannot be null");
        }
        oredCriteria.add(Criteria.where("name").is(value));

        return this;
    }

    public GoodsCriteria andNameNotEqualTo(String value) {
        if (value == null) {
            throw new RuntimeException("Value for condition cannot be null");
        }
        oredCriteria.add(Criteria.where("name").ne(value));

        return this;
    }

    public GoodsCriteria andNameLike(String value) {
        if (value == null) {
            throw new RuntimeException("Value for condition cannot be null");
        }
        Pattern pattern= Pattern.compile("^.*"+value+".*$", Pattern.CASE_INSENSITIVE);

        oredCriteria.add(Criteria.where("name").regex(pattern));
        return this;
    }



    public GoodsCriteria andNameIn(List<String> values) {
        if (values == null) {
            throw new RuntimeException("Values for condition cannot be null");
        }
        oredCriteria.add(Criteria.where("name").in(values));

        return this;
    }

    public GoodsCriteria andNameNotIn(List<String> values) {
        if (values == null) {
            throw new RuntimeException("Values for condition cannot be null");
        }
        oredCriteria.add(Criteria.where("name").nin(values));

        return this;
    }

    //good_sn
    public GoodsCriteria andGoodSnEqualTo(String value) {
        if (value == null) {
            throw new RuntimeException("Value for condition cannot be null");
        }
        oredCriteria.add(Criteria.where("goods_sn").is(value));

        return this;
    }

    //imgs
    public GoodsCriteria andImgEqualTo(String value) {
        if (value == null) {
            throw new RuntimeException("Value for condition cannot be null");
        }
        oredCriteria.add(Criteria.where("imgs").is(value));

        return this;
    }
}
