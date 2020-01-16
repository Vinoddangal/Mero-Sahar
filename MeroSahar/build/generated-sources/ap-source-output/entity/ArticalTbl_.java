package entity;

import entity.LocationTabl;
import entity.UserTbl;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-01T00:38:44")
@StaticMetamodel(ArticalTbl.class)
public class ArticalTbl_ { 

    public static volatile SingularAttribute<ArticalTbl, Date> date;
    public static volatile SingularAttribute<ArticalTbl, String> heading;
    public static volatile SingularAttribute<ArticalTbl, LocationTabl> locationid;
    public static volatile SingularAttribute<ArticalTbl, String> photo;
    public static volatile SingularAttribute<ArticalTbl, Integer> id;
    public static volatile SingularAttribute<ArticalTbl, String> type;
    public static volatile SingularAttribute<ArticalTbl, String> subheading;
    public static volatile SingularAttribute<ArticalTbl, UserTbl> userid;
    public static volatile SingularAttribute<ArticalTbl, String> content;
    public static volatile SingularAttribute<ArticalTbl, String> tags;

}