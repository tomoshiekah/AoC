

public class day16product extends day16operators {
    @Override
    public long combine() {
        long product = subPackets.get(0).combine();
        for(int i = 1; i < subPackets.size(); i++){
            product = product * subPackets.get(i).combine();
        }
        return product;
    }
}
