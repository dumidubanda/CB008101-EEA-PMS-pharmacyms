package com.cb008101.pharmacyms.pharmaitems;


import com.cb008101.pharmacyms.dto.DrugDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PharmaItemsController
{

    @Autowired
    private DrugItemsService drugItemsService;

    @RequestMapping(method = RequestMethod.POST, value = "/saveDrug")
    public void saveDrug(@RequestBody Items items)
    {
        drugItemsService.saveDrug(items);
    }

    @RequestMapping("/getAllDrugs")
    public List<Items> getAllDrugs()
    {
        return drugItemsService.getAllDrugs();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateDrug/{id}")
    public void updateDrugs(@PathVariable Integer id, @RequestBody Items items)
    {
        drugItemsService.updateDrug(id, items);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteDrug/{id}")
    public void deleteDrug(@PathVariable Integer id)
    {
        drugItemsService.deleteDrug(id);
    }

    @GetMapping("/getAllDrugsByNames")
    public List<DrugDTO> getAllByNames()
    {
        return drugItemsService.getAllByNames();
    }

    @GetMapping("/getDrugById/{id}")
    public Items getDrugById(@PathVariable Integer id)
    {
        return drugItemsService.getByID(id);
    }

}
