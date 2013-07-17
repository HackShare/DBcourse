import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: complexityclass
 * Date: 7/14/13
 * Time: 12:19 AM
 * To change this template use File | Settings | File Templates.
 */
public class Console {

    private PhoneBase base;

    Console() {

        base = new PhoneBase();

    }

    public void start() {

        System.out.println("Welcome to my lightweight database!");

        Scanner sc = new Scanner(System.in);
        String command = "";

        while (!command.equals("exit")) {

            command = sc.next();

            switch (command) {
                case "create":
                    String idc = sc.next();
                    String namec = sc.next();
                    String phonec = sc.next();
                    base.create(idc, namec, phonec);
                    System.out.println("added!");
                    break;
                case "read":
                    String idr = sc.next();
                    base.read(idr);
                    break;
                case "update":
                    String idu = sc.next();
                    String nameu = sc.next();
                    String phoneu = sc.next();
                    System.out.println("updated");
                    base.update(idu, nameu, phoneu);
                    break;
                case "delete":
                    String idd = sc.next();
                    base.delete(idd);
                    System.out.println("deleted");
                    break;
                case "print":
                    base.printBase();
                    break;

            }

        }

        System.out.println("closed");

    }


    public static void main(String[] args) {


        Console console = new Console();
        console.start();

    }


}
