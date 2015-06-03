package barber;

/**
 * Omega
 * Belentsov K.
 * 03.06.15
 */
public class Barber extends AHuman {

  private static int VISITORS_LIMIT = 20;

  public int visitorsCount;

  public Barber(QueuesHolder holder) {
    super(holder);
  }

  public void run() {
    while (visitorsCount++ < VISITORS_LIMIT) {

      Visitor visitor = holder.pullNextVisitor();
      if (visitor != null)
        System.out.println("Стрижом " + visitor.getName());
      try {
        Thread.sleep(5000);

        synchronized (holder) {
          holder.notifyAll();
        }

        if (visitor != null)
          visitor.isAlive = false;

      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}