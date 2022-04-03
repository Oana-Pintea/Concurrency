import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Gate {
    private Queue<TicketType> queue;

    public Gate()
    {
        queue = new ConcurrentLinkedDeque<>();
    }
    public void validate(TicketType ticket) {
        queue.add(ticket);
    }
    public boolean isAnybodyAtTheGate()
    {
        return !queue.isEmpty();
    }
    public List<TicketType> letEverybodyIn()
    {
        List<TicketType> list = new ArrayList<>();

        while(!queue.isEmpty())
        {
            TicketType ticket = queue.remove();
            list.add(ticket);
        }

        return list;
    }
}
