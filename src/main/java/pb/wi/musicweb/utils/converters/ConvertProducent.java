package pb.wi.musicweb.utils.converters;

import pb.wi.musicweb.database.models.ProducentEntity;
import pb.wi.musicweb.modelFX.ProducentFX;

import java.util.Random;

public class ConvertProducent {

    private static Random random = new Random();

    public static ProducentEntity convertToProducentEntity(ProducentFX producentFX) {
        ProducentEntity producentEntity = new ProducentEntity();
        if(producentFX.getId() != 0) {
            producentEntity.setIdProducent((short) producentFX.getId());
        } else producentEntity.setIdProducent((short) random.nextInt(Short.MAX_VALUE-1));
        producentEntity.setImieProducent(producentFX.getName());
        producentEntity.setNazwiskoProducent(producentFX.getSurname());
        producentEntity.setPseudonimProducent(producentFX.getNick());
        return producentEntity;
    }

    public static ProducentFX convertToProducentFX(ProducentEntity producent) {
        ProducentFX producentFX = new ProducentFX();
        producentFX.setId(producent.getIdProducent());
        producentFX.setName(producent.getImieProducent());
        producentFX.setSurname(producent.getNazwiskoProducent());
        producentFX.setNick(producent.getPseudonimProducent());
        return producentFX;
    }
}
