/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notesapp;
import com.evernote.auth.EvernoteService;
import com.evernote.auth.EvernoteAuth;
import com.evernote.clients.*;
import com.evernote.edam.type.*;

/**
 *
 * @author AGV
 */
public class Evernote {
    
    private NoteStoreClient noteStore;
    
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
        this.noteStore = factory.createNoteStoreClient();
        
    }
    
    
    public void CreateNote(Note currentNote) throws Exception{
        com.evernote.edam.type.Note note = new  com.evernote.edam.type.Note();
        note.setTitle("Nuevo Titulo");
        note.setContent(createContent("Content"));
        
        this.noteStore.createNote(note);
    }
    
    private String createContent( String content  ){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                +"<!DOCTYPE en-note SYSTEM \"http://xml.evernote.com/pub/enml2.dtd\">"
                +"<en-note>"
                +"<p>"+ content + "</p>"
                +"</en-note>";
        
    }
    
}
