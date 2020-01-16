package entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-01T00:38:44")
@StaticMetamodel(ReviewTbl.class)
public class ReviewTbl_ { 

    public static volatile SingularAttribute<ReviewTbl, Date> date;
    public static volatile SingularAttribute<ReviewTbl, Integer> articalid;
    public static volatile SingularAttribute<ReviewTbl, String> comment;
    public static volatile SingularAttribute<ReviewTbl, Integer> id;
    public static volatile SingularAttribute<ReviewTbl, Integer> userid;
    public static volatile SingularAttribute<ReviewTbl, Integer> likes;

}