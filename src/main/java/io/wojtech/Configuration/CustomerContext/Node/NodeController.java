package io.wojtech.Configuration.CustomerContext.Node;

import io.wojtech.Configuration.RestRequestStatus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NodeController {
	
	@Autowired
	NodeService nodeService;

    @RequestMapping( method= RequestMethod.POST, value = "/node")
	RestRequestStatus addNewNode( @RequestBody Node node ) {
		RestRequestStatus status = new RestRequestStatus();
		if ( nodeService.addNewNode(node)) {
			status.setOperationStatus(true);
		} else {
			status.setOperationStatus(false);
			status.setComment("The element with given node ID already exists");
		}
		
		return status;
	}
	
    @RequestMapping( method= RequestMethod.PUT, value = "/node")
	void modifyNode( @RequestBody Node node ) {
		nodeService.modifyNode(node);
	}
	
    @RequestMapping( method= RequestMethod.DELETE, value = "/node/{nodeStringId}")
	void deleteNode( @PathVariable String nodeStringId ) {
		nodeService.deleteNode(nodeStringId);
	}
	
    @RequestMapping( method= RequestMethod.GET, value = "/node")
	List<Node> getAllNodes() {
		return nodeService.getAllNodes();	
	}

    @RequestMapping( method= RequestMethod.GET, value = "/node/{nodeStringId}")
	Node getAllNodes( @PathVariable String nodeStringId) {
		return nodeService.getNodeById(nodeStringId);
	}

}
