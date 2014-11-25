package login;

import datalayer.UserDB;

public class Login {

    public static void main(String[] args) {
        
        System.out.println(UserDB.getUserFromDB("cons@stud.kea.dk", "534b44a19bf18d20b71ecc4eb77c572f"));
    }
    
}
