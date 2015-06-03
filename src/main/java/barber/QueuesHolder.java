package barber;

import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueuesHolder {

  private Deque<Visitor> hall   = new LinkedBlockingDeque<Visitor>();
  private Deque<Visitor> street = new LinkedBlockingDeque<Visitor>();

  public Visitor pullNextVisitor() {
    return hall.pollLast();
  }

  public synchronized boolean tryChangeQueue(Visitor visitor) {
    if (thereIsEmptySeatsInHall() && street.peekLast().equals(visitor)) {
      hall.addFirst(street.pollLast());
      return true;
    }
    return false;
  }

  public synchronized boolean tryHoldPlace(Visitor visitor) {
    if (thereIsEmptySeatsInHall() && street.size() == 0) {
      hall.addFirst(visitor);
      return true;
    }
    if (thereIsEmptySeatsOnStreet()) {
      street.addFirst(visitor);
      return true;
    }

    return false;
  }

  private boolean thereIsEmptySeatsInHall() {
    return hall.size() < 2;
  }

  private boolean thereIsEmptySeatsOnStreet() {
    return street.size() < 5;
  }
}
