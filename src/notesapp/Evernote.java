/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notesapp;
import com.evernote.auth.EvernoteService;
import com.evernote.auth.EvernoteAuth;
import com.evernote.clients.*;

/**
 *
 * @author AGV
 */
public class Evernote {
    
    
    public Evernote(String token)  throws Exception {
        
        EvernoteAuth evernoteAuth = new EvernoteAuth( EvernoteService.SANDBOX, token);
        ClientFactory factory = new ClientFactory(evernoteAuth);
        UserStoreClient user = factory.createUserStoreClient();
        
        boolean version_r = user.checkVersion("Evernote EDAMDemo (Java)",
                com.evernote.edam.userstore.Constants.EDAM_VERSION_MAJOR, 
                com.evernote.edam.userstore.Constants.EDAM_VERSION_MINOR);
        
        
        
       if(!version_r)
       {
           System.err.println("No es posible establecer una conexion");
           System.exit(1);
       }
        System.out.println("Conexion Exitosa");
        
    }
    
}
