package io.wojtech.Configuration.CustomerContext.Node;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NodeService {
	
	@Autowired
	NodeRepository nodeRepository;
	
	boolean addNewNode(Node node) {
		
		if ( 0 == nodeRepository.countByNodeStringId(node.nodeStringId) ) {
			nodeRepository.save(node);
			return true;
		}
		return false;		
	}
	
	void modifyNode( Node node ) {
		nodeRepository.save(node);
	}
	
	void deleteNode(String nodeId) {
		nodeRepository.delete(nodeId);
	}
	
	List<Node> getAllNodes() {
		return nodeRepository.findAll();
	}
	
	Node getNodeById(String nodeId) {
		return nodeRepository.findOne(nodeId);
	}

}
