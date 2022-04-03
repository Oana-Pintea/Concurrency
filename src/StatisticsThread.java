import java.util.List;

public class StatisticsThread extends Thread{
    private Gate gate;

    private int total;
    int[] stats;
    String [] stat_names = {"full", "fullvip", "freepass", "oneday", "onedayvip"};

    public StatisticsThread(Gate gate)
    {
        this.gate = gate;
        stats = new int[stat_names.length];
    }
    @Override
    public void run(){
        while(true) {
            try {
                sleep(Festival.checkStatisticsInterval);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }

            if (gate.isAnybodyAtTheGate()) {
                List<TicketType> list = gate.letEverybodyIn();


                for (TicketType ticket : list) {
                    int index = ticket.getValue();
                    stats[index]++;
                    total++;
                }

                System.out.println(total + " people entered");
                for (int i = 0; i < stats.length; i++)
                    System.out.println(stats[i] + " people have " + stat_names[i] + " tickets");
            }
            else
                break;

            if(total == Festival.peopleNumber)
                break;
        }
    }
}
