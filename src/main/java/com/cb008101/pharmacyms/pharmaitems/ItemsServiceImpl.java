package com.cb008101.pharmacyms.pharmaitems;


import com.cb008101.pharmacyms.dto.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemsServiceImpl implements ItemsService
{

    @Autowired
    private ItemsRepository itemsRepository;


    @Override
    public void deletePharmaItem(Integer id)
    {
        itemsRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Optional<Items> updatePharmaItem(Integer id, Items items)
    {
        return itemsRepository.findById(id).map(e ->
        {
            e.setItemName(items.getItemName());
            e.setItmPrice(items.getItmPrice());
            e.setItemQuantity(items.getItemQuantity());
            return e;
        });
    }

    @Override
    public List<Items> getAllDrugs()
    {
        List<Items> itemsList = new ArrayList<>();
        itemsRepository.findAll().forEach(itemsList::add);
        return itemsList;
    }

    @Override
    public void saveDrug(Items items)
    {
        itemsRepository.save(items);
    }


    @Override
    public Items getByID(Integer id)
    {
        Optional<Items> itms = Optional.ofNullable(
                itemsRepository.findById(id).
                        orElseThrow(() -> new IllegalArgumentException("Invalid ID")));
        Items items = itms.get();
        return items;
    }

    @Override
    public List<ItemDTO> getAllByNames()
    {
        List<ItemDTO> drugsList = new ArrayList<ItemDTO>();
        itemsRepository.getAllDrugDetails().forEach(drugsList::add);
        return drugsList;
    }
}
