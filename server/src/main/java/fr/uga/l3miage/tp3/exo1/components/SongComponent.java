package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.models.SongEntity;
import fr.uga.l3miage.tp3.exo1.models.SongEntity;
import fr.uga.l3miage.tp3.exo1.models.UserEntity;
import fr.uga.l3miage.tp3.exo1.repositories.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Set;


@Component
@RequiredArgsConstructor
public class SongComponent {
    private final SongRepository songRepository;

    public SongEntity getSong(String title){
        return songRepository.findById(title).orElseThrow();
    }

    public SongEntity createSong(SongEntity songEntity){
        return songRepository.save(songEntity);
    }

    public SongEntity updateSong(String name, SongEntity newSongEntity){
        SongEntity songEntity = songRepository.findById(name).orElseThrow();
        songEntity.setDuration(newSongEntity.getDuration());
        songEntity.setAlbumEntity(newSongEntity.getAlbumEntity());
        songEntity.setArtistEntity(newSongEntity.getArtistEntity());
        return songRepository.save(songEntity);
    }


    public void deleteSong(String title){
        songRepository.deleteById(title);
    }

    public SongEntity getSongIsInInterval(Duration min, Duration max){
        return songRepository.findSongByDurationBetween(min,max);
    }
}
