public class Clock extends Thread {

    public static boolean running = true;

    /*
    Thread ruft die nextGen Methode in der Kasse World auf
    Tote und lebende Zellen werden mit Methoden in der Conuter Klasse berechnet und durch den Thread ausgegeben
     */
    public void run() {
        while (running) {
            try {
                sleep(50);
                World.nextGen();
                Counter.CellsAlive();
                Counter.CellsDead();
                System.out.println("Living Cells in generation" + World.gen + ":" + Counter.alive);
                System.out.println("Dead Cells in generation" + World.gen + ":" + Counter.dead);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
