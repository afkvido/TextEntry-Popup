public class Main {


    public static volatile String commit_message;

    public static guiWindow e = new guiWindow();


    public static void main (String[] args) {

        e.show();
    }

    public static void finish () throws Exception {

        e.button.setText("Adding...");
        e.frame.getContentPane().update(e.frame.getGraphics());
        Process a = Runtime.getRuntime().exec("git add --all");
        a.waitFor();

        e.button.setText("Committing...");
        e.frame.getContentPane().update(e.frame.getGraphics());
        Process c = Runtime.getRuntime().exec("git commit -m " + commit_message + "");
        c.waitFor();

        e.button.setText("Pushing...");
        e.frame.getContentPane().update(e.frame.getGraphics());
        Process p = Runtime.getRuntime().exec("git push origin master");
        p.waitFor();

        e.button.setText("Done!");
        e.frame.getContentPane().update(e.frame.getGraphics());
        Thread.sleep(200);
        System.exit(0);
    }
}