

public class day16greater extends day16operators{
    @Override
    public long combine() {
        if(subPackets.get(1).combine() > subPackets.get(0).combine()){
            return 1;
        }else{
            return 0;
        }
    }
}
