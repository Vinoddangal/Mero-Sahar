package entity;

import entity.ArticalTbl;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-01T00:38:44")
@StaticMetamodel(UserTbl.class)
public class UserTbl_ { 

    public static volatile SingularAttribute<UserTbl, String> firstname;
    public static volatile SingularAttribute<UserTbl, String> password;
    public static volatile CollectionAttribute<UserTbl, ArticalTbl> articalTblCollection;
    public static volatile SingularAttribute<UserTbl, Integer> locationid;
    public static volatile SingularAttribute<UserTbl, Long> contact;
    public static volatile SingularAttribute<UserTbl, Integer> id;
    public static volatile SingularAttribute<UserTbl, String> email;
    public static volatile SingularAttribute<UserTbl, String> lastname;

}