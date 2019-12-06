package pb.wi.musicweb.utils.converters;

import pb.wi.musicweb.database.models.AutorTekstuEntity;
import pb.wi.musicweb.modelFX.AuthorFX;

public class ConverterAuthor {

    public static AutorTekstuEntity convertToAutorTekstuEntity(AuthorFX authorFX) {
        AutorTekstuEntity autorTekstuEntity = new AutorTekstuEntity();
        if(authorFX.getId() != 0) {
            autorTekstuEntity.setIdAutorTekstu((short) authorFX.getId());
        }
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
