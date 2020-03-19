import com.example.lostc.User;

//Write and Read Class
public class WR_File {

    public boolean writeCurrentUser(){

        //Write to local file .../currentUser.csv

        return true; //Rückgabe ob schreiben erfolgreich war.
    }

    public User readCurrentUser(){

        //Read from local file .../currentUser.csv

        User test = new User("Max_Mustermann");
        return test;
    }


}
