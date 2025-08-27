package com.example.Online.Billing.Symtem.Pahana.Edu.service;

import com.example.Online.Billing.Symtem.Pahana.Edu.dto.ItemDTO;
import java.util.List;

public interface ItemService {
    List<ItemDTO> getAllItems();
    void saveItem(ItemDTO itemDTO);
    ItemDTO getItemById(Long id);
    void deleteItemById(Long id);
}
