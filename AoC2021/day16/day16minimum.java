

public class day16minimum extends day16operators {
    @Override
    public long combine() {
        long min = subPackets.get(0).combine();
        for(int i = 1; i < subPackets.size(); i++){
            if(min > subPackets.get(i).combine()){
                min = subPackets.get(i).combine();
            }
        }
        return min;
    }
}
