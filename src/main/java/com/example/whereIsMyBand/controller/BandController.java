package com.example.whereIsMyBand.controller;

import com.example.whereIsMyBand.profiles.Announce;
import com.example.whereIsMyBand.profiles.Band;
import com.example.whereIsMyBand.services.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/band")
public class BandController {

    @Autowired
    private BandService bandService;

    @GetMapping("/band_list")
    public ResponseEntity<List<Band>> getAllGroup() {
        List<Band> bandList = bandService.getAllGroup();
        return new ResponseEntity<>(bandList, HttpStatus.OK);
    }

    @GetMapping("/band_detail/{id}")
    public ResponseEntity<Band> getGroupById(@PathVariable("id") Long id) {
        Band bandDetail = bandService.findById(id);
        return new ResponseEntity<>(bandDetail, HttpStatus.OK);
    }

    @PostMapping("/band_create")
    public ResponseEntity<Band> createGroup(@RequestBody Band band) {
        Band createdBand = bandService.createGroup(band);
        return new ResponseEntity<>(createdBand, HttpStatus.CREATED);
    }

    @PutMapping("/band_update/{id}")
    public ResponseEntity<Band> updateGroup(@PathVariable("id") Long id, @RequestBody Band band) {
        Band updatedBand = bandService.updateGroupById(id, band);
        return new ResponseEntity<>(updatedBand, HttpStatus.OK);
    }

    @DeleteMapping("/band_delete/{id}")
    public void deleteGroup(@PathVariable("id") Long id) {
        bandService.deleteGroupById(id);
    }

    @GetMapping("/band/{city}")
    public ResponseEntity<Band>findBandByCity(@PathVariable("city") String city) {
        Band band = bandService.findBandByCity(city.toLowerCase());
        return new ResponseEntity<>(band, HttpStatus.OK);
    }
    @PostMapping("/{id}/announces")
    public ResponseEntity<Announce> createAnnounce(@PathVariable("id") Long id,@RequestBody Announce announce) {
        Announce createdAnnounce = bandService.createAnnounce(id, announce);
        return new ResponseEntity<>(createdAnnounce, HttpStatus.CREATED);
    }

}
