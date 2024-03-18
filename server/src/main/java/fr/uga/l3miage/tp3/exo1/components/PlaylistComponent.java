package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.models.PlaylistEntity;
import fr.uga.l3miage.tp3.exo1.models.PlaylistEntity;
import fr.uga.l3miage.tp3.exo1.models.SongEntity;
import fr.uga.l3miage.tp3.exo1.repositories.PlaylistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Set;


@Component
@RequiredArgsConstructor
public class PlaylistComponent {
    private final PlaylistRepository playlistRepository;

    public PlaylistEntity getPlaylist(String name){
        return playlistRepository.findById(name).orElseThrow();
    }

    public PlaylistEntity createPlaylist(PlaylistEntity playlistEntity){
        return playlistRepository.save(playlistEntity);
    }

    public PlaylistEntity updatePlaylist(String name, PlaylistEntity newPlaylistEntity) {
        PlaylistEntity playlistEntity = playlistRepository.findById(name).orElseThrow();
        playlistEntity.setDescription(newPlaylistEntity.getDescription());
        playlistEntity.setTotalDuration(newPlaylistEntity.getTotalDuration());
        playlistEntity.setSongEntities(newPlaylistEntity.getSongEntities());
        return playlistRepository.save(playlistEntity);
    }
    public void deletePlaylist(String name){
        playlistRepository.deleteById(name);
    }

    public Set<PlaylistEntity> getPlaylistsContainingSong(SongEntity song)
    {
        return playlistRepository.findAllBySongEntitiesContains(song);
    }

}
