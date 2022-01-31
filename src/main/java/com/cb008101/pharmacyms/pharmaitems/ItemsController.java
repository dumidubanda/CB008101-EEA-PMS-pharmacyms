package com.cb008101.pharmacyms.pharmaitems;


import com.cb008101.pharmacyms.dto.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemsController
{

    @Autowired
    private ItemsService itemsService;

    @RequestMapping(method = RequestMethod.POST, value = "/saveDrug")
    public void saveDrug(@RequestBody Items items)
    {
        itemsService.saveDrug(items);
    }

    @RequestMapping("/getAllDrugs")
    public List<Items> getAllDrugs()
    {
        return itemsService.getAllDrugs();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateDrug/{id}")
    public void updateDrugs(@PathVariable Integer id, @RequestBody Items items)
    {
        itemsService.updateDrug(id, items);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteDrug/{id}")
    public void deleteDrug(@PathVariable Integer id)
    {
        itemsService.deleteDrug(id);
    }

    @GetMapping("/getAllDrugsByNames")
    public List<ItemDTO> getAllByNames()
    {
        return itemsService.getAllByNames();
    }

    @GetMapping("/getDrugById/{id}")
    public Items getDrugById(@PathVariable Integer id)
    {
        return itemsService.getByID(id);
    }

}
