public class Main {


    public static volatile String commit_message;

    public static guiWindow e = new guiWindow();

    public static Boolean adding_started = false;

    public static Boolean committing_started = false;

    public static Boolean pushing_started = false;


    public static Boolean adding_done = false;

    public static Boolean committing_done = false;

    public static Boolean pushing_done = false;


    public static void main (String[] args) {

        e.show();
    }



    public static void finish () throws Exception {


        Thread _add = new Thread(() -> {

            if (!adding_started) {

                try {
                    e.button.setText("Adding...");
                    e.frame.pack();
                    e.frame.update(e.frame.getGraphics());
                    Process add = Runtime.getRuntime().exec("git add --all");

                    adding_done = true;

                } catch (Exception ignored) {}
            }
        });

        Thread _commit = new Thread(() -> {

            if (!committing_started) {

                try {
                    e.button.setText("Committing...");
                    e.frame.pack();
                    e.frame.update(e.frame.getGraphics());
                    Process commit = Runtime.getRuntime().exec("git commit -m " + commit_message + "");
                    committing_done = true;


                } catch (Exception ignored) {}
            }
        });

        Thread _push = new Thread(() -> {

            if (!pushing_started) {
                try {
                    e.button.setText("Pushing...");
                    e.frame.pack();
                    e.frame.update(e.frame.getGraphics());
                    Process push = Runtime.getRuntime().exec("git push origin master");

                    pushing_done = true;

                } catch (Exception ignored) {}
            }
        });


        while (true) {

            if (!adding_done && !committing_done && !pushing_done) {
                _add.start();
            }


            if (adding_done && !committing_done && !pushing_done) {
                _commit.start();
            }


            if (adding_done && committing_done && !pushing_done) {
                _push.start();
            }




            if (adding_done && committing_done && pushing_done) {
                break;
            }

            Thread.sleep(4000);
    }




        e.button.setText("Done!");
        e.frame.pack();
        e.frame.update(e.frame.getGraphics());

        Thread.sleep(300);

    }




}
