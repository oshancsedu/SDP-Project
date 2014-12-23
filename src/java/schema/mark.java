/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package schema;

/**
 *
 * @author tonmoy
 */
public class mark implements observer{
    float m;
    
    public float get_mark()
    {
        return m;
    }
    public void set_mark(float m)
    {
        this.m=m;
    }

   
    public void update_result(float g) {
        
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
