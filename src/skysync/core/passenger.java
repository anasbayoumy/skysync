package skysync.core;

public class passenger {

    private int id; //incremented++ in db
    private String Fname;
    private String Lname;
    private String email;
    private String phone;
    
    public passenger(){}
    
//=======================   
public int getId(){
    return id;
}
public void setId(int id){
    this.id = id;
}
//=======================
public String getFname(){
    return Fname;
}
public void setFname(String Fname){
    this.Fname = Fname;
}
//=======================   
public String getLname(){
    return Lname;
}
public void setLname(String Lname){
    this.Lname = Lname;
}
//=======================  
public String getEmail(){
    return email;
}
public void setEmail(String email){
    this.email = email;
}
//=======================  
public String getPhone(){
    return phone;
}
public void setPhone(String phone){
    this.phone = phone;
}
//=======================  
    
}

