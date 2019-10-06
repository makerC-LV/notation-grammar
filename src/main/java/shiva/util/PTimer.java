package shiva.util;
public class PTimer {

    private String name;
    private long time = 0;
    private long calls = 0;
    private long lastStart = 0;
    
    
    public PTimer(String name) {
        this.name = name;
    }

    public void start() {
        lastStart = System.nanoTime();
    }
    
    public void stop() {
        if (lastStart == 0) {
            System.out.println("Stop before start");
            throw new RuntimeException("Stop called without start");
        }
        long delta = System.nanoTime() - lastStart;
//        if (delta <= 0) {
//            System.out.println("Delta zero");
//            delta = 1;
//        }
//        long oldt = time;
        time += delta;
//        if (time < oldt) {
//            System.out.println("Overflow: " + oldt + " " + time + " " + delta);
//            throw new RuntimeException("Overflow");
//        }
        lastStart = 0;
        calls++;
    }

    @Override
    public String toString() {
        return "PTimer [name=" + name + ", time=" + time/1E6 + ", calls=" + calls + "]";
    }
    
    
}