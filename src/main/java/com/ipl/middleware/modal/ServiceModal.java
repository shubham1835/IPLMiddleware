package com.ipl.middleware.modal;

import com.ipl.middleware.dto.InventoryServiceDTO;
import lombok.Data;
import org.javers.core.metamodel.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Data
@Document("service_management")
public class ServiceModal {
    @Id
    private String id;
    private String storeId;
    private Map<String, String> categoryFile;
    private Map<String, List<InventoryServiceDTO>> serviceCategory;
}
