package entity;

import entity.ArticalTbl;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-01T00:38:44")
@StaticMetamodel(LocationTabl.class)
public class LocationTabl_ { 

    public static volatile CollectionAttribute<LocationTabl, ArticalTbl> articalTblCollection;
    public static volatile SingularAttribute<LocationTabl, String> city;
    public static volatile SingularAttribute<LocationTabl, String> street;
    public static volatile SingularAttribute<LocationTabl, String> district;
    public static volatile SingularAttribute<LocationTabl, Integer> id;
    public static volatile SingularAttribute<LocationTabl, Integer> state;

}