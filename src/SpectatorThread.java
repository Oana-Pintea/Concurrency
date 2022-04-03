import java.util.Random;

public class SpectatorThread extends Thread {
    private TicketType ticket;
    private Gate gate;

    public SpectatorThread(TicketType ticket, Gate gate){
        this.ticket = ticket;
        this.gate = gate;
    }


    @Override
    public void run()
    {
        Random rand = new Random();
        int i = rand.nextInt(Festival.maxSpectatorArrivalInterval);
        try {
            Thread.sleep(i);
        }catch (InterruptedException ex)
        {
            System.out.println(ex.getMessage());
        }

        gate.validate(ticket);
    }
}
