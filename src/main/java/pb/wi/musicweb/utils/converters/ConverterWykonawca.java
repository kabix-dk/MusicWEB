package pb.wi.musicweb.utils.converters;

import pb.wi.musicweb.database.models.WykonawcaEntity;
import pb.wi.musicweb.modelFX.WykonawcaFX;

public class ConverterWykonawca {

    public static WykonawcaEntity converToWykonawcaEntity(WykonawcaFX wykonawcaFX) {
        WykonawcaEntity wykonawcaEntity = new WykonawcaEntity();
        if(wykonawcaFX.getId() != 0) {
            wykonawcaEntity.setIdWykonawca((short) wykonawcaFX.getId());
        }
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
