package io.wojtech.Configuration.CustomerContext.Node;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NodeRepository extends JpaRepository<Node,String>{
	
	long countByNodeStringId(String nodeStringId);

}
