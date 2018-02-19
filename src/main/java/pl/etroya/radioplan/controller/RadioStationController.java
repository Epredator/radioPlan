package pl.etroya.radioplan.controller;

import org.springframework.web.bind.annotation.*;
import pl.etroya.radioplan.model.RadioStation;

import javax.validation.constraints.Max;
import java.util.List;




@RestController
@RequestMapping("/api/v1")
public class RadioStationController {
    @RequestMapping(value = "radiostations", method = RequestMethod.GET)
    public List<RadioStation> list(){
        return RadioStationStub.list();

    }

    @RequestMapping(value = "radiostations", method = RequestMethod.POST)
    public RadioStation create(@RequestBody RadioStation radioStation){
        return RadioStationStub.create(radioStation);
    }

    @RequestMapping(value = "radiostations/{id}", method = RequestMethod.GET)
    public RadioStation get(@PathVariable Long id){
        return  RadioStationStub.get(id);
    }

    @RequestMapping(value = "radiostation{id}", method = RequestMethod.PUT)
    public RadioStation update(@PathVariable Long id, @RequestBody RadioStation radioStation){
        return RadioStationStub.update(id, radioStation);
    }

    @RequestMapping(value = "radiostation/{id}", method = RequestMethod.DELETE)
    public RadioStation delete(@PathVariable Long id){
        return RadioStationStub.delete(id);
    }
}
