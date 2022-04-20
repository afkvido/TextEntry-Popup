public class Main {


    public static volatile String commit_message;

    public static guiWindow e = new guiWindow();


    public static void main (String[] args) {

        e.show();
    }

    public static void finish () throws Exception {

        e.button.setText("Adding...");
        e.frame.getContentPane().update(e.frame.getGraphics());
        Runtime.getRuntime().exec("git add --all");

        e.button.setText("Committing...");
        e.frame.getContentPane().update(e.frame.getGraphics());
        Runtime.getRuntime().exec("git commit -m " + commit_message + "");

        e.button.setText("Pushing...");
        e.frame.getContentPane().update(e.frame.getGraphics());
        Runtime.getRuntime().exec("git push origin master");


    }
}