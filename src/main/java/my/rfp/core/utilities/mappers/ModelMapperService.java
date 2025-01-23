package my.rfp.core.utilities.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories
public interface ModelMapperService {
	
	ModelMapper forResponse();
	ModelMapper forRequest();
}
