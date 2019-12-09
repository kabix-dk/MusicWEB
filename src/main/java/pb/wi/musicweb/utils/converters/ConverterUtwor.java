package pb.wi.musicweb.utils.converters;

import pb.wi.musicweb.database.models.UtworEntity;
import pb.wi.musicweb.modelFX.UtworFX;

public class ConverterUtwor {

    public static UtworEntity convertToUtwor(UtworFX utworFX) {
        UtworEntity utworEntity = new UtworEntity();
        utworEntity.setNazwaUtwor(utworFX.getName());
        return utworEntity;
    }

    public static UtworFX convertUtworFX(UtworEntity utworEntity) {
        UtworFX utworFX = new UtworFX();
        utworFX.setId(utworEntity.getIdUtwor());
        utworFX.setName(utworEntity.getNazwaUtwor());
        return utworFX;
    }
}
