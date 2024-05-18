package admin;
import java.lang.*;
class Adminuser {
   private String username;
    private String password;
 
     private String email;
    public Adminuser(String username, String password,String email) {

        this.username = username;
        this.password = password;
        this.email= email;
    
    }

   

    public String getUsername() {
        return username;
    }

    public String getPass() {
        return password;
    }

    public String getEmail()
    {
        return email;
    }   
	
}