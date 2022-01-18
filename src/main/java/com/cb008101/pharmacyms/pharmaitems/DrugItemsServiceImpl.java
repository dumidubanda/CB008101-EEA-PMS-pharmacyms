package com.cb008101.pharmacyms.pharmaitems;


import com.cb008101.pharmacyms.dto.DrugDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DrugItemsServiceImpl implements DrugItemsService
{

    @Autowired
    private DrugItemsRepository drugItemsRepository;


    @Override
    public void deleteDrug(Integer id)
    {
        drugItemsRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Optional<Items> updateDrug(Integer id, Items items)
    {
        return drugItemsRepository.findById(id).map(e ->
        {
            e.setDrugName(items.getDrugName());
            e.setItmPrice(items.getItmPrice());
            e.setFullQty(items.getFullQty());
            return e;
        });
    }

    @Override
    public List<Items> getAllDrugs()
    {
        List<Items> itemsList = new ArrayList<>();
        drugItemsRepository.findAll().forEach(itemsList::add);
        return itemsList;
    }

    @Override
    public void saveDrug(Items items)
    {
        drugItemsRepository.save(items);
    }

    @Override
    public Items getByID(Integer id)
    {
        Optional<Items> drgs = Optional.ofNullable(
                drugItemsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ID"))
        );
        Items drug = drgs.get();
        return drug;
    }

    @Override
    public List<DrugDTO> getAllByNames()
    {
        List<DrugDTO> drugsList = new ArrayList<DrugDTO>();
        drugItemsRepository.getAllDrugDetails().forEach(drugsList::add);
        return drugsList;
    }
}
