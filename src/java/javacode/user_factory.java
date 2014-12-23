package javacode;

/**
 *
 * @author Oshan
 */
public class user_factory {
    
    public user setUser(String u){
        if(u.equalsIgnoreCase("admin"))
            return new adminUser();
        else if(u.equalsIgnoreCase("student"))
            return new studentUser();
        else if(u.equalsIgnoreCase("teacher"))
            return new teacherUser();
        else
        return null;
    }
    
}
