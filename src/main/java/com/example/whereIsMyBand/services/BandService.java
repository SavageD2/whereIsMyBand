package com.example.whereIsMyBand.services;

import com.example.whereIsMyBand.profiles.Announce;
import com.example.whereIsMyBand.profiles.Band;
import com.example.whereIsMyBand.repositories.BandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.geom.IllegalPathStateException;
import java.util.List;
import java.util.Optional;

@Service
public class BandService {
    @Autowired
    private BandRepository bandRepository;

    public Band createGroup(Band band) {
        return bandRepository.save(band);
    }
    public List<Band> getAllGroup() {
        return bandRepository.findAll();
    }

    public Band findById(Long id) {
        return bandRepository.findById(id).orElse(null);
    }

    public Band updateGroupById(Long id, Band band) {
        Band bandFound = bandRepository.findById(id)
                .orElseThrow(() -> new IllegalPathStateException("No group found with id: " + id)); // juste au cas où je ne le trouve pas ^^
        bandFound.setEmail(band.getEmail());
        bandFound.setPassword(band.getPassword());
        bandFound.setGroupName(band.getGroupName());
        bandFound.setDescription(band.getDescription());
        bandFound.setBanner(band.getBanner());
        bandFound.setCity(band.getCity());
        bandFound.setWebsite(band.getWebsite());
        return bandRepository.save(bandFound);

    }
    public void deleteGroupById(Long id) {
        bandRepository.deleteById(id);
    }

    public Band findBandByCity(String city){
        return bandRepository.findByCity(city);
    }
    public Announce createAnnounce(Long id, Announce announce){
        Optional<Band> bandOptional = bandRepository.findById(id);
        if(bandOptional.isPresent()) {
            Band band = bandOptional.get();
            announce.setBand(band);
            band.getAnnounces().add(announce);
            bandRepository.save(band);
        }else {
            throw new IllegalPathStateException("No group found with id: " + id);
        }
        return null;
    }


}
