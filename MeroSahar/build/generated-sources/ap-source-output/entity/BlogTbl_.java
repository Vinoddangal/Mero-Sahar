package entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-01T00:38:44")
@StaticMetamodel(BlogTbl.class)
public class BlogTbl_ { 

    public static volatile SingularAttribute<BlogTbl, Date> date;
    public static volatile SingularAttribute<BlogTbl, String> heading;
    public static volatile SingularAttribute<BlogTbl, Integer> locationid;
    public static volatile SingularAttribute<BlogTbl, String> photo;
    public static volatile SingularAttribute<BlogTbl, Integer> id;
    public static volatile SingularAttribute<BlogTbl, String> tag;
    public static volatile SingularAttribute<BlogTbl, Integer> userid;
    public static volatile SingularAttribute<BlogTbl, String> content;
    public static volatile SingularAttribute<BlogTbl, Integer> expenses;

}