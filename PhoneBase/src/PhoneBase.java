import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: complexityclass
 * Date: 7/13/13
 * Time: 11:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class PhoneBase {


    class Note {

        private String id;
        private String name;
        private String phonenumber;

        Note(String id, String name, String phonenumber) {
            this.id = id;
            this.name = name;
            this.phonenumber = phonenumber;
        }

        String getPhonenumber() {
            return phonenumber;
        }

        void setPhonenumber(String phonenumber) {
            this.phonenumber = phonenumber;
        }

        String getName() {

            return name;
        }

        void setName(String name) {
            this.name = name;
        }

        String getId() {

            return id;
        }

        void setId(String id) {
            this.id = id;
        }
    }


    private List<Note> phoneBase;


    public PhoneBase() {

        phoneBase = new ArrayList<Note>();

    }

    public void create(String id, String name, String phonenumber) {
        phoneBase.add(new Note(id, name, phonenumber));
    }

    public String read(String id) {
        String result = "not find";
        for (Note note : phoneBase) {
            if (note.getId().equals(id)) {
                result = note.getName() + " " + note.getPhonenumber();
                break;
            }
        }

        return result;
    }

    public void update(String id, String name, String phonenumber) {
        for (Note note : phoneBase) {
            if (note.getId().equals(id)) {
                note.setName(name);
                note.setPhonenumber(phonenumber);
            }
        }
    }

    public void delete(String id) {

        for (Iterator<Note> it = phoneBase.iterator(); it.hasNext(); ) {

            Note note = it.next();
            if (note.getId().equals(id)) {
                it.remove();
            }

        }

    }

    public void printBase(){

        System.out.println("Phone base");

        for(Note note : phoneBase){

              System.out.printf("\n%-20.20s %10s %10s",note.getId(),note.getName(),note.getPhonenumber());

        }

    }

}




































