package pb.wi.musicweb.utils.converters;

import pb.wi.musicweb.database.models.AlbumEntity;
import pb.wi.musicweb.modelFX.AlbumFX;

public class ConverterAlbum {

    public static AlbumFX convertAlbumFX(AlbumEntity albumEntity) {
        AlbumFX albumFX = new AlbumFX();
        albumFX.setId(albumEntity.getIdAlbum());
        albumFX.setName(albumEntity.getNazwaAlbum());
        return albumFX;
    }
}
