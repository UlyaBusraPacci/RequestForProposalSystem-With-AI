package my.rfp.core.utilities.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import my.rfp.business.responses.GetByIdRfpItemResponse;
import my.rfp.entities.rfpMain.RfpItem;

//@Configuration
public class ModelMapperConfig {

//    @Bean
//    public ModelMapper modelMapper() {
//        ModelMapper modelMapper = new ModelMapper();
//        modelMapper.typeMap(RfpItem.class, GetByIdRfpItemResponse.class)
//                   .addMappings(mapper -> {
//                       mapper.map(src -> src.getRfp().getId(), GetByIdRfpItemResponse::setRfp_id);
//                       mapper.map(RfpItem::getId, GetByIdRfpItemResponse::setId);
//                       mapper.map(RfpItem::getDetails, GetByIdRfpItemResponse::setDetails);
//                       mapper.map(RfpItem::getResponse, GetByIdRfpItemResponse::setResponse);
//                   });
//        return modelMapper;
//    }

//		@Bean
//		public ModelMapper modelMapper() {
//		    ModelMapper modelMapper = new ModelMapper();
//		    modelMapper.getConfiguration()
//		        .setMatchingStrategy(MatchingStrategies.STRICT);
//			return modelMapper;
//		}
}
