package barber;

public class Main {

  public static void main(String[] args) throws Exception {

    QueuesHolder holder = new QueuesHolder();

    new Barber(holder).start();

    Thread.sleep(100);

    while (true) {

      Visitor visitor = new Visitor(holder);
      new Thread(visitor).start();

      Thread.sleep(1000);
    }
  }
}
