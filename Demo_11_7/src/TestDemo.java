enum TrafficLight {
    GREEN,
    RED,
    YELLOW;
}

public class TestDemo {
    public static void main(String[] args) {
        TrafficLight light = TrafficLight.RED;
        for (int i = 0; i < TrafficLight.values().length; i++) {
            System.out.println(TrafficLight.values()[i] + " 序列号 " + TrafficLight.values()[i].ordinal());
        }

        switch (light) {
            case RED -> System.out.println("红灯，不能通行");
            case GREEN -> System.out.println("绿灯，可以通行");
            case YELLOW -> System.out.println("黄灯，等待再通行");
        }

    }
}
