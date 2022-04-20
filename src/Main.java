public class Main {


    public static volatile String commit_message;




    public static void main (String[] args) {

        new guiWindow().show();
    }

    public static void finish () throws Exception {


        Runtime.getRuntime().exec("git add --all");
        System.out.println("Added all files to git");


        Runtime.getRuntime().exec("git commit -m \"" + commit_message + "\"");
        System.out.println("Committed all files to git repository");


        Runtime.getRuntime().exec("git push origin master");
        System.out.println("Pushed all files to git remote");

        System.exit(0);
    }
}
