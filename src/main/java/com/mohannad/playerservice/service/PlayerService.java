package com.mohannad.playerservice.service;

import com.mohannad.playerservice.model.Player;
import java.util.List;

public interface PlayerService {
    List<Player> getAllPlayers();
    Player getPlayerById(String playerId);
}