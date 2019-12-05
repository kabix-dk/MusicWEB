package pb.wi.musicweb.utils.converters;

import pb.wi.musicweb.database.models.AutorTekstuEntity;
import pb.wi.musicweb.database.models.WykonawcaEntity;
import pb.wi.musicweb.modelFX.AuthorFX;
import pb.wi.musicweb.modelFX.WykonawcaFX;

import java.util.Random;

public class ConverterAuthor {

    private static Random random = new Random();

    public static AutorTekstuEntity convertToAutorTekstuEntity(AuthorFX authorFX) {
        AutorTekstuEntity autorTekstuEntity = new AutorTekstuEntity();
        if(authorFX.getId() != 0) {
            autorTekstuEntity.setIdAutorTekstu((short) authorFX.getId());
        } else autorTekstuEntity.setIdAutorTekstu((short) random.nextInt(Short.MAX_VALUE-1));
        autorTekstuEntity.setImieAutorTekstu(authorFX.getName());
        autorTekstuEntity.setNazwiskoAutorTekstu(authorFX.getSurname());
        autorTekstuEntity.setPseudonimAutorTekstu(authorFX.getNick());
        return autorTekstuEntity;
    }

    public static AuthorFX convertToAuthorFX(AutorTekstuEntity autor) {
        AuthorFX authorFX = new AuthorFX();
        authorFX.setId(autor.getIdAutorTekstu());
        authorFX.setName(autor.getImieAutorTekstu());
        authorFX.setSurname(autor.getNazwiskoAutorTekstu());
        authorFX.setNick(autor.getPseudonimAutorTekstu());
        return authorFX;
    }
}
