/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notesapp;
import com.evernote.auth.EvernoteService;
import com.evernote.auth.EvernoteAuth;
import com.evernote.clients.*;
import com.evernote.edam.notestore.NoteFilter;
import com.evernote.edam.notestore.NoteList;
import java.util.ArrayList;
import java.util.List;

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
        note.setTitle(currentNote.getTitle());
        note.setContent(createContent(currentNote.get()));
        
       com.evernote.edam.type.Note new_note = this.noteStore.createNote(note);
       currentNote.set_guid( new_note.getGuid() );
    }
    
    
    public void UpdateNote( Note currentNote ) throws Exception {
        com.evernote.edam.type.Note note = this.noteStore.getNote(currentNote.get_guid(), true, false, false, false);
        note.setTitle(currentNote.getTitle());
        note.setContent(createContent( currentNote.get() ));
        this.noteStore.updateNote(note);
    }
    
    public  List<Note> GetNotes() throws Exception{
        List<Note> finalList = new ArrayList<>();
        
        NoteList noteList = this.noteStore.findNotes(new NoteFilter(), 0, 100);
        for(com.evernote.edam.type.Note note:noteList.getNotes()){
            com.evernote.edam.type.Note notes = this.noteStore.getNote(note.getGuid(), true, false, false, false);
            String message = this.getContent(notes.getContent());
            String title = notes.getTitle();
            
            
            finalList.add( new Note(message,title,note.getGuid())  );
        }
        
        return finalList;
        
    }
    
    public void DeleteNote(String guid) throws Exception{
        this.noteStore.deleteNote(guid);
        
    }
    
    private String createContent( String content  ){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                +"<!DOCTYPE en-note SYSTEM \"http://xml.evernote.com/pub/enml2.dtd\">"
                +"<en-note>"
                +"<p>"+ content + "</p>"
                +"</en-note>";
        
    }
    
    private String getContent(String xml){
        int p1 =xml.indexOf("<p>") + "<p>".length();
        int p2 =xml.indexOf("</p>");
        return xml.substring(p1,p2);
    }
   
    
}
