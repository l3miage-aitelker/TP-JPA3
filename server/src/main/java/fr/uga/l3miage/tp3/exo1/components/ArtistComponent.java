package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.enums.GenreMusical;
import fr.uga.l3miage.tp3.exo1.models.ArtistEntity;
import fr.uga.l3miage.tp3.exo1.models.ArtistEntity;
import fr.uga.l3miage.tp3.exo1.models.SongEntity;
import fr.uga.l3miage.tp3.exo1.repositories.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;


@Component
@RequiredArgsConstructor
public class ArtistComponent {
    private final ArtistRepository artistRepository;

    public ArtistEntity getArtist(String name){
        return artistRepository.findById(name).orElseThrow();
    }

    public ArtistEntity createArtist(ArtistEntity artistEntity){
        return artistRepository.save(artistEntity);
    }

    public ArtistEntity updateArtist(String name, ArtistEntity newArtistEntity){
        ArtistEntity artistEntity = artistRepository.findById(name).orElseThrow();
        artistEntity.setBiography(newArtistEntity.getBiography());
        artistEntity.setGenreMusical(newArtistEntity.getGenreMusical());
        artistEntity.setAlbumEntities(newArtistEntity.getAlbumEntities());
        return artistRepository.save(artistEntity);
    }
    public void deleteArtist(String name){
        artistRepository.deleteById(name);
    }

    public int getCountArtistFromGenre(GenreMusical genre){
        return artistRepository.countArtistByGenreMusical(genre);
    }

}
