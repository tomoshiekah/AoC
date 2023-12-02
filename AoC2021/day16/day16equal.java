

public class day16equal extends day16operators{
    @Override
    public long combine() {
        if(subPackets.get(0).combine() == subPackets.get(1).combine()){
            return 1;
        }else{
            return 0;
        }
    }
}
