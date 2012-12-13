package com.heatclinic.core.order.service.workflow;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.workflow.BaseActivity;
import org.broadleafcommerce.core.workflow.ProcessContext;

import java.util.Map;

public class CheckInventoryActivity extends BaseActivity {
    private static Log LOG = LogFactory.getLog(AddOrderItemActivity.class);
    
    public ProcessContext execute(ProcessContext context) throws Exception {
        Map<String, Object> request = ((AddItemContext) context).getSeedData();

//        OrderItemRequestDTO orderItemRequest = (OrderItemRequestDTO) request.get("orderItemRequest");

//        ... logic to check inventory for the current item ...
//        ... if no inventory, you would throw an exception ...
        
        ((AddItemContext) context).setSeedData(request);
        return context;
    }
}
