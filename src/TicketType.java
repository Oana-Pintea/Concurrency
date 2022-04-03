public enum TicketType {
    FULL(0),
    FULLVIP(1),
    FREEPASS(2),
    ONEDAY(3),
    ONEDAYVIP(4);

    private final int value;
    private TicketType(int value)
    {
        this.value = value;
    }
    public int getValue()
    {
        return value;
    }
}
