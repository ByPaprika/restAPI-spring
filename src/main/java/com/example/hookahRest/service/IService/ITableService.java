package com.example.hookahRest.service.IService;

import com.example.hookahRest.model.TableInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ITableService {
    Iterable getTableInfo();

    void createTable(@RequestBody TableInfo booking);

    void updateTable(@PathVariable Long id, @RequestBody TableInfo booking);

    void deleteTable(@PathVariable Long id);
}
