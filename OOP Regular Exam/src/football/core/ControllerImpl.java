package football.core;


import football.entities.field.ArtificialTurf;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static football.common.ConstantMessages.*;
import static football.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private SupplementRepository supplementRepository;
    private Map<String, Field> fields;

    public ControllerImpl() {
        this.supplementRepository = new SupplementRepositoryImpl();
        this.fields = new LinkedHashMap<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        Field field;

        if(fieldType.equals("ArtificialTurf")){
            field = new ArtificialTurf(fieldName);
        } else if(fieldType.equals("NaturalGrass")){
            field = new NaturalGrass(fieldName);
        }else{
            throw new NullPointerException(INVALID_FIELD_TYPE);
        }
        fields.put(fieldName, field);

        return String.format(SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        Supplement supplement;

        if(type.equals("Powdered")){
            supplement = new Powdered();
        } else if (type.equals("Liquid")){
            supplement = new Liquid();
        } else {
            throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }

        supplementRepository.add(supplement);

        return String .format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        Supplement supplement = supplementRepository.findByType(supplementType);

        if(supplement == null) {
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
        }

        Field field = fields.get(fieldName);
        field.addSupplement(supplement);

        supplementRepository.remove(supplement);

        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Player player;

        if(playerType.equals("Men")){
            player = new Men(playerName, nationality, strength);
        } else if (playerType.equals("Women")){
            player = new Women(playerName, nationality, strength);
        } else {
            throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }

        Field field = fields.get(fieldName);

        String fieldType = field.getClass().getSimpleName();

        boolean fieldsAndPlayersAreArtificial = fieldType.equals("ArtificialTurf") && playerType.equals("Women");
        boolean fieldsAndPlayersAreNatural = fieldType.equals("NaturalGrass") && playerType.equals("Men");
        if(fieldsAndPlayersAreArtificial || fieldsAndPlayersAreNatural){
            field.addPlayer(player);
        } else {
            return FIELD_NOT_SUITABLE;
        }
        return String.format(SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);

    }

    @Override
    public String dragPlayer(String fieldName) {

        Field field = fields.get(fieldName);

        field.drag();

        return String.format(PLAYER_DRAG, field.getPlayers().size());

    }

    @Override
    public String calculateStrength(String fieldName) {
        Collection<Player> players = fields.get(fieldName).getPlayers();

        int totalStrength = players.stream()
                .mapToInt(Player::getStrength)
                .sum();
        return String.format(STRENGTH_FIELD, fieldName, totalStrength);
    }

    @Override
    public String getStatistics() {
        return fields.values().stream()
                .map(Field::getInfo)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
