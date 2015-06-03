package barber;

/**
 * Omega
 * Belentsov K.
 * 03.06.15
 */
public class AHuman extends Thread  {

  protected QueuesHolder holder;

  public AHuman(QueuesHolder holder) {
    this.holder = holder;
  }
}
