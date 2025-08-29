package com.example.Online.Billing.Symtem.Pahana.Edu.service.impl;

import com.example.Online.Billing.Symtem.Pahana.Edu.dto.ItemDTO;
import com.example.Online.Billing.Symtem.Pahana.Edu.entity.Item;
import com.example.Online.Billing.Symtem.Pahana.Edu.repository.ItemRepository;
import com.example.Online.Billing.Symtem.Pahana.Edu.repository.OrderDetailRepository;
import com.example.Online.Billing.Symtem.Pahana.Edu.service.ItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public List<ItemDTO> getAllItems() {
        return itemRepository.findAll().stream().map(item -> {
            ItemDTO dto = new ItemDTO();
            BeanUtils.copyProperties(item, dto);
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void saveItem(ItemDTO itemDTO) {
        Item item = new Item();
        BeanUtils.copyProperties(itemDTO, item);
        itemRepository.save(item);
    }

    @Override
    public ItemDTO getItemById(Long id) {
        return itemRepository.findById(id).map(item -> {
            ItemDTO dto = new ItemDTO();
            BeanUtils.copyProperties(item, dto);
            return dto;
        }).orElse(null);
    }

    @Override
    public void deleteItemById(Long id) {
        if (!orderDetailRepository.findByItemId(id).isEmpty()) {
            throw new RuntimeException("Cannot delete this item because it is part of an existing order.");
        }
        itemRepository.deleteById(id);
    }
}
