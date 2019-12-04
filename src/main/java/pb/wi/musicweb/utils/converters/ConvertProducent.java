package pb.wi.musicweb.utils.converters;

import pb.wi.musicweb.database.models.ProducentEntity;
import pb.wi.musicweb.modelFX.ProducentFX;

import java.util.Random;

public class ConvertProducent {

    private static Random generator = new Random();

    public static ProducentEntity convertProducentFXToProducentEntity(ProducentFX producentFX) {
        ProducentEntity producentEntity = new ProducentEntity();
        producentEntity.setIdProducent((short) Math.abs(generator.nextInt(Short.MAX_VALUE)));
        producentEntity.setImieProducent(producentFX.getName());
        producentEntity.setNazwiskoProducent(producentFX.getSurname());
        producentEntity.setPseudonimProducent(producentFX.getNick());
        return producentEntity;
    }
}
