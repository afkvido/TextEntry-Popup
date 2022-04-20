import java.io.IOException;

public class Main {


    public static volatile String commit_message;

    public static guiWindow e = new guiWindow();


    public static Boolean adding_done = false;

    public static Boolean committing_done = false;

    public static Boolean pushing_done = false;


    public static void main (String[] args) {

        e.show();
    }



    public static void finish () throws Exception {




        Thread _add = new Thread(() -> {
            try {
                e.button.setText("Adding...");
                e.frame.pack();
                e.frame.update(e.frame.getGraphics());
                Process add = Runtime.getRuntime().exec("git add --all");

                while (add.isAlive()) {
                    Thread.sleep(1000);
                }

                adding_done = true;



            } catch (Exception ignored) {}
        });


        Thread _commit = new Thread(() -> {
            try {
                e.button.setText("Committing...");
                e.frame.pack(); e.frame.update(e.frame.getGraphics());
                Process commit = Runtime.getRuntime().exec("git commit -m " + commit_message + "");

                while (commit.isAlive()) {
                    Thread.sleep(1000);
                }

                committing_done = true;


            } catch (Exception ignored) {}
        });

        Thread _push = new Thread(() -> {
            try {
                e.button.setText("Pushing...");
                e.frame.pack();
                e.frame.update(e.frame.getGraphics());
                Process push = Runtime.getRuntime().exec("git push origin master");
                Thread.sleep(2000);

                pushing_done = true;

            } catch (Exception ignored) {}
        });



        _add.start();



        _commit.start();


        _push.start();
        Thread.sleep(2000);



        e.button.setText("Done!");
        e.frame.pack();
        e.frame.update(e.frame.getGraphics());

        Thread.sleep(300);

    }




}
