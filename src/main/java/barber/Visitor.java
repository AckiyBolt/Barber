package barber;

public class Visitor extends AHuman {

  public boolean isAlive = true;

  public Visitor(QueuesHolder holder) {
    super(holder);
  }

  public void run() {

    boolean isHolden = holder.tryHoldPlace(this);

    if(isHolden) {
      System.out.println(this.getName() + " встал в очередь");
      while (isAlive) {
        try {
          synchronized (holder) {
            holder.wait();
          }
            boolean inHall = holder.tryChangeQueue(this);
            if (inHall) {
              System.out.println(this.getName() + " встал в очередь в холе");
            }

        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

      System.out.println(this.getName() + " обскубан");

    } else {
      System.out.println(this.getName() + " ушел лесом");
    }
  }
}
