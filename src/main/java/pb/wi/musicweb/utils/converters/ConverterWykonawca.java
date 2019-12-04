package pb.wi.musicweb.utils.converters;

import pb.wi.musicweb.database.models.WykonawcaEntity;
import pb.wi.musicweb.modelFX.WykonawcaFX;

import java.util.Random;

public class ConverterWykonawca {

    private static Random generator = new Random();

    public static WykonawcaEntity convertWykonawcaFXToWykonawcaEntity(WykonawcaFX wykonawcaFX) {
        WykonawcaEntity wykonawcaEntity = new WykonawcaEntity();
        wykonawcaEntity.setIdWykonawca((short) Math.abs(generator.nextInt(Short.MAX_VALUE)));
        wykonawcaEntity.setImieWykonawca(wykonawcaFX.getName());
        wykonawcaEntity.setNazwiskoWykonawca(wykonawcaFX.getSurname());
        wykonawcaEntity.setPseudonimWykonawca(wykonawcaFX.getNick());
        return wykonawcaEntity;
    }
}
