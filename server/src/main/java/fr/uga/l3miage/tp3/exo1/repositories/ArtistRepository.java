package fr.uga.l3miage.tp3.exo1.repositories;

import fr.uga.l3miage.tp3.exo1.enums.GenreMusical;
import fr.uga.l3miage.tp3.exo1.models.ArtistEntity;
import fr.uga.l3miage.tp3.exo1.models.SongEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.util.Set;

@Repository
public interface ArtistRepository extends JpaRepository<ArtistEntity, String> {

    public int countArtistByGenreMusical(GenreMusical genre);

}
