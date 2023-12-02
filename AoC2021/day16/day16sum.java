public class day16sum extends day16operators {
    @Override
    public long combine() {
        long sum = 0;
        for(int i = 0; i < subPackets.size(); i++){
            sum = sum + subPackets.get(i).combine();
        }
        return sum;
    }
}
