package transmission;

import java.util.Objects;

/** 
 * Class For Automatic Transmission.
 *
 */
public class AutomaticTransmission implements Transmission {
  private int speed;
  private int gear;
  private int t1;
  private int t2;
  private int t3;
  private int t4;
  private int t5;
  
  /** 
   * Constructor for initialising variables.
   *
   */
  
  public AutomaticTransmission(int t1, int t2, 
      int t3, int t4, int t5) throws IllegalArgumentException {
    this.speed = 0;
    this.gear = 0;
    this.t1 = t1;
    this.t2 = t2;
    this.t3 = t3;
    this.t4 = t4;
    this.t5 = t5;
    if (t1 < 0 || t2 < 0 || t3 < 0 || t4 < 0 || t5 < 0) {
      throw new IllegalArgumentException("Speed Cannot Be Negative");
    }
    if (t1 >= t2) {
      throw new IllegalArgumentException();
    }
    if (t2 >= t3) {
      throw new IllegalArgumentException();
    }
    if (t3 >= t4) {
      throw new IllegalArgumentException();
    }
    if (t4 >= t5) {
      throw new IllegalArgumentException();
    }
    if (t2 >= t4) {
      throw new IllegalArgumentException();
    }
    if (t2 >= t5) {
      throw new IllegalArgumentException();
    }
    if (t1 >= t3) {
      throw new IllegalArgumentException();
    }
    if (t1 >= t4) {
      throw new IllegalArgumentException();
    }
    if (t1 >= t5) {
      throw new IllegalArgumentException();
    }
    if (t3 >= t5) {
      throw new IllegalArgumentException();
    }
    
  }

  @Override
  public void increaseSpeed() {
    speed = speed + 1;
  }

  @Override
    public void decreaseSpeed() throws IllegalStateException {
    if (speed == 0) {
      throw new IllegalStateException("Speed already 0");
    } else {
      speed = speed - 1;
    }

  }

  @Override
  public int getSpeed() {
    return this.speed;
  }

  @Override
  public int getGear() {
    if (speed > 0) {
      gear = 1;
    }
    if (speed >= t1) {
      gear = 2;
    }
    if (speed >= t2) {
      gear = 3;
    }
    if (speed >= t3) {
      gear = 4;
    }
    if (speed >= t4) {
      gear = 5;
    }
    if (speed >= t5) {
      gear = 6;
    }
    return this.gear;
  }

  @Override
public String toString() {
    return String.format("Transmission (speed = " + speed + ", gear = " + gear + ")");
  }
  
  @Override
public int hashCode() {
    return Objects.hash(gear, speed, t1, t2, t3, t4, t5);
  }

  @Override
public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    AutomaticTransmission other = (AutomaticTransmission) obj;
    return gear == other.gear && speed == other.speed && t1 == other.t1
      && t2 == other.t2 && t3 == other.t3
      && t4 == other.t4 && t5 == other.t5;
  }
}

