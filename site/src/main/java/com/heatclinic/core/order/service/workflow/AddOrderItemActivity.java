package com.heatclinic.core.order.service.workflow;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.workflow.BaseActivity;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.core.workflow.SequenceProcessor;
import org.broadleafcommerce.core.workflow.WorkflowException;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.Map;

public class AddOrderItemActivity extends BaseActivity {
    private static Log LOG = LogFactory.getLog(AddOrderItemActivity.class);
    
    @Resource(name = "blOrderService")
    protected OrderService orderService;

    public ProcessContext execute(ProcessContext context) throws Exception {
        Map<String, Object> request = ((AddItemContext) context).getSeedData();

        OrderItemRequestDTO orderItemRequest = (OrderItemRequestDTO) request.get("orderItemRequest");
        Order order = orderService.findOrderById((Long) request.get("orderId"));

//        ... logic to add the order item to the current order ...
        
        ((AddItemContext) context).setSeedData(request);
        return context;
    }

    @Resource(name = "myAwesomeAddItemWorkflow")
    protected SequenceProcessor myAwesomeAddItemWorkflow;

    public boolean addItem(OrderItemRequestDTO orderItemRequest, Long orderId) {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("orderItemRequest", orderItemRequest);
        request.put("orderId", orderId);

        try {
            AddItemContext context = (AddItemContext) myAwesomeAddItemWorkflow.doActivities(request);
            return true;
        } catch (WorkflowException e) {
            return false;
        }
    }
}
