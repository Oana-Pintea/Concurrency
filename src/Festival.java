import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Festival{

    public static final int maxSpectatorArrivalInterval = 10000;
    public static final int checkStatisticsInterval = 5000;
    public static final int peopleNumber = 100;

    private Gate gate;

    public Festival(Gate gate) {
        this.gate = gate;
    }



    public void start()
    {
        StatisticsThread statistics = new StatisticsThread(gate);
        statistics.start();


        List<SpectatorThread> spectatori = new ArrayList<>();
        for(int k=1; k<=peopleNumber; k++) {

            Random rand = new Random();
            int max = TicketType.values().length;
            int i = rand.nextInt(max);
            TicketType ticket = TicketType.values()[i];


            SpectatorThread sp = new SpectatorThread(ticket, gate);
            spectatori.add(sp);
            sp.start();
        }


        try {
            for (SpectatorThread sp : spectatori)
                sp.join(maxSpectatorArrivalInterval);
        }catch(InterruptedException ex)
        {
            System.out.println(ex.getMessage());
        }

    }
}
