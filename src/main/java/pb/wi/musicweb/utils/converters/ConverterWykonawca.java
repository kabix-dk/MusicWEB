package pb.wi.musicweb.utils.converters;

import pb.wi.musicweb.database.models.WykonawcaEntity;
import pb.wi.musicweb.modelFX.WykonawcaFX;

import java.util.Random;

public class ConverterWykonawca {

    private static Random generator = new Random();

    public static WykonawcaEntity converToWykonawcaEntity(WykonawcaFX wykonawcaFX) {
        WykonawcaEntity wykonawcaEntity = new WykonawcaEntity();
        wykonawcaEntity.setIdWykonawca((short) Math.abs(generator.nextInt(Short.MAX_VALUE)));
        wykonawcaEntity.setImieWykonawca(wykonawcaFX.getName());
        wykonawcaEntity.setNazwiskoWykonawca(wykonawcaFX.getSurname());
        wykonawcaEntity.setPseudonimWykonawca(wykonawcaFX.getNick());
        return wykonawcaEntity;
    }

    public static WykonawcaFX convertToWykonawcaFX(WykonawcaEntity wykonawca) {
        WykonawcaFX wykonawcaFX = new WykonawcaFX();
        wykonawcaFX.setId(wykonawca.getIdWykonawca());
        wykonawcaFX.setName(wykonawca.getImieWykonawca());
        wykonawcaFX.setSurname(wykonawca.getNazwiskoWykonawca());
        wykonawcaFX.setNick(wykonawca.getPseudonimWykonawca());
        return wykonawcaFX;
    }
}
