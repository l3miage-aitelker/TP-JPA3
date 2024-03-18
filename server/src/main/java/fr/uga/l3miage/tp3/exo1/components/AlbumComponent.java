package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.enums.GenreMusical;
import fr.uga.l3miage.tp3.exo1.models.AlbumEntity;
import fr.uga.l3miage.tp3.exo1.models.AlbumEntity;
import fr.uga.l3miage.tp3.exo1.repositories.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Date;


@Component
@RequiredArgsConstructor
public class AlbumComponent {
    private final AlbumRepository albumRepository;

    public AlbumEntity getAlbum(String title){
        return albumRepository.findById(title).orElseThrow();
    }

    public AlbumEntity createAlbum(AlbumEntity albumEntity){
        return albumRepository.save(albumEntity);
    }

    public AlbumEntity update(String name, AlbumEntity newAlbumEntity){
        AlbumEntity albumEntity = albumRepository.findById(name).orElseThrow();
        albumEntity.setReleaseDate(newAlbumEntity.getReleaseDate());
        albumEntity.setSongEntities(newAlbumEntity.getSongEntities());
        albumEntity.setArtistEntity(newAlbumEntity.getArtistEntity());
        return albumRepository.save(albumEntity);
    }

    public void deleteAlbum(String title){
        albumRepository.deleteById(title);
    }


}
