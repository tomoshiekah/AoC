

public class day16maximum extends day16operators {
    @Override
    public long combine() {
        long max = subPackets.get(0).combine();
        for(int i = 1; i < subPackets.size(); i++){
            if(max < subPackets.get(i).combine()){
                max = subPackets.get(i).combine();
            }
        }
        return max;
    }

}
