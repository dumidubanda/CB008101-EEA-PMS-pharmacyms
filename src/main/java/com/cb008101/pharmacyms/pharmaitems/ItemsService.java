package com.cb008101.pharmacyms.pharmaitems;


import com.cb008101.pharmacyms.dto.ItemDTO;

import java.util.List;
import java.util.Optional;

public interface ItemsService
{
    void deletePharmaItem(Integer id);

    Optional<Items> updatePharmaItem(Integer id, Items items);

    List<Items> getAllDrugs();

    void saveDrug(Items items);

    Items getByID(Integer id);

    List<ItemDTO> getAllByNames();
}
